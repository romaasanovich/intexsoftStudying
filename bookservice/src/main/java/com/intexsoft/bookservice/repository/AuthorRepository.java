package com.intexsoft.bookservice.repository;

import com.intexsoft.bookservice.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT * FROM mydb.author where author.UUID = ?1", nativeQuery = true)
    Author findByUUID(String UUID);

    @Modifying
    @Query(value = "INSERT INTO `mydb`.`author` (`UUID`, `name`, `bio`, `birthDay`) VALUES (?1, ?2, ?3,?4)", nativeQuery = true)
    void create(String UUID, String name, String bio, String birthDay);

    @Modifying
    @Query(value = "UPDATE `mydb`.`author` SET `UUID`=?1,`name`=?2, `bio`=?3 , `birthDay` =?4 where 'id' = ?5", nativeQuery = true)
    void update(String UUID, String name, String bio, String birthDay, String id);
}
