package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudClientServiceFakeImpl implements ICrudClientService {

    @Autowired
    FakeData trash;

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Client delete(String id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return trash.getClients();
    }
}
