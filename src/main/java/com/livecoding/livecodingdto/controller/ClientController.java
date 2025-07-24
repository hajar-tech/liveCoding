package com.livecoding.livecodingdto.controller;

import com.livecoding.livecodingdto.dto.RequestClient;
import com.livecoding.livecodingdto.model.Client;
import com.livecoding.livecodingdto.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final  ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/creerClient")
    public ResponseEntity<Client> createClient (@RequestBody RequestClient dto){
        return ResponseEntity.ok(clientService.createClient(dto));
    }
}
