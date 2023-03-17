package net.softsociety.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.blog.domain.Member;

@Mapper
public interface MemberDAO {
	/*
	 * 회원가입
	 */
	public int registerMember(Member member);
	/*
	 * 회원목록
	 */
	public List<Member> getMemberlist();
	/*
	 * ID 중복검사
	 */
	public Member checkMemberid(String blogid);
}
