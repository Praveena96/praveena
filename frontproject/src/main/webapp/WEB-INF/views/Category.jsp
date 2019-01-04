<%@ include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
.second-table
{
border:2px solid black;
}
</style>
</head>
<body>

<h3 align="center">Category Page</h3>

<form action ="addCategory" method="post">

<table align="center">
<tr>
    <td>Category Name</td>
     <td><input type="text" name="categoryName"/></td>
</tr>


<tr>
    <td>Category Desc</td>
    <td><input type="text" name="categoryDesc"/></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Add Category"/>
    </td>
</tr>

</table>
</form>
<table align="center" class="second-table">
<tr>
    <td class="second-table">Category Id</td>
    <td class="second-table">Category Name</td>
    <td class="second-table">Category Desc</td>
    <td class="second-table">operation</td>
    </tr>
<c:forEach items="${listCategories}" var="category">
<tr>
      <td class="second-table">${category.categoryId}</td>
       <td class="second-table">${category.categoryName}</td>
       <td class="second-table">${category.categoryDesc}</td>
       <td>
          <a button type="button" class="btn btn-success" href="<c:url value="/updateCategory"/>">Update</a>
          <a button type="button" class="btn btn-danger" href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
       </td>
</tr>

</c:forEach>
</table>
</body>
</html>