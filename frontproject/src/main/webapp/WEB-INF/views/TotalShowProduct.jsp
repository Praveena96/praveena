<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>
<form action="<c:url value="/addToCart/${prodtt.productId}"/>" method="get">
<div class="container">
    <div class="row">
        <div class="col-md-4">
              <div class="thumbnail">
                <img src=<c:url value="/resources/images/${prodtt.productId}.jpg"/> alt="" width="200" height="200">
                <div class="caption">
                  <h4>Price:Rs.${prodtt.price}/-</h4>
                   <div>
                  <h4>Name:${prodtt.productName}</h4>
                 </div>
                 <div>
                  <h4>Stock:${prodtt.stock}/-</h4>
                </div>
                <p data-th="quantity">
                <input name="quantity" type="number" class="form-control text-center" value="1">
                </p>
                </div>
               <div class="ratings">
                  <p>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                     (15 reviews)
                  </p>
                </div>
                
                <div class="btn-ground text-center">
                    <input type="submit" class="btn btn-success" value="ADD TO CART"/>
                   
                </div>
                
            </div>
</div>
</div>
</div>

</form>
</body>
</html>