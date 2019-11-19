package trello.alextrello.cart

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory
import trello.alextrello.cart.dto.CartDto
import trello.alextrello.cart.service.CartService

import static org.hamcrest.Matchers.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(value = CartController, secure = false)
@EnableSpringDataWebSupport
@Import(CartControllerTestConfiguraton)
class CartControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    CartService cartService

    def "get cart dto by cart id"() {
        given:
        def carts = generateCartList()

        cartService.getAllByBoardId(1L) >> carts

        expect:
        mockMvc.perform(get("http://localhost:8060/api/v1/cart/{boardId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath('$').value(hasSize(10)))
                .andExpect(jsonPath('$[0].id').value(is(1)))
                .andExpect(jsonPath('$[8].description').value(is("some description9")))
    }

    private static List<CartDto> generateCartList() {
        return [new CartDto(1, "title1", "some descritption1", null),
                new CartDto(2, "title2", "some descritption2", null),
                new CartDto(3, "title3", "some descritption3", null),
                new CartDto(4, "title4", "some descritption4", null),
                new CartDto(5, "title5", "some descritption5", null),
                new CartDto(6, "title6", "some descritption6", null),
                new CartDto(7, "title7", "some descritption7", null),
                new CartDto(8, "title8", "some descritption8", null),
                new CartDto(9, "title9", "some descritption9", null),
                new CartDto(9, "title10", "some descritption10", null)]
    }

    @TestConfiguration
    static class CartControllerTestConfiguraton {
        private DetachedMockFactory factory = new DetachedMockFactory()

        @Bean
        @Primary
        CartService dataPointService() {
            return factory.Mock(CartService)
        }
    }
}
