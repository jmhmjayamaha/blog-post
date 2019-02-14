package com.hksoft.springbootonetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hksoft.springbootonetomany.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
