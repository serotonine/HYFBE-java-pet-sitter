package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.enums.Role;
import com.hyfbe.pet_sitter.exception.PetSitterEntityNotFoundException;
import com.hyfbe.pet_sitter.mapper.CustomerMapper;
import com.hyfbe.pet_sitter.mapper.UserMapper;
import com.hyfbe.pet_sitter.model.Customer;
import com.hyfbe.pet_sitter.model.Employee;
import com.hyfbe.pet_sitter.model.User;
import com.hyfbe.pet_sitter.repository.CustomerRepository;
import com.hyfbe.pet_sitter.repository.EmployeeRepository;
import com.hyfbe.pet_sitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repo;
    private final CustomerRepository crepo;
    private final EmployeeRepository erepo;
    private final UserMapper mapper;
    private final CustomerMapper cmapper;
    private final PasswordEncoder encoder;

    // GET
    public List<User> getAllUsers(){
        return repo.findAll();
    }
    // Check if an employee has a row.
    public boolean employeeExist(Long id){
        return repo.existsByEmployeeId(id);
    }

    //POST
    public User addUser(UserRequestDTO dto ){
        // User
        String password = encoder.encode(dto.getPassword());
        User user = new User(dto.getName(), password);
        Long customerId = dto.getCustomer();
        Long employeeId = dto.getEmployee();
        if(customerId !=null){
            Customer customer = crepo.findById(customerId).orElseThrow(()-> new PetSitterEntityNotFoundException("Customer",customerId));
            user.setCustomer(customer);
        }
        if(employeeId !=null){
            Employee employee = erepo.findById(employeeId).orElseThrow(()-> new PetSitterEntityNotFoundException("Employee",employeeId));
            user.setEmployee(employee);
            user.setRole(Role.valueOf("EMPLOYEE"));
        }
        // TODO in Employee & Customer user field = null;
        return repo.save(user);
    }

    public User addUser(CustomerRequestDTO customerDTO ){
        // User
        String password = encoder.encode(customerDTO.getPassword());
        User user = new User(customerDTO.getEmail(), password);
        // Customer
        Customer customer = new Customer(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setTel(customerDTO.getTel());
        customer.setAddress(customerDTO.getAddress());

        customer.setUser(user);
        user.setCustomer(customer);

        User saved = repo.save(user);

        return saved;
    }

}
