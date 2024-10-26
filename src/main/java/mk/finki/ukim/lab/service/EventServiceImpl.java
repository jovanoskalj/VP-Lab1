package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.model.Event;
import mk.finki.ukim.lab.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{
private  final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }


    @Override
    public List<Event> searchEvents(String text, double minRating) {
        return eventRepository.findAll().stream()
                .filter(event -> (text == null || event.getName().toLowerCase().contains(text.toLowerCase()) ||
                        event.getDescription().toLowerCase().contains(text.toLowerCase())) &&
                        event.getPopularityScore() >= minRating)
                .collect(Collectors.toList());
    }


}
