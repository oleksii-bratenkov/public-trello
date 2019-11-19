package trello.alextrello.record.service

import spock.lang.Specification
import trello.alextrello.cart.service.CartServiceImpl
import trello.alextrello.entity.Board
import trello.alextrello.entity.Cart
import trello.alextrello.repository.CartRepository

class CartRecordServiceTest extends Specification {

    def "should return all carts"() {
        given:
        def cartRepository = Mock(CartRepository)
        def cartService = new CartServiceImpl(cartRepository)

        cartRepository.getAllByBoardId(1L) >> prepareCartList()

        when:
        def list = cartService.getAllByBoardId(1)

        then:
        list.size() == 2
    }

    private static List<Cart> prepareCartList() {
        return new ArrayList<Cart>() {
            {
                add(new Cart(1, "test", "test", null, createBoard()))
                add(new Cart(2, "test2", "test2", null, createBoard()))
            }
        }
    }

    private static Board createBoard() {
        Board board = new Board()
        board.setTitle("some title")
        board.setId(1)
        return board
    }
}
