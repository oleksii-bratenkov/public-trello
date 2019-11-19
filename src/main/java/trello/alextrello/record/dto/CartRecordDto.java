package trello.alextrello.record.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRecordDto {

    private Long id;
    private String title;
    private String description;
    private String comment;
    private LocalDateTime deadline;
    private Long order;
}
