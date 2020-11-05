package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.impls.CrudClientServiceFakeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/client")
public class ClientWebController {
    @Autowired
    CrudClientServiceFakeImpl service;


    @RequestMapping("/list")
    String getList(Model model) {
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        System.out.println(" Why are u delete me ?!");
        service.delete(id);
        return "redirect:/web/client/list";
    }
    @RequestMapping("/update/{id}")
    String editById(@PathVariable("id") String id){

        return null;
    }

}
