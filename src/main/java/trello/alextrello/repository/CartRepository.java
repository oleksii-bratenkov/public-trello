package trello.alextrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trello.alextrello.entity.Cart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository <Cart, Long> {

    List<Cart> getAllByBoardId(Long boardId);


}
