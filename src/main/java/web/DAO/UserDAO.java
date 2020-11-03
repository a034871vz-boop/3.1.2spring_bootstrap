package web.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
}

