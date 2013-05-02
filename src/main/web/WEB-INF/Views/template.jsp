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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Diaries by Steven Zhang</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" media="screen" />
    <script>
        //get context path so that all the javascript could request the right url
        var context = "${pageContext.request.contextPath}";
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body>
<div class="header-bar">
    <h1>Diaries by Steven Zhang</h1>
</div>
<div class="container">
    <div class="columns">
        <tiles:insertAttribute name="menu" ignore="true"/>
        <tiles:insertAttribute name="body"/>
    </div>
    <c:url value="/addUser" var="addUser"/>
    <div id="signupPanel" class="signUp">
        <span id='closelink'><button>Close</button></span>

        <form id="registerForm" action="${addUser}" method='post'>
            <fieldset>
                <legend><h2>Sign Up</h2></legend>
                <ul>
                    <li><label for="username"> User name: </label> <input id="username" type="text" name="username"
                                                                          class="username"/></li>
                    <li><label for="password"> Password: </label> <input id="password" type="password" name="password"/>
                    </li>
                    <li><label for="email"> Email: </label> <input id="email" type="email" name="email"/></li>
                    <li><input id="signupSubmit" name="Submit" class="submit" type="submit"/></li>
                </ul>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>