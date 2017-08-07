package by.it.milosh.repository;

import by.it.milosh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User WHERE username=:username")
    User findUserByUsername(@Param("username") String username);

}
