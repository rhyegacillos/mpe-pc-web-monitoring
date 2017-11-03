<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <div class="spare-pc-wrapper">
        <div class="title-main">
            <h3>Repaired PC Spare Search</h3>
            <div class="title-underline"></div>
        </div>
        <form id="formSearch" method="get" action="searchSparePC">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="input-group">
                            <input name="controlNum" class="form-input form-control"
                                   placeholder="Search HDD Control No.">
                            <span class="input-group-addon fa-icon"><i class="fa fa-search"
                                                                       onkeypress="return checkSubmit(event)"
                                                                       onclick="document.getElementById('formSearch').submit()"></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group text-center">
                <label class="error">${noRecord}</label>
            </div>
        </form>

        <div class="title-underline-long"></div>

        <%--@elvariable id="pcSpare" type="com.mpe.pc.webmonitoring.domains.PCSpare"--%>
        <div class="row">
            <form:form action="addSparePC" modelAttribute="pcSpare">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default pc-repair-form">
                        <div class="panel-heading main-title">Repaired Spare PC Registration <a href="loadTable" class="header-link-table">View Table</a> </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>HDD Control No.</label>
                                    <div class="input-group">
                                        <form:input path="controlNumber" cssClass="form-control form-input"
                                                    placeholder="HDD Control No." readonly="true"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                                    </div>
                                    <form:errors path="controlNumber" cssClass="error"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Repaired by</label>
                                    <div class="input-group">
                                        <form:input path="repairedBy" cssClass="form-control form-input"
                                                    placeholder="Repaired By" readonly="true"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-user-circle-o"></i></span>
                                    </div>
                                    <form:errors path="repairedBy" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Date Repaired</label>
                                    <div class="input-group">
                                        <form:input path="date" cssClass="form-control form-input" placeholder="Date Repaired" readonly="true"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                    <form:errors path="date" cssClass="error"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Location</label>
                                    <div class="input-group">
                                        <form:input path="location" cssClass="form-control form-input"
                                                    placeholder="location"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-location-arrow"></i></span>
                                    </div>
                                    <form:errors path="location" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Date Withdrawn</label>
                                    <div class="input-group">
                                        <form:input path="dateWithdrawn" cssClass="form-control form-input date" placeholder="Date Withdrawn"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                    <form:errors path="dateWithdrawn" cssClass="error"/>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Withdrawn By</label>
                                    <div class="input-group">
                                        <form:input path="withdrawnBy" cssClass="form-control form-input"
                                                    placeholder="Withdrawn By"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                                    </div>
                                    <form:errors path="withdrawnBy" cssClass="error"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Use For</label>
                                    <div class="input-group">
                                        <form:input path="useFor" cssClass="form-control form-input"
                                                    placeholder="Use For"/>
                                        <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                                    </div>
                                    <form:errors path="useFor" cssClass="error"/>
                                </div>
                            </div>
                            </div>
                        <div class="panel-footer footer-submit">
                            <button type="submit" class="btn btn-info btn-block">ADD / UPDATE</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>

        <div class="title-underline-long"></div>

    </div>
</div>
