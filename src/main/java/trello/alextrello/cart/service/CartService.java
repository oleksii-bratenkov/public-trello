package trello.alextrello.cart.service;

import trello.alextrello.cart.dto.CartDto;

import java.util.List;

public interface CartService {

  List<CartDto> getAllByBoardId(Long boarId);
  CartDto saveNewCart(CartDto cartDto, Long boardId);
}
