package com.portfolio.backend.basededatos.security.controller;

import com.portfolio.backend.basededatos.security.model.User;
import com.portfolio.backend.basededatos.security.service.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET,
    RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return iUserService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User findUser(@PathVariable int id) {
        return iUserService.findUser(id);
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        iUserService.saveUser(user);
        return "Usuario cargado";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        iUserService.deleteUser(id);
        return "Usuario eliminado";
    }

    @PutMapping
    public User editUser(@RequestBody User us) {
        User nuevoUser = iUserService.findUser(us.getId());

        nuevoUser.setEmail(us.getEmail());
        nuevoUser.setPassword(us.getPassword());

        iUserService.saveUser(nuevoUser);

        return nuevoUser;
    }

    @PostMapping("/login")
    public boolean loginUser(@RequestBody User us) {

        try {
            User userDB = iUserService.findByEmail(us.getEmail());

            if (userDB.getEmail().equals(us.getEmail()) && userDB.getPassword().equals(us.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return false;
    }

}
