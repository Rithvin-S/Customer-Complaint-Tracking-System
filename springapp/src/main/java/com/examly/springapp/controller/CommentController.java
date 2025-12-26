
package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @GetMapping
    public ResponseEntity<Object> getAllComments() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCommentById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
