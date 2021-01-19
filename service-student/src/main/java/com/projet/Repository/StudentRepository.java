package com.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
