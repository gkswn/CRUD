package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.domain.entity.Board;
import com.example.crud.domain.repository.BoardRepository;
import com.example.crud.dto.BoardDto;

@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository){
		this.boardRepository = boardRepository;
	}

	@Transactional
	public Long savePost(BoardDto boardDto){
		return boardRepository.save(boardDto.toEntity()).getId();
	}

	@Transactional
	public List<BoardDto> getBoardList() {
		List<Board> boards = boardRepository.findAll();
		List<BoardDto> boardList = new ArrayList<>();

		for(Board board : boards){
			BoardDto boardDto = BoardDto.builder()
				.id(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.createdDate(board.getCreatedDate())
				.build();

			boardList.add(boardDto);
		}
		return boardList;
	}

	@Transactional
	public BoardDto getPost(Long id) {
		Optional<Board> boardWrapper = boardRepository.findById(id);
		Board board = boardWrapper.get();

		BoardDto boardDto = BoardDto.builder()
			.id(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.writer(board.getWriter())
			.createdDate(board.getCreatedDate())
			.build();

		return boardDto;
	}
}
