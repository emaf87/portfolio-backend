package com.portfolio.backend.basededatos.security.service;

import com.portfolio.backend.basededatos.security.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<Usuario> getUsers();

    public void saveUser(Usuario user);

    public void deleteUser(int id);

    public Usuario findUser(int id);

    public Optional<Usuario> findByEmail(String email);

    public Boolean existsByEmail(String email);

}
