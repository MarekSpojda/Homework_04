package pl.coderslab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_01_1", urlPatterns = {"/task4a"})
public class Servlet_01_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        RequestDispatcher rd = request.getRequestDispatcher("langcontext.jsp");
        rd.include(request, response);

        response.getWriter().println("<form action=\"/task4b\" method=\"POST\">");
        response.getWriter().println("<select name = \"greetings\">");
        response.getWriter().println("<option value = \"Hello\">en</option>");
        response.getWriter().println("<option value = \"Cześć\">pl</option>");
        response.getWriter().println("<option value = \"Ehre\">de</option>");
        response.getWriter().println("<option value = \"Hola\">es</option>");
        response.getWriter().println("<option value = \"Bienvenue\">fr</option>");
        response.getWriter().println("</select>");
        response.getWriter().println("<input type=\"submit\" value=\"Go!\">");
        response.getWriter().println("</form>");
    }
}
