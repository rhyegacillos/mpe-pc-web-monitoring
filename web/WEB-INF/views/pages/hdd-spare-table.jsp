<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <a href="showForm" class="btn btn-back-link">Back To Registration Form</a>
        </div>
        <div class="title-main col-md-6">
            <h3>HDD Table Inventory</h3>
            <div class="title-underline"></div>
        </div>
        <div id="withdraw-link" class="col-md-3">
            <a href="withdrawalTable" class="btn btn-back-link">View Withdrawal Inventory</a>
        </div>
    </div>
    <div class="title-underline-long"></div>
    <div class="table-responsive">
        <table class="table main-table">
            <thead>
            <tr>
                <th><a href="<spring:url value="hddTable?page=0&sort=moduleNo"/>" class="th-link">Module Number</a></th>
                <th><a href="<spring:url value="hddTable?page=0&sort=hddSize"/>" class="th-link">HDD Size</a></th>
                <th><a href="<spring:url value="hddTable?page=0&sort=brand"/>" class="th-link">Brand</a></th>
                <th><a href="<spring:url value="hddTable?page=0&sort=purpose"/>" class="th-link">Purpose</a></th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hddPage.content}" var="hdd">
                <tr>
                    <td><a href="<spring:url value="/hdd/${hdd.moduleNo}"/>">${hdd.moduleNo}</a></td>
                    <td>${hdd.hddSize}</td>
                    <td>${hdd.brand}</td>
                    <td>${hdd.purpose}</td>
                    <td><a href="<spring:url value="/hdd/${hdd.moduleNo}/delete"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="1">
                    Total: ${totalHdd}
                </td>
                <td colspan="4">
                    <ul class="pagination custom-pagination-tfoot">
                        <c:choose>
                            <c:when test="${hddPage.first}"><li><a class="first-page">Previous</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="/hdd/hddTable?page=${hddPage.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${hddPage.last}"><li><a class="last-page">Next</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="/hdd/hddTable?page=${hddPage.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
                        </c:choose>
                        <li><a href="downloadSpares">Export to Excel</a></li>
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
