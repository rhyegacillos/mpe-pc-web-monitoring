<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="well head-title">
    <div id="tip-logo"><img src="${pageContext.request.contextPath}/static/images/toshiba-logo.png" alt="Toshiba Logo" ></div>
    <strong><span><i class="fa fa-laptop fa-fw fa-1x"></i></span> MPE PC WEB INVENTORY</strong> </div>
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <ul class="nav navbar-nav collapse navbar-collapse" id="menu">
            <li><a href="${pageContext.request.contextPath}/pcEndorse/showForm">PC ENDORSEMENT</a></li>
            <li><a href="${pageContext.request.contextPath}/pcRepair/showForm">REPAIR INVENTORY</a></li>
            <li><a href="${pageContext.request.contextPath}/pcSpare/showForm">REPAIR SPARE</a></li>
            <li><a href="${pageContext.request.contextPath}/newSpare/showForm">NEW SPARE</a></li>
            <li><a href="${pageContext.request.contextPath}/hdd/showForm">HDD INVENTORY</a></li>
            <li><a href="${pageContext.request.contextPath}/ngPcParts/showForm">DISPOSAL INVENTORY</a></li>
            <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome, <span><i class="fa fa-user fa-fw fa-1x"></i></span>
                ${userLoginDetails.firstName}
                <span><i class="fa fa-caret-down fa-fw"></i></span></a>

                <ul class="dropdown-menu">
                    <li><a href="#">ID: ${userLoginDetails.employeeId}</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="${pageContext.request.contextPath}/user/showForm">Register New User</a></li>
                    </sec:authorize>
                    <li class="divider"></li>
                    <li>
                        <form action="${pageContext.request.contextPath}/" method="post">
                            <input type='submit' value='Logout' class="btn-link" id="logout-web">
                            <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
                        </form>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
