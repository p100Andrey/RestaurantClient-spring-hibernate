<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Create an ArrayList with test data
    ArrayList<String> list = new ArrayList();
    list.add("Zakuski");
    list.add("Pervie Blyuda");
    list.add("Vtorie Blyuda");
    list.add("Desert");
    pageContext.setAttribute("razdely", list);
%>

<html>

<head>
    <title>Dish Page</title>

    <style>
        a {
            text-decoration: none;
        }

        /* Убираем подчеркивание у ссылок */
        a:hover {
            text-decoration: underline;
        }

        /* Добавляем подчеркивание при наведении курсора мыши на ссылку */
    </style>

    <style type="text/css">
        .tg {
            width: 800px;
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body style="background: url(/№1.jpg); background-size: cover">
<div align="center">

    <c:import url="/WEB-INF/pages/header.jsp"></c:import>

    <table class="tg">
        <br/>
        <h1 style="color: white">Menu</h1>

        <c:if test="${!empty listDish}">

            <tr>
                    <%--<th width="20">ID</th>--%>
                <th width="60">Name</th>
                <th width="60">Category</th>
                <th width="30">Cost</th>
                <th width="30">Weight</th>
                    <%--<th width="30">Edit</th>--%>
                    <%--<th width="30">Delete</th>--%>
            </tr>
            <c:forEach items="${listDish}" var="dish">
                <tr>
                        <%--<td>${dish.dishid}</td>--%>
                    <td><a href="/dishdata/${dish.dishid}" target="_blank">${dish.dishname}</a></td>
                    <td>${dish.category}</td>
                        <%--<td>${dish.cost/100}${dish.cost%100}</td>--%>
                    <td>${dish.cost}</td>
                    <td>${dish.weight}</td>
                        <%--<td><a href="<c:url value='/dishedit/${dish.dishid}'/>">Edit</a></td>--%>
                        <%--<td><a href="<c:url value='/dishremove/${dish.dishid}'/>">Delete</a></td>--%>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>