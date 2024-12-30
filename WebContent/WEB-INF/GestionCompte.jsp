<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<table class="table" >
<tr><th>User Name </th><th>Action</th></tr>
<c:forEach items="${listcompte}" var="compte">
<tr>
<c:if test="${empty username }">
    <td>${compte.getUserName()}</td>
    <td><a href="Servlet8?username=${compte.getUserName()}"><button>Supprimer</button></a>
        <a href="Servlet9?username=${compte.getUserName()}&&password=${compte.getPassword()}"><button>Modifier</button></a></td>
</c:if>
<c:if test="${!empty username }">
   <c:if test="${compte.getUserName()==sessionScope.username}">
    <form action="Servlet9" method="post" >
    <td><input type="text" name="N_username" value="${compte.getUserName()}"></td>
    <td><a href="Servlet8?username=${compte.getUserName()}"><button>Supprimer</button></a>
        <a href="Servlet9?username=${compte.getUserName()}&&password=${compte.getPassword()}"><button>Modifier</button></a>
       <input type="submit" value="Valider"></td>
    </form>
   </c:if>
     <c:if test="${compte.getUserName()!=sessionScope.username}">
       <td>${compte.getUserName()}</td>
       <td><a href="Servlet8?username=${compte.getUserName()}"><button>Supprimer</button></a>
        <a href="Servlet9?username=${compte.getUserName()}&&password=${compte.getPassword()}"><button>Modifier</button></a></td>
   </c:if>
</c:if>
</tr>
</c:forEach>
</table>
<form action="Servlet6" method="post">
<input type="submit" value="Ajouter">
</form>
<c:if test="${!empty password}">
 <form action="Servlet7" method="post">
 <label>User Name</label><input type="text" name="username">
 <label>Password</label><input type="password" name="password" value="${password}" readonly="true">
 <input type="submit" value="Valider">
 </form>

</c:if>
</body>
</html>