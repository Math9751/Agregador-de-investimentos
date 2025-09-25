package tech.math.agregadorinvestimentos.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.math.agregadorinvestimentos.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
