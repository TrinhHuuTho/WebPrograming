<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<body>
	<form action="/LTWeb_T3-4/register" method="post">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="email"><b>Username</b></label> <input type="text"
				placeholder="Enter User name" name="username" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <label
				for="fullname"><b>Fullname</b></label> <input type="text"
				placeholder="Enter Fullname" name="fullname" required>
			<hr>

			<button type="submit" class="registerbtn">Register</button>
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a
					href="http://localhost:8080/LTWeb_T3-4/views/login.jsp">Sign in</a>.
			</p>
		</div>
	</form>
</body>
</html>
