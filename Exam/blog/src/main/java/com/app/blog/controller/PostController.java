package com.app.blog.controller;

import com.app.blog.entity.Post;
import com.app.blog.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping
  public String showPostList(Model model) {
    List<Post> posts = postService.findAll();
    model.addAttribute("posts", posts);
    return "posts";
  }

  @GetMapping("/add")
  public String showPostForm(Post post) {
    return "post-add";
  }

  @GetMapping("/edit/{id}")
  public String shwoEditForm(@PathVariable("id") Long id, Model model) {
    Post post = postService.findById(id);
    model.addAttribute("post", post);
    return "post-edit";
  }

  @PostMapping("/add")
  public String createPost(@RequestParam("title") String title, @RequestParam("content") String content) {
    Post post = new Post(title, content);
    postService.save(post);
    return "redirect:/posts";
  }

  @PostMapping("/edit/{id}")
  public String updatePost(@PathVariable("id") Long id, @RequestParam("title") String title,
      @RequestParam("content") String content) {
    Post post = postService.findById(id);
    post.setTitle(title);
    post.setContent(content);
    postService.save(post);
    return "redirect:/posts";
  }

  @GetMapping("/delete/{id}")
  public String deletePost(@PathVariable("id") Long id) {
    postService.deleteById(id);
    return "redirect:/posts";
  }

}
