package web.DAO;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import web.model.Role;

import java.util.Set;

public interface RoleDAO extends CrudRepository<Role, Long> {

}
