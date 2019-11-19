package trello.alextrello.board.dto;

import trello.alextrello.cart.dto.CartCustomMapper;
import trello.alextrello.cart.dto.CartDto;
import trello.alextrello.entity.Board;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoardCustomMapper {


    public static List<BoardDto> mapToBoardDtoList(List<Board> boards){
        return boards.stream()
                .map(BoardCustomMapper::mapToBoardDto)
                .collect(Collectors.toList());
    }

    public static BoardDto mapToBoardDto(Board board){
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setTitle(board.getTitle());
        List<CartDto> list = !board.getCartSet().isEmpty()? CartCustomMapper.mapToCartDtoList(board.getCartSet())
                : Collections.emptyList();
        boardDto.setCarts(list);
        return boardDto;
    }

    public static Board mapToBoard(BoardDto boardDto){
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        return board;
    }
}
