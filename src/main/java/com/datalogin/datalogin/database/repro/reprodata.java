package com.datalogin.datalogin.database.repro;

import com.datalogin.datalogin.database.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface reprodata extends JpaRepository<user,String> {


    @Query( nativeQuery = true , value = "SELECT * FROM user WHERE name = ?1 and pass=?2")
    List<user> login(String name, String pass);

    @Query( nativeQuery = true , value = "SELECT * FROM user WHERE name = ?1 and pass=?2")
    List<user> search(String id);


}
