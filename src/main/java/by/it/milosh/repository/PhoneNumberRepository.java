package by.it.milosh.repository;


import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @Query("FROM PhoneNumber WHERE used!=true ")
    List<PhoneNumber> findAllUnusedNumbers();

}
