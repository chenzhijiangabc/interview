$("#sumbitButton").click(function () {
 /*   $("#tip").css("visibility","visible");
    <!--在js中获取返回的信息-->
    var msg=[[${message}]];
    /!*alert(msg);*!/*/
alert("wo1jinlail")
// 1.发送数据到后台
   var datafrom=$("#myform").serialize();
   $.ajax({type:"post",
       url:"${pageContext.request.contextPath}/AddBaseMessage",
       data:datafrom,
       success:function (respone) {
           alert(respone);
       }
       });

});