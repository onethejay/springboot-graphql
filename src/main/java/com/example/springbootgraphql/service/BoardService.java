package com.example.springbootgraphql.service;

import com.example.springbootgraphql.dto.BoardDto;
import com.example.springbootgraphql.entity.BoardEntity;
import com.example.springbootgraphql.entity.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    //게시글 1개 가져오기
    public BoardDto getBoard(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        return new ModelMapper().map(boardEntity, BoardDto.class);
    }

    //게시글 목록 가져오기
    public List<BoardDto> getBoardList() {
        List<BoardDto> dtos = new ArrayList<>();

        boardRepository.findAll().forEach(entity -> {
            dtos.add(new ModelMapper().map(entity, BoardDto.class));
        });

        return dtos;
    }

    //게시글 등록
    public BoardDto create(BoardDto boardDto) {
        BoardEntity entity = BoardEntity.builder()
                .id(boardDto.getId())
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();

        BoardEntity savedEntity = boardRepository.save(entity);

        return new ModelMapper().map(savedEntity, BoardDto.class);
    }

    //게시글 수정
    public BoardDto update(BoardDto boardDto) {
        BoardEntity entity = boardRepository.findById(boardDto.getId())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setTitle(boardDto.getTitle());
        entity.setContent(boardDto.getContent());

        BoardEntity savedEntity = boardRepository.save(entity);

        return new ModelMapper().map(savedEntity, BoardDto.class);
    }

    //게시글 삭제
    public void delete(Long id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        boardRepository.delete(entity);
    }
}