package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.Repository.ItemRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrudItemMongoImpl implements ICrudItem {

    @Autowired
    FakeData trash;

    @Autowired
    ItemRepository repository;

    private List<Item> list = new ArrayList<>();

   @PostConstruct  // не будет добавлять больше чем нужно..
    void init() {
        list = trash.getItems();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Item create(Item item) {
        item.setId(item.getId());
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        repository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }
}
/*
mongodb+srv://alexrith:<password>@cluster0.6sjdx.mongodb.net/test*/


//    MongoClientURI uri = new MongoClientURI(
//            "mongodb+srv://alexrith:<password>@cluster0.6sjdx.mongodb.net/<dbname>?retryWrites=true&w=majority");
//
//    MongoClient mongoClient = new MongoClient(uri);
//    MongoDatabase database = mongoClient.getDatabase("test");
