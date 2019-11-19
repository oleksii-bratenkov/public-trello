package trello.alextrello.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trello.alextrello.cart.dto.CartDto;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private List<CartDto> carts;

}
