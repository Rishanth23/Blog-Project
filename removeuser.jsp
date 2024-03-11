<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.sql.SQLException"%>
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
            <a href = "designhome.jsp">Home</a>
            <a href = "blogusers.jsp">View Blog Users</a>
            <a href = "viewblogs.jsp">View All Blogs</a>
            <a href = "removeuser.jsp">Delete User</a>
            <a href = "index.html">Logout</a>
          </div>
        </div>
      </nav>
      <div class = "banner">
        <div class = "container">
          <h1 class = "banner-title">
<h3 style="color: orange ;background-color:rgb(0, 0,0)">Delete User</h3>
<% 
String sql = "select * from user;";
ResultSet rs = Dao.getData1(sql);
%>
<center>
<table width="100%" border="0"><thead style="color:white;">
<tr class="w3-blue"><th>User Name</th><th>Email ID</th><th>Delete</th></tr>
<%
try{
	while(rs.next()){
%>
<tr class="w3-card-2 w3-hover-blue-grey w3-text-white"><td><%=rs.getString(1) %><td><%=rs.getString(2) %></td>
<td><a href="RemoveServer?email=<%=rs.getString(2) %>">Delete</a> </td></tr>
<%} 
}catch(SQLException e){
	e.printStackTrace();
}
%>
</table>
</div>
</center>
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