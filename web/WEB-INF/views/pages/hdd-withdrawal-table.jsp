<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <a href="hddTable" class="btn btn-back-link">Back To HDD Spare Inventory</a>
        </div>
        <div class="title-main col-md-6">
            <h3>HDD Table Inventory</h3>
            <div class="title-underline"></div>
        </div>
    </div>
    <div class="title-underline-long"></div>
    <div class="table-responsive">
        <table class="table main-table">
            <thead>
            <tr>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=moduleNo"/>" class="th-link">Module Number</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=hddSize"/>" class="th-link">HDD Size</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=brand"/>" class="th-link">Brand</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=purpose"/>" class="th-link">Purpose</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=dateWithdrawn,desc"/>" class="th-link">Date Withdrawn</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=withdrawnBy"/>" class="th-link">Withdrawn By</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=useFor"/>" class="th-link">Use For</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=mac"/>" class="th-link">MAC Address</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=hddNo"/>" class="th-link">PC Control No.</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=lineInstalled"/>" class="th-link">Line Installed</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=remarks"/>" class="th-link">Remarks</a></th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${hddPage.content}" var="hdd">
                <tr>
                    <td><a href="<spring:url value="${hdd.moduleNo}"/>">${hdd.moduleNo}</a></td>
                    <td>${hdd.hddSize}</td>
                    <td>${hdd.brand}</td>
                    <td>${hdd.purpose}</td>
                    <td>${hdd.dateWithdrawn}</td>
                    <td>${hdd.withdrawnBy}</td>
                    <td>${hdd.useFor}</td>
                    <td>${hdd.mac}</td>
                    <td>${hdd.hddNo}</td>
                    <td>${hdd.lineInstalled}</td>
                    <td>${hdd.remarks}</td>
                    <td><a href="<spring:url value="/hdd/${hdd.moduleNo}/delete"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    Total: ${totalHdd}
                </td>
                <td colspan="12">
                    <ul class="pagination custom-pagination-tfoot">
                        <c:choose>
                            <c:when test="${hddPage.first}"><li><a class="first-page">Previous</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="withdrawalTable?page=${hddPage.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${hddPage.last}"><li><a class="last-page">Next</a></li></c:when>
                            <c:otherwise><li><li><a href="<spring:url value="withdrawalTable?page=${hddPage.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
                        </c:choose>
                        <li><a href="downloadWithdrawals">Export to Excel</a> </li>
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
