<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">

    <div class="row">
        <div class="col-md-3">
            <a href="loadForm" class="btn btn-back-link">Back To Registration Form</a>
        </div>
        <div class="title-main col-md-6">
            <h3>New Spare PC Inventory</h3>
            <div class="title-underline"></div>
        </div>
        <div id="withdraw-link" class="col-md-3">
            <a href="withdrawTable" class="btn btn-back-link">View Withdrawal Inventory</a>
        </div>

    </div>

    <div class="table-responsive">
        <table class="table main-table">
            <thead>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=controlNum"/>" class="th-link">Control Number</a></th>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=mac"/>" class="th-link">MAC Address</a></th>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=purpose"/>" class="th-link">Purpose</a></th>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=powerSupply"/>" class="th-link">Power Supply</a></th>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=intake"/>" class="th-link">Intake Fan</a></th>
            <th><a href="<spring:url value="/newSpare/loadTable?page=0&sort=exhaust"/>" class="th-link">Exhaust Fan</a></th>
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
                    <td><a href="<spring:url value="/newSpare/${pcSpare.mac}/delete"/>">DELETE</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    <span>Total: ${newSparesTotal}</span> | <span> Page ${newSparePage.number + 1} of ${newSparePage.totalPages}
                </td>
                <td colspan="5">
                    <ul class="pagination custom-pagination-tfoot">
                        <c:choose>
                            <c:when test="${newSparePage.first}"><li><a class="first-page">Previous</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="loadTable?page=${newSparePage.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${newSparePage.last}"><li><a class="last-page">Next</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="loadTable?page=${newSparePage.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
                        </c:choose>
                        <li><a href="downloadSpares">Export to Excel</a> </li>
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</div>


