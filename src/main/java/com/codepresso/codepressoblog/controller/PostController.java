package com.codepresso.codepressoblog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.codepressoblog.controller.dto.PostRequestDto;
import com.codepresso.codepressoblog.controller.dto.PostResponseDto;
import com.codepresso.codepressoblog.service.PostService;
import com.codepresso.codepressoblog.vo.Post;

@RestController
public class PostController {
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/post")
	public List<PostResponseDto> getPostList(@RequestParam Integer page) {
		List<Post> postList = postService.getPostByPage(page, 3);
		List<PostResponseDto> result = new ArrayList<>();
		for (Post p : postList) {
			result.add(new PostResponseDto(p));
		}
		return result;
	}
	
	@PostMapping("/post") 
	public String createPost(@RequestBody PostRequestDto postDto) {
		Post p = postDto.getPost();
		postService.savePost(p);
		
		/**
		 * This will return String "success" 
		 * because class is annotated with @RestController 
		 * so everything will be exchange as JSON string
		 * 
		 * If the class is annotated with @Controller
		 * then it will return page named "success" in src/main/resources
		 * */
		
		return "success";
	}
	
	@PutMapping("/post") 
	public String updatePost(@RequestBody PostRequestDto postDto) {
		Post p = postDto.getPost();
		postService.updatePost(p);
		return "success";
	}
}
