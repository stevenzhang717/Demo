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
<script type="text/javascript" src="<c:url value="/resources/js/post.js"/>"></script>
<div class="column-middle">
    <h2>Posts</h2>
    <label for="order-by">Orders: </label>
    <select name="order" id="order-by">
        <option value="created" class="orders" selected="selected">Creation</option>
        <option value="subject" class="orders">Title</option>
    </select>
    <div class="post-list">
        <ul id="posts">

        </ul>
    </div>
</div>
<c:if test="${showNewForm}">
    <h2>New Post</h2>
    <div class="column-right">
        <div class="post-form">
            <form id="postForm"
                  action="${pageContext.request.contextPath}/users/<security:authentication property="principal.username" />/addPost"
                  method="post">
                <div class="form-fields">
                    <ul>
                        <li><label for="subject">Subject:</label><input type="text" id="subject" name="subject"></li>
                        <li>Weather Condition: <span id="weather"></span></li>
                        <li><label for="content">Content:</label> <textarea cols="40" rows="5" id="content"
                                                                            name="content"> </textarea></li>
                        <li><input id="weather_input" type="hidden" name="weather"/></li>
                        <li><input type="submit" value="submit"></li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</c:if>