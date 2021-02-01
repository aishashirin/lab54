package lab.lab54.repositories;

import lab.lab54.entities.Event;
import lab.lab54.entities.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepo extends MongoRepository<Subscription,String> {
    Subscription findSubscriptionById(String id);
    List<Subscription> findSubscriptionByEmail(String email);
    boolean existsSubscriptionByIdAndEmail(String id,String email);
    boolean existsSubscriptionByEvent(Event event);

    @Override
    void delete(Subscription subscription);
}
