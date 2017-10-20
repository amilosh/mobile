package by.it.milosh.repository;

import by.it.milosh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE username=:username")
    User findUserByUsername(@Param("username") String username);

    @Query("select count(u) FROM User u")
    Long numberOfUsers();

    @Query(value = "select * from user where user.user_id in (select user_roles.user_id from user_roles where user_roles.role_id=?1)", nativeQuery = true)
    List<User> findUsersByRoleId(int roleId);

    @Query(value = "select * from user where user.user_id in (select user_roles.user_id from user_roles where user_roles.role_id in (select role.role_id from role where role.role_name=?1))", nativeQuery = true)
    List<User> findUsersByRoleName(String roleNme);

}
