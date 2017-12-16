<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="main-wrapper">
        <div class="title-main">
            <h3>SEARCH PC REPAIR RECORD</h3>
            <div class="title-underline"></div>
        </div>
        <form id="formSearch" method="get" action="searchControlNo">
            <div class="form-horizontal">
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
                    <label class="error">${occurrenceAlert}</label>
                </div>
            </div>
        </form>
        <div class="title-underline-long"></div>
        <%--@elvariable id="pcRepair" type="com.mpe.pc.webmonitoring.domains"--%>
        <form:form action="updatePcRepairInfo" modelAttribute="pcRepair">
            <div class="panel panel-default pc-repair-form">
                <div class="panel-heading main-title">PC Repair Registration <a href="pcRepairTable" class="header-link-table">View Table</a></div>
                <div class="panel-body">
                   <div class="row">
                       <div class="form-group col-md-4 col-md-offset-1">
                           <label>HDD Control No.</label>
                           <div class="input-group">
                               <form:input path="controlNumber" cssClass="form-control form-input"
                                           placeholder="HDD Control No."/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                           </div>
                           <form:errors path="controlNumber" cssClass="error"/>
                       </div>
                       <div class="form-group col-md-4 col-md-offset-2">
                           <label>MAC Address</label>
                           <div class="input-group">
                               <form:input path="mac" cssClass="form-control form-input" placeholder="MAC address"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                           </div>
                           <form:errors path="mac" cssClass="error"/>
                       </div>
                   </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Mobo Serial</label>
                            <div class="input-group">
                                <form:input path="mobo" cssClass="form-control form-input" placeholder="Mobo Serial"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                            </div>
                            <form:errors path="mobo" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>PM Date</label>
                            <div class="input-group">
                                <form:input path="pmDate" cssClass="form-control form-input date"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Station</label>
                            <div class="input-group">
                                <form:input path="station" cssClass="form-control form-input" placeholder="Station"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>PC Name</label>
                            <div class="input-group">
                                <form:input path="pcName" cssClass="form-control form-input" placeholder="PC Name"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>NG Description</label>
                            <div class="input-group">
                                <form:input path="ngDescription" cssClass="form-control form-input"
                                            placeholder="NG Description"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Finding</label>
                            <div class="input-group">
                                <form:input path="finding" cssClass="form-control form-input"
                                            placeholder="Finding"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Weak Component</label>
                            <div class="input-group">
                                <form:input path="weakComponent" cssClass="form-control form-input"
                                            placeholder="Weak Component"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Action Taken </label>
                            <div class="input-group">
                                <form:input path="actionTaken" cssClass="form-control form-input"
                                            placeholder="Action Taken"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>HDD Installed</label>
                            <div class="input-group">
                                <form:select path="hddInstalled" items="${hddInstalledList}"
                                             cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-hdd-o"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>HDD Orientation</label>
                            <div class="input-group">
                                <form:select path="hddOrientation" items="${hddOrientations}"
                                             cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-hdd-o"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Source</label>
                            <div class="input-group">
                                <form:input path="source" cssClass="form-control form-input" placeholder="Source"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-info-circle"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Month </label>
                            <div class="input-group">
                                <form:select path="month" items="${monthList}" cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar-o"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Change Fan</label>
                            <div class="input-group">
                                <form:input path="changeFan" cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                            <form:errors path="changeFan" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Remove Intake Fan</label>
                            <div class="input-group">
                                <form:input path="removedIntakeFan" cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                            <form:errors path="removedIntakeFan" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>NG Occurrence</label>
                            <div class="input-group">
                                <form:input path="ngOccurrence" cssClass="form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-wrench"></i></span>
                            </div>
                            <form:errors path="ngOccurrence" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Remarks</label>
                            <div class="input-group">
                                <form:input path="remarks" cssClass="form-control form-input" placeholder="Remarks"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Date Repair Start</label>
                            <div class="input-group">
                                <form:input path="dateRepairStart" cssClass="date date form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                            <form:errors path="dateRepairStart" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Date Repair End</label>
                            <div class="input-group">
                                <form:input path="dateRepairEnd" cssClass="date date form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                            <form:errors path="dateRepairEnd" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Repaired by</label>
                            <div class="input-group">
                                <form:input path="repairedBy" cssClass="form-control form-input" placeholder="Repaired By"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-user-circle-o"></i></span>
                            </div>
                            <form:errors path="repairedBy" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Date Endorsed</label>
                            <div class="input-group">
                                <form:input path="dateEndorsed" cssClass="date date form-control form-input"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
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