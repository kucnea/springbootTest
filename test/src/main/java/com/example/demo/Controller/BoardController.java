package com.example.demo.Controller;

import java.util.List;

import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/boardpage")
	public String boardPage(Model model,
			@RequestParam("page") @Nullable Integer page, 
			@RequestParam("size") @Nullable Integer size
			) {
		
		if(page==null) page=1;
		if(size==null) size=10;
		
		page-=1;
		Page<Board> pages = boardService.searchList(page,size);
		
		if(page<0) page=0;
		else if(page>pages.getTotalPages()) page=pages.getTotalPages();
		
		List<Board> list = pages.getContent();
		
		System.out.println("list.size() : "+list.size());
		if(list.size()!=0) model.addAttribute("list", list);
		else model.addAttribute("msg", "1");
		
		return "board.boardPage";
	}
	

	
}
