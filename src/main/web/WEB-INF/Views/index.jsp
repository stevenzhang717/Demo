<%--
  Created by IntelliJ IDEA.
  User: penghaozhang
  Date: 8/03/13
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>

<div class="span6 offset1">
<div id="descriptionPanel">

    <h2>About</h2>

    <p>Hello, My name is Steven is this the project I created by my own. Y
        ou can create a new user and post your diary on you own page.
    </p>

</div>


<c:url value="/addUser" var="addUser"/>
<div id="signupPanel" class="signUp">
    <a id="closelink">Close</a>

    <h2>Sign up</h2>

    <form id="registerForm" action="${addUser}" method='post'>
        <label for="username"> User name: </label> <input id="username" type="text" name="username" class="username"><br>
        <label for="password"> Password: </label> <input id="password" type="password" name="password"><br>
        <label for="email"> Email: </label> <input id="email" type="email" name="email"><br>
        <input id="signupSubmit" name="Submit" class="submit" type="submit"/>
    </form>
</div>
</div>


</body>
</html>