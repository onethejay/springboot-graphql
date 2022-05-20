package com.example.springbootgraphql.web;

import com.example.springbootgraphql.dto.BoardDto;
import com.example.springbootgraphql.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public BoardDto create(@Argument String title, @Argument String content) {
        BoardDto boardDto = BoardDto.builder()
                .title(title)
                .content(content)
                .build();

        return boardService.create(boardDto);
    }
}
