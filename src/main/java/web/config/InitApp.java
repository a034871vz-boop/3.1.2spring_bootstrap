package web.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.RoleDAO;
import web.DAO.UserDAO;
import web.model.Role;
import web.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitApp implements ApplicationListener<ContextRefreshedEvent> {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public InitApp(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role[] rolesArray = new Role[]{new Role("ADMIN"), new Role("USER")};
        Set<Role> rolesSet = new HashSet<>(Arrays.asList(rolesArray));
        roleDAO.saveAll(rolesSet);
        User admin = new User("admin", "admin", "35", "admin@mail.ru", "admin", rolesSet);
        userDAO.save(admin);
    }
}
