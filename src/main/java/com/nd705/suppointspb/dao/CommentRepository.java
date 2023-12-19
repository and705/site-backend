package com.nd705.suppointspb.dao;

import com.nd705.suppointspb.entity.blog.Category;
import com.nd705.suppointspb.entity.blog.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
