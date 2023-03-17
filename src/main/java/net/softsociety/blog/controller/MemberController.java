package net.softsociety.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.blog.domain.Member;
import net.softsociety.blog.service.MemberService;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(Member member) {
		log.info("회원정보 : {}", member.toString());
		int result = service.registerMember(member);
		if (result == 1) {
			log.info("회원가입 성공");
		} else {
			log.info("회원가입 실패");
		}
		return "redirect:/";
	}
	
	@GetMapping("/member/enter")
	public String enter() {
		return "/member/enter";
	}
	
	@GetMapping("/member/memberlist")
	public String memberlist(Model model) {
		List<Member> memberlist = service.getMemberlist();
		log.info("회원정보 : {}", memberlist);
		model.addAttribute("memberlist", memberlist);
		return "/member/memberlist";
	}
	
	@GetMapping("/member/idCheck")
	@ResponseBody
	public boolean idCheck(String blogid) {
		log.info("아이디 : {} ", blogid);
		Member userid = service.checkMemberid(blogid);
		log.info("아이디 : {}", userid);
		if (userid == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
