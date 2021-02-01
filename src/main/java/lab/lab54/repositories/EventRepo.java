package lab.lab54.repositories;

import lab.lab54.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepo extends MongoRepository<Event, String> {
    Event findEventById(String id);

    Event findEventByName(String name);

    boolean existsEventByName(String name);

    boolean existsEventById(String id);
}
