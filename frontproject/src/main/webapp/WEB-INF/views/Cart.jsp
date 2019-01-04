
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="Header.jsp" %>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
table
{
border-collapse:collapse;
}
.first-table
{
border:3px solid black;
}
</style>
</head>
<body>
<h3 align="center">Cart</h3>
<table align="center" class="first-table">
  <tr>

         <td class="first-table"> Product Name</td>
         <td class="first-table"> Quantity</td>
          <td class="first-table"> Price</td>
         <td class="first-table">Total Price</td>
          <td class="first-table"> Operation</td>
  </tr>

<c:forEach items="${cartItems}" var="cart">
<tr>
    <td class="first-table">${cart.productName}</td>
   <td class="first-table"><input type="text" name="quantity" value="${cart.quantity}"/></td>
   <td class="first-table">${cart.price}</td>
   <td class="first-table">${cart.quantity*cart.price}</td>   
   <td>
    
    <a input type="submit" class="btn btn-danger" href="<c:url value="/deleteCartItems/${cart.cartId}"/>" method="get">DELETE</a>   
    <a input type="submit"  class="btn btn-success" href="<c:url value="/updateCartItems/${cart.cartId}"/>" method="get">UPDATE</a>   
    </td>
 </tr>


</c:forEach>

 <tr>
   <td class="first-table" style="Color:cyan" colspan="4">Grand Total</td>
    <td class="first-table" style="Color:brown" colspan="3">Rs.${grandTotal}</td>
</tr>
<tr>
     <td class="first-table" style="Color:red" colspan="3"><a href="<c:url value="/showproduct"/>">Continue Shopping</a></td>
      <td  class="first-table" style="Color:orange" colspan="3"><a href="<c:url value="/checkout"/>">CheckOut</a></td>
        
</table>
</body>
</html>