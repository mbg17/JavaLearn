<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="/updateUserServlet" method="post">
            <input type="text" style="display: none" name="id" value="${requestScope.student.id}">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名" value="${requestScope.student.name}"/>
          </div>

          <div class="form-group">
            <label>性别：</label>
              <input type="radio" name="gender" value="男" <c:if test="${requestScope.student.gender=='男'}">checked</c:if> />男
                <input type="radio" name="gender" value="女"  <c:if test='${requestScope.student.gender=="女"}'>checked</c:if>/>女
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${requestScope.student.age}"/>
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" id="address" class="form-control" >
                <option value="陕西" <c:if test='${requestScope.student.address=="陕西"}'>selected</c:if>>陕西</option>
                <option value="北京" <c:if test='${requestScope.student.address=="北京"}'>selected</c:if>>北京</option>
                <option value="上海" <c:if test='${requestScope.student.address=="上海"}'>selected</c:if>>上海</option>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq" placeholder="请输入QQ号码" value="${requestScope.student.qq}"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email" placeholder="请输入邮箱地址" value="${requestScope.student.email}"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>