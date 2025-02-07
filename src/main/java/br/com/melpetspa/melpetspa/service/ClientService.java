package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.ClientCreateDTO;
import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.repository.ClientRepository;
import br.com.melpetspa.melpetspa.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public void createClient(ClientCreateDTO clientDTO) {
        if(!validation(clientDTO)){
            return;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setCpf(clientDTO.getCpf());
        clientEntity.setName(clientDTO.getName());
        clientEntity.setPhone(clientDTO.getPhone());
        clientEntity.setEmail(clientDTO.getEmail());

        clientEntity = clientRepository.save(clientEntity);

    }

    public ClientCreateDTO updatePartialClient(Long id, ClientCreateDTO clientDTO) {
        return null;
    }

    private boolean validation(ClientCreateDTO clientDTO) {
        if (!Utils.isCpfValid(clientDTO.getCpf())) {
            return false;
        }

        if (!Utils.isValidEmail(clientDTO.getEmail())) {
            return false;
        }
         return true;
    }
}