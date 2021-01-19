package com.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.models.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Integer> {

}
