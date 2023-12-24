package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.dto.BoardDto;
import com.example.crud.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;

	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}

	@GetMapping("/")
	public String list(){
		return "board/list.html";
	}

	@GetMapping("/post")
	public String board(){
		return "board/write.html";
	}

	@PostMapping("/post")
	public String write(BoardDto boardDto){
		boardService.savePost(boardDto);
		return "redirect:/";
	}
}
