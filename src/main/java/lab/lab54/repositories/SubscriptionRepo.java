package lab.lab54.repositories;

import lab.lab54.entities.Event;
import lab.lab54.entities.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepo extends MongoRepository<Subscription,String> {
    Subscription findSubscriptionById(String id);
    Subscription findSubscriptionByIdAndEmail(String id,String email);
    boolean existsSubscriptionByIdAndEmail(String id,String email);
    boolean existsSubscriptionByEvent(Event event);

    @Override
    void delete(Subscription subscription);
}
