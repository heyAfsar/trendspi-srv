package com.crashtech.trendspisrv.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crashtech.trendspisrv.modal.ERole;
import com.crashtech.trendspisrv.modal.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

