<%@page isELIgnored="false" %>

<h1 style="color:red;text-align:center;">Login Application</h1>

<form action="loginurl" method="post">
  Username:::  <input type="text" name="name"><br>
  Password ::: <input type="text" name="pass"><br>
  <input type="submit" value="Login"/>
</form>
<br><br>
  <h1 style="color:red">${res} </h1>

