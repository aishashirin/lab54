package lab.lab54.dto;

import lab.lab54.entities.Event;
import lab.lab54.entities.Subscription;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDTO {

    public static SubscriptionDTO from(Subscription subscription){
        return builder()
                .id(subscription.getId())
                .event(subscription.getEvent())
                .email(subscription.getEmail())
                .time(subscription.getTime())
                .build();
    }

    public static List<SubscriptionDTO> list(List<Subscription> subscriptions){
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
        for(Subscription s : subscriptions){
            subscriptionDTOS.add(from(s));
        }
        return subscriptionDTOS;
    }

    private String id;
    private Event event;
    private String email;
    private LocalDateTime time;
}
