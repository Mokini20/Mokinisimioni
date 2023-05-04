package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.Mkwama;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface Mkwamarepository extends JpaRepository<Mkwama,Long> {
    //All crud method for database
}
