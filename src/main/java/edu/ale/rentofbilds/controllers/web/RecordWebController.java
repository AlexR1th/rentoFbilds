package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.form.ClientForm;
import edu.ale.rentofbilds.form.RecordForm;
import edu.ale.rentofbilds.form.SearchForm;
import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Gender;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.client.impls.CrudClientServiceMongoImpl;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/record")
public class RecordWebController {

    @Autowired
    ServiceRecordMongoImpl servise;

    @Autowired
    CrudClientServiceMongoImpl clientService;

    Build standart = new Build("1", "build1", LocalDateTime.now(), LocalDateTime.now());

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("records", servise.getAll());
//        SearchForm search = new SearchForm();
//        model.addAttribute("search", search);
        return "recordTable";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> clients = clientService.getAll()
                .stream().map(client -> client.getName())
                .collect(Collectors.toList());
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clients);

        return "recordAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm recordForm, Model model) {
        Record record = new Record();
        record.setName(recordForm.getName());
        record.setDescription(recordForm.getDescription());

        String startAsString = recordForm.getStart();
        LocalDate startAsDate = LocalDate.parse(startAsString);
        LocalDateTime startAsDateTime = startAsDate.atTime(0, 0, 0);
        record.setStart(startAsDateTime);

        record.setFinish(LocalDate.parse(recordForm.getFinish()).atTime(0,0,0));
        String clientName = recordForm.getClient();
        Client client = clientService.getByName(clientName).get(0);
        record.setClient(client);
        record.setBuild(standart);
//        record.setClient(record.getClient());
//        record.setBuild(record.getBuild());
        servise.create(record);
        return "redirect:/web/record/all";
    }


}
