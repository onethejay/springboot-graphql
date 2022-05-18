package com.example.springbootgraphql.web;

import com.example.springbootgraphql.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    @QueryMapping
    public BoardEntity board(@Argument String idx) {
        System.out.println("호출되었습니다.");
        return new BoardEntity("1", "제목1", "내용1");
    }

    @QueryMapping
    public List<BoardEntity> boardList() {
        return Collections.emptyList();
    }
}
