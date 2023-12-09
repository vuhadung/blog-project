package com.codepresso.codepressoblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.codepresso.codepressoblog.vo.Post;

@Mapper
public interface PostMapper {
	List<Post> findAll();

	List<Post> findByPage(@Param("limit") Integer limit, @Param("offset") Integer offset);
	
	Post findOne(@Param("id") Integer id);
	
	Integer save(@Param("post") Post post);
	
	Integer update(@Param("post") Post post);
}
