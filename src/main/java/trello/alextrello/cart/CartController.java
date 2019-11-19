package trello.alextrello.cart;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trello.alextrello.cart.dto.CartDto;
import trello.alextrello.cart.service.CartService;
import trello.alextrello.cart.service.CartServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("{boardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CartDto> getAllByBoardId(@PathVariable Long boardId){
        return cartService.getAllByBoardId(boardId);
    }

    @PostMapping("/{boardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartDto createCart(@PathVariable Long boardId,
                              @RequestBody CartDto cartDto){
        return cartService.saveNewCart(cartDto, boardId);
    }
}
