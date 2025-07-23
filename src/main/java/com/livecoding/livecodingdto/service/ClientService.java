package com.livecoding.livecodingdto.service;

import com.livecoding.livecodingdto.dto.ClientRequestDto;
import com.livecoding.livecodingdto.model.Client;
import com.livecoding.livecodingdto.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client createClient (ClientRequestDto dto){
        Client client = new Client();
        client.setNom(dto.getNom());

        return clientRepository.save(client);
    }
}
