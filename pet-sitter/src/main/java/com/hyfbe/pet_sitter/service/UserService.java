package com.hyfbe.pet_sitter.service;

import com.hyfbe.pet_sitter.dto.customer.CustomerCompleteResponseDTO;
import com.hyfbe.pet_sitter.dto.user.LoginResponseDTO;
import com.hyfbe.pet_sitter.dto.user.UserRequestDTO;
import com.hyfbe.pet_sitter.dto.customer.CustomerRequestDTO;
import com.hyfbe.pet_sitter.dto.user.UserResponseDTO;
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
import com.hyfbe.pet_sitter.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserService {
    private final UserRepository repo;
    private final CustomerRepository crepo;
    private final EmployeeRepository erepo;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    // GET
    @Transactional(readOnly = true)
    public List<UserResponseDTO> getAllUsers(){
        List<User> users = repo.findAll();
        return users.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    // Check if an employee has a row.
    public boolean employeeExist(Long id){
        return repo.existsByEmployeeId(id);
    }

    // POST
    @Transactional
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
    // ON REGISTER A NEW CUSTOMER IS CREATED.
    public UserResponseDTO addUser(CustomerRequestDTO customerDTO ){
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

        return mapper.toResponseDTO(saved);
    }

    // LOGIN
    public LoginResponseDTO login(String email, String pwd){
        User user = repo.findByName(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));
        log.warn("pwd received: [{}]", pwd);
        log.warn("hash for 123: {}", encoder.encode("123"));
        log.warn("hash in db:   [{}]", user.getPassword());
        log.warn("matches: {}", encoder.matches(pwd, user.getPassword()));
        if (!encoder.matches(pwd, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        Map<String, Object> claims = Map.of(
                "userId", user.getId(),
                "role", user.getRole().name()
        );

        String token = jwtUtils.generateToken(user.getName(), claims);
        return new LoginResponseDTO(token);
    }



}
