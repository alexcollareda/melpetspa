package br.com.melpetspa.melpetspa.service;

import br.com.melpetspa.melpetspa.dto.User;
import br.com.melpetspa.melpetspa.entity.ClientEntity;
import br.com.melpetspa.melpetspa.entity.UserEntity;
import br.com.melpetspa.melpetspa.repository.ClientRepository;
import br.com.melpetspa.melpetspa.repository.UserRepository;
import br.com.melpetspa.melpetspa.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    public User authenticateUser(String username, String password) {
        UserEntity userEntity = userRepository.findByEmail(username);;

        if (userEntity != null){
            if(password.equals(userEntity.getPassword())){
                User user = new User();
                user.setUsername(username);
                user.setAccessType("user");
                return user;
            }else{
                throw new RuntimeException("Senha inválida");
            }
        }else{
            throw new RuntimeException("Usuário não existente");
        }
    }


    public User authenticateClient(String username, String password) {
            ClientEntity client = null;

            if (Utils.isCpfValid(username)){
                client = clientRepository.findByCpf(username);
            }else{
                client = clientRepository.findByPhone(username);
            }

            if (client != null){
                if(password.equals(client.getPassword())){
                    User user = new User();
                    user.setUsername(username);
                    user.setAccessType("client");
                    return user;
                }else{
                    throw new RuntimeException("Senha inválida");
                }
            }else{
                throw new RuntimeException("Usuário não existente");
            }
    }
}
