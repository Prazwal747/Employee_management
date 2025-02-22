package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.HTTPmodel.ResponseModel;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.model.Employee;
import net.javaguides.ems.service.EmployeeService;
import net.javaguides.ems.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

    private EmployeeService employeeService; //DI with constructor injection

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseModel<EmployeeDto>> createEmployee(@RequestBody EmployeeDto employeeDto){
        if(employeeDto==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseModel<EmployeeDto>(400,"Recieved Empty Object",null));
        }
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(new ResponseModel<EmployeeDto>(200,"Success",savedEmployee));
    }
}

    
