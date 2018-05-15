package com.intexsoft.bookservice.repository;

import com.intexsoft.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM mydb.book where book.UUID = ?1", nativeQuery = true)
    Book findByUUID(String UUID);

    @Modifying
    @Query(value = "INSERT INTO `mydb`.`book` (`UUID`, `name`, `description`, `publishDate`, `publisherId`, `price`) VALUES (?1,?2 ,?3 , ?4, ?5, ?6)", nativeQuery = true)
    void create(String UUID, String name, String description, String date, String publId, String price);

    @Modifying
    @Query(value = "UPDATE `mydb`.`book` SET `UUID`=?1, `name`=?2, `description`=?3, `publishDate`=?4, `publisherId`=?5, `price`=?6 WHERE `id`=?7", nativeQuery = true)
    void update(String UUID, String name, String description, String date, String publId, String price, String id);


}
