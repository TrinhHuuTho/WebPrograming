<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/LTWeb_T3-4/login" method="post">
		<h2>Login</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="text" placeholder="Tài khoản" name="username"
					class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="password" placeholder="Mật khẩu" name="password"
					class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="checkbox" name="rememberme"
					class="form-control">Nhớ tôi
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input"> 
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span>
				<input type="submit" value="Login"
					class="form-control">
				</div>
			</label>
		</section>
	</form>
</body>
</html>