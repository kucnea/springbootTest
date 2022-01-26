package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
@Transactional(rollbackOn = Exception.class) //
public class MemberService {
	
	@Autowired MemberRepository memberRepository;
	
	public int creat(Member member) {
		
		memberRepository.save(member);
		
		return member.getMIdx();
	}
	
	public boolean validId(String MId) {
		
		if(memberRepository.findByMId(MId) != null) return false;
		else return true;
		
	}
	
}
