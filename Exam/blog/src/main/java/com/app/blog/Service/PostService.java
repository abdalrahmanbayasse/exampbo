package com.app.blog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.Service.PostService;
import com.app.blog.repo.PostRepo;
import com.app.blog.entity.Post;

import java.util.List;

@Service
public class PostService {
  @Autowired
  private PostRepo postRepo;

  public Post save(Post post) {
    return postRepo.save(post);
  }

  public Post findById(Long id) {
    return postRepo.findById(id).orElse(null);
  }

  public List<Post> findAll() {
    return postRepo.findAll();
  }

  public void deleteById(Long id) {
    postRepo.deleteById(id);
  }
}
