package trello.alextrello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import trello.alextrello.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Transactional
    void deleteBoardById(Long boardId);
}