package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.DAO.RoleDAO;
import web.DAO.UserDAO;
import web.model.Role;
import web.model.User;

import java.util.*;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDAO.findByEmail(email);
    }

    @Override
    public void createUser(User user) {
        userDAO.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public void updateUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    public Optional<User> getUserById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void createRoles(Set<Role> roles) {
        roleDAO.saveAll(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleDAO.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }
}
