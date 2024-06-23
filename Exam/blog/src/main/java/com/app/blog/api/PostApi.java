package com.app.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.blog.entity.Post;
import com.app.blog.Service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostApi {

  @Autowired
  private PostService postService;

  @GetMapping
  public List<Post> findAll() {
    return postService.findAll();
  }

  @GetMapping("/dummy")
  public void dummy() {
    Post post = new Post("New Book", "This is content");
    postService.save(post);
  }

  @RequestMapping(value = "/save", method = RequestMethod.GET)
  @ResponseBody
  public String save(@RequestParam("title") String title, @RequestParam("content") String content) {
    Post post = new Post(title, content);
    postService.save(post);
    return "Saved Post with title: " + title;
  }

}
