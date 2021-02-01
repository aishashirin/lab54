package lab.lab54.Controllers;

import lab.lab54.dto.EventDTO;
import lab.lab54.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/allEvents")
    public List<EventDTO> getAllEvents() {
        return eventService.getEvents();
    }
}
