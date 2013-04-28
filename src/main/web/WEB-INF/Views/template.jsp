<%--
  Created by IntelliJ IDEA.
  User: penghaozhang
  Date: 26/04/13
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML>

<html lang="en">
<head>
    <title>Diaries by Steven Zhang</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"> </script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand"><strong>Diaries by Steven Zhang</strong></a>
        </div>
    </div>
</div>
<div class="row-fluid">

    <tiles:insertAttribute name="menu" ignore="true" />
    <tiles:insertAttribute name="body" />

</div>
</body>
</html>