<%--
  Created by IntelliJ IDEA.
  User: penghaozhang
  Date: 26/04/13
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div id=loginPanel class="span3">
    <sec:authorize access="isAnonymous()">
        <h2>Login</h2>
        <spring:url var="loginUrl" value="/j_spring_security_check" />
        <div>
            <form name="loginForm" action="${loginUrl}" method="post">
                <table>
                    <tr>
                        <td><label for="username">User Name:</label></td>
                        <td><input id="username" type="text" name="j_username" /></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password:</label></td>
                        <td><input id="password" type="password" name="j_password" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input name="submit" type="submit" value="Login" /></td>
                    </tr>
                </table>
            </form>
            <p>Don't have an account?
                <button id="signupButton">Sign up</button>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p>You have login already,</p>

        <p>And your user name is

        <p><strong><sec:authentication property="principal.username" /></strong>
                <spring:url var="userpage" value="/RedirectUser" />

        <p><a href="${userpage}">Your home page</a>

        <p><a href="<c:url value="/j_spring_security_logout" />">logout</a></p>
    </sec:authorize>
</div>