<!DOCTYPE html>
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
         <span>Create/Write a blog of your choice!</span>
         </h1>
        </div>
        </div>
    </header>
    <!-- end of header -->
    <!--about-->
   <section class="about">
       <div class = "banner">
        <div class = "container">
         <form action="Upload" method="post" enctype="multipart/form-data">
          <textarea cols="70" rows="15" name="filedata" placeholder="Write a blog of your choice!"></textarea><br><br>
          <input type="submit" class="w3-gray w3-button" placeholder="SUBMIT"/> &nbsp;&nbsp;
          </form>
        </div>
      </div> 
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