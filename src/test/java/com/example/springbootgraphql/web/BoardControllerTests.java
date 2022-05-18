package com.example.springbootgraphql.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

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
}