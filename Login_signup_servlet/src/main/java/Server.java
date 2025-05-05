
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=(String)request.getAttribute("username");
		String password=(String)request.getAttribute("password");
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>User Info</title>");
		out.println("</head><body>");
		out.println("<div class='output-container'>");
		out.println("<h2>The user Information</h2>");
		out.println("<p><strong>Username:</strong>"+ username +"</p>");
		out.println("<p><strong>Password:</strong> " + password + "</p>");
		out.println("</div>");
		out.println("</body></html>");

		
	}

}
