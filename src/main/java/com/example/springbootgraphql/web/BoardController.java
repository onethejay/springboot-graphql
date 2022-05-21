package com.example.springbootgraphql.web;

import com.example.springbootgraphql.dto.BoardDto;
import com.example.springbootgraphql.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @QueryMapping
    public BoardDto board(@Argument Long id) {
        System.out.println("호출되었습니다.");
        return boardService.getBoard(id);
    }

    @QueryMapping
    public List<BoardDto> boardList() {
        return boardService.getBoardList();
    }

    @MutationMapping
    public BoardDto create(@Argument BoardDto boardInput) {
        System.out.println("BoardInput :: " + boardInput);
        return boardService.create(boardInput);
    }

    @MutationMapping
    public BoardDto update(@Argument BoardDto boardInput) {
        System.out.println("BoardInput :: " + boardInput);
        return boardService.update(boardInput);
    }

    @MutationMapping
    public Boolean delete(@Argument Long id) {
        boardService.delete(id);
        return true;
    }
}
