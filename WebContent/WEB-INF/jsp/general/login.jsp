<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	${msg }
	<br>
	<form name='loginForm'
		action="<c:url value='/j_spring_security_check' />" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<input name="submit" type="submit" value="Login" />
					<br>
					<a href="${pageContext.request.contextPath }/user/register.html">Sign out</a>
				</td>
			</tr>
		</table>
	</form>
