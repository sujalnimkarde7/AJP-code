import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><head><title>Result</title></head><body>");

        double ans = 0;
        boolean valid = true;
        String symbol = "";

        switch (operation) {
            case "add":
                ans = num1 + num2;
                symbol = "+";
                break;
            case "sub":
                ans = num1 - num2;
                symbol = "-";
                break;
            case "multi":
                ans = num1 * num2;
                symbol = "*";
                break;
            case "divi":
                if (num2 != 0) {
                    ans = num1 / num2;
                    symbol = "/";
                } else {
                    valid = false;
                    out.println("<h4 style='color: red;'>Error: Division by zero not possible</h4>");
                }
                break;
            default:
                valid = false;
                out.println("<h4 style='color: red;'>Error: Invalid operation</h4>");
        }

        if (valid) {
            out.println("<h2>Result:</h2>");
            out.println("<p>" + num1 + " " + symbol + " " + num2 + " = " + ans + "</p>");
        }

        out.println("</body></html>");
    }
}