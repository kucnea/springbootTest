package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service
@Transactional(rollbackOn = Exception.class) //
public class BoardService {
	
	@Autowired BoardRepository boardRepository;
	
	public int creat(Board board) {
		
		boardRepository.save(board);
		
		return board.getBIdx();
	}

	public Page<Board> searchList(int page, int size) {

		
		PageRequest pageRequest = 
				PageRequest.of(page, size, Sort.by("BIdx").descending());
		
		Page<Board> list = boardRepository.findAll(pageRequest);
		
		return list;
	}

	
	
}
