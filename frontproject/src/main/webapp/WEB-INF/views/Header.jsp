<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title> Bootstrap- Navbar Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

 <nav class="navbar navbar-expand-sm bg-dark navbar-primary justify-content-center">
 <ul class="navbar-nav">
 
 <c:if test="${!sessionScope.loggedIn}">
         <li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">Login</a></li>
            <li class="nav-item"><a class="nav-link" href="<c:url value="/register"/>">Register</a></li>
             <li class="nav-item"><a class="nav-link" href="<c:url value="/about us"/>">About Us</a></li>
              <li class="nav-item"><a class="nav-link" href="<c:url value="/contact us"/>">Contact Us</a></li>
 </c:if>
              
        <c:if test="${sessionScope.loggedIn}">
                <c:if test="${sessionScope.role=='ROLE_USER'}">
                <li class="nav-item"><a class="nav-link" href="<c:url value="/showproduct"/>">ShowProduct</a></li>
                <li class="nav-item"><a class="nav-link" href="<c:url value="/cart"/>">Cart</a></li>
          </c:if>
               
                
                <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
                     <li class="nav-item"><a class="nav-link" href="<c:url value="/category"/>">Category</a></li>
                     <li class="nav-item"><a class="nav-link" href="<c:url value="/product"/>">Product</a></li>
                </c:if>
</c:if>

<div class="nav navbar nav navbar right">
   <c:if test="${sessionScope.loggedIn}">
    <div id="userdetail"> 
      <font color="violet">
          Welcome ${sessionScope.username}
          <a href="<c:url value="/perform_logout"/>" class="btn btn-danger">LOGOUT</a>
      </font>
 </div>
 </c:if>
 </div>
 </ul>
 </nav>
</body>
</html>