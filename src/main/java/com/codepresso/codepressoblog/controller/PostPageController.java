package com.codepresso.codepressoblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codepresso.codepressoblog.service.PostService;

@Controller
public class PostPageController {
	private PostService postService;
	
	public PostPageController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/post/{id}")
	public String getPostDetailPage(Model model, @PathVariable Integer id) {
		model.addAttribute("post", postService.getPostById(id));
		return "post_detail";
	}
	
	@GetMapping("/post/create")
	public String getPostCreatePage() {
		return "post_write";
	}
	
	@GetMapping("/post/create-new")
	@ResponseBody
	public String getPostCreateNewPage() {
		
		/**
		 * If the method is annotated with @ResponseBody
		 * it will return a String rather than HTML page
		 * */
		
		return "post_write";
	}
	
	@RequestMapping("/post/edit/{id}")
	public String getPostCreatePage(Model model, @PathVariable Integer id) {
		model.addAttribute("post", postService.getPostById(id));
		return "post_edit";
	}

}
