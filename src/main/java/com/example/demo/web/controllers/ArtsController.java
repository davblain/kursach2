package com.example.demo.web.controllers;


import com.example.demo.business.Entities.ArtsEntity;
import com.example.demo.business.Entities.AuthorsEntity;
import com.example.demo.business.service.service.ArtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by davblain on 23.05.2017.
 */
@RestController
public class ArtsController {
    @Autowired
    private ArtsService artsService;



    @RequestMapping("/service/arts/page/{id}")
    @ResponseBody
    List<ArtsEntity> artsPage(@PathVariable int id)
    {
        PagedListHolder<ArtsEntity> pageHolder = new PagedListHolder<ArtsEntity>(artsService.list());
        pageHolder.setPageSize(16);
        pageHolder.setPage(id);
        return  pageHolder.getSource();
    }

    @RequestMapping("/service/arts/search/{name}/page/{id}")
    @ResponseBody
    List<ArtsEntity> artsPageSearch(@PathVariable String name,@PathVariable int id)
    {
        PagedListHolder<ArtsEntity> pageHolder = new PagedListHolder<ArtsEntity>(artsService.searchByName(name));
        pageHolder.setPageSize(16);
        pageHolder.setPage(id);
        return  pageHolder.getSource();
    }
    @RequestMapping("/service/arts/search/{name}")
    @ResponseBody
    List<ArtsEntity> artsSearch(@PathVariable String name)
    {

        return  artsService.searchByName(name);

    }

    @RequestMapping("/service/arts")
    @ResponseBody List<ArtsEntity> artList(@RequestParam(required = false) String search)
    {
        if (search==null)
            return  artsService.list();
        return  artsService.searchByName(search);

    }
    @RequestMapping("/service/arts/{id}")
    @ResponseBody ArtsEntity art(@PathVariable int id)
    {
        ArtsEntity art = artsService.find(id);
        return  art;
    }




}
