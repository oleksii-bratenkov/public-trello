package trello.alextrello.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trello.alextrello.record.dto.CartRecordDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Long id;
    private String title;
    private String description;
    private List<CartRecordDto> cartRecords;

}
