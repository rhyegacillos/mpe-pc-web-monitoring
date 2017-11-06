<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <a href="loadForm" class="btn btn-back-link">Back To Registration Form</a>
        </div>
        <div class="title-main col-md-6">
            <h3>PC Repair Table Inventory</h3>
            <div class="title-underline"></div>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table main-table table-search">
            <thead>
            <tr>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=controlNumber"/>" class="th-link">Control
                    Number</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=mac"/>" class="th-link">MAC
                    Address</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=mobo"/>" class="th-link">MOBO</a>
                </th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=pmDate"/>" class="th-link">PM
                    Date</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=station"/>"
                       class="th-link">Station</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=pcName"/>" class="th-link">PC
                    Name</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=ngDescription"/>" class="th-link">NG
                    Description</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=finding"/>"
                       class="th-link">Finding</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=weakComponent"/>" class="th-link">Weak
                    Component</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=actionTaken"/>" class="th-link">Action
                    Taken</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=hddInstalled"/>" class="th-link">HDD
                    Installed</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=hddOrientation"/>" class="th-link">HDD
                    Orientation</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=source"/>"
                       class="th-link">Source</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=month"/>" class="th-link">Month</a>
                </th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=changeFan"/>" class="th-link">Change
                    Fan</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=removedIntakeFan"/>"
                       class="th-link">Remove Intake Fan</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=ngOccurrence"/>" class="th-link">NG
                    Occurrence</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=remarks"/>"
                       class="th-link">Remarks</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=dateRepairStart"/>" class="th-link">Date
                    Repair Start</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=dateRepairEnd"/>" class="th-link">Date
                    Repair End</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=repairedBy"/>" class="th-link">Repaired
                    By</a></th>
                <th><a href="<spring:url value="/pcRepair/pcRepairTable?page=0&sort=dateEndorsed"/>" class="th-link">Date
                    Endorsed</a></th>
                <th>ACTION</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.content}" var="pcRepair">
                <tr>
                    <td><a href="<spring:url value="/pcRepair/${pcRepair.controlNumber}"/>">${pcRepair.controlNumber}</a></td>
                    <td>${pcRepair.mac}</td>
                    <td>${pcRepair.mobo}</td>
                    <td>${pcRepair.pmDate}</td>
                    <td>${pcRepair.station}</td>
                    <td>${pcRepair.pcName}</td>
                    <td>${pcRepair.ngDescription}</td>
                    <td>${pcRepair.finding}</td>
                    <td>${pcRepair.weakComponent}</td>
                    <td>${pcRepair.actionTaken}</td>
                    <td>${pcRepair.hddInstalled}</td>
                    <td>${pcRepair.hddOrientation}</td>
                    <td>${pcRepair.source}</td>
                    <td>${pcRepair.month}</td>
                    <td>${pcRepair.changeFan}</td>
                    <td>${pcRepair.removedIntakeFan}</td>
                    <td>${pcRepair.ngOccurrence}</td>
                    <td>${pcRepair.remarks}</td>
                    <td>${pcRepair.dateRepairStart}</td>
                    <td>${pcRepair.dateRepairEnd}</td>
                    <td>${pcRepair.repairedBy}</td>
                    <td>${pcRepair.dateEndorsed}</td>
                    <td><a href="<spring:url value="/pcRepair/${pcRepair.controlNumber}/delete"/>">DELETE</a></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="22">
                        Total: ${size}
                    </td>
                </tr>
            </tfoot>
        </table>
        <ul class="pagination custom-pagination">
            <c:choose>
                <c:when test="${page.first}"><li><a class="first-page">Previous</a></li></c:when>
                <c:otherwise><li><a href="<spring:url value="pcRepairTable?page=${page.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${page.last}"><li><a class="last-page">Next</a></li></c:when>
                <c:otherwise><li><a href="<spring:url value="pcRepairTable?page=${page.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
            </c:choose>
            <%--<li><a href="<spring:url value="/pcRepair/pcRepairTable?page=${page.number - 1}&sort=${sort}"/>">Previous</a></li>--%>
            <%--<li><a href="<spring:url value="/pcRepair/pcRepairTable?page=${page.number + 1}&&sort=${sort}"/>">Next</a></li>--%>
            <li><a href="download">Export to Excel</a> </li>
        </ul>
    </div>
</div>
