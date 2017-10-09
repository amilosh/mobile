package by.it.milosh.repository;

import by.it.milosh.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("FROM Role WHERE roleName=:roleName")
    Role getRoleByRoleName(@Param("roleName")String roleName);

}
