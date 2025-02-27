<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="BEAN.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
	.one
	{
	 background-color:none;
	 border:2px solid;
	 border-radius:50px 50px 50px 50px;
	 height:50px;
	 width:150px;
	 
	}
	.one:hover
	{
		background-color:#07256A;
		color:white;
	}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Trainings</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content=""> 
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- owl stylesheets --> 
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
</style>
</head>
<body>
<% 
    String id=(String) session.getAttribute("id");
    String uname=(String) session.getAttribute("name");
    %>
    <!-- header section start -->
    <div class="header_section">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="logo"><a href="index.html"><img src="data:image/jpeg;base64,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"></a></div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="userHome">
              <button type="submit" class="one">HOME</button>
              </form>
            </li>
            <li class="nav-item  active">
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="userfeed">
              <button type="submit" class="one">FEEDS</button>
              </form>
            </li>
            <li class="nav-item">
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="userpeople">
              <button type="submit" class="one">PEOPLE</button>
              </form>
            </li>
            <li class="nav-item">
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="usermessage">
              <button type="submit" class="one">MESSAGE</button>
              </form>
            </li>
            <li class="nav-item">
              <form action="Controller" method="post">
              <input type="hidden" name="id" value="<%= id %>">
              <input type="hidden" name="uname" value="<%= uname %>">
              <input type="hidden" name="action" value="usercreatepost">
              <button type="submit" class="one">CREATE POST</button>
              </form>
            </li>
            <li class="nav-item">
            <input type="hidden" name="action" value="logout">
            <form action="Sign_In.html">
              <input type="submit" class="one" value="LOGOUT"></form>
            </li>                                             
          
        </div>
      </nav>
    </div>
    <!-- header section end -->
    <!-- dancer section start -->
    
    <!-- dancer section end -->
    <!-- footer section start -->
    
    <!-- footer section end -->
    <!-- copyright section start -->
    
    <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:80px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      
      
      <!-- Accordion -->
      
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    
    <%
    ArrayList<Variable> data=(ArrayList<Variable>) session.getAttribute("feed");
    for(Variable feed:data)
    {
    
    %>
    
      <h1><%=feed.getImgname() %></h1>
      
      <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
       <span class="w3-right w3-opacity"></span>
        <h4><%= feed.getName() %><br>
        <hr class="w3-clear">
        
        <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-half">
              <img src="feed/<%=feed.getImgname() %>" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
            </div>
            
            
        </div>
        <p>#<%= feed.getTag() %></p><br>
        
      </div>
    <%
    
    }
    %> 
      
    <!-- End Middle Column -->
    
    
    <!-- Right Column -->
    
      
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->

 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>
    <!-- copyright section end -->
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/plugin.js"></script>
    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <!-- javascript --> 
    <script src="js/owl.carousel.js"></script>
    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>    


</body>
</html>