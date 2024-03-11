<!DOCTYPE html>
<%@page import="com.dao.Dao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" href="blog.css">
    <link rel="StyleSheet" href=w3.css>
  </head>
  <body>

    <!-- header -->
    <header>
      <nav class = "navbar">
        <div class = "container">
          <a href = "simplelookin.html" class = "navbar-brand">Simply lookin'. BLOG</a>
          <div class = "navbar-nav">
            <a href = "userhome.jsp">Home</a>
            <a href = "upload.jsp">Create Blog</a>
            <a href = "search.jsp">Search Blog</a>
            <a href = "view.jsp">View Blog</a>
            <a href = "viewOthers.jsp">View Others Blog</a>
            <a href = "index.html">Logout</a>
          </div>
        </div>
      </nav>
      <div class = "banner">
        <div class = "container">
          <h1 class = "banner-title">
          	<h2 style="color: orange ;background-color:rgb(0, 0,0)">View Blog Info</h2>
<table width="100%" border="0"><thead style="color:white;">
<tr class="w3-blue">
<th>Blog Posted By</th>
<th>Blog Data</th>
<th>Blog Date</th>
</tr>
<%
try{
	String uid=(String)session.getAttribute("uid");
ResultSet r=Dao.getUserUpload(uid);
while(r.next())
{
		%>
		<tr class="w3-card-2 w3-hover-blue-grey w3-text-white">
		<td><%=r.getString(2) %></td>
		<td><%=r.getString(3) %></td>
		<td><%=r.getString(4) %></td>
		</tr>
		<%
}
}catch(SQLException e)
{
	e.printStackTrace();
}
%></thead>
</table>
        </h1>
        </div>
      </div>
    </header>
    <!-- end of header -->
    <!--about-->
    <section class="about">
       <!-- <div class = "banner">
        <div class = "container">
          <h1 class = "banner-title">
            <span>BLOG</span>
          </h1>
         <form action="upload" method="post"></form>
          <table>
          
          <textarea cols="70" rows="15" placeholder="Write a blog of your choice!"></textarea><br><br>
           <input type="submit" class="w3-gray w3-button" placeholder="SUBMIT"/> &nbsp;&nbsp;
          </table>
        </div>
      </div> --> 
    </section>
  
    <!-- end of footer -->
    
  </body>
  <!-- <div class = "banner">
        <div class = "container">
          <h1 class = "banner-title">
            <span>DESIGN.</span>
          </h1>
          <p>Create/Write a blog of your choice!</p>
        </div>
      </div> -->
</html>