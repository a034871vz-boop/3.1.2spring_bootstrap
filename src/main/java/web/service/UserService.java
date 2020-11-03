package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;
import web.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();

    void createUser(User user);
    Iterable<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    Optional<User> getUserById(Long id);
}
