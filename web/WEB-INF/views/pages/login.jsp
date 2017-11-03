<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body onload='document.f.username.focus();' class="bg-login">
<div >
    <div class="container">
        <div class="row">
            <div class="col-md-7"></div>
            <div class="col-md-5">
                <div class="login-wrapper">
                    <h3>LOGIN</h3>
                    <hr>
                    <form name='f' action='${loginUrl}' method='POST'>
                        <c:if test="${param.error != null}">
                            <div id="error">Invalid Credentials</div>
                            <br>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div id="logout">Logout Successful</div>
                            <br>
                        </c:if>

                        <div class="user-wrapper">
                            <div class="input-group margin-bottom-sm ">
                                <span class="input-group-addon"><i class="fa fa-user fa-fw fa-2x"></i></span>
                                <input class="form-control" type="text" name="username" placeholder="Enter Username">
                            </div>
                        </div>
                        <div class="password-wrapper">
                            <div class="input-group margin-bottom-sm ">
                                <span class="input-group-addon"><i class="fa fa-lock fa-fw fa-2x"></i></span>
                                <input class="form-control" type="password" name="password" placeholder="Enter Password">
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type='submit' value='LOGIN' class="btn btn-info btn-block btn-login">
                            <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember-me" checked="checked"><strong> Remember me </strong></label>
                            </div>
                        </div>

                    </form>
                </div>
            </div>

        </div>

    </div>
</div>

</body>

