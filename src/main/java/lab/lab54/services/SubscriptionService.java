package lab.lab54.services;
import lab.lab54.dto.SubscriptionDTO;
import lab.lab54.entities.Event;
import lab.lab54.entities.Subscription;
import lab.lab54.repositories.EventRepo;
import lab.lab54.repositories.SubscriptionRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionService {
    private SubscriptionRepo subscriptionRepo;
    private EventRepo eventRepo;

    public String subscribe(String id,String email){
        String message;
        Event event = eventRepo.findEventById(id);
        if(eventDateIsInFuture(event) && eventRepo.existsEventById(id)) {
            if (!subscriptionRepo.existsSubscriptionByEvent(event)) {
                Subscription subscription = Subscription.builder()
                        .id(subscriptionRepo.findAll().size() + 1 + "")
                        .email(email)
                        .event(event)
                        .time(LocalDateTime.now())
                        .build();
                subscriptionRepo.save(subscription);
                message = "Success! You subscribed. Id of event:" + event.getId();
            } else {
                message = "You already subscribed for this event. Its ID-" + event.getId();
            }
        }
        else if (!eventRepo.existsEventById(id)) {
            message = "There is no event with such ID";
        } else {
            message = "Event has already passed. Its ID-" + event.getId();
        }
        return message;
    }

    public List<SubscriptionDTO> getSubscriptionsByEmail(String email) {
        return SubscriptionDTO.list(subscriptionRepo.findSubscriptionByEmail(email));
    }

    public String deleteSubscription(String id, String email) {
        String msg;
        if (subscriptionRepo.existsSubscriptionByIdAndEmail(id, email)) {
            Subscription subscription = subscriptionRepo.findSubscriptionById(id);
            subscriptionRepo.delete(subscription);
            msg = "You successfully deleted subscription by ID-" + id + " for email-" + email;
        } else {
            msg = "There is no such ID or email";
        }
        return msg;
    }

    private boolean eventDateIsInFuture(Event event) {
        return event.getTime().isAfter(LocalDateTime.now());
    }

}
