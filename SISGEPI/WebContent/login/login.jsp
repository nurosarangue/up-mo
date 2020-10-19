<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>

<meta name="_csrf_header" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<!-- Bootstrap -->
    <link href="${path}/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Font Awesome -->
    <link href="${path}/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- NProgress -->
    <link href="${path}/resources/vendors/nprogress/nprogress.css" rel="stylesheet"/>
    <!-- Animate.css -->
    <link href="${path}/resources/vendors/animate.css/animate.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="${path}/resources/build/css/custom.min.css" rel="stylesheet"/>

</head>
<body class="login">
<c:url value="/login" var="loginUrl" />
 <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
        
          <section class="login_content">
            <form action="${loginUrl}" method="post">
              <h1>Login</h1>
              
              <c:if test="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION != null}">
					<ul
						style="text-align: center; margin-top: 4%; text-decoration: none; color: red; font-weight: bold; list-style: none;">
						<li style="margin-left: -12%;">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</li>
					</ul>
				</c:if>
              <div>
                <input type="text" name="username" autofocus class="form-control" placeholder="username" required="" />
              </div>
              <div>
                <input type="password" name="password" class="form-control" placeholder="password" required="" />
              </div>
               <div>
                <button type="submit" class="btn btn-default submit">Logar</button>
              </div>
             

              <div class="clearfix"></div>

              <div class="separator">
               <div>
                  <h1><i class="fa fa-paw"></i> SISGEPI</h1>
                  <p>©2020 Todos Direitos reservados</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        
      </div>
    </div>
</body>
</html>