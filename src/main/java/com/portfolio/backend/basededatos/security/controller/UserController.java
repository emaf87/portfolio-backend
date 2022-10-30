package com.portfolio.backend.basededatos.security.controller;

import com.portfolio.backend.basededatos.security.model.Rol;
import com.portfolio.backend.basededatos.security.model.Usuario;
import com.portfolio.backend.basededatos.security.repository.RolRepository;
import com.portfolio.backend.basededatos.security.service.IUserService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    @ResponseBody
    public List<Usuario> getUsers() {
        return iUserService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Usuario findUser(@PathVariable int id) {
        return iUserService.findUser(id);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Usuario user) {
        if (iUserService.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        else {
            Usuario nuevoUser = new Usuario();
            nuevoUser.setEmail(user.getEmail());
            nuevoUser.setPassword(passwordEncoder.encode(user.getPassword()));
            
            Rol roles = rolRepository.findByNombre("ROLE_ADMIN").get();
            nuevoUser.setRoles(Collections.singleton(roles));
            
            iUserService.saveUser(nuevoUser);
            return new ResponseEntity<>("El usuario fue registrado", HttpStatus.OK);

        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        iUserService.deleteUser(id);
        return "Usuario eliminado";
    }

    @PutMapping
    public Usuario editUser(@RequestBody Usuario us) {
        Usuario nuevoUser = iUserService.findUser(us.getId());

        nuevoUser.setEmail(us.getEmail());
        nuevoUser.setPassword(us.getPassword());

        iUserService.saveUser(nuevoUser);

        return nuevoUser;
    }
    /*
    @PostMapping("/login")
    public boolean loginUser(@RequestBody Usuario us) {

        try {
            Optional<Usuario> userDB = iUserService.findByEmail(us.getEmail());

            if (userDB.getEmail().equals(us.getEmail()) && userDB.getPassword().equals(us.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return false;
    }*/

}
