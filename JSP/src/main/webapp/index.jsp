<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Palindrome Checker</title>
</head>
<body>
<div class="container">
<h2>Palindrome Checker</h2>
<form method="post">
<label>Enter a word</label>
<input type="text" name="inputStr" required>
<button type="submit">Check</button>
</form>
<% String inputStr = request.getParameter("inputStr");

if (inputStr != null && !inputStr.trim().isEmpty()) {
    String str = inputStr.toLowerCase();
    boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());

    if (isPalindrome) {
        out.println("<p style='color: green;'><strong>" + inputStr + " is a Palindrome!</strong></p>");
    } else {
        out.println("<p style='color: red;'><strong>" + inputStr + " is not a Palindrome.</strong></p>");
    }
}


%></div>

</body>
</html>