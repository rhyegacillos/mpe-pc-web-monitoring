<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div id="pc-repair-link">
        <a href="showForm" class="btn btn-back-link">Back To Registration Form</a>
    </div>
    <div class="title-main">
        <h3>PC Parts Disposal Monitoring</h3>
        <div class="title-underline"></div>
    </div>
    <div class="table-responsive">
        <table class="table main-table">
            <thead>
            <tr>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=month,desc"/>" class="th-link">Month</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=dateDefect,desc"/>" class="th-link">Date Defect</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=source,desc"/>" class="th-link">Source</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=defectiveParts,desc"/>" class="th-link">Defective Part</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=brand,desc"/>" class="th-link">Brand</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=serialNumber,desc"/>" class="th-link">Serial Number</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=process,desc"/>" class="th-link">Process</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=pcName,desc"/>" class="th-link">PC Name</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=defect,desc"/>" class="th-link">Defect</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=datePurchased,desc"/>" class="th-link">Date Purchased</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=dateInstalled,desc"/>" class="th-link">Date Installed</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=lifespan,desc"/>" class="th-link">MTBF</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=disposedBy,desc"/>" class="th-link">Disposed By</a></th>
                <th><a href="<spring:url value="ngPcPartsTable?page=0&sort=remarks,desc"/>" class="th-link">Remarks</a></th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ngPcPartsPage.content}" var="ngPcParts">
                <tr>
                    <td><a href="<spring:url value="/ngPcParts/${ngPcParts.id}"/>">${ngPcParts.month}</a></td>
                    <td>${ngPcParts.dateDefect}</td>
                    <td>${ngPcParts.source}</td>
                    <td>${ngPcParts.defectiveParts}</td>
                    <td>${ngPcParts.brand}</td>
                    <td>${ngPcParts.serialNumber}</td>
                    <td>${ngPcParts.process}</td>
                    <td>${ngPcParts.pcName}</td>
                    <td>${ngPcParts.defect}</td>
                    <td>${ngPcParts.datePurchased}</td>
                    <td>${ngPcParts.installedDate}</td>
                    <td>${ngPcParts.lifespan}</td>
                    <td>${ngPcParts.disposedBy}</td>
                    <td>${ngPcParts.remarks}</td>
                    <td><a href="<spring:url value="/ngPcParts/${ngPcParts.id}/delete"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="5">
                    <span>Total: ${totalNgPcParts}</span> | <span> Page ${ngPcPartsPage.number + 1} of ${ngPcPartsPage.totalPages}
                </td>
                <td colspan="10">
                    <ul class="pagination custom-pagination-tfoot">
                        <c:choose>
                            <c:when test="${ngPcPartsPage.first}"><li><a class="first-page">Previous</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="ngPcPartsTable?page=${ngPcPartsPage.number - 1}&sort=${sort},desc"/>">Previous</a></li></c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${ngPcPartsPage.last}"><li><a class="last-page">Next</a></li></c:when>
                            <c:otherwise><li><a href="<spring:url value="ngPcPartsTable?page=${ngPcPartsPage.number + 1}&sort=${sort},desc"/>">Next</a></li></c:otherwise>
                        </c:choose>
                        <li><a href="download">Export to Excel</a> </li>
                    </ul>
                </td>
            </tr>
            </tfoot>
        </table>

    </div>
</div>
