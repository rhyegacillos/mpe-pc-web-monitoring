<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="spare-pc-wrapper">
        <div class="row">
            <div class="col-md-3">
                <a href="loadTable" class="btn btn-back-link">Back To Spare Inventory</a>
            </div>
            <div class="title-main col-md-6">
                <h3>Repaired Spare PC Withdrawal Inventory</h3>
                <div class="title-underline"></div>
            </div>
        </div>

        <div class="title-underline-long"></div>

        <div class="table-responsive">
            <table class="table main-table">
                <thead>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=controlNumber"/>" class="th-link">Control Number</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=date"/>" class="th-link">Date Repaired</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=repairedBy"/>" class="th-link">Repaired By</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=location"/>" class="th-link">Location</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=dateWithdrawn"/>" class="th-link">Date Withdrawn</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=withdrawnBy"/>" class="th-link">Withdrawn By</a></th>
                <th><a href="<spring:url value="withdrawalTable?page=0&sort=useFor"/>" class="th-link">Use For</a></th>
                </thead>
                <tbody>
                <c:forEach items="${pcSparePage.content}" var="pcSpare">
                    <tr>
                        <td><a href="<spring:url value="/pcSpare/${pcSpare.controlNumber}"/>">${pcSpare.controlNumber}</a></td>
                        <td>${pcSpare.date}</td>
                        <td>${pcSpare.repairedBy}</td>
                        <td>${pcSpare.location}</td>
                        <td>${pcSpare.dateWithdrawn}</td>
                        <td>${pcSpare.withdrawnBy}</td>
                        <td>${pcSpare.useFor}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        Total: ${pcSparesTotal}
                    </td>
                    <td colspan="5">
                        <ul class="pagination custom-pagination-tfoot">
                            <c:choose>
                                <c:when test="${pcSparePage.first}"><li><a class="first-page">Previous</a></li></c:when>
                                <c:otherwise><li><a href="<spring:url value="loadTable?page=${pcSparePage.number - 1}&sort=${sort}"/>">Previous</a></li></c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${pcSparePage.last}"><li><a class="last-page">Next</a></li></c:when>
                                <c:otherwise><li><a href="<spring:url value="loadTable?page=${pcSparePage.number + 1}&sort=${sort}"/>">Next</a></li></c:otherwise>
                            </c:choose>
                            <%--<li><a href="<spring:url value="/pcSpare/withdrawalTable?page=${pcSparePage.number - 1}&sort=${sort}"/>">Previous</a></li>--%>
                            <%--<li><a href="<spring:url value="/pcSpare/withdrawalTable?page=${pcSparePage.number + 1}"/>&sort=${sort}">Next</a></li>--%>
                            <li><a href="downloadWithdrawals">Export to Excel</a> </li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
