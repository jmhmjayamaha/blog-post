package lk.hjsoft.springbootmanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.hjsoft.springbootmanytomany.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
