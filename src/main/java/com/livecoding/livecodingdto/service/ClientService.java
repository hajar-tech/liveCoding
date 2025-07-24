package com.livecoding.livecodingdto.service;

import com.livecoding.livecodingdto.dto.RequestClient;
import com.livecoding.livecodingdto.model.Client;
import com.livecoding.livecodingdto.repository.ClientRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService (ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }
    public Client createClient (RequestClient dto){

        Client client = new Client();

        client.setNom(dto.getNom());
        return clientRepo.save(client);

    }
}
