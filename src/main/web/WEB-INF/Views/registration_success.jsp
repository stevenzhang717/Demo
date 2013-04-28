<%--
  Created by IntelliJ IDEA.
  User: penghaozhang
  Date: 23/03/13
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
<script type="text/javascript">
    //wait 5 seconds and redirect the user to the homepage
    window.setTimeout(function () {
        window.location.href = '/';
    }, 5000);
</script>

<div id="successMessage">
    <p>${requestScope.user.username}, You have been register an account successfully!
        we will now redirect you for you back to the home page so that you could login.</p>
</div>