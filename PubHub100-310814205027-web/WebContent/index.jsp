<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- including bootstrap file -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<title>Book Application</title>
</head>
<body>
	<div class="container">
	
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Book Management</h1>
	               		<hr />
	               	</div>
	            </div> 
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form class="form-signin" action="LoginController" method="post">
                <input type="text" class="form-control" placeholder="Email" name="email" required autofocus>
                <input type="password" class="form-control" placeholder="Password" name="password"required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                <label class="checkbox pull-left">
                   &nbsp <input type="checkbox" value="remember-me" >
                    Remember me
                </label>
                <br/>
                <%
						String flag=(String)request.getAttribute("flag");
						if(flag!=null){
							if(flag.equals("false")){
							%>
							 <label class="checkbox pull-left" style="color:red;right: 20%">Invalid Email or password </label>
							<%
						}
							else{
								%>
								 <label class="checkbox pull-left" style="color:green;right: 20%">Registered Successfully </label>
								<%
							}	
						}
						%>
						<br>
                </form>
            </div>
            <a href="register.jsp" class="text-center new-account">Create an account </a>
        </div>
    </div>
   
</div>
	
	
	
	
	



	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>