<%--
  Created by IntelliJ IDEA.
  User: penghaozhang
  Date: 19/04/13
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"> </script>
<script type="text/javascript" src="<c:url value="/resources/js/post.js"/>"> </script>

<div class="span6 offset1">
    <c:if test="${showNewForm}">
        <div id="postDiv">
            <h2>New Post</h2>

            <form id="postForm" action="/users/<security:authentication property="principal.username" />/addPost"
                  method="post">
                Subject: <input type="text" name="subject"><br>
                Weather Condition: <span id="weather"></span><br>
                Content: <input type="text" name="content">
                <input id="weather_input" type="hidden" name="weather"/>
                <input type="submit" value="submit">
            </form>
        </div>
    </c:if>

    <ul id="posts">

    </ul>
</div>