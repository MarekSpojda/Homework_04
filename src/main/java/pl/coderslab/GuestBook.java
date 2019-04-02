package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;

@WebServlet(name = "GuestBook", urlPatterns = {"/guest-book"})
public class GuestBook extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        saveToDatabase(request, response);
        response.sendRedirect("/guest-book");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.getRequestDispatcher("/WEB-INF/guestbook.jsp").include(request, response);

        showAll(request, response);
    }

    private Connection initializeDatabase()
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String database = getServletContext().getInitParameter("database");
        String user = getServletContext().getInitParameter("user");
        String password = getServletContext().getInitParameter("password");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database +
                        "?useSSL=false&characterEncoding=UTF-8&" +
                        "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                user, password);
    }

    private void saveToDatabase(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String entry = request.getParameter("entry");

        try (Connection con = initializeDatabase()) {
            String query = "insert into entries(Name,Surname,Entry) values(?,?,?)";
            PreparedStatement st = con
                    .prepareStatement(query);

            st.setString(1, name);
            st.setString(2, surname);
            st.setString(3, entry);

            st.executeUpdate();

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.getWriter().println("<table>");
        try (Connection con = initializeDatabase()) {
            String query = "select * from entries where id>? ORDER BY id DESC";
            PreparedStatement st = con
                    .prepareStatement(query);

            st.setInt(1, 0);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String entry = rs.getString(4);
                response.getWriter().println("<tr><td>" + name + "</td><td>" + surname + "</td><td>" + entry + "</td></tr>");
            }

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.getWriter().println("</table>");
    }
}
