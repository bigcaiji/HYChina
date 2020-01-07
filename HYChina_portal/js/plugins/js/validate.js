/**
 用途：检查输入手机号码是否正确
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isMobile(s){
    var regu ="^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 * 检查输入的身份证号是否正确
 * 输入:str  字符串
 *  返回:true 或 flase; true表示格式正确
 */
function isCard(str) {
    //15位数身份证正则表达式
    var arg1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
    //18位数身份证正则表达式
    var arg2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/;
    if (str.match(arg1) == null && str.match(arg2) == null) {
        return false;
    }
    else {
        return true;
    }
}
/**
 * 检查输入的字符是否具有特殊字符
 * 输入:str  字符串
 * 返回:true 或 flase; true表示包含特殊字符
 * 主要用于注册信息的时候验证
 */
function isQuote(str) {
    var items = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "{", "}", "[", "]", "(", ")");
    items.push(":", ";", "'", "|", "\\", "<", ">", "?", "/", "<<", ">>", "||", "//");
    items.push("admin", "administrators", "administrator", "管理员", "系统管理员");
    items.push("select", "delete", "update", "insert", "create", "drop", "alter", "trancate");
    str = str.toLowerCase();
    for (var i = 0; i < items.length; i++) {
        if (str.indexOf(items[i]) >= 0) {
            return true;
        }
    }
    return false;
}
/**
 * 检查输入的URL地址是否正确
 * 输入:str  字符串
 *  返回:true 或 flase; true表示格式正确
 */
function checkURL(str) {
    if (str.match(/(http[s]?|ftp):\/\/[^\/\.]+?\..+\w$/i) == null) {
        return false
    }
    else {
        return true;
    }
}
/**
 用途：检查输入的电话号码格式是否正确
 输入：
 strPhone：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isPhone(strPhone) {
    var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/;
    var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/;
    if (strPhone.length > 9) {
        if (phoneRegWithArea.test(strPhone)) {
            return true;
        } else {
            return false;
        }
    } else {
        if (phoneRegNoArea.test(strPhone)) {
            return true;
        } else {
            return false;
        }

    }
}
/**
 用途：校验ip地址的格式
 输入：strIP：ip地址
 返回：如果通过验证返回true,否则返回false；
 **/

function isIP(strIP) {
    if (isNull(strIP)) return false;
    var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式
    if(re.test(strIP))
    {
        if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) return true;
    }
    return false;
}
/**
 用途：检查输入字符串是否为空或者全部都是空格
 输入：str
 返回：
 如果全是空返回true,否则返回false
 */
function isNull( str ){
    if ( str == "" ) return true;
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
}
/**
 用途：检查输入对象的值是否符合整数格式
 输入：str 输入的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isInteger( str ){
    var regu = /^[-]{0,1}[0-9]{1,}$/;
    return regu.test(str);
}
/**
 用途：检查输入字符串是否符合正整数格式
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isNumber( s ){
    var regu = "^[0-9]+$";
    var re = new RegExp(regu);
    if (s.search(re) != -1) {
        return true;
    } else {
        return false;
    }
}
/**
 用途：检查输入字符串是否是带小数的数字格式,可以是负数
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isDecimal( str ){
    if(isInteger(str)) return true;
    var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
    if (re.test(str)) {
        if(RegExp.$1==0&&RegExp.$2==0) return false;
        return true;
    } else {
        return false;
    }
}
/**
 用途：检查输入对象的值是否符合端口号格式
 输入：str 输入的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isPort( str ){
    return (isNumber(str) && str<65536);
}
/**
 用途：检查输入对象的值是否符合E-Mail格式
 输入：str 输入的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isEmail( str ){
    var myReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if(myReg.test(str)) return true;
    return false;
}
/**
 用途：检查输入对象的值是否符合密码格式
 输入：str 输入的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isPassword( str ){
    if(str.length>=6&&str.length<=16) return true;
    return false;
}
/**
 用途：检查输入对象的值是否相同
 输入：pwd1,pwd2 输入的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isTwoPassword( pwd1 ,pwd2 ){
    if(pwd1==pwd2) return true;
    return false;
}
/**
 用途：检查输入字符串是否符合金额格式
 格式定义为带小数的正数，小数点后最多三位
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isMoney( s ){
    var regu = "^[0-9]+[\.]{0,1}[0-9]{0,2}$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    } else {
        return false;
    }
}
/**
 用途：检查输入字符串是否只由英文字母和数字和下划线组成
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isNumberOr_Letter( s ){//判断是否是数字或字母
    var regu = "^[0-9a-zA-Z\_]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：检查输入字符串是否只由英文字母和数字组成
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isNumberOrLetter( s ){//判断是否是数字或字母
    var regu = "^[0-9a-zA-Z]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：检查输入字符串是否只由英文字母组成
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isLetter( s ){//判断是否是数字或字母
    var regu = "^[a-zA-Z]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：检查输入字符串是否是中文
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isChinese( s ){//判断是否是数字或字母
    var regu = "^[\u0391-\uFFE5]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：检查输入字符串是否是邮编
 输入：
 s：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isZIP( s ){//判断是否是数字或字母
    var regu = /^\d{6}/;
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：检查输入字符串是否只由汉字、字母、数字组成
 输入：
 value：字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isChinaOrNumbOrLett( s ){//判断是否是汉字、字母、数字组成
    var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    }else{
        return false;
    }
}
/**
 用途：判断是否是日期
 输入：date：日期；fmt：日期格式
 返回：如果通过验证返回true,否则返回false
 */
function isDate( date, fmt ) {
    if (fmt==null) fmt="yyyyMMdd";
    var yIndex = fmt.indexOf("yyyy");
    if(yIndex==-1) return false;
    var year = date.substring(yIndex,yIndex+4);
    var mIndex = fmt.indexOf("MM");
    if(mIndex==-1) return false;
    var month = date.substring(mIndex,mIndex+2);
    var dIndex = fmt.indexOf("dd");
    if(dIndex==-1) return false;
    var day = date.substring(dIndex,dIndex+2);
    if(!isNumber(year)||year>"2100" || year< "1900") return false;
    if(!isNumber(month)||month>"12" || month< "01") return false;
    if(day>getMaxDay(year,month) || day< "01") return false;
    return true;
}
function getMaxDay(year,month) {
    if(month==4||month==6||month==9||month==11)
        return "30";
    if(month==2)
        if(year%4==0&&year%100!=0 || year%400==0)
            return "29";
        else
            return "28";
    return "31";
}
/**
 用途：字符1是否以字符串2结束
 输入：str1：字符串；str2：被包含的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isLastMatch(str1,str2)
{
    var index = str1.lastIndexOf(str2);
    if(str1.length==index+str2.length) return true;
    return false;
}
/**
 用途：字符1是否以字符串2开始
 输入：str1：字符串；str2：被包含的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isFirstMatch(str1,str2)
{
    var index = str1.indexOf(str2);
    if(index==0) return true;
    return false;
}
/**
 用途：字符1是包含字符串2
 输入：str1：字符串；str2：被包含的字符串
 返回：如果通过验证返回true,否则返回false
 */
function isMatch(str1,str2)
{
    var index = str1.indexOf(str2);
    if(index==-1) return false;
    return true;
}
/**
 用途：判断输入的数字不大于某个特定的数字
 输入：str1：输入数字；str2：特定数字
 返回：如果通过验证返回true,否则返回false
 */
function isMaxValue(str1,str2)
{
    if(str1>str2) return false;
    return true;
}
/**
 用途：判断输入的数字不小于某个特定的数字
 输入：str1：输入数字；str2：特定数字
 返回：如果通过验证返回true,否则返回false
 */
function isMinValue(str1,str2)
{
    if(str1<str2) return false;
    return true;
}
/**
 用途：检查输入的起止日期是否正确，规则为两个日期的格式正确，
 且结束如期>=起始日期
 输入：
 startDate：起始日期，字符串
 endDate：结束如期，字符串
 返回：
 如果通过验证返回true,否则返回false
 */
function isTwoDate( startDate,endDate ) {
    if( !isDate(startDate) ) {
        return false;
    } else if( !isDate(endDate) ) {
        return false;
    } else if( startDate > endDate ) {
        return false;
    }
    return true;
}
/**
 用途：检查证券代码是否正确
 输入：
 secCode:证券代码
 返回：
 如果通过验证返回true,否则返回false
 */
function isSecCode( secCode ) {
    if( secCode.length !=6 ){
        return false;
    }
    if(!isNumber( secCode ) ){
        return false;
    }
    return true;
}
/**
 * 后台三级联动
 * @param value 传参名称
 */
function sector(value){
    if(byId("parent").value!=-1&&byId("parent").value!=1){
        var eChild=byId('child_'+byId("parent").value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("cspan").innerHTML="";
        byId("cspan").appendChild(eChild);
    }else{
        byId("cspan").innerHTML="";
        byId("aspan").innerHTML="";
    }
}
function sector2(value){
    if(byId('child_'+byId("parent").value).value!=-1){
        var eChild=byId('child_'+byId('child_'+byId("parent").value).value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("aspan").innerHTML="";
        byId("aspan").appendChild(eChild);
    }else{
        byId("aspan").innerHTML="";
    }
}
/**
 * 后台同页面二次应用三级联动
 * @param value 传参名称
 */
function sector4(value){
    if(byId("parent1").value!=-1&&byId("parent1").value!=1){
        var eChild=byId('child_'+byId("parent1").value+'_1').cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("cspan1").innerHTML="";
        byId("cspan1").appendChild(eChild);
    }else{
        byId("cspan1").innerHTML="";
        byId("aspan1").innerHTML="";
    }
}
function sector5(value){
    if(byId('child_'+byId("parent1").value+'_1').value!=-1){
        var eChild=byId('child_'+byId('child_'+byId("parent1").value+'_1').value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("aspan1").innerHTML="";
        byId("aspan1").appendChild(eChild);
    }else{
        byId("aspan1").innerHTML="";
    }
}
/**
 * 二级联动
 * @param value
 */
function sector3(value){
    if(byId("parent").value!=-1){
        var eChild=byId('child_'+byId("parent").value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("cspan").innerHTML="";
        byId("cspan").appendChild(eChild);
    }else{
        byId("cspan").innerHTML="";
    }
}
/**
 * 前台三级联动
 * @param value 传参名称
 */
function sector6(value){
    if(byId("parent").value!=-1&&byId("parent").value!=1){
        var eChild=byId('child_'+byId("parent").value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("cspan").innerHTML="";
        byId("cspan").appendChild(eChild);
    }else{
        byId("cspan").innerHTML="";
        byId("aspan").innerHTML="";
    }
    initList();
}
function sector7(value){
    if(byId('child_'+byId("parent").value).value!=-1){
        var eChild=byId('child_'+byId('child_'+byId("parent").value).value).cloneNode(true);
        eChild.name=value;
        eChild.style.display="";
        eChild.value="-1";
        byId("aspan").innerHTML="";
        byId("aspan").appendChild(eChild);
    }else{
        byId("aspan").innerHTML="";
    }
    initList();
}
/**
 * 判断是否是电脑
 * @returns {Boolean}
 */
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = ["Android", "iPhone",
        "SymbianOS", "Windows Phone",
        "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}
/**
 * 兼容bug
 * @param value
 */
function value(value){}