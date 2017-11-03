<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="hdd-wrapper">
        <div class="title-main">
            <h3>SEARCH HDD RECORD</h3>
            <div class="title-underline"></div>
        </div>
        <form id="formSearch" method="get" action="searchHdd">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="input-group">
                                <input name="moduleNo" class="form-input form-control"
                                       placeholder="Search HDD ">
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
            </div>
        </form>
        <div class="title-underline-long"></div>
        <%--@elvariable id="hdd" type="com.mpe.pc.webmonitoring.domains"--%>
        <form:form action="addHdd" modelAttribute="hdd">
            <div class="panel panel-default pc-repair-form">
                <div class="panel-heading main-title">HDD Registration <a href="hddTable" class="header-link-table">View Table</a></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Module No.</label>
                            <div class="input-group">
                                <form:input path="moduleNo" cssClass="form-control form-input"
                                            placeholder="Module No."/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-barcode"></i></span>
                            </div>
                            <form:errors path="moduleNo" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Brand</label>
                            <div class="input-group">
                                <form:input path="brand" cssClass="form-control form-input" placeholder="Brand"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                            </div>
                            <form:errors path="brand" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>HDD Size</label>
                            <div class="input-group">
                                <form:select path="hddSize" items="${hddSize}" cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-hdd-o"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Purpose</label>
                            <div class="input-group">
                                <form:input path="purpose" cssClass="form-control form-input" placeholder="Purpose"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                            </div>
                            <form:errors path="purpose" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Date Withdrawn</label>
                            <div class="input-group">
                                <form:input path="dateWithdrawn" cssClass="form-control form-input date" placeholder="Date Withdrawn"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Withdrawn By</label>
                            <div class="input-group">
                                <form:input path="withdrawnBy" cssClass="form-control form-input" placeholder="Withdrawn By"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                            </div>
                            <form:errors path="withdrawnBy" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Use For</label>
                            <div class="input-group">
                                <form:input path="useFor" cssClass="form-control form-input"
                                            placeholder="Use For"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-location-arrow"></i></span>
                            </div>
                            <form:errors path="useFor" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
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
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>PC Control Number</label>
                            <div class="input-group">
                                <form:input path="hddNo" cssClass="form-control form-input"
                                            placeholder="PC Control Number"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                            </div>
                            <form:errors path="hddNo" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Line Installed</label>
                            <div class="input-group">
                                <form:input path="lineInstalled" cssClass="form-control form-input"
                                            placeholder="Action Taken"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-location-arrow"></i></span>
                            </div>
                            <form:errors path="lineInstalled" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Remarks</label>
                            <div class="input-group">
                                <form:input path="remarks" cssClass="form-control form-input"
                                            placeholder="Remarks"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-hdd-o"></i></span>
                            </div>
                            <form:errors path="remarks" cssClass="error"/>
                        </div>
                    </div>

                </div>
                <div class="panel-footer footer-submit">
                    <button type="submit" class="btn btn-block">SUBMIT</button>
                </div>
            </div>
        </form:form>
    </div>
</div>