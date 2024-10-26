package mk.finki.ukim.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.lab.model.Event;
import mk.finki.ukim.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name="event-servlet", urlPatterns = "/*")

public class EventListServlet extends HttpServlet {
private final EventService eventService;
private final SpringTemplateEngine springTemplateEngine;

    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);


        String searchText = req.getParameter("searchText");
        String minRatingParam = req.getParameter("minRating");

        List<Event> events;
        events = eventService.listAll();
        if ((searchText == null || searchText.isEmpty()) && (minRatingParam == null || minRatingParam.isEmpty())) {

            events = eventService.listAll();
        } else {

            double minRating = minRatingParam != null && !minRatingParam.isEmpty() ? Double.parseDouble(minRatingParam) : 0.0;
            // Search events based on criteria
            events = eventService.searchEvents(searchText, minRating);
        }

        // Set up Thymeleaf context
        WebContext context = new WebContext(webExchange, req.getLocale());
        // Capture the client IP address
        String clientIpAddress = req.getRemoteAddr();
        context.setVariable("clientIpAddress", clientIpAddress);
        context.setVariable("events", events);
        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
