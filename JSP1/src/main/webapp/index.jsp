<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do-List</title>
<style>
  body {
    font-family: sans-serif;
    background-color: #f0f0f0;
    padding: 20px;
  }

  div {
    background-color: #ffffff;
    width: 300px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ccc;
  }

  h1 {
    text-align: center;
  }

  input[type="text"] {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    box-sizing: border-box;
  }

  button {
    width: 100%;
    padding: 8px;
    background-color: #007bff;
    color: white;
    border: none;
  }

  a {
    display: block;
    text-align: center;
    margin-top: 10px;
    color: #007bff;
    text-decoration: none;
  }
</style>
</head>
<body>
<div>
   <h1>TO-Do-List</h1>
   <form action="Server" method="post">
       <input type="text"  name="task" placeholder="Entre new task">
       <button type="submit" >Add Task</button>
       <br/>
       <a href="Server1">View To Do</a>
   </form>
</div>

</body>
</html>