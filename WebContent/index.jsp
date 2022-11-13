<%@page import="com.sp.demo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%
Student student=(Student)(request.getAttribute("updateData"));
%>
</head>
<body>

<form action="Controller" method="post">

  <% if(student!=null){
  %>
   Name: <input type="text" name="sname" value="<%=student.getName()%>"/>
  <input type="hidden" name="id" value="<%=student.getId()%>">
  <input type="submit" value="update">
    <input type="hidden" name="action" value="edit">
  
  <%}else{ %>
    Name: <input type="text" name="sname" "/>
  <input type="submit" value="save">
  <input type="hidden" name="action" value="save">
  
   <%} %>
<table border=1>
        <thead>
            <tr>
                <th>User Name</th>
                <th>ID</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listAll}" var="user">
                <tr>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.id}" /></td>
                    <td><a href="Controller?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
                    <td><a href="Controller?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</form>
  
  
</body>
</html>