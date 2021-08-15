<%--
  Created by IntelliJ IDEA.
  User: 陆远
  Date: 2020/6/15
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;padding-top: 80px;">用户信息列表</h3>
    <div style="float: left;">

        <form class="form-inline" action="/userServlet" method="get">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" class="form-control" id="exampleInputName2" value="${requestScope.parameterMap.name[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" name="address" class="form-control" id="exampleInputName3" value="${requestScope.parameterMap.address[0]}">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail2" value="${requestScope.parameterMap.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" id="delSelected" onclick="delSelected()">删除选中</a>

    </div>
    <form action="/delSelectedServlet" method="post" id="delList">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="selectedAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:if test="${requestScope.PageBean.list!=null}">
                <c:forEach items="${requestScope.PageBean.list}" var="student" varStatus="s">
                    <tr>
                        <td><input type="checkbox" name="uid" value="${student.id}"></td>
                        <td>${s.count}</td>
                        <td>${student.name}</td>
                        <td>${student.gender}</td>
                        <td>${student.age}</td>
                        <td>${student.address}</td>
                        <td>${student.qq}</td>
                        <td>${student.email}</td>
                        <td><a class="btn btn-default btn-sm" href="/findUserServlet?id=${student.id}">修改</a>&nbsp;
                            <a class="btn btn-default btn-sm" id="del" onclick="delUser(${student.id})">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.PageBean.list==null}">
                <tr>
                    <td colspan="9" align="center">没有更多数据</td>
                </tr>
            </c:if>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li <c:if test="${requestScope.PageBean.currentPage==1 || requestScope.PageBean.currentPage==0}">class="disabled"</c:if>>
                    <c:if test="${requestScope.PageBean.currentPage-1<=0}">
                        <a href="${pageContext.request.contextPath}/userServlet?currentPage=1&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${requestScope.PageBean.currentPage-1>0}">
                        <a href="${pageContext.request.contextPath}/userServlet?currentPage=${requestScope.PageBean.currentPage-1}&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>
                </li>
                <c:if test="${requestScope.PageBean.currentPage+6<requestScope.PageBean.totalPages}">
                    <c:forEach begin="${requestScope.PageBean.currentPage}" end="${requestScope.PageBean.currentPage+6}"
                               var="page" step="1">
                        <li <c:if test="${requestScope.PageBean.currentPage==page}">class="active"</c:if>><a
                                href="${pageContext.request.contextPath}/userServlet?currentPage=${page}&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}">${page}</a></li>
                    </c:forEach>
                </c:if>
                <c:if test="${requestScope.PageBean.totalPages<=6}">
                    <c:forEach begin="1" end="${requestScope.PageBean.totalPages==0?1:requestScope.PageBean.totalPages}" var="page" step="1">
                        <li <c:if test="${requestScope.PageBean.currentPage==page}">class="active"</c:if>><a
                                href="${pageContext.request.contextPath}/userServlet?currentPage=${page}&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}">${page}</a></li>
                    </c:forEach>
                </c:if>
                <li
                        <c:if test="${requestScope.PageBean.currentPage==requestScope.PageBean.totalPages||requestScope.PageBean.currentPage==0}">class="disabled"</c:if>>
                    <c:if test="${requestScope.PageBean.currentPage+1>requestScope.PageBean.totalPages}">
                        <a href="${pageContext.request.contextPath}/userServlet?currentPage=${requestScope.PageBean.totalPages==0?1:requestScope.PageBean.totalPages}&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                    <c:if test="${requestScope.PageBean.currentPage+1<=requestScope.PageBean.totalPages}">
                        <a href="${pageContext.request.contextPath}/userServlet?currentPage=${requestScope.PageBean.currentPage+1}&name=${requestScope.parameterMap.name[0]}&address=${requestScope.parameterMap.address[0]}&email=${requestScope.parameterMap.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </c:if>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${requestScope.PageBean.totalCount}条记录，共${requestScope.PageBean.totalPages==0?1:requestScope.PageBean.totalPages}页
                </span>

            </ul>
        </nav>
    </div>
    <script>
        function delUser(id) {
            var b = confirm("是否真的要删除？");
            if (b) {
                location.href = "/delUserServlet?id=" + id;
            }
            return;
        }

        function delSelected() {
            var b = confirm("是否真的要删除？");
            var flag = false;
            var elementsByName = document.getElementsByName("uid");
            for (let i = 0; i < elementsByName.length; i++) {
                if (elementsByName[i].checked) {
                    flag = true;
                    break;
                }
            }
            if (b && flag) {
                document.getElementById("delList").submit();
            } else {
                alert("请勾选数据后删除");
            }
        }

        document.getElementById("selectedAll").onclick = function () {
            var elementsByName = document.getElementsByName("uid");
            for (let i = 0; i < elementsByName.length; i++) {
                elementsByName[i].checked = this.checked;
            }
        }
    </script>
</div>
</body>
</html>
