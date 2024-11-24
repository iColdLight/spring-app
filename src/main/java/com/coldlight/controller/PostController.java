package com.coldlight.controller;

import com.coldlight.model.Post;
import com.coldlight.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getAllUsers() {
        return postService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getUserById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Post createUser(@RequestBody Post post) {
        return postService.save(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Post updateUser(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return postService.save(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        Post post = postService.findById(id);
        postService.delete(post);
    }
}
