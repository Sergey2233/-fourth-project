<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>Login Application</title>  
</head>  
<body>  
    <form action="..\MainServlet" method="POST"> 
     <input type = "hidden" name="command" value= "loginservlet"/> 
        <fieldset style="width: 500px">  
            <legend> Login to App </legend>  
            <table>  
                <tr>  
                    <td> логин:</td>  
                    <td><input type="text" name="login" required="required" /></td>  
                </tr>  
                <tr>  
                    <td>пароль:</td>  
                    <td><input type="password" name="password" required="required" /></td>  
                </tr> 
                <tr>  
                    <td> имя:</td>  
                    <td><input type="text" name="firstName" required="required" /></td>  
                </tr>  
                <tr>  
                    <td>фамилия:</td>  
                    <td><input type="text" name="secondName" required="required" /></td>  
                </tr>  
               
                <tr>  
                    <td><input type="submit" value="вход" /></td>  
                </tr>  
            </table>  
        </fieldset>  
    </form>  
</body>  
</html>  
