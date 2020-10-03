package com.rkp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.rkp.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

}
