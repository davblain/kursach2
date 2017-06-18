package com.example.demo.web.controllers;

import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.Entities.AuthorsEntity;
import com.example.demo.business.service.service.ArtsService;
import com.example.demo.business.service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by davblain on 02.06.2017.
 */
@RestController
public class AuthorsController {

    @Autowired
    private AuthorService authorService;





    @RequestMapping("/service/authors/page/{id}")
    @ResponseBody
    List<AuthorsEntity> authorPage(@PathVariable int id)
    {
        PagedListHolder<AuthorsEntity> pageHolder = new PagedListHolder<AuthorsEntity>(authorService.list());
        pageHolder.setPageSize(16);
        pageHolder.setPage(id);
        return  pageHolder.getSource();
    }
    @RequestMapping("/service/authors/search/{name}/page/{id}")
    @ResponseBody
    List<AuthorsEntity> authorPageSearch(@PathVariable String name,@PathVariable int id)
    {
        PagedListHolder<AuthorsEntity> pageHolder = new PagedListHolder<AuthorsEntity>(authorService.searchByName(name));
        pageHolder.setPageSize(16);
        pageHolder.setPage(id);
        return  pageHolder.getSource();
    }


    @RequestMapping("/service/authors/search/{name}")
    @ResponseBody
    List<AuthorsEntity> authorSearch(@PathVariable String name)
    {

        return  authorService.searchByName(name);

    }


    @RequestMapping("/service/authors")
    @ResponseBody
    List<AuthorsEntity> authorList(@RequestParam(required = false) String search)
    {
        if (search==null)
            return  authorService.list();
        return (authorService.searchByName(search));
    }

    @RequestMapping("/service/authors/{id}")
    @ResponseBody
    AuthorsEntity author(@PathVariable int id)
    {
        AuthorsEntity author = authorService.find(id);
        return  author;
    }
}
