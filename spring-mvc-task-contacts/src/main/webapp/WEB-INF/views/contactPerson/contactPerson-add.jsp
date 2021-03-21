<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p>Add new contact person</p>
	
<c:if test="${not empty info}">
	<div>${info}</div>
</c:if>
	
<form:form action="${pageContext.request.contextPath}/contactPerson/confirm" modelAttribute="contactPersonDto" method="post">
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
		
	<button id=save>Save</button>
</form:form>