<%-- 
    Document   : user
    Created on : Sep 14, 2022, 3:42:03 PM
    Author     : Admiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleName ne 'User'}"> 
            <c:redirect url="login.jsp"></c:redirect>
        </c:if> 
        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1></br>
        <a href="userInfor.jsp">User profile</a>
        <br>
        <c:url var="logoutLink" value="MainController" >
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}">Logout</a>
        
    </body>
    
</html>
