<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="login-page">
    <div class="form">
	<form class="login-form"
		action="<c:url value='/j_spring_security_check' />" method='POST'>
		<input name="email" type="text" placeholder="email" />
        <input name="password" type="password" placeholder="password" />
        <button>login</button>
        <p class="message">Not registered?
          <a type="submit" value="Login" href="${pageContext.request.contextPath }/general/register.html">Create an account</a>
        </p>
     </form>    
     </div>
     </div>