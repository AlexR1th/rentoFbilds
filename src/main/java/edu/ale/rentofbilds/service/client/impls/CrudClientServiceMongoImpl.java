package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.Repository.ClientRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrudClientServiceMongoImpl implements ICrudClientService {

    @Autowired
    FakeData trash;

    @Autowired
    ClientRepository repository;

    private List<Client> list = new ArrayList<>();

    //    @Override
//    public Client create(Client client) {
//        client.setCreated_at(LocalDateTime.now());
//        client.setModified_at(LocalDateTime.now());
//        return repository.save(client);
//    }

//    @PostConstruct
    void init() {
        repository.deleteAll();
        list = trash.getClients();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Client create(Client client) {
        client.setId(client.getId());
//        client.setName(client.getName());
//        client.setAdress(client.getAdress());
//        client.setPhone(client.getPhone());
//        client.setDateOfBirthday(client.getDateOfBirthday());
//        client.setDescription(client.getDescription());
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
//        client.setId(client.getId());
//        client.setName(client.getName());
//        client.setAdress(client.getAdress());
//        client.setPhone(client.getPhone());
//        client.setDateOfBirthday(client.getDateOfBirthday());
//        client.setDescription(client.getDescription());
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        repository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
