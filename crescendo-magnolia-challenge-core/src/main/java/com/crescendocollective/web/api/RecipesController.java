package com.crescendocollective.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RecipesController {

    @RequestMapping("/recipes")
    @ResponseBody
    public List<Object> handle() {
        // TODO: Gather recipes from JCR and return JSON representation
        return null;
    }

}
