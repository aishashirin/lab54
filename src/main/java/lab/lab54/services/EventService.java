package lab.lab54.services;

import lab.lab54.dto.EventDTO;
import lab.lab54.repositories.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private  EventRepo eventRepo;

    public List<EventDTO> getEvents(){
        return EventDTO.list(eventRepo.findAll());
    }
}
