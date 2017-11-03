<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
    <div class="title-main">
        <h3>New Spare PC Inventory</h3>
        <div class="title-underline"></div>
    </div>

    <div class="title-underline-long"></div>

    <%--@elvariable id="newSparePC" type="com.mpe.pc.webmonitoring.domains.NewSparePC"--%>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form action="addNewSparePC" modelAttribute="newSparePC">
                <div class="panel panel-default pc-repair-form">
                    <div class="panel-heading main-title">New Spare PC Registration <a href="loadTable" class="header-link-table">View Table</a></div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>HDD Control No.</label>
                                <div class="input-group">
                                    <form:input path="controlNum" cssClass="form-control form-input"
                                                placeholder="HDD Control No."/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label>MAC Address</label>
                                <div class="input-group">
                                    <form:input path="mac" cssClass="form-control form-input"
                                                placeholder="MAC Address"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                                </div>
                                <form:errors path="mac" cssClass="error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Purpose</label>
                                <div class="input-group">
                                    <form:input path="purpose" cssClass="form-control form-input"
                                                placeholder="Purpose"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-comment"></i></span>
                                </div>
                                <form:errors path="purpose" cssClass="error"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Power Supply</label>
                                <div class="input-group">
                                    <form:input path="powerSupply" cssClass="form-control form-input"
                                                placeholder="Power Supply"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-gears"></i></span>
                                </div>
                                <form:errors path="powerSupply" cssClass="error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Intake</label>
                                <div class="input-group">
                                    <form:input path="intake" cssClass="form-control form-input"
                                                placeholder="Intake"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-gears"></i></span>
                                </div>
                                <form:errors path="intake" cssClass="error"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Exhaust</label>
                                <div class="input-group">
                                    <form:input path="exhaust" cssClass="form-control form-input"
                                                placeholder="Exhaust"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-gears"></i></span>
                                </div>
                                <form:errors path="exhaust" cssClass="error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Date Withdrawn</label>
                                <div class="input-group">
                                    <form:input path="dateWithdrawn" cssClass="form-control form-input date"
                                                placeholder="Date Withdrawn"/>
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
                                <label>Line Installed</label>
                                <div class="input-group">
                                    <form:input path="lineInstalled" cssClass="form-control form-input"
                                                placeholder="Line Installed"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                                </div>
                                <form:errors path="lineInstalled" cssClass="error"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label>Use For</label>
                                <div class="input-group">
                                    <form:input path="useFor" cssClass="form-control form-input"
                                                placeholder="Use For"/>
                                    <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                                </div>
                                <form:errors path="useFor" cssClass="error"/>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer footer-submit">
                        <button type="submit" class="btn btn-info btn-block">ADD / UPDATE</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>

    <div class="title-underline-long"></div>
    </div>
</div>


