package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.ClientCreateDTO;
import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public void createClient(ClientCreateDTO clientDTO) {

    }

    public ClientCreateDTO updatePartialClient(Long id, ClientCreateDTO clientDTO) {
        return null;
    }

    private boolean validation(ClientCreateDTO clientDTO) {
         return true;
    }
}