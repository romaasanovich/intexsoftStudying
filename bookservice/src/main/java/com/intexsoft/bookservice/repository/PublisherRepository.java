package com.intexsoft.bookservice.repository;

import com.intexsoft.bookservice.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query(value = "SELECT * FROM mydb.publisher where publisher.UUID = ?1", nativeQuery = true)
    Publisher findByUUID(String UUID);

    @Modifying
    @Query(value = "INSERT INTO `mydb`.`publisher` (`UUID`, `name`) VALUES (?1,?2);", nativeQuery = true)
    void create(String UUID, String name);

    @Modifying
    @Query(value = "UPDATE `mydb`.`publisher` SET `UUID`=?1, `name`=?2 WHERE `id`=?3", nativeQuery = true)
    void update(String UUID, String name, String id);

}
