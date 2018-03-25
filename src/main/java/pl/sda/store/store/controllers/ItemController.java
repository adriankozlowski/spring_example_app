package pl.sda.store.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.store.store.model.Item;

@Controller
public class ItemController {

    @GetMapping("/additem")
    public String addItemForm(ModelMap map){
        map.addAttribute("item", new Item());
        return "additem";
    }

    @PostMapping("/additem")
    public String addItem(@ModelAttribute Item item) {

        return "layout";
    }
}
