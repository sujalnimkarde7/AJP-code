import jakarta.servlet.ServletException;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task=request.getParameter("task");
		
		HttpSession session=request.getSession();
		 List<String> tasks = (List<String>) session.getAttribute("tasks");
		 if(tasks==null) {
			 tasks=new ArrayList<>();
			 
		 }
		 tasks.add(task);
		 session.setAttribute("tasks", tasks);
		 response.sendRedirect("todo.jsp");
		 

	}

       
 
	


	

}