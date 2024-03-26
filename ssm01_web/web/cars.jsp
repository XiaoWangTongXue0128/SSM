<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

    <style>
        td{

            text-align: center;
        }
    </style>
</head>
<body>
    <h2>汽车列表</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <td>汽车编号</td>
                <td>汽车名称</td>
                <td>汽车颜色</td>
                <td>汽车价格</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${requestScope.cars==null or requestScope.cars.size()==0}">
                    <tr>
                        <td rowspan="5">无任何记录</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${requestScope.cars}" var="car">
                        <tr>
                            <td>${car.cno}</td>
                            <td>${car.cname}</td>
                            <td>${car.color}</td>
                            <td>${car.price}</td>
                            <td>
                                <a href="">编辑</a>
                                <a href="">删除</a>
                            </td>
                        </tr>

                    </c:forEach>

                </c:otherwise>
            </c:choose>
        </tbody>
    </table>

</body>
</html>
