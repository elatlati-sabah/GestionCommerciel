package com.pfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
