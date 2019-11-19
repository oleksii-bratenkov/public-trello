package trello.alextrello.record.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRecordQuery {

    private Long cartRecordId;
    private Long cartId;
    private Integer changeIndex;
}
