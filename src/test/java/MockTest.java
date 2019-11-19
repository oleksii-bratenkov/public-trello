import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import trello.alextrello.cart.dto.CartDto;
import trello.alextrello.cart.service.CartServiceImpl;
import trello.alextrello.entity.Board;
import trello.alextrello.entity.Cart;
import trello.alextrello.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class MockTest {

  @Mock
  CartRepository cartRepository;

  @InjectMocks
  CartServiceImpl cartService;

  @Test
  public void testCartService() {
    when(cartRepository.getAllByBoardId(1L)).thenReturn(prepareCartList());
    List<CartDto> allByBoardId = cartService.getAllByBoardId(1L);

    assertThat(allByBoardId.size(), is(2));
  }


  private static List<Cart> prepareCartList() {
    return new ArrayList<Cart>() {
      {
        add(new Cart(1L, "test", "test", null, createBoard()));
        add(new Cart(2L, "test2", "test2", null, createBoard()));
      }
    };
  }

  private static Board createBoard() {
    Board board = new Board();
    board.setTitle("some title");
    board.setId(1L);
    return board;
  }
}
