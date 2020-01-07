$(function(){

    $("#table").bootstrapTable({
        url:"/sys/role/list",
        pagination:true,//是否开启分页功能
        sidePagination:"server",//服务端分页
        showRefresh: true,  //显示刷新按钮
        search: true,
        toolbar: '#toolbar',
        columns:[
            {checkbox:true},
            {field: 'roleId',
                title: '序号',
                width: 40,
                formatter: function(value, row, index) {
                    var pageSize = $('#table').bootstrapTable('getOptions').pageSize;
                    var pageNumber = $('#table').bootstrapTable('getOptions').pageNumber;
                    return pageSize * (pageNumber - 1) + index + 1;
                }},
            {field:'roleId',title:'编号'},
            {field:'roleName',title:'角色名称'},
            {field:'createTime',title:'创建时间'}
        ]
    });


});

var vm  = new Vue({
    el:'#dtapp',
    data:{
        showList:true,
        title:'',
        role:{}
    },
    methods:{
        del: function(){
            //getSelectedRows();：common.js中定义   功能获得用户选择的记录  返回的是数组
            var rows = getSelectedRows();
            if(rows == null){
                return ;
            }
            var id = 'roleId';
            //提示确认框
            layer.confirm('您确定要删除所选数据吗？', {
                btn: ['确定', '取消'] //可以无限个按钮
            }, function(index, layero){
                var ids = new Array();
                //遍历所有选择的行数据，取每条数据对应的ID
                $.each(rows, function(i, row) {
                    ids[i] = row[id];//得到选择的这一行的id
                });

                //ids  = [1,2,3];//json数组
                $.ajax({
                    type: "POST",
                    url: "/sys/role/del",
                    data: JSON.stringify(ids),//把json数组转json字符串
                    success: function(r) {
                        if(r.code === 0){//成功
                            layer.alert('删除成功');
                            //刷新
                            $('#table').bootstrapTable('refresh');
                        }else{
                            layer.alert(r.msg);
                        }
                    },
                    error: function() {
                        layer.alert('服务器没有返回数据，可能服务器忙，请重试');
                    }
                });
            });
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
        },
        update: function (event) {
            var id = 'roleId';
            var roleId = getSelectedRow()[id];
            if(roleId == null){
                return ;
            }

            $.get("../sys/role/info/"+roleId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.role=r.role;
            });
        },
        saveOrUpdate: function (event) {
            //有菜单编号时是修改，没有：新增
            var url = vm.role.roleId == null ? "../sys/role/save" : "../sys/role/update";
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(vm.role),//json字符串
                success: function(r){
                    if(r.code === 0){
                        layer.alert('操作成功', function(index){
                            layer.close(index);
                            vm.reload();
                        });
                    }else{
                        layer.alert(r.msg);
                    }
                }
            });
        },
        reload: function (event) {
            vm.showList = true;
            $("#table").bootstrapTable('refresh');
        }
    }
});