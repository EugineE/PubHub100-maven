<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
<!-- including bootstrap file -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
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
            <input type="text" class="form-control" placeholder="Search..." name="search" >
            <input type="submit" value="search" class="btn btn-secondary btn-sm" >
          </form>
        </div>
      </div>
    </nav>

    
        <div class="container main">
      <div class="row">
        <div class=" col-md-2 col-sm-2 col-lg-2"  ></div>
 <div class=" col-md-8 col-sm-8 col-lg-8"  >
        <!-- Status -->
<% 
String flag=(String)request.getAttribute("flag");
if(flag!=null){
if(flag.equals("true")){
	%>
	<div id="contact-form" class="form-container" data-form-container style="color: rgb(46, 125, 50); background: rgb(200, 230, 201);">
	<div class="row">
		<div class="form-title">
			<span>Book is registered successfully</span>
		</div>
	</div>
	</div>
<%}
else if(flag.equals("false")){
	%>
	<div id="login-form" class="form-container" data-form-container style="color: rgb(198, 40, 40); background: rgb(255, 205, 210);">
			<div class="row">
				<div class="form-title">
					<span>Book already exists</span>
				</div>
			</div>
			</div>
<%
}
}
%> 

<!-- End Status -->
			<form action="AddBookController" method="get">
			<div id="contact-form" class="form-container" data-form-container>
			<div class="row">
				<div class="form-title">
					<span>Add Book</span>
				</div>
			</div>
			<div class="input-container">
				<div class="row">
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your Book Name."> </span>
						<input type="text" data-min-length="8" placeholder="Book Name" name="name">
					</span>
				</div>
				<div class="row">
					<span class="req-input">
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Please Input Your Book Price."> </span>
						<input type="text" placeholder="Price" name="price">
					</span>
				</div>
				<div class="row">
					<span class="req-input">
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Please Input Your Book Author."> </span>
						<input type="text" placeholder="Author Name" name="authorName">
					</span>
				</div>
				
				<div class="row submit-row">
					<button type="submit" class="btn btn-block submit-form">Save</button>
				</div>
			</div>
			</div>
			</form>
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
</html>