package com.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rest.model.Address;
import com.rest.model.Employee;

public class DbService {
	
	Map objMap = new HashMap<Integer, Employee>();
	
	public DbService(){
		Address address1 = new Address("TESTSTREET", "TESTCITY", "TESTSTATE", "121121");
		Address address2 = new Address("TESTSTREET1", "TESTCITY1", "TESTSTATE1", "121122");
		Address address3 = new Address("TESTSTREET2", "TESTCITY2", "TESTSTATE2", "111121");
		
		Employee objEmp1 = new Employee(1, "TEST1", address1);
		Employee objEmp2 = new Employee(2, "TEST2", address2);
		Employee objEmp3 = new Employee(3, "TEST3", address3);
		
		objMap.put(1, objEmp1);
		objMap.put(2, objEmp2);
		objMap.put(3, objEmp3);
			
	}
	
	public List<Employee> getEmpData(){
		List objList = new ArrayList<Employee>(objMap.values());
		return objList;
	}
		
	public Employee getEmpById(int id){
		Employee objEmp = (Employee) objMap.get(id);
		return objEmp;
	}
	
	public List<Employee> delEmployee(int id){
		objMap.remove(id);
		System.out.println("Data removed" + objMap);
		List objList = new ArrayList<Employee>(objMap.values());
		return objList;
	}
	
	public Employee updateEmployee(int id){
		Employee objEmp = (Employee) objMap.get(id);
		objEmp.setName("TESTUPDATENAME");
		return objEmp;
	}
	
//	public Employee addEmployee(){
//		Employee objEmp = new Employee(id, name, address)
//	}

}
