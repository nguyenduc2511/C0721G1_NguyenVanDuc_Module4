package com.example.demo.controllers;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.service.IBlogService;
import com.example.demo.model.service.ICategogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blog/api")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = this.iBlogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/pages/{page}")
    public ResponseEntity<Page<Blog>> findAll(@PathVariable("page") int page) {
        Page<Blog> blogs = this.iBlogService.findAll(PageRequest.of(page, 2));
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable("id") int id) {
        Optional<Blog> currentBlog = this.iBlogService.findById(id);

        if (currentBlog.isPresent()) {
            return new ResponseEntity<>(currentBlog.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
