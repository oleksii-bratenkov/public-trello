package trello.alextrello.board;

import org.springframework.web.bind.annotation.*;
import trello.alextrello.board.dto.BoardDto;
import trello.alextrello.board.service.BoardService;
import trello.alextrello.board.service.BoardServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/board")
@CrossOrigin(origins = "http://localhost:4200")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void saveBoard(@RequestBody BoardDto boardDto){
        boardService.saveBoard(boardDto);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BoardDto> getAll()
    {
        return boardService.getAll();
    }

    @DeleteMapping("{boardId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoardById(boardId);
    }

    @GetMapping("{boardId}")
    public BoardDto getOne(@PathVariable Long boardId){
        return boardService.getById(boardId);
    }

}
