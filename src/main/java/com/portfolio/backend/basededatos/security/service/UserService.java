
package com.portfolio.backend.basededatos.security.service;

import com.portfolio.backend.basededatos.security.model.Usuario;
import com.portfolio.backend.basededatos.security.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Usuario> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(Usuario user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Usuario findUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean existsByEmail(String email) {
       return userRepository.existsByEmail(email);
    }
    
}
