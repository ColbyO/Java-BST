package com.bst.controllers;

import com.bst.models.BinarySearchTree;
import com.bst.models.Bst;
import com.bst.repositories.BstRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BSTController {

    BstRepository repo;

    @GetMapping("/")
    public String showForm(Model model) {
        Bst bst = new Bst();
        model.addAttribute("bst", bst);
        return "form";
    }

    @PostMapping("/result")
    public String getData(@ModelAttribute Bst bst, Model model) {
        // if no input redirect to home page to avoid error.
        if (bst.getNumbers() == "") {
            return "redirect:/";
        }
        // change to String then separate by commas then convert to int.
        BinarySearchTree bstree = new BinarySearchTree();
        String[] res = bst.getNumbers().replace(" ", "").split("[,]", 0);
        for(String myStr: res){
           int number = Integer.parseInt(myStr);
            bstree.insert(number);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        String json = gson.toJson(bstree);
        bst.setNumbers(bst.getNumbers().replace(" ", ""));
        bst.setData(json);
        model.addAttribute("bst", bst);

        return "result";
    }

    @PostMapping("/log")
    public String createLog(@ModelAttribute("bst") Bst bst) {
        repo.save(bst);
        return "result";
    }
}