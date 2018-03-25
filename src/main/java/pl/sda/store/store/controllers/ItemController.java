package pl.sda.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.store.store.model.Item;
import pl.sda.store.store.services.ItemService;

@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;

    @GetMapping("/additem")
    public String addItemForm(ModelMap map){
        map.addAttribute("item", new Item());
        return "additem";
    }

    @PostMapping("/additem")
    public String addItem(@ModelAttribute Item item) {
        itemService.addItem(item);
        return "redirect:/";
    }
}
