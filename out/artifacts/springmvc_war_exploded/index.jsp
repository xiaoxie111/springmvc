<%--
  Created by IntelliJ IDEA.
  User: cyqh
  Date: 2019/7/9
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js" type="text/javascript"></script>
<script>
    /*$(function(){
        $('#sub').click(function(){
            var username=$('#username').val();
            var password=$('#password').val();
            $.ajax({
                type: "post",
                url: "/springmvc/hello/test.form",
                data: {username:username}, //提交到demo.php的数据
                // dataType: "json", //回调函数接收数据的数据格式

                success: function(msg){

                    console.log(msg); //控制台输出
                    // $('#text').empty(); //清空Text里面的所有内容
                    // var data='';
                    // if(msg!=''){
                    //     data = eval("("+msg+")"); //将返回的json数据进行解析，并赋给data
                    // }
                    // console.log(data); //控制台输出
                    $('#text').html(msg); //在#text中输出
                    console.log(msg); //控制台输出
                },

                error:function(msg){
                    console.log(msg);
                }
            });
        });
    })*/

    function login() {

      console.log($('#username')); //控制台输出
        var username=$('#username').val();
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            // dataType: "json",//预期服务器返回的数据类型
            url: "/springmvc/hello/test.form" ,//url
            data: {username:username},
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)

                $('#text').html(result); //在#text中输出
                // if (result.resultCode == 200) {
                //     alert("SUCCESS");
                // }
                // ;
            },
            error : function() {
                alert("异常！");
            }
        });
    }
</script>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<button id="sub">查询</button>--%>
  <form action="##" method="post">
      <p>用户名：<input name="username" type="text" id="username" tabindex="1" size="15" value=""/></p>
      <p><input type="button" value="登录" onclick="login()">&nbsp;<input type="reset" value="重置"></p>
  </form>
  <span id="text"></span><!-- 用以显示返回来的数据，只刷新这部分地方 -->
  </body>
</html>
