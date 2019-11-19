package trello.alextrello.board.service;

import org.springframework.stereotype.Service;
import trello.alextrello.repository.BoardRepository;
import trello.alextrello.board.dto.BoardCustomMapper;
import trello.alextrello.board.dto.BoardDto;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    public void saveBoard(BoardDto boardDto){
        boardRepository.save(BoardCustomMapper.mapToBoard(boardDto));
    }

    public List<BoardDto> getAll(){
        return BoardCustomMapper.mapToBoardDtoList(boardRepository.findAll());
    }

    public BoardDto getBoardByUserId(){
        return null;
    }

    public BoardDto getById(Long boardId){
        return BoardCustomMapper.mapToBoardDto(boardRepository.getOne(boardId));
    }

    public void deleteBoardById(Long boardId){
        boardRepository.deleteBoardById(boardId);
    }
}
