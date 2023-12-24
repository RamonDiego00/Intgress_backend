package com.mondi.intgress.repository;

import com.mondi.intgress.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query("SELECT u FROM UserModel u WHERE u.email = :email")
    Optional<UserModel> findByEmail(@Param("email") String email);

}
