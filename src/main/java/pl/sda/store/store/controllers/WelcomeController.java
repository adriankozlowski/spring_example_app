package pl.sda.store.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.store.store.services.ItemService;

@Controller
public class WelcomeController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("items", itemService.getList());
        return "layout";
    }
}
