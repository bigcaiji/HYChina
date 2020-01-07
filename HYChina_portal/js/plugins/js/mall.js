var param = "";
$.ajaxPost = function(url, param, callback) {
    param += "&_date=" + new Date().getTime();
    $.ajax({
        type:"post",
        url:url,
        data:param,
        success:function(data) {
            if (data) {
                if((typeof data) === 'string' && data.indexOf("_noLogin") != -1) {
                    window.location.href = data.split(",")[1];
                } else if((typeof data) === 'string' && data.indexOf("_noPermission") != -1) {
                    window.location.href = "noPermission";
                } else {
                    if(param.indexOf('pageNo')>-1){
                        callback(data,2);
                    }else{
                        callback(data,1);
                    }
                }
            }
        }
    });
};

function doJumpPage(i,count) {
    if(isNaN(i)) {
        alert("输入格式不正确!");
        return;
    }
    param = "pageNo=" + i;
    //回调页面方法
    if(isNaN(count)){
        initList(param);
    }else{
        initList2(param);
    }
}