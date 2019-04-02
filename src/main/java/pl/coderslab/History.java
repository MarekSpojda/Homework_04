package pl.coderslab;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class History {
    public static void updateHistory(HttpServletRequest request, HttpServletResponse response, int pageId) {
        HttpSession session = request.getSession();
        List<String> history = (ArrayList<String>) session.getAttribute("history");
        if (history == null || history.size() == 0) {
            history = new ArrayList<>();
        }

        history.add("Strona " + pageId);
        session.setAttribute("history", history);
    }
}
