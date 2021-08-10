<%@ page import="cart.*, java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title>Cart</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- bootstrap css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- style css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="css/responsive.css">

	<link rel="stylesheet" href="css/cart.css">
    <!-- fevicon -->
    <link rel="icon" href="images/fevicon.png" type="image/gif" />
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <!-- Tweaks for older IEs-->
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout">
    <!-- loader  -->
    <div class="loader_bg">
        <div class="loader"><img src="images/loading.gif" alt="#" /></div>
    </div>

    <div class="wrapper">

        <!-- end loader -->
        <div class="sidebar">
            <!-- Sidebar  -->
            <nav id="sidebar">

                <div id="dismiss">
                    <i class="fa fa-arrow-left"></i>
                </div>

                <ul class="list-unstyled components">

                    <li class="active">
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="#brand">Brands</a>
                    </li>
                    <li>
                        <a href="#shoes">Shoes</a>
                    </li>
                    <li>
                        <a href="#jewellery">Jewellery</a>
                    </li>
                    <li>
                        <a href="#kids">Kids and Babies</a>
                    </li>
                </ul>

            </nav>
        </div>

        <div id="content">
            <!-- header -->
            <header>
                <!-- header inner -->
                <div class="head_top">
                    <div class="header">

                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-lg-3 logo_section">
                                    <div class="full">
                                        <div class="center-desk">
                                            <div class="logo">
                                                <a href="index.jsp"><img src="images/logo.png" alt="#"></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9">
                                    <div class="right_header_info">
                                        <ul>
                                            <%
                                            HttpSession sess = request.getSession(false);                                            
                                            if(sess.getAttribute("uname") == null) {
                                            %>                                          
                                            
                                            <li class="menu_iconb">
                                                <a href="login.html">Log in <img style="margin-right: 15px;" src="icon/5.png" alt="#" /> </a>
                                            </li>
                                            <li class="menu_iconb">
                                                <a href="register.html">Signup<img style="margin-left: 15px;" src="icon/6.png" alt="#" /></a>
                                            </li>
                                            <%
                                            }
                                            else {
                                            	String uname = (String) sess.getAttribute("uname");
                                            %>
                                            
                                            <li class="menu_iconb">
                                                <a href="#">Hello, <span>${uname}</span></a>
                                            </li>
                                            
                                            <li class="menu_iconb">
                                                <a href="Logout">Log out <img style="margin-right: 15px;" src="icon/5.png" alt="#" /> </a>
                                            </li>
                                            <%
                                            }
                                            %>
                                            <li class="tytyu">
                                                <a href="cart.jsp"> <img style="margin-right: 15px;" src="icon/2.png" alt="#" /></a>
                                            </li>

                                            <li>
                                                <button type="button" id="sidebarCollapse">
                                                    <img src="images/menu_icon.png" alt="#" />
                                                </button>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- end header inner -->

                    <!-- end header -->
                    

                </div>
            </header>
            
        </div>
     
    <section>
        

    <!-- news Jewellery -->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="cart" class="cart-bg">
                    <h1>Cart</h1>
                    <div class="row">                       
                        
						<%
							if(sess.getAttribute("items") != null) {
								List<Product> plist = (List<Product>) sess.getAttribute("items");
								
								for(Product p : plist) {
								%>
									<div class="cart-item row">
										<img style="width:50px" src="icon/<%= p.getImage() %>"/>
										<h2><%= p.getName() %></h2>
										<h4><%= p.getCount() %>X<%= p.getPrice() %></h4>
										<h3>$<%= p.getCount() * p.getPrice() %></h3>
									</div>
								<%
								}
							}
							else {
								%>
									<p>Cart is empty!</p>
								<% 
							}
						%>                        
                    </div>
					<a class="buynow" href="Checkout.jsp">Check Out</a>
                </div>
            </div>
        </div>
    </div>
    <!-- end news Jewellery -->

    
    <!--  footer -->
    <footer>
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="footer_top">
                            <div class="row">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                    <a href="index.jsp"> <img class="logo1" src="images/logo1.png" /></a>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                    <ul class="sociel">
                                        <li> <a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                        <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                                        <li> <a href="#"><i class="fa fa-instagram"></i></a></li>
                                        <li> <a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
                        <div class="row">
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-6 ">
                                <div class="address">
                                    <h3>Contact us </h3>
                                    <ul class="loca">
                                        <li>
                                            <a href="#"><img src="icon/loc.png" alt="#" /></a>145 londone
                                            <br>uk </li>
                                        <li>
                                            <a href="#"><img src="icon/call.png" alt="#" /></a>+12586954775 </li>
                                        <li>
                                            <a href="#"><img src="icon/email.png" alt="#" /></a>demo@gmail.com </li>

                                    </ul>

                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6 col-sm-6">
                                <div class="address">
                                    <h3>customer service</h3>
                                    <ul class="Menu_footer">
                                        <li><a href="finalcart.html">My Cart</a> </li>
                                        <li><a href="Checkout.jsp">Checkout</a> </li>
                                        <li><a href="login.html">Login</a> </li>
                                    </ul>
                                </div>
                            </div>
                            

                            <div class="col-lg-3 col-md-6 col-sm-6 ">
                                <div class="address">
                                    <h3>why choose us</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna </p>
                                    <form class="newtetter">
                                        <input class="tetter" placeholder="Your email" type="text" name="Your email">
                                        <button class="submit">Subscribe</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
        </div>

    </footer>
    <!-- end footer -->
  

    </div>

    <div class="overlay"></div>

    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>

    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#dismiss, .overlay').on('click', function() {
                $('#sidebar').removeClass('active');
                $('.overlay').removeClass('active');
            });

            $('#sidebarCollapse').on('click', function() {
                $('#sidebar').addClass('active');
                $('.overlay').addClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>

    <script>
        $(document).ready(function() {
            $(".fancybox").fancybox({
                openEffect: "none",
                closeEffect: "none"
            });

            $(".zoom").hover(function() {

                $(this).addClass('transition');
            }, function() {

                $(this).removeClass('transition');
            });
        });
    </script>
    
    <script src="js/mainpage.js"></script>
    
</body>

</html>