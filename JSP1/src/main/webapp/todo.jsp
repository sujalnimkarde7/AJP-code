<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*" %>
   
<%
   List<String>tasks=(List<String>)session.getAttribute("tasks");
%>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
        <style>
        body {
            font-family: sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }

        h2 {
            text-align: center;
        }

        ul {
            background-color: #ffffff;
            width: 300px;
            margin: auto;
            padding: 15px;
            border: 1px solid #ccc;
            list-style-type: none;
        }

        li {
            padding: 5px 0;
            border-bottom: 1px solid #eee;
        }

        li:last-child {
            border-bottom: none;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
   <h2>TO-DO-List</h2>
   <ul>
     <% 
        if(tasks!=null && !tasks.isEmpty()){
        	for(String i:tasks){
       %>	
          <li><%=i %></li>
       <%    	
        	}
        } else{
        %>
          <li>No task added yet</li>	
        <% }%>
   </ul>
   <a href="index.jsp">Go Back</a>
</body>
</html>