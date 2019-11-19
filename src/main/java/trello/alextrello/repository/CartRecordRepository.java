package trello.alextrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trello.alextrello.entity.CartRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRecordRepository extends JpaRepository<CartRecord, Long>  {

    Long countAllByCartId(Long cartRecordId);

    Optional <CartRecord> findTopByCartIdOrderByRecordOrderDesc(Long cartId);

    Optional<CartRecord> findByRecordOrderAndAndCartId(Long recordOder, Long cartId);

    List<CartRecord> findAllByCartIdOrderByRecordOrderAsc(Long cartId);

    Optional<CartRecord> findByRecordOrderAndCartId(Long recordOrder, Long cartId);

    @Modifying
    @Query (value = "UPDATE record SET cart_id= :cartId WHERE id =:id", nativeQuery = true)
    int updateCartRecordCart(@Param("id") Long id, @Param("cartId") Long cartId);
}
