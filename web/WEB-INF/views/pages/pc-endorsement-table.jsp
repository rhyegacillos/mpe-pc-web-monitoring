<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <a href="showForm" class="btn btn-back-link">Back To Registration Form</a>
        </div>
        <div class="title-main col-md-6">
            <h3>PC Endorsement Inventory</h3>
            <div class="title-underline"></div>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table main-table table-search">
            <thead>
            <tr>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=controlNo"/>" class="th-link">HDD Control Number</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=dateEndorsed"/>" class="th-link">Date Endorsed</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=line"/>" class="th-link">Line</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=process"/>" class="th-link">Process</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=ngCode"/>" class="th-link">NG Code</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=source"/>" class="th-link">Source</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=endorsedBy"/>" class="th-link">Endorsed By</a></th>
                <th><a href="<spring:url value="pcEndorsementTable?page=0&sort=remarks"/>" class="th-link">Remarks</a></th>
                <th>ACTION</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pcEndorsePage.content}" var="pcEndorse">
                <tr>
                    <td><a href="<spring:url value="/pcEndorse/${pcEndorse.controlNo}"/>">${pcEndorse.controlNo}</a></td>
                    <td>${pcEndorse.dateEndorsed}</td>
                    <td>${pcEndorse.line}</td>
                    <td>${pcEndorse.process}</td>
                    <td>${pcEndorse.ngCode}</td>
                    <td>${pcEndorse.source}</td>
                    <td>${pcEndorse.endorsedBy}</td>
                    <td>${pcEndorse.remarks}</td>
                    <td><a href="<spring:url value="/pcEndorse/${pcEndorse.controlNo}/delete"/>">DELETE</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="22">
                        Total: ${pcEndorseTotal}
                    </td>
                </tr>
            </tfoot>
        </table>
        <ul class="pagination custom-pagination">
            <c:choose>
                <c:when test="${pcEndorsePage.first}"><li><a class="first-page">Previous</a></li></c:when>
                <c:otherwise><li><a href="<spring:url value="pcEndorsementTable?page=${pcEndorsePage.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${pcEndorsePage.last}"><li><a class="last-page">Next</a></li></c:when>
                <c:otherwise><li><a href="<spring:url value="pcEndorsementTable?page=${pcEndorsePage.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
            </c:choose>
            <li><a href="download">Export to Excel</a> </li>
        </ul>
    </div>
</div>
