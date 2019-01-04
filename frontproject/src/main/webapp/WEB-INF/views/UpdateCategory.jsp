<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<h3 align="center">Update Category Page</h3>
</head>
<body>
<form action="updateCategory" method="post">

<table align="center">
<tr>
    <td>Category Id</td>
    <td><input type="text" id="categoryId" name="categoryId" value="${category.categoryId }" /></td>
</tr>


<tr>
    <td>Category Name</td>
    <td><input type="text" id="categoryName" name="categoryName" value="${category.categoryName }"/></td>
</tr>


<tr>
    <td>Category Desc</td>
    <td><input type="text" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc }"/></td>
</tr>

<tr>
<center>
     <td colspan="3"><input type="submit" value="Add Category"/></td>
</center>
</tr>

</table>
</form>
</body>
</html> 