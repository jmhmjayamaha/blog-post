package com.hksoft.springbootonetomany.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.hksoft.springbootonetomany.model.Comment;

public interface CommentService {

	Page<Comment> getAllComments(Long postId, Pageable pageable);
	Comment createComment(Long postId, Comment comment);
	Comment updateComment(Long postId, Long commentId, Comment commentUpdate);
	ResponseEntity<?> deleteComment(Long postId, Long commentId);
	
}
