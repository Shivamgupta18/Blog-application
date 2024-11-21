package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Blog;
import com.blog.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepo;
	public Blog createBlog(Blog blog) {
		return blogRepo.save(blog);
		
	}
	
	public List<Blog> getAllBlog(){
		return blogRepo.findAll();
	}
	
	public Blog getBlogBYId(int id) {
		return blogRepo.findById(id).orElseThrow(()->new RuntimeException("Blog is not found "));
	}
	
	
	public Blog editBlog(Blog blog ,int id) {
		blog.setId(id);
		return blogRepo.save(blog);
	}
	
	public void deleteBLog(int id) {
		blogRepo.deleteById(id);
	}
}
