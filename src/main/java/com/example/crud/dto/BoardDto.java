package com.example.crud.dto;

import java.time.LocalDateTime;

import com.example.crud.domain.entity.Board;

import lombok.Builder;

public class BoardDto {
	private Long id;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	public Board toEntity() {
		Board board = Board.builder()
			.id(id)
			.writer(writer)
			.title(title)
			.content(content)
			.build();
		return board;
	}

	@Builder
	public BoardDto(Long id, String writer, String title, String content, LocalDateTime createdDate,
		LocalDateTime modifiedDate) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
}
