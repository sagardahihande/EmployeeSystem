package com.example.demo.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmpService {
	
	 
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	
	public java.util.List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	
	public Employee getEmpById(int id)
	{
		java.util.Optional<Employee> e = repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}
}
