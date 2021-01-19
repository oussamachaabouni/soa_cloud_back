package com.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.Model.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {

}
