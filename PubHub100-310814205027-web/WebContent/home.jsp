<%@page import="com.revature.dao.BookDAO"%>
<%@page import="com.revature.model.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<title>Home</title>
</head>
<div id="page">
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" >Book Management</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="home.jsp">Home</a></li>
            <li><a href="addBook.jsp">Add Book</a></li>
            <li><a href="rename.jsp">Rename Book</a></li>
            <li><a href="price.jsp">Change Book Price</a></li>
            <li><a href="remove.jsp">Remove Book</a></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>

          <form class="navbar-form navbar-right" action="SelectionController" method="get">
            <input type="text" class="form-control" placeholder="Search..." name="search">
            <input type="submit" value="search" class="btn btn-secondary btn-sm">
            <p style="color: white; ">Welcome <%=session.getAttribute("name") %></p>
          </form>
        </div>
      </div>
    </nav>

    <div class="container main" >
      <div class="row">
        <div class=" col-md-2 col-sm-2 col-lg-2"  ></div>
 <div class=" col-md-8 col-sm-8 col-lg-8"  >
 <div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Book list </h3>
			</div>
		</div>
		<table class="table table-hover" id="dev-table">
				<thead>
					<tr>
					<th>Id</th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Price</th>
					</tr>
				</thead>
				<tbody>
 <%
 BookDAO bookDAO=new BookDAO(); 
 if(request.getAttribute("list")==null){
 List<Book> list=bookDAO.findAll();
 for(Book book:list)
 {
	
	%>
	<tr>
	<td><center><%=book.getId() %></center></td>
	<td><center><%=book.getName() %></center></td>
	<td><center><%=book.getAuthorName() %></center></td>
	<td><center><%=book.getPrice() %></center></td>
	</tr>
	
	<%
 }}
 else{
	 List<Book> listById=(List<Book>)request.getAttribute("list");
	 for(Book book:listById)
	 {
		
		%>
		<tr>
		<td><center><%=book.getId() %></center></td>
		<td><center><%=book.getName() %></center></td>
		<td><center><%=book.getAuthorName() %></center></td>
		<td><center><%=book.getPrice() %></center></td>
		</tr>
		
		<%
 }
 }
 %>
</tbody>
</table>

 </div>
  <div class=" col-md-2 col-sm-2 col-lg-2"  ></div>
</div>
 </div>
<footer class="footer" id="foot">
    <div class="container">
      <div class="row">
      <div class="col-lg-4 col-md-4 col-sm-5 col-xs-5">
        &copy PubHub100
        </div>
         <div class="col-lg-3 col-md-3 col-sm-1 col-xs-1"></div>
         <div class="col-lg-5 col-md-5 col-sm-6 col-xs-6">
         Designed by Eugine(IT-department)
         </div>
        </div>
      </div>
</footer>
<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</div>
</html>