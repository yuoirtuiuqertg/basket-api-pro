package com.example.baskett.service;

import com.example.baskett.model.Basket;
import com.example.baskett.model.Client;
import com.example.baskett.repositorie.ClientRepositorie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class ClientService {
    private final ClientRepositorie clientRepositorie;

    public void saveClient(Client client) {
        log.info("Saving ne {}",client);
        clientRepositorie.save(client);

    }


    public Client getClientByAuntification(String auntification){
        List<Client> client =  clientRepositorie.findByAuntification(auntification);
        Client client1= new Client();
        for (int i = 0; i<client.size(); i++){
            client1.setAuntification(client.get(i).getAuntification());
            client1.setId(client.get(i).getId());
        }
        return client1;
    }

    public void deleteClient(String auntification) {
        clientRepositorie.deleteById(getClientByAuntification(auntification).getId());
    }
    public void deleteID(Long id) {
        //Client client = (Client) clientRepositorie.findByAuntification(auntification);
        clientRepositorie.deleteById(id);
    }

}
