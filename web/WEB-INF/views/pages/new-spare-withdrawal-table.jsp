<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <a href="loadTable" class="btn btn-back-link">Back To Spare Inventory</a>
        </div>
        <div class="title-main col-md-6">
            <h3>New Spare Withdrawal Inventory</h3>
            <div class="title-underline"></div>
        </div>
    </div>

    <div class="table-responsive">
        <table class="table main-table">
            <thead>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=controlNum,desc"/>" class="th-link">Control Number</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=mac,desc"/>" class="th-link">MAC Address</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=purpose,desc"/>" class="th-link">Purpose</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=powerSupply,desc"/>" class="th-link">Power Supply</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=intake,desc"/>" class="th-link">Intake Fan</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=exhaust,desc"/>" class="th-link">Exhaust Fan</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=withdrawnBy,desc"/>" class="th-link">Withdrawn By</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=dateWithdrawn,desc"/>" class="th-link">Date Withdrawn</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=lineInstalled,desc"/>" class="th-link">Line Installed</a></th>
            <th><a href="<spring:url value="withdrawTable?page=0&sort=useFor,desc"/>" class="th-link">Use For</a></th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${newSparePage.content}" var="pcSpare">
                <tr>
                    <td>${pcSpare.controlNum}</td>
                    <td><a href="<spring:url value="/newSpare/${pcSpare.mac}"/>">${pcSpare.mac}</a></td>
                    <td>${pcSpare.purpose}</td>
                    <td>${pcSpare.powerSupply}</td>
                    <td>${pcSpare.intake}</td>
                    <td>${pcSpare.exhaust}</td>
                    <td>${pcSpare.withdrawnBy}</td>
                    <td>${pcSpare.dateWithdrawn}</td>
                    <td>${pcSpare.lineInstalled}</td>
                    <td>${pcSpare.useFor}</td>
                    <td><a href="<spring:url value="/newSpare/${pcSpare.mac}/delete"/>">DELETE</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    Total: ${newSparesTotal}
                </td>
                <td colspan="9">
                    <ul class="pagination custom-pagination-tfoot">
                        <c:choose>
                            <c:when test="${newSparePage.first}"><li><a class="first-page">Previous</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="withdrawTable?page=${newSparePage.number - 1}&sort=${sort},desc"/>">Previous</a></li></c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${newSparePage.last}"><li><a class="last-page">Next</a></li></c:when>
                            <c:otherwise><li><li><a href="<spring:url value="withdrawTable?page=${newSparePage.number + 1}&sort=${sort},desc"/>">Next</a></li></c:otherwise>
                        </c:choose>
                        <%--<li><a href="<spring:url value="withdrawTable?page=${newSparePage.number - 1}&sort=${sort}"/>">Previous</a></li>--%>
                        <%--<li><a href="<spring:url value="withdrawTable?page=${newSparePage.number + 1}"/>&sort=${sort}">Next</a></li>--%>
                        <li><a href="downloadWithdrawals">Export to Excel</a> </li>
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>


