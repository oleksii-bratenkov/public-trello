package trello.alextrello.record.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRecordChangeCartDto {

    private Long cartRecordID;
    private Long toCartId;
    private Long changeIndex;
}
