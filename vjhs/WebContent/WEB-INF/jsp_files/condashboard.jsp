<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>VJHS::Contact Us</title>

<!-- Bootstrap core CSS -->
<link href="css_files//bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css_files/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js_files/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="homepage.user"><img src="img/vjhs_logo.gif" height=80px width=80px /></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="aboutschool.user"><img class="img-circle"
							src="img/AboutSchool.jpg" alt="#"
							style="width: 80px; height: 80px;"></a></li>
					<li><a href="schoollife.user"><img class="img-circle"
							src="img/SchoolLife.jpg" alt="#"
							style="width: 80px; height: 80px;"></a></li>
					<li><a href="gallery.user"><img class="img-circle"
							src="img/Gallery.jpg" alt="#" style="width: 80px; height: 80px;"></a></li>
					<li><a href="contact.user"><img class="img-circle"
							src="img/ContactUs.jpg" alt="#"
							style="width: 80px; height: 80px;"></a></li>
				</ul>
				<form class="navbar-form navbar-right">
            <label class="navbar-brand-title">VIGNANA JYOTHI HIGH SCHOOL</label>
          </form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Contact Us <span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">Nadakuduru</a></li>
					<li><a href="#">Karapa</a></li>
				</ul>
				
			</div>
					<%@include file="contactus.jsp" %>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js_files/bootstrap.min.js"></script>
	<script src="js_files/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
