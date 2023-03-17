package net.softsociety.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.blog.dao.BlogDAO;
import net.softsociety.blog.domain.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	BlogDAO dao;
	
	@Override
	public List<Blog> getBlogList(String blogid) {
		List<Blog> bloglist = dao.getBlogList(blogid); 
		return bloglist;
	}

	@Override
	public int writeBlog(Blog blog) {
		int write = dao.writeBlog(blog);
		return write;
	}

	@Override
	public Blog getBlogDetail(int blogseq) {
		Blog listdetail = dao.getReadBlog(blogseq);
		return listdetail;
	}

	@Override
	public int removeBlog(int boardid) {
		int removeBlog = dao.removeBlog(boardid);
		return removeBlog;
	}

	@Override
	public int updateBlog(Blog blog) {
		int update = dao.updateBlog(blog);
		return update;
	}

	@Override
	public int increaseRecommend(int blogseq) {
		int recommend = dao.increaseRecommend(blogseq);
		return recommend;
	}

	@Override
	public int getRecommendCount(int blogseq) {
		int recommend = dao.getRecommendCount(blogseq);
		return recommend;
	}
	
	
	
}
