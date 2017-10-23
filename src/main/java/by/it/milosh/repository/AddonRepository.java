package by.it.milosh.repository;

import by.it.milosh.model.Addon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddonRepository extends JpaRepository<Addon, Long> {

    @Query(value = "select * from addon where addon.addon_id in (select user_addons.addon_id from user_addons where user_addons.user_id=?1)", nativeQuery = true)
    List<Addon> getAddonsByUserId(Long userId);

    @Query(value = "select * from addon where addon.addon_id not in (select user_addons.addon_id from user_addons where user_addons.user_id=?1)", nativeQuery = true)
    List<Addon> getAddonsNotUsedByUserId(Long userId);

}
