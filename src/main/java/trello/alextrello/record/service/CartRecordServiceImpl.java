package trello.alextrello.record.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trello.alextrello.entity.Cart;
import trello.alextrello.entity.CartRecord;
import trello.alextrello.record.dto.CartRecordChangeCartDto;
import trello.alextrello.record.dto.CartRecordCustomMapper;
import trello.alextrello.record.dto.CartRecordDto;
import trello.alextrello.repository.CartRecordRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartRecordServiceImpl implements CartRecordService {

  private final CartRecordRepository cartRecordRepository;

  public CartRecordDto saveCartRecord(CartRecordDto cartRecordDto, Long cartId) {
    CartRecord cartRecord = CartRecordCustomMapper.mapToCartRecord(cartRecordDto);
    Cart cart = new Cart();
    cart.setId(cartId);
    cartRecord.setCart(cart);
    Optional <CartRecord> cartRecordForOrder = cartRecordRepository.findTopByCartIdOrderByRecordOrderDesc(cartId);
    Long recordOrder = cartRecordForOrder.map(cartRecord1 -> cartRecord1.getRecordOrder() + 2).orElse(2L);
    cartRecord.setRecordOrder(recordOrder);
    cartRecordRepository.save(cartRecord);
    return cartRecordDto;
  }

  public void changeRecordsOrder(Long cartRecordId, Integer changeIndex, Long cartId) {
    CartRecord changed = cartRecordRepository.getOne(cartRecordId);
    Optional<CartRecord> cartRecordChanging = cartRecordRepository.findByRecordOrderAndAndCartId(changed.getRecordOrder() + changeIndex*2, cartId);
    cartRecordChanging.ifPresent(cartRecord -> saveOrders(cartRecord, changed));
  }

  @Override
  public Long countAllByCartId(Long cartRecordId) {
    return cartRecordRepository.countAllByCartId(cartRecordId);
  }

  @Transactional
  public void changeCart(CartRecordChangeCartDto cartRecordChangeCartDto) {
    cartRecordRepository.updateCartRecordCart(cartRecordChangeCartDto.getCartRecordID(),
        cartRecordChangeCartDto.getToCartId());
  }

  @Override
  public CartRecordDto getOne(Long cartRecordId) {
    return CartRecordCustomMapper.mapToCartRecordDto(cartRecordRepository.getOne(cartRecordId));
  }


  private void saveOrders(CartRecord changing, CartRecord changed) {
    Long forChanged = changed.getRecordOrder();
    changed.setRecordOrder(changing.getRecordOrder());
    cartRecordRepository.save(changed);
    changing.setRecordOrder(forChanged);
    cartRecordRepository.save(changing);
  }


/*  private void reorderCartRerords(Long cartId) {
    List<CartRecord> cartRecords = cartRecordRepository.findAllByCartIdOrderByRecordOrderAsc(cartId);
    for (int i = 0; i < cartRecords.size(); i++) {

      cartRecords.get(i).setRecordOrder((long) i);
    }
    cartRecordRepository.saveAll(cartRecords);
  }*/
}
