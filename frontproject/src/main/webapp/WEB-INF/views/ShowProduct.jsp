<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <body> 
    <h3 align="center">Product Display</h3>

<div class="row text-center text-lg-left">
<c:forEach items="${prodtt}" var="product">
     <div class="col-lg-3 col-md-4 col-6">
             <a href="<c:url value="/totalshowproduct/${product.productId}.jpg"/>">
             <img class="img-fluid img-thumbnail" src=<c:url value="/resources/images/${product.productId}.jpg"/> alt=" " width="150" height="150">
        <div class="container">
            <b>price:${product.price}/-</b>
             <b>stock:${product.stock}/-</b>
   </div>
   </a>
</div>
</c:forEach>

</div>
</body>
</html>