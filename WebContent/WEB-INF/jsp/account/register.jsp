<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:form method="post" commandName="account" 
	action="${pageContext.request.contextPath }/account/register.html">
	<table cellpadding="2" cellspacing="">
		<tr>
			<td>First Name</td>
			<td>
				<s:input path="firstname"/>
			</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>
				<s:input path="lastname"/>
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>
				<s:input path="email"/>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<s:password path="password"/>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<input type="submit" value="Save"/>
			</td>
		</tr>
	</table>	
</s:form>
