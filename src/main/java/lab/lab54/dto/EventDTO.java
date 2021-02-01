package lab.lab54.dto;

import lab.lab54.entities.Event;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {

    public static EventDTO from(Event event){
        return builder()
                .id(event.getId())
                .time(event.getTime())
                .name(event.getName())
                .description(event.getDescription())
                .build();
    }

    public static List<EventDTO> list(List<Event> events){
        List<EventDTO> eventDTOS = new ArrayList<>();
        for(Event event : events){
            eventDTOS.add(from(event));
        }
        return eventDTOS;
    }

    private String id;
    private LocalDateTime time;
    private String name;
    private String description;
}
