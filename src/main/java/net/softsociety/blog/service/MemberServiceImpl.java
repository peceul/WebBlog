package net.softsociety.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.blog.dao.MemberDAO;
import net.softsociety.blog.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO dao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int registerMember(Member member) { //회원가입
		String encodedPassword = passwordEncoder.encode(member.getBlogpwd());
		member.setBlogpwd(encodedPassword);
		int result = dao.registerMember(member);
		return result;
	}

	@Override
	public List<Member> getMemberlist() {
		List<Member> member = dao.getMemberlist();
		return member;
	}

	@Override
	public Member checkMemberid(String blogid) {
		Member checkMemberid = dao.checkMemberid(blogid);
		return checkMemberid;
	}
}
