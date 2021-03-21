<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>All contact persons</p>
	
<div>
	<h1>All contact persons</h1>
	<table>
		<thead>
			<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Manufacturer id</th>
				<th>Manufacturer name</th>
				<th>City code</th>
				<th>City name</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="contactPerson" items="${contactPersons}">
			<tr>
				<td>${contactPerson.firstname}</td>
				<td>${contactPerson.lastname}</td>
				<td>${contactPerson.manufacturerDto.id}</td>
				<td>${contactPerson.manufacturerDto.name}</td>
				<td>${contactPerson.manufacturerDto.cityDto.number}</td>
				<td>${contactPerson.manufacturerDto.cityDto.name}</td>
				<td><a href="${pageContext.request.contextPath}/contactPerson/details/id/${contactPerson.id}">details</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>