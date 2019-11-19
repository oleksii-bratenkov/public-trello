package trello.alextrello.record;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import trello.alextrello.record.dto.CartRecordChangeCartDto;
import trello.alextrello.record.dto.CartRecordDto;
import trello.alextrello.record.dto.CartRecordQuery;
import trello.alextrello.record.service.CartRecordService;
import trello.alextrello.record.service.CartRecordServiceImpl;
import trello.alextrello.repository.CartRecordRepository;

@RestController
@RequestMapping("/api/v1/cart-record")
@AllArgsConstructor
public class CartRecordController {

    private final CartRecordService cartRecordService;

    @PostMapping("{cartId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartRecordDto saveCartRecord(@PathVariable Long cartId,
                                        @RequestBody CartRecordDto cartRecordDto){
        return cartRecordService.saveCartRecord(cartRecordDto, cartId);
    }

    @PutMapping("{cartId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CartRecordDto updateCartRecord(@PathVariable Long cartId,
                                          @RequestBody CartRecordDto cartRecordDto){

        return cartRecordService.saveCartRecord(cartRecordDto, cartId);
    }

    @GetMapping("{cartRecordId}")
    public Long getAllByCartIdRecord(@PathVariable Long cartRecordId){
        return cartRecordService.countAllByCartId(cartRecordId);
    }

    @PutMapping("/change-order")
    @CrossOrigin(origins = "http://localhost:4200")
    public void changeOrder(@RequestBody CartRecordQuery cartRecordQuery){
        cartRecordService.changeRecordsOrder(cartRecordQuery.getCartRecordId(),
            cartRecordQuery.getChangeIndex(), cartRecordQuery.getCartId());
    }

    @PutMapping("/change-cart")
    @CrossOrigin(origins = "http://localhost:4200")
    public void changeCart(@RequestBody CartRecordChangeCartDto cartRecordChangeCartDto){
        cartRecordService.changeCart(cartRecordChangeCartDto);
    }
}
