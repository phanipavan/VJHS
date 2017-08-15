<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VJHS::Homepage</title>
<link rel="stylesheet" href="css_files/bootstrap.min.css" />
<script type="text/javascript"
	src="js_files/ie-emulation-modes-warning.js"></script>
<link rel="stylesheet" href="css_files/carousel.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="header.jsp"%>
		</div>
		<div class="body_content" style="width: 1170px;">
			<div style="height: 30px; padding: 2px;">
				<marquee>
					<div style="float: left;">
						<a href=#>Click Here to View the Results of 2014-15</a>
					</div>
					<div style="padding-left: 100px; float: left">
						<a href=#>Admissions Started for Academic Year 2015-16</a>
					</div>
				</marquee>
			</div>
			<!-- Carousel ================================================== -->
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
					<li data-target="#myCarousel" data-slide-to="5"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/one.jpg" alt="First slide">
					</div>
					<div class="item">
						<img src="img/two.jpg" alt="Second slide">
					</div>
					<div class="item">
						<img src="img/third.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="img/foour.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="img/five.jpg" alt="Third slide">
					</div>
					<div class="item">
						<img src="img/six.jpg" alt="Third slide">
					</div>
				</div>
			</div>
			<!-- /.carousel -->
			<br>
			<div class="container marketing">

				<!-- Three columns of text below the carousel -->
				<div class="row">

					<div class="col4">
						<a href="aboutschool.user"> <img class="img-circle"
							src="img/AboutSchool.jpg" alt="#"
							style="width: 130px; height: 130px;"> <br> <br> <span
							style="font-weight: bold;">Explore about School</span>
						</a>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col4">
						<a href="schoollife.user"> <img class="img-circle"
							src="img/SchoolLife.jpg" alt="#"
							style="width: 130px; height: 130px;"> <br> <br> <span
							style="font-weight: bold;">Know about Life at School</span>
						</a>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col4">
						<a href="gallery.user"> <img class="img-circle"
							src="img/Gallery.jpg" alt="#"
							style="width: 130px; height: 130px;"> <br> <br> <span
							style="font-weight: bold;">View the School Gallery</span>
						</a>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col4">
						<a href="contact.user"> <img class="img-circle"
							src="img/ContactUs.jpg" alt="#"
							style="width: 130px; height: 130px;"> <br> <br> <span
							style="font-weight: bold;">Get our Contact Information</span>
						</a>
					</div>
				</div>
				<!-- /.row -->
			</div>
		</div>
		<div style="min-height: 10px;"></div>
		<div class="footer">
			<%@ include file="adminfooter.jsp"%>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js_files/bootstrap.min.js"></script>
	<script src="js_files/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js_files/ie10-viewport-bug-workaround.js"></script>
</body>
</html>