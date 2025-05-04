

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/Addition")
public class Addition extends HttpServlet {
	private static final long serialVersionUID=1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		int number1=Integer.parseInt(request.getParameter("num1"));
		int number2=Integer.parseInt(request.getParameter("num2"));
		int sum=number1+number2;
        // Write HTML response with a link to the CSS file
        out.println("<html><head>");
        out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>"); // Linking the CSS file
        out.println("</head><body>");
        
        out.println("<h1 class='center-text'>The Result Window</h1>");
        out.println("<div class='result-box'>");
        out.println("<p>The sum of " + number1 + " and " + number2 + " is " + sum + "</p>");
        out.println("</div>");
        
        out.println("</body></html>");
		
	
	}

}