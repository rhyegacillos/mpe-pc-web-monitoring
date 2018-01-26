<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="hdd-wrapper">
        <div class="title-main">
            <h3>SEARCH NG PC PARTS RECORD</h3>
            <div class="title-underline"></div>
        </div>
        <form id="formSearch" method="get" action="searchNgPcParts">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="input-group">
                                <input name="serialNumber" class="form-input form-control"
                                       placeholder="Search serial number ">
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
        <%--@elvariable id="ngPcParts" type="com.mpe.pc.webmonitoring.domains"--%>
        <form:form action="addNgPcParts" modelAttribute="ngPcParts">
            <div class="panel panel-default pc-repair-form">
                <div class="panel-heading main-title">NG PC Parts Registration <a href="ngPcPartsTable" class="header-link-table">View Table</a></div>
                <div class="panel-body">
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Month</label>
                            <div class="input-group">
                                <form:select path="month" items="${months}" cssClass="form-control form-input"
                                             placeholder="Month"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Date Defect</label>
                            <div class="input-group">
                                <form:input path="dateDefect" cssClass="form-control form-input date" placeholder="Date Defect"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                            <form:errors path="dateDefect" cssClass="error"/>
                        </div>
                    </div>
                   <div class="row">
                       <div class="form-group col-md-4 col-md-offset-1">
                           <label>Source</label>
                           <div class="input-group">
                               <form:input path="source" cssClass="form-control form-input" placeholder="Source"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                           </div>
                           <form:errors path="source" cssClass="error"/>
                       </div>
                       <div class="form-group col-md-4 col-md-offset-2">
                           <label>Defective Parts</label>
                           <div class="input-group">
                               <form:input path="defectiveParts" cssClass="form-control form-input" placeholder="Defective Parts"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-gears"></i></span>
                           </div>
                           <form:errors path="defectiveParts" cssClass="error"/>
                       </div>
                   </div>
                   <div class="row">
                       <div class="form-group col-md-4 col-md-offset-1">
                           <label>Brand</label>
                           <div class="input-group">
                               <form:input path="brand" cssClass="form-control form-input" placeholder="Brand"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                           </div>
                       </div>
                       <div class="form-group col-md-4 col-md-offset-2">
                           <label>Serial Number</label>
                           <div class="input-group">
                               <form:input path="serialNumber" cssClass="form-control form-input" placeholder="Serial Number"/>
                               <span class="input-group-addon fa-icon"><i class="fa fa-barcode"></i></span>
                           </div>
                       </div>
                   </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Process</label>
                            <div class="input-group">
                                <form:input path="process" cssClass="form-control form-input"
                                            placeholder="Process"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                            </div>
                            <form:errors path="process" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>PC Name</label>
                            <div class="input-group">
                                <form:input path="pcName" cssClass="form-control form-input"
                                            placeholder="PC Name"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-desktop"></i></span>
                            </div>
                            <form:errors path="pcName" cssClass="error"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Defect</label>
                            <div class="input-group">
                                <form:input path="defect" cssClass="form-control form-input"
                                            placeholder="Defect"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-sticky-note"></i></span>
                            </div>
                            <form:errors path="defect" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Date Purchased</label>
                            <div class="input-group">
                                <form:input path="datePurchased" cssClass="form-control form-input date"
                                            placeholder="Date Purchased"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Installed Date</label>
                            <div class="input-group">
                                <form:input path="installedDate" cssClass="form-control form-input date"
                                            placeholder="Installed Date"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>MTBF</label>
                            <div class="input-group">
                                <form:input path="lifespan" cssClass="form-control form-input"
                                            placeholder="MTBF"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-pencil"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-4 col-md-offset-1">
                            <label>Disposed By</label>
                            <div class="input-group">
                                <form:input path="disposedBy" cssClass="form-control form-input"
                                            placeholder="Disposed By"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-user"></i></span>
                            </div>
                            <form:errors path="disposedBy" cssClass="error"/>
                        </div>
                        <div class="form-group col-md-4 col-md-offset-2">
                            <label>Remarks</label>
                            <div class="input-group">
                                <form:input path="remarks" cssClass="form-control form-input"
                                            placeholder="Remarks"/>
                                <span class="input-group-addon fa-icon"><i class="fa fa-comment"></i></span>
                            </div>
                            <form:errors path="remarks" cssClass="error"/>
                        </div>
                        <form:hidden path="id" />
                    </div>
                </div>
                <div class="panel-footer footer-submit">
                    <button type="submit" class="btn btn-block">SUBMIT</button>
                </div>
            </div>
        </form:form>
    </div>
</div>