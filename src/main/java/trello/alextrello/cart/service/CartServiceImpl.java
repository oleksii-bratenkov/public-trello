package trello.alextrello.cart.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import trello.alextrello.cart.dto.CartDto;
import trello.alextrello.entity.Cart;
import trello.alextrello.repository.CartRepository;
import trello.alextrello.cart.dto.CartCustomMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public List<CartDto> getAllByBoardId(Long boarId){
        return CartCustomMapper.mapToCartDtoList(cartRepository.getAllByBoardId(boarId));
    }

    public CartDto saveNewCart(CartDto cartDto, Long boardId){
        Cart save = cartRepository.save(CartCustomMapper.mapToCart(cartDto, boardId));
        return CartCustomMapper.mapToCartDto(save);
    }
}
