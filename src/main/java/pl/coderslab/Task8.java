package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Task8", urlPatterns = {"/newsletter"})
public class Task8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.getWriter().println("Still working on that in 2019...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        boolean displayForm = true;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("displayFormCookie")) {
                    displayForm = false;
                    session.setAttribute("displayForm", displayForm);
                }
            }
        }

        if (displayForm) {
            session.setAttribute("displayForm", displayForm);
            Cookie cookie = new Cookie("displayFormCookie", "You+shall+see+form");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
        }

        request.getRequestDispatcher("/WEB-INF/task8.jsp").include(request, response);
    }
}
