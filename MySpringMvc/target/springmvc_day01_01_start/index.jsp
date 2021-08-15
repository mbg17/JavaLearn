<%--
  Created by IntelliJ IDEA.
  User: 陆远
  Date: 2020/8/1
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="js/jquery-3.5.1.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{name":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
        });

    </script>

</head>

<body>
<button id="btn">tijiao</button>
<form action="upload/fileupload1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload">
    <input type="submit" value="tijiao">
</form>
<a href="error/testException">测试异常跳转</a>
</body>
</html>