package com.dks.apilojavirtual.resource;

import com.dks.apilojavirtual.domain.Client;
import com.dks.apilojavirtual.service.ClientService;
import org.hibernate.loader.plan.spi.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listClient(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.list());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        clientService.create(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(uri).body(client);
    }

}
