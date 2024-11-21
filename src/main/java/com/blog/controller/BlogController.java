package com.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Blog;
import com.blog.service.BlogService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {
	
	@Autowired
	private BlogService blogService;

    @PostMapping("/create")
	public Blog addBlog(@RequestBody Blog blog)
	{
    	return blogService.createBlog(blog);
	}
    
    @GetMapping("all")
    public List<Blog> getAllBLogIn(){
    	return blogService.getAllBlog();
    }
    
    @GetMapping("/count/{id}")
    public Blog findByIdBlog(@PathVariable int id)
    {
    	return blogService.getBlogBYId(id);
    }
    
    @PutMapping("/edit/{id}")
    public Blog updateBLog(@RequestBody Blog blog,@PathVariable int id) {
    	return blogService.editBlog(blog, id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBlogBased(@PathVariable int id) {
    	
    	blogService.deleteBLog(id);
    	return "Deleted successfully";
    }
    
}
