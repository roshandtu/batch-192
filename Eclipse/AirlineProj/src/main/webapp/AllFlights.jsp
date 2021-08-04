<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="js/script.js" defer></script>
    <title>All Flights</title>
</head>
<body>
    <div id="navbar">
        <div></div>
        <ul>
            <li data-selected="true"><a href="index.html">Home</a></li>
            <li><a href="cancel.html">Cancel Flight</a></li>
            <li><a href="aboout.html">About Us</a></li>
            <li><a href="admin.jsp">Admin</a></li>
        </ul>
    </div>

    <div class="cont" id="cont-1">
        <div id="flight-list-cont" class="action-cont hor-center-div">
            <h1>All Flights</h1>
            <jsp:include page="flightlist.jsp">
            	<jsp:param value="all" name="list-type"/>
            	<jsp:param value="true" name="bookable"/>
            </jsp:include>
        </div>
        
    </div>
</body>
</html>