package com.example.springbootgraphql.web;

import com.example.springbootgraphql.dto.BoardDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureGraphQlTester
class BoardControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;


    @DisplayName("1. 게시글 1개 가져오기")
    @Test
    void test_1(){
        this.graphQlTester.documentName("board")
                .variable("id", "1")
                .execute()
                .path("board.title")
                .entity(String.class)
                .isEqualTo("제목1");
    }

    @DisplayName("2. 게시글 목록 가져오기")
    @Test
    void test_2(){
        this.graphQlTester.documentName("boardList")
                .execute()
                .path("boardList[*].title")
                .entityList(String.class)
                .contains("제목1", "제목2", "제목3");
    }

    @DisplayName("3. 게시글 create")
    @Test
    void test_3(){

        this.graphQlTester.documentName("create")
                .variable("title", "제목5")
                .variable("content", "내용5")
                .execute()
                .path("create.title")
                .entity(String.class)
                .isEqualTo("제목5");

    }
}