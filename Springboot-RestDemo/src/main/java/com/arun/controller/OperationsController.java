package com.arun.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arun.model.Address;
import com.arun.model.Department;
import com.arun.model.Employee;

@RestController
@RequestMapping("/emp-api")
public class OperationsController {

	@GetMapping("/getemp")
	public ResponseEntity<Employee> getEmployee()

	{
		
		  Employee e = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
		  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
		  List.of("java", "python"),
		  
		  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
		  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		 
		//Employee e=new Employee(2,"arun");
		
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping("/getemps")
	public ResponseEntity<List<Employee>> getEmployees()

	{
		
		  Employee e1 = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
		  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
		  List.of("java", "python"),
		  
		  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
		  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		  
		  Employee e2 = new Employee(10, "Arun", true, new Address("15", "bank", "kmm",
				  "tg"), new String[] { "kumar", "taakaam" }, Set.of("red", "blue"),
				  List.of("java", "python"),
				  
				  LocalDate.of(2000, 7, 1), List.of(Map.of("aadhar", 2345), Map.of("pan", "cwjpa34")),
				  List.of(new Department(12, "sales"), new Department(13, "marketing")));
		 
		  
		
		return new ResponseEntity<>(List.of(e1,e2),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Map<String,Object> e)
	{
		return new ResponseEntity<String>(e.toString(),HttpStatus.CREATED);
	}
	
	@PostMapping("/saveall")
	public ResponseEntity<String> saveAll(@RequestBody List<Employee> e)
	{
		return new ResponseEntity<String>(e.toString(),HttpStatus.CREATED);
	}
	
	
	  @PostMapping("/report") 
	  public String getReport(@RequestParam(value =
	  "eno",required=false,defaultValue="0") int no,@RequestParam String name) 
	  {
	  return no+" "+name; 
	  }
	  
	  @GetMapping("/report") 
	  public String getRepor(@RequestParam(value =
	  "eno",required=false,defaultValue="0") int no,@RequestParam String name)
	  {
	  return no+" "+name; 
	  }
	  
	  @PostMapping(value="/reportmap") 
	  public String getRepors(@RequestParam Map<String,Object> map)
	  {
	  return map.get("eno")+" "+map.get("name"); 
	  }
	  
	  
	  @GetMapping(value={"/report/{eno}/{name}","/report/{eno}"})
	  public String getvalues(@PathVariable(value="eno")String  no,@PathVariable(required = false) String name)
	  {
		  return no+" "+name;  
	  }
	  
	  
	  @GetMapping("/report/eno/name")
	  public String getreport1(@PathVariable(value="eno",required = false)String  no,@PathVariable(required = false) String name)
	  {
		  return "from 1-->"+no+" "+name;
	  }
	  
	  @GetMapping("/report/{eno}/name")
	  public String getreport2(@PathVariable(value="eno")String  no,@PathVariable(required = false) String name)
	  {
		  return "from 2-->"+no+" "+name;
	  }
	 
	  
	  @GetMapping("/report/eno/{name}")
	  public String getreport3(@PathVariable(value="eno",required = false)String  no,@PathVariable(required = false) String name)
	  {
		  return "from 3-->"+no+" "+name;
	  }
	 
	  
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
