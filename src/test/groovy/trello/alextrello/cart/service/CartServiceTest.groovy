package trello.alextrello.cart.service

import spock.lang.Specification
import trello.alextrello.entity.Board
import trello.alextrello.entity.Cart
import trello.alextrello.repository.CartRepository

class CartServiceTest extends Specification {



    def "should return list"() {
        given:
        def cart = Mock(CartRepository)
        def cartService = new CartServiceImpl(cart)

        when: 'cart service ....'
        cart.getAllByBoardId(1L) >> prepareCartList()
        def cartList = cartService.getAllByBoardId(1L)

        then:
        cartList.size() == 2
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

