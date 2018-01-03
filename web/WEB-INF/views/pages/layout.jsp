<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        <tiles:insertAttribute name="title" />
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/responsive.css">

</head>
<body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />

<script src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/jquery.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/javascript/custom.js"></script>
</body>
</html>



