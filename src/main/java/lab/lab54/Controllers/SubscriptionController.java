package lab.lab54.Controllers;

import lab.lab54.dto.SubscriptionDTO;
import lab.lab54.services.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/subscription/{eventId}")
    public String addSubscription(@PathVariable("eventId") String eventId,
                                  @RequestParam("email") String email) {
        return subscriptionService.subscribe(eventId, email);
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDTO> getAllSubscriptions(@RequestParam("email") String email) {
        return subscriptionService.getSubscriptionsByEmail(email);
    }

    @PostMapping("/subscription/{id}")
    public String deleteSubscription(@PathVariable("id") String id,
                                     @RequestParam("email") String email) {
        return subscriptionService.deleteSubscription(id, email);
    }
}
