<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p>Edit data for contact person</p>
	
<form:form action="${pageContext.request.contextPath}/contactPerson/confirm" modelAttribute="contactPersonDto" method="post">
	<form:hidden path="id"/>
	
	<div>Firstname:</div>
	<div><form:input type="text" path="firstname"/></div>
	<div><form:errors path="firstname" /></div>
	
	<div>Lastname:</div>
	<div><form:input type="text" path="lastname"/></div>
	<div><form:errors path="lastname" /></div>
		
	<div>Manufacturer:</div>
	<div>
		<form:select path="manufacturerDto" multiple="false">
			<form:options items="${manufacturers}" itemValue="id" itemLabel="name"/>
		</form:select>		
	</div>
	<div><form:errors path="manufacturerDto" /></div>
		
	<button id=save>Update</button>
</form:form>