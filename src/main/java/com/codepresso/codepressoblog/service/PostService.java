package com.codepresso.codepressoblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codepresso.codepressoblog.mapper.PostMapper;
import com.codepresso.codepressoblog.vo.Post;

@Service
public class PostService {
	private PostMapper postMapper;

	public PostService(PostMapper mapper) {
		this.postMapper = mapper;
	}

	public List<Post> getAllPost() {
		return postMapper.findAll();
	}

	public List<Post> getPostByPage(Integer page, Integer size) {
		return postMapper.findByPage(size, (page - 1) * size);
	}
	
	public Post getPostById(Integer id) {
		return postMapper.findOne(id);
	}
	
	public boolean savePost(Post post) {
		return postMapper.save(post) == 1;
	}
	
	public boolean updatePost(Post post) {
		return postMapper.update(post) == 1;
	}
}
