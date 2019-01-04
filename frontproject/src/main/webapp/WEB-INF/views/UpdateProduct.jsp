<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<h3 align="center">Update Product Page</h3>
</head>
<body>
<form action="updateproduct" method="get">

<table align="center">
<tr>
    <td>Product Id</td>
    <td><input type="text" id="productId" name="productId" value="${product.productId}" /></td>
</tr>


<tr>
    <td>Product Name</td>
    <td><input type="text" id="productName" name="productName" value="${product.productName}"/></td>
</tr>


<tr>
    <td>Product price</td>
    <td><input type="text" id="price" name="price" value="${product.price}"/></td>
</tr>

<tr>
<center>
     <td colspan="3"><input type="submit" value="updateproduct"/></td>
</center>
</tr>

</table>
</form>
</body>
</html> 