<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="spare-pc-wrapper">
        <div class="row">
            <div class="col-md-3">
                <a href="showForm" class="btn btn-back-link">Back To Registration Form</a>
            </div>
            <div class="title-main col-md-6">
                <h3>Users Table</h3>
                <div class="title-underline"></div>
            </div>
        </div>


        <div class="title-underline-long"></div>

        <div class="table-responsive">
            <table class="table main-table">
                <thead>
                <th><a href="<spring:url value="loadTable?page=0&sort=employeeId"/>" class="th-link">Employee ID</a></th>
                <th><a href="<spring:url value="loadTable?page=0&sort=firstName"/>" class="th-link">First Name</a></th>
                <th><a href="<spring:url value="loadTable?page=0&sort=lastName"/>" class="th-link">Last Name</a></th>
                <th><a href="<spring:url value="loadTable?page=0&sort=password"/>" class="th-link">Password</a></th>
                <th>Action</th>
                </thead>
                <tbody>
                <c:forEach items="${users.content}" var="user">
                    <tr>
                        <td>${user.employeeId}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.password}</td>
                        <td><a href="<spring:url value="/user/${user.employeeId}"/>">DELETE</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="2">
                        <span>Total: ${totalUsers}</span> | <span> Page ${users.number + 1} of ${users.totalPages}
                    </td>
                    <td colspan="4">
                        <ul class="pagination custom-pagination-tfoot">
                            <li><a href="<spring:url value="loadTable?page=${page.number - 1}&sort=${sort}"/>">Previous</a></li>
                            <li><a href="<spring:url value="loadTable?page=${page.number + 1}"/>&sort=${sort}">Next</a></li>
                            <li><a href="download">Export to Excel</a> </li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
