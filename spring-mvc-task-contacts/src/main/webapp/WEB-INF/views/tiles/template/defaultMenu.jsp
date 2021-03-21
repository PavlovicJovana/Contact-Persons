<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<c:url value="/contactPerson/add" var="contactPersonAdd"></c:url>
	<a href="<c:out value="${contactPersonAdd}"/>">Add contact person</a>
</div>
<div>
	<c:url value="/contactPerson/list" var="contactPersonList"></c:url>
	<a href="<c:out value="${contactPersonList}"/>">List of contacts</a>
</div>
