package org.example.springdata.repository;

import jakarta.transaction.Transactional;
import org.example.springdata.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM Account where name = :name and bill = :bill;")
    Account findAccountBy(@Param("name") String name, @Param("bill") Integer bill);
//    Account findAccountByNameAndBill(@Param("name") String name, @Param("bill") Integer bill);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Account set name = ?2 where id = ?1;")
    int setNameFor(Long id, String name);
}
