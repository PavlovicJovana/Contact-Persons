<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<p>Press the confirm button</p>

<form:form action="${pageContext.request.contextPath}/contactPerson/saveOrUpdate" modelAttribute="contactPersonDto" method="post">
	<form:hidden path="id"/>
		
	<div>Firstname</div>
	<div><form:input type="text" path="firstname" readonly="readonly"/></div>
	<div><form:errors path="firstname" /></div>
		
	<div>Lastname</div>
	<div><form:input type="text" path="lastname" readonly="readonly"/></div>
	<div><form:errors path="lastname" /></div>
		
	<div>Manufacturer id</div>
	<div><form:input type="text" path="manufacturerDto.id" readonly="readonly"/></div>
	<div><form:errors path="manufacturerDto.id" /></div>
		
	<div>Manufacturer name</div>
	<div><form:input type="text" path="manufacturerDto.name" readonly="readonly"/></div>
	<div><form:errors path="manufacturerDto.name" /></div>
		
	<div>City code</div>
	<div><form:input type="text" path="manufacturerDto.cityDto.number" readonly="readonly"/></div>
	<div><form:errors path="manufacturerDto.cityDto.number" /></div>
		
	<div>City name</div>
	<div><form:input type="text" path="manufacturerDto.cityDto.name" readonly="readonly"/></div>
	<div><form:errors path="manufacturerDto.cityDto.name" /></div>
		
	<div>
		<button id=save>Confirm</button>
	</div>
</form:form>