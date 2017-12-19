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
			<td valign="top">Roles</td>
			<td>
				<c:forEach var="role" items="${roles }">
					<input type="checkbox" name="roles" 
					value="${role.id }"> ${role.name }
					<br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<input type="submit" value="Save"/>
			</td>
		</tr>
		<!--
		<tr>
			<td>Enable</td>
			<td>
				<s:checkbox path="enabled" value="1"/>
			</td>
		</tr>
		-->
	</table>
	
	<input type="submit" value="Save" style="width:30px;height:50px; background: blue;"/>
</s:form>
