package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String list(Model model){
		List<BoardDto> boardDtoList = boardService.getBoardList();
		model.addAttribute("boardList",boardDtoList);

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

	@GetMapping("post/{no}")
	public String detail(@PathVariable("no") Long id, Model model) {
		BoardDto boardDto = boardService.getPost(id);

		model.addAttribute("boardDto",boardDto);
		return "board/detail.html";
	}
}
