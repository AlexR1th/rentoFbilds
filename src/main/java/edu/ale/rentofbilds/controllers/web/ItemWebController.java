package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
        // rest возращает JASON
    String getAll(Model model) {
        model.addAttribute("spisok", service.getAll());
        return "itemsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
     /*
//        System.out.println(" вы нажали Delete ");
//
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);*/
        return "redirect:/web/item/all";
        //crud CRUD -> create read update delete
    }


}
