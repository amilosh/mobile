package by.it.milosh.repository;

import by.it.milosh.model.Addon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRepository extends JpaRepository<Addon, Long> {
}
