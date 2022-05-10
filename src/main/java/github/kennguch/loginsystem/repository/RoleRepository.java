package github.kennguch.loginsystem.repository;

import github.kennguch.loginsystem.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}