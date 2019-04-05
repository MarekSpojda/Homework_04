package pl.coderslab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Servlet_02", urlPatterns = {"/task5"})
public class Servlet_02 extends HttpServlet {
    private String startZone = null;
    private String startCodeForJsp = null;
    private String endZone = null;
    private String endCodeForJsp = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String startAirport = request.getParameter("startAirport");
        String endAirport = request.getParameter("endAirport");
        String startTime = request.getParameter("start-time");
        String flightTime = request.getParameter("flight-time");
        String price = request.getParameter("price");

        validateFlight(response, startAirport, endAirport, startTime, flightTime, price);

        HttpSession session = request.getSession();
        List<Airport> airports = (ArrayList<Airport>) session.getAttribute("airports");
        for (Airport airport : airports) {
            assignZoneAndCode(airport, startAirport, endAirport);
        }

        ZonedDateTime startDateTime = null;
        ZonedDateTime endtDateTime = null;
        DateTimeFormatter format = null;
        try {
            final String DATE_FORMAT = "yyyy-MM-dd hh:mm a";
            LocalDateTime ldt = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern(DATE_FORMAT));
            ZoneId startZoneId = ZoneId.of(startZone);
            startDateTime = ZonedDateTime.of(ldt, startZoneId);
            endtDateTime = startDateTime.plusHours(Long.parseLong(flightTime)).withZoneSameInstant(ZoneId.of(endZone));

            format = DateTimeFormatter.ofPattern(DATE_FORMAT);
            response.getWriter().println("Lokalny czas przylotu: " + format.format(endtDateTime));
        } catch (Exception e) {
            response.getWriter().println(">>> !! Wystąpił nieoczekiwany błąd. Przepraszamy za utrudnienia. Jeśli to " +
                    "możliwe zgłoś zaistniałą sytuację pracownikowi firmy. !! <<<");
            e.printStackTrace();
        }

        assert format != null;
        Flight flight = new Flight(startAirport, endAirport, format.format(endtDateTime), Double.parseDouble(price));
        request.setAttribute("flight", flight);
        request.setAttribute("start", format.format(startDateTime));
        request.setAttribute("end", format.format(endtDateTime));
        request.setAttribute("startCode", startCodeForJsp);
        request.setAttribute("endCode", endCodeForJsp);
        request.setAttribute("flightTime", flightTime);

        request.getRequestDispatcher("/WEB-INF/displayFlight.jsp").include(request, response);
    }

    private void assignZoneAndCode(Airport airportToCheck, String startAirport, String endAirport) {
        if (airportToCheck.getName().equals(startAirport)) {
            startZone = airportToCheck.getTimezone();
            startCodeForJsp = airportToCheck.getCode();
        } else if (airportToCheck.getName().equals(endAirport)) {
            endZone = airportToCheck.getTimezone();
            endCodeForJsp = airportToCheck.getCode();
        }
    }

    private void validateFlight(HttpServletResponse response, String startAirport, String endAirport, String startTime, String flightTime, String price) throws IOException {
        if (startAirport.equals(endAirport)) {
            response.getWriter().println("Lotnisko wylotu jest takie same jak lotnisko przylotu.");
        } else if (startTime.equals("")) {
            response.getWriter().println("Nie podano daty lotu.");
        } else if (flightTime.equals("") || flightTime.equals("0")) {
            response.getWriter().println("Czas lotu nie może wynosić 0.");
        } else if (price.equals("0")) {
            response.getWriter().println("Cena lotu musi być większa od 0.");
        } else {
            generateFlightInfo(response, startAirport, endAirport, startTime, flightTime, price);
        }
    }

    private void generateFlightInfo(HttpServletResponse response, String startAirport, String endAirport, String startTime, String flightTime, String price) throws IOException {
        response.getWriter().println("Lotnisko wylotu: " + startAirport + "<br>");
        response.getWriter().println("Lotnisko przylotu: " + endAirport + "<br>");
        response.getWriter().println("Czas startu: " + startTime + "<br>");
        response.getWriter().println("Długość lotu w godzinach: " + flightTime + "<br>");
        response.getWriter().println("Cena lotu: " + price + "<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Airport> airports = (ArrayList<Airport>) session.getAttribute("airports");
        if (airports == null) {
            airports = new AirportDao().getList();
            session = request.getSession();
            session.setAttribute("airports", airports);
        }

        RequestDispatcher rd = request.getRequestDispatcher("airport.jsp");
        rd.include(request, response);
    }
}
