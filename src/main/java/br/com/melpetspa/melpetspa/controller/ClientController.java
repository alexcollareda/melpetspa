package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.ClientCreateDTO;
import br.com.melpetspa.melpetspa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void createClient(@RequestBody ClientCreateDTO clientDTO){
        clientService.createClient(clientDTO);
    }

    @PatchMapping("/{id}")
    public ClientCreateDTO updatePartialUser(@PathVariable Long id, @RequestBody ClientCreateDTO clientDTO) {
        return clientService.updatePartialClient(id, clientDTO); // Seu serviço para atualização parcial
    }
}
