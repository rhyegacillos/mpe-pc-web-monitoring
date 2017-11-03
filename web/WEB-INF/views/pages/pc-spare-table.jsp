<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="spare-pc-wrapper">
        <div class="row">
            <div class="col-md-3">
                <a href="loadForm" class="btn btn-back-link">Back To Registration Form</a>
            </div>
            <div class="title-main col-md-6">
                <h3>Repaired Spare PC Inventory</h3>
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
                <th><a href="<spring:url value="/pcSpare/loadTable?page=0&sort=controlNumber"/>" class="th-link">Control Number</a></th>
                <th><a href="<spring:url value="/pcSpare/loadTable?page=0&sort=date"/>" class="th-link">Date Repaired</a></th>
                <th><a href="<spring:url value="/pcSpare/loadTable?page=0&sort=repairedBy"/>" class="th-link">Repaired By</a></th>
                <th><a href="<spring:url value="/pcSpare/loadTable?page=0&sort=location"/>" class="th-link">Location</a></th>
                </thead>
                <tbody>
                <c:forEach items="${pcSparePage.content}" var="pcSpare">
                    <tr>
                        <td><a href="<spring:url value="/pcSpare/${pcSpare.controlNumber}"/>">${pcSpare.controlNumber}</a></td>
                        <td>${pcSpare.date}</td>
                        <td>${pcSpare.repairedBy}</td>
                        <td>${pcSpare.location}</td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        Total: ${pcSparesTotal}
                    </td>
                    <td colspan="4">
                        <ul class="pagination custom-pagination-tfoot">
                            <li><a href="<spring:url value="/pcSpare/loadTable?page=${pcSparePage.number - 1}&sort=${sort}"/>">Previous</a></li>
                            <li><a href="<spring:url value="/pcSpare/loadTable?page=${pcSparePage.number + 1}"/>&sort=${sort}">Next</a></li>
                            <li><a href="downloadSpares">Export to Excel</a> </li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>