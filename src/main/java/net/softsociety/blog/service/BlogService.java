package net.softsociety.blog.service;

import java.util.List;

import net.softsociety.blog.domain.Blog;

public interface BlogService {
	
	public List<Blog> getBlogList(String blogid);

	public int writeBlog(Blog blog);

	public Blog getBlogDetail(int blogseq);

	public int removeBlog(int boardid);

	public int updateBlog(Blog blog);

	public int increaseRecommend(int blogseq);

	public int getRecommendCount(int blogseq);
	
}
