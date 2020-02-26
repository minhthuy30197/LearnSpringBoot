package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    // Khi được gắn @Query, thì tên của method không còn tác dụng nữa
    // JPQL
    @Query("select u from User u where u.email = ?1")
    public User myCustomQuery(String email);

    // Native SQL
    @Query(value = "select * from user u where u.email = ?1", nativeQuery = true)
    public User myCustomQuery2(String email);

    @Query(value = "SELECT * FROM user u WHERE u.name = :name", nativeQuery = true)
    public User findUserByName(@Param("name") String name);
}
