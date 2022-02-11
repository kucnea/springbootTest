package com.example.demo.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;

import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class BoardControllerTest {
	
	@Autowired BoardService boardService;
	
	@Test
	void boardPage(){
		
		int page = 1;
		int size = 10;
		
		Page<Board> pages = boardService.searchList(page, size);
		System.out.println("pages.isEmpty() : "+pages.isEmpty());
		if(pages.isEmpty()) {
			page=0;
			size=10;
			
			pages = boardService.searchList(page,size);
		}
		
		List<Board> list = pages.getContent();
		
		System.out.println("list.size() : "+list.size());
		log.info("list.size() : "+list.size());
	}
	
	@Test
	void test() {
		System.out.println("dawdwad");
	}
	
	
}
