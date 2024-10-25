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

    }
    public List<Event> searchEvents(String text){
        return events.stream()
                .filter(i->i.getName().contains(text)||i.getDescription().contains(text))
                .collect(Collectors.toList());
    }

}
