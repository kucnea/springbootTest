package com.example.demo.Controller;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/join/")
public class JoinController {
	
	@Autowired MemberService memberService;
	
	@GetMapping("/joinpage")
	public String joinPage() throws Exception {
		
		return "join.joinPage";
	}
	
	@PostMapping("/insertmember")
	public String insertMember(@ModelAttribute Member member, Model model, HttpServletRequest request) {
		
		System.out.println("MId : "+member.getMId()+", MPw : "+member.getMPw());
		int result = memberService.creat(member); 
		HttpSession session = request.getSession();
		
		if(result>=0) session.setAttribute("member", member);
		
		if(member!=null) model.addAttribute("member", member);
		
		return "root.index";
	}
	
	@GetMapping("/validid")
	public String validId(@RequestParam("MId") @Nullable String MId, Model model) {
		
		
		boolean result = memberService.validId(MId); 
		if(result) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 2);
		}
		model.addAttribute("preset", MId);
		
		return "join.joinPage";
	}
	
}
