package com.virtusa.examserver.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.examserver.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
