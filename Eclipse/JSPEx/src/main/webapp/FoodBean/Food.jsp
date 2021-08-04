<jsp:useBean id="bn" class="beans.FoodPrice"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food</title>
<style>
    * {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
    }
    body {
        background: url('https://static-cse.canva.com/blob/140234/Rainbow-Gradient-Pink-and-Purple-Zoom-Virtual-Background.png');
        background-size: cover;
    }

    #cont {
        width: 35%;
        height: max-content;
        padding: 60px 40px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        border-radius: 10px;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        align-items: center;
        box-shadow: 10px 10px 15px rgba(25, 25, 25, 0.3);
        
    }

    #cont * {
        z-index: 2;
    }

    #cont div {
        width: calc(100% + 80px);
        height: calc(100% + 120px);
        position: absolute;
        left: -40px;
        top: -60px;
        background-color: rgba(25, 25, 25, 0.5);
        filter: blur(60px);
        z-index: 1;
    }

    #cont select, #cont input {
        font-size: 1.2em;
        background-color: rgba(250, 250, 250, 0.4);
        border: 0;
        outline: none;
        padding: 4px 8px;
        border-radius: 5px;
    }

    #cont input {
        background-color: aqua;
    }

    #cont input:active {
        filter: brightness(0.3);
    }

</style>
</head>
<body>
    <div id="cont">
        
        <h1>Get Food Price</h1>
        <form action="Food.jsp" method="POST">
            <select name="food" id="food">
            	<option value="sel">--select--</option> 
                <option value="hb">Hangover Breakfast</option> 
                <option value="sp">Soup</option>    
                <option value="cs">Chicken Salad</option>  
                <option value="ws">Wings</option>                   
            </select>
            <input type="submit" value="Get Price">
        </form>
        <h3>Price: <span>
        <%
		if(request.getParameter("food") != null) {
			%>			
			<jsp:setProperty property="food" name="bn"/>	 
        	<jsp:getProperty property="price" name="bn"/>
        <%
		}
		%>
        </span></h3>
        <div></div>
    </div>
</body>
<script>
    if(document.querySelector('span').innerText == "") {
        document.querySelector('h3').style.display = "none";
    }
    else {
        document.querySelector('h3').style.display = "block";
    }
</script>
</html>