package com.rkp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rkp.pma.entities.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	List<Employee> findAll();
}
