package com.example.crud.service;

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
}
