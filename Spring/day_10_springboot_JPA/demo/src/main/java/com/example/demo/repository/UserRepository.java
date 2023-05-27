package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // sử dụng method query
    Optional<User> findByEmail(String email);

    // Sử dụng JPQL query
    @Query("select u from  User  u where  u.email = ?1")
    Optional<User>findByEmailUsingJPQL(String email);

    @Query("select u from  User  u where  u.email = :email")
    Optional<User>findByEmailUsingJPQL1(@Param("email") String email);

    // Sử dụng native query
    @Query(nativeQuery = true, value = "select * from  User  u where  u.email = ?1")
    Optional<User>findByEmailUsingNativeQuery(String email);

//    List<User> findByName(String name);
//
//    List<User> findByNameContaining(String keyword);
}
