package net.softsociety.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.blog.domain.Blog;

@Mapper
public interface BlogDAO {
	
	public List<Blog> getBlogList(String blogid);

	public int writeBlog(Blog blog);

	public Blog getReadBlog(int blogseq);

	public int removeBlog(int boardid);

	public int updateBlog(Blog blog);

	public int increaseRecommend(int blogseq);

	public int getRecommendCount(int blogseq);
	
}
