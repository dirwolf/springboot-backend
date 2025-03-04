package net.javaguides.springboot.controller;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController{

    @Autowired
    private EmployeeRepository emprepo;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return emprepo.findAll();
    }

//    build create employee  POST  api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return emprepo.save(employee);
    }
//build get employee by id GET api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Employee emp = emprepo.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not exist with id : " + id));

        return ResponseEntity.ok(emp);
    }
//    build UPDATE api

    @PutMapping("{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable long id,@RequestBody Employee empDetails){

//        lets fetch it first
        Employee emp = emprepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee does not exist with is: " + id));

        emp.setFirstName(empDetails.getFirstName());
        emp.setLastName(empDetails.getLastName());
        emp.setEmailId(empDetails.getEmailId());

        Employee updatedEmployee = emprepo.save(emp);

        return ResponseEntity.ok(updatedEmployee);
    }
//    build DELETE employee api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable long id){
    Employee emp = emprepo.findById(id).orElseThrow(
            ()->new ResourceNotFoundException("Employee does not exist with id : "+id)
    );
    emprepo.delete(emp);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
