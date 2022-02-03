package com.example.demo.controller;

import java.util.List;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
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
	
	
	@GetMapping("/insertboardpage")
	public String insertBoardPage() {
		return "board.insertBoardPage";
	}
	
	@PostMapping("/insertboard")
	public String insertBoard(@ModelAttribute Board board, HttpServletRequest request, Model model) {
		
		System.out.println("Insert BoardStage board Title : "+board.getBTitle());
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		board.setMember(member);
		
		int result = boardService.creat(board);
		
		if(result>=0) return "redirect:boardpage?page=1&size=10";
		else {
			model.addAttribute("result",1);
			return "board.insertBoardPage";
		}
		
	}
	
	@GetMapping("/readboard")
	public String readBoard(@RequestParam("BIdx") @Nullable Integer bIdx, Model model) {
		
		Board board = boardService.find(bIdx);
		if(board!=null) model.addAttribute("board", board);
		
		return "board.boardDetail";
	}
	
	@GetMapping("/updateboardpage")
	public String updateBoardPage(@RequestParam("BIdx") @Nullable Integer bIdx, Model model) {
		
		Board board = boardService.find(bIdx);
		if(board!=null) model.addAttribute("board", board);
		
		return "board.updateBoardPage";
	}
	
	@PostMapping("/updateboard")
	public String updateBoard(@ModelAttribute Board board, HttpServletRequest request, Model model) {
		
		System.out.println("Update Stage board.getBIdx() : "+board.getBIdx());
		
		board = boardService.update(board);
		
		return "redirect:readboard?BIdx="+board.getBIdx();
	}
	
	@GetMapping("/deleteboard")
	public String deleteMapping(@RequestParam("BIdx") @Nullable Integer bIdx) {
		
		boardService.delete(bIdx);
		
		return "redirect:boardpage?page=1&size=10";
	}
	
}
