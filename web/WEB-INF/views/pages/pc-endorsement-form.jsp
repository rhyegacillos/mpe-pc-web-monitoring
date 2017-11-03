<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="pc-endorsement-wrapper">
        <div class="title-main">
            <h3>SEARCH PC ENDORSE RECORD</h3>
            <div class="title-underline"></div>
        </div>
        <form id="formSearch" method="get" action="searchControlNo">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="input-group">
                                <input name="controlNo" class="form-input form-control"
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
            </div>
        </form>
        <div class="title-underline-long"></div>
        <%--@elvariable id="pcEndorse" type="com.mpe.pc.webmonitoring.domains"--%>
        <form:form action="addAndUpdatePcEndorse" modelAttribute="pcEndorse">
            <div class="panel panel-default pc-repair-form">
                <div class="panel-heading main-title">PC Endorsement Registration <a href="pcEndorsementTable" class="header-link-table">View Table</a></div>
                <div class="panel-body">
                   <div class="row">
                       <div class="form-group col-md-4 col-md-offset-1">
                           <label>HDD Control No.</label>
                           <div class="input-group">
                               <form:input path="controlNo" cssClass="form-control form-input"
                                           placeholder="HDD Control No."/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                           </div>
                           <form:errors path="controlNo" cssClass="error"/>
                       </div>
                       <div class="form-group col-md-4 col-md-offset-2">
                           <label>Date Endorsed</label>
                           <div class="input-group">
                               <form:input path="dateEndorsed" cssClass="form-control form-input date" placeholder="Date Endorsed"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                           </div>
                           <form:errors path="dateEndorsed" cssClass="error"/>
                       </div>
                   </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Line</label>
                            <div class="input-group">
                                <form:input path="line" cssClass="form-control form-input" placeholder="Line"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                            <form:errors path="line" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Process</label>
                            <div class="input-group">
                                <form:input path="process" cssClass="form-control form-input" placeholder="Process"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                            <form:errors path="process" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>NG Code</label>
                            <div class="input-group">
                                <form:input path="ngCode" cssClass="form-control form-input" placeholder="NG Code"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                            <form:errors path="ngCode" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Source</label>
                            <div class="input-group">
                                <form:input path="source" cssClass="form-control form-input" placeholder="Source"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                            <form:errors path="source" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Endorsed By</label>
                            <div class="input-group">
                                <form:input path="endorsedBy" cssClass="form-control form-input"
                                            placeholder="Endorsed By"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                            </div>
                            <form:errors path="endorsedBy" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Remarks</label>
                            <div class="input-group">
                                <form:input path="remarks" cssClass="form-control form-input"
                                            placeholder="Remarks"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
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