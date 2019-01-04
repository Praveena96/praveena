<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<div class="container">
 <h3 align="center">Receipt</h3>
 
 <table class="table bordered">
 <tr bgcolor="red">
      <td>OrderId</td>
      <td>${paymentDetail.orderId}</td>
      <td>OrderDate</td>
      <td>${paymentDetail.orderDate}
      </td>
</tr>
 
 <tr bgcolor="violet">
  <td>Customer</td>
      <td>${userdetail.username}</td>
      <td>PaymentMode</td>
      <td>${paymentDetail.paymentmode}
      </td>
</tr>
 <tr bgcolor="red">
   <td>Address</td>
   <td colspan="3">${userdetail.address}</td>
 </tr>
 </table>

<br/><br/><br/>
<table class="table borderde">
<tr bgcolor="pink">
     <td></td>
     <td>Product Name</td>
     <td>Quantity</td>
     <td>Price</td>
     <td>Total Price</td>
</tr>
<c:forEach items="${cartItems}" var="cart">
<tr>
  <td></td>
  <td>${cart.productName}</td>
  <td>${cart.quantity}</td>
  <td>${cart.price}</td>
  <td>${cart.quantity*cart.price}/-</td>
</tr>

</c:forEach>
<tr bgcolor="cyan">
   <td colspan="4">Grand Total</td>
   <td>Rs.${paymentDetail.totalShoppingAmount}/-</td>
</tr>
   
<tr bgcolor="gray">
    <td colspan="5">
    <center>Thank for shopping with us.Visit Again</center>
    </td>
 </tr> 
  
</table>
</div>
</body>
</html>