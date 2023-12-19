package com.nd705.suppointspb.dao;

import com.nd705.suppointspb.entity.blog.Category;
import com.nd705.suppointspb.entity.blog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategoryId(Long categoryId);
}
