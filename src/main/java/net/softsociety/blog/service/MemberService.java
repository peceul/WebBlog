package net.softsociety.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.softsociety.blog.domain.Member;

@Service
public interface MemberService {
	/*
	 * 회원 가입
	 */
	public int registerMember(Member member);
	/*
	 * 멤버 목록
	 */
	public List<Member> getMemberlist();
	/*
	 * 멤버 아이디 중복 검사
	 */
	public Member checkMemberid(String blogid);
	
}
