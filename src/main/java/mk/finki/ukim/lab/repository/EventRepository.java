package mk.finki.ukim.lab.repository;

import lombok.AllArgsConstructor;
import mk.finki.ukim.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class EventRepository {

    List<Event> events = new ArrayList<>(10);

    public List<Event> findAll(){
        return events;
    }
    public EventRepository() {
        // Initialize with 10 events
        events.add(new Event("Concert", "Live music event", 8.5));
        events.add(new Event("Workshop", "Coding workshop", 7.2));
        events.add(new Event("Art Exhibition", "Showcase of local artists", 9.0));
        events.add(new Event("Cooking Class", "Learn to cook Italian cuisine", 8.0));
        events.add(new Event("Tech Conference", "Networking with industry experts", 9.5));
        events.add(new Event("Film Screening", "Showing independent films", 7.8));
        events.add(new Event("Book Club", "Discussion of this month's book", 6.5));
        events.add(new Event("Yoga Retreat", "Relaxation and mindfulness sessions", 8.3));
        events.add(new Event("Charity Run", "Run for a good cause", 5.7));
        events.add(new Event("Science Fair", "Showcasing student projects", 3.5));


    }
    public List<Event> searchEvents(String text) {
        String lowerCaseText = text.toLowerCase();
        return events.stream()
                .filter(event -> event.getName().toLowerCase().contains(lowerCaseText) ||
                        event.getDescription().toLowerCase().contains(lowerCaseText))
                .collect(Collectors.toList());
    }

}
