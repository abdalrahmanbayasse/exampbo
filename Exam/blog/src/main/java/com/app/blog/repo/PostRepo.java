package com.app.blog.repo;

import com.app.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;;


public interface PostRepo extends JpaRepository<Post, Long> {
  
}
