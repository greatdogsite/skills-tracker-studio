package com.mango.skillstrackerstudio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.*;

@Controller
public class SkillsController {

    private static List<String> languages = new ArrayList<>(Arrays.asList("Java","Python","Javascript"));

    @GetMapping()  //
    public String indexHandler(Model model){
        model.addAttribute("languages", languages);
        return "index";
    }

    @GetMapping("form")
    public String renderForm() { //Post to index
        return "form";
    }
    @PostMapping("index")
    public String acceptForm(Model model, @RequestParam("firstName") String firstName, @RequestParam("first") String first, @RequestParam("second") String second, @RequestParam("third") String third) {
        languages.clear();
        languages.add(0,first);
        languages.add(1,second);
        languages.add(2,third);
        model.addAttribute("languages", languages);
        model.addAttribute("firstName", firstName);
        return "index";
    }
}
