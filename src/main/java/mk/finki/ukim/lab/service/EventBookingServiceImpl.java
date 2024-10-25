package mk.finki.ukim.lab.service;

import mk.finki.ukim.lab.model.EventBooking;
import mk.finki.ukim.lab.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return  new EventBooking(eventName,attendeeName,attendeeAddress, (long) numberOfTickets);
    }
}
