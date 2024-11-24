package com.coldlight.controller;

import com.coldlight.model.Comment;
import com.coldlight.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getAllUsers() {
        return commentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment getUserById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment createUser(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Comment updateUser(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        return commentService.save(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        commentService.delete(comment);
    }
}
