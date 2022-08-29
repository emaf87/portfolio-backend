
package com.portfolio.backend.basededatos.security.service;

import com.portfolio.backend.basededatos.security.model.User;
import java.util.List;
import java.util.Optional;


public interface IUserService{
    
    public List<User> getUsers();
    
    public void saveUser(User user);
    
    public void deleteUser(int id);
    
    public User findUser(int id);
    
    public User findByEmail(String email);

}
