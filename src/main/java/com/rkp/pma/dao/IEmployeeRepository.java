package com.rkp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rkp.pma.dto.IEmployeeProject;
import com.rkp.pma.entities.Employee;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	List<Employee> findAll();

	@Query(nativeQuery=true, value="SELECT e.first_name AS firstName, e.last_name AS lastName , COUNT(pe.employee_id) AS projectCount FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id GROUP BY e.first_name, e.last_name ORDER BY 3 DESC") 
	public List<IEmployeeProject> employeeProjects();
}
