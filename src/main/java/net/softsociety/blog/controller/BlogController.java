package net.softsociety.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.service.BlogService;

@Slf4j
@Controller
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@GetMapping("/board")
	public String board(String blogid, Model model) {
		List<Blog> bloglist = service.getBlogList(blogid);
		model.addAttribute("blogid", blogid);
		model.addAttribute("bloglist", bloglist);
		log.info("블로그 ID : {}", blogid);
		return "/blog/board";
	}

	@GetMapping("/board/write")
	public String write() {
		return "/blog/write";
	}

	@PostMapping("/board/write")
	public String write(Blog blog, RedirectAttributes rttr, @AuthenticationPrincipal UserDetails user) {
		log.info("글 내용 : {}", blog);
		int write = service.writeBlog(blog);
		if (write == 1) {
			log.info("게시글 저장 성공");
		} else {
			log.info("게시글 저장 실패");
		}
		log.info("blogid : {}", user.getUsername());
		rttr.addAttribute("blogid", user.getUsername());
		return "redirect:/board";
	}
	
	@GetMapping("/board/read")
	public String read(int boardid, Model model) {
		Blog blogread = service.getBlogDetail(boardid);
		model.addAttribute("blogid",blogread.getBlogid());
		model.addAttribute("blogread", blogread);
		log.info("블로그 목록 : {}", blogread);
		return "/blog/read";
	}
	
	@GetMapping("/board/remove")
	public String remove(int boardid, RedirectAttributes rttr, @AuthenticationPrincipal UserDetails user) {
		int remove = service.removeBlog(boardid);
		if (remove == 1) {
			log.info("게시글 삭제 성공");
		} else {
			log.info("게시글 저장 실패");
		}
		rttr.addAttribute("blogid", user.getUsername());
		return "redirect:/board";
	}
	
	@GetMapping("/board/update")
	public String update(int boardid, Model model) {
		Blog blogread = service.getBlogDetail(boardid);
		model.addAttribute("blogid", blogread.getBlogid());
		model.addAttribute("blogread", blogread);
		log.info("블로그 목록 : {}", blogread);
		return "/blog/update";
	}
	
	@PostMapping("/board/update")
	public String update(Blog blog, RedirectAttributes rttr, @AuthenticationPrincipal UserDetails user) {
		log.info("글 내용 : {}", blog);
		int update = service.updateBlog(blog);
		if (update == 1) {
			log.info("게시글 수정 성공");
		} else {
			log.info("게시글 저장 실패");
		}
		rttr.addAttribute("boardid", blog.getBlogseq());
		return "redirect:/board/read";
	}
	
	@GetMapping("/board/recommend")
	@ResponseBody
	public int recommend(int blogseq) {
		log.info("blogseq : {}", blogseq);
		int recommend = service.increaseRecommend(blogseq);
		if (recommend == 1) {
			log.info("추천수가 증가됨");
		} else {
			log.info("추천수 수정 실패");
		}
		int recommendcount = service.getRecommendCount(blogseq);
		return recommendcount;
	}
	
}
