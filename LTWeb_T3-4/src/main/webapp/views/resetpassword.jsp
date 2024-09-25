<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đặt lại mật khẩu</title>
</head>
<body>
    <h1>Đặt lại mật khẩu</h1>
    <c:if test="${alert !=null}">
        <h3>${alert}</h3>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/forgotpassword">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required /><br><br>

        <label for="newPassword">Mật khẩu mới:</label>
        <input type="password" id="newPassword" name="newPassword" required /><br><br>

        <label for="confirmPassword">Xác nhận mật khẩu:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required /><br><br>

        <input type="submit" value="Đổi mật khẩu" />
    </form>
</body>
</html>
