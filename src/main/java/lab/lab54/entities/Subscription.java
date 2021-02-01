package lab.lab54.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Document(collection = "subscriptions")
public class Subscription {
    @Id
    private String id;
    private Event event;
    private String email;
    private LocalDateTime time;
}
