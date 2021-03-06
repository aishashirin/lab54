package lab.lab54.repositories;

import lab.lab54.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepo extends MongoRepository<Event, Integer> {
    Event findEventById(String id);

    Event findEventByName(String name);

    boolean existsEventByName(String name);

    boolean existsEventById(String id);
}
