package com.helloworld.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.helloworld.app.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
