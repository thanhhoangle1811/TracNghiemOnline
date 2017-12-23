<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>${examName}</div>
<br/>
<div>${totalRightAnswer} of ${totalQuestion} questions answered correctly</div>
<br/>
<div>You have reached ${totalGradeOfUser} of ${totalGradeOfExam} points</div>
