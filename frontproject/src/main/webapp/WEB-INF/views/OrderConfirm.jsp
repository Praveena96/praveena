<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<style>
table
{
border-collapse:collapse;
}
.first-table
{
border:2px solid black;
}
.second-table
{
border:2px solid black;
}

</style>
<body>
   <h3 align="center">Your Order</h3>
   
<table class="table bordered" class="first-table">
  <tr bgcolor="blue">
      <td></td>
      <td class="first-table">Product Name</td>
      <td class="first-table">Quantity</td>
      <td class="first-table">Price</td>
       <td class="first-table">Total Price</td>
  </tr>

<c:forEach items="${lablecart}" var="cart">
<tr>
   <td></td>
   <td class="first-table">${cart.productName}</td>
   <td class="first-table">${cart.quantity}</td>
   <td class="first-table">${cart.price}</td>
   <td class="first-table">${cart.quantity*cart.price}</td>
</tr>
</c:forEach>
  <tr class="first-table" bgcolor="violet">
      <td class="first-table" colspan="4" >Grand Total</td>
      <td class="first-table">Rs.${grandTotal}/-</td>
</tr>

   <tr class="first-table" bgcolor="purble">
   <td colspan="3" class="first-table"><a href="<c:url value="/cart"/>">Edit Card</a></td>
   </tr>

</table>

<form action="payment">
<table class ="table bordered" class="second-table">
    <tr bgcolor="blue" class="second-table">
      <td colspan="2" class="second-table">Payment Detail</td> 
    </tr>

 <tr bgcolor="sky blue" class="second-table">
       <td class="second-table">Payment Type</td>  
     <td class="second-table"><input type="radio" name="paymentmode" value="COD"/>Cash On Delivery
    <input type="radio" name="paymentmode" value="CC"/>Credit Card</td>
    
  
 </tr>
 <tr style="red" class="second-table">
    <td class="second-table">
    <input type="text" name="creditcard"/>Credit Cart
    </td>
</tr>
    
 <tr bgcolor="red" class="second-table">
 <td class="second-table">CVV <input type="text" name="cvv"/></td>
 <td class="second-table">Valid Upto<input type="text" name="valid"/></td>
  <td style="Color:violet" colspan="2" class="second-table"><input type="submit" value="PAY"/></td>
   
 </tr>
</table>
</form>


</body>
</html>