<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
    <div class="title-main">
        <h3>User Registration</h3>
        <div class="title-underline"></div>
    </div>

    <div class="title-underline-long"></div>

    <%--@elvariable id="user" type="com.mpe.pc.webmonitoring.domains.User"--%>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form action="addNewUser" modelAttribute="user">
                <div class="panel panel-default pc-repair-form">
                    <div class="panel-heading main-title">Add New User Registration <a href="loadTable" class="header-link-table">View Table</a></div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Employee Number</label>
                                <div class="input-group">
                                    <form:input path="employeeId" cssClass="form-control form-input"
                                                placeholder="Employee ID"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-id-badge"></i></span>
                                </div>
                                <form:errors path="employeeId" cssClass="error"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label>First Name</label>
                                <div class="input-group">
                                    <form:input path="firstName" cssClass="form-control form-input"
                                                placeholder="First Name"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                                </div>
                                <form:errors path="firstName" cssClass="error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Last Name</label>
                                <div class="input-group">
                                    <form:input path="lastName" cssClass="form-control form-input"
                                                placeholder="Last Name"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                                </div>
                                <form:errors path="lastName" cssClass="error"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Password</label>
                                <div class="input-group">
                                    <form:input path="password" cssClass="form-control form-input"
                                                placeholder="Password"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-key"></i></span>
                                </div>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer footer-submit">
                        <button type="submit" class="btn btn-info btn-block">ADD USER</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <div class="title-underline-long"></div>
</div>
</div>


