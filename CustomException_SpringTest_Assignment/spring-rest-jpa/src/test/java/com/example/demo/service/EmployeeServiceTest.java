package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Employee;
@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	EmployeeService service;
	@Test
	public void testService() {
		
        Optional<Employee> result = service.findEmpById(77);
        assertTrue(result.isPresent());
	}
    @Test
    void shouldThrowExceptionWhenNotFound() {

    	ResponseStatusException exception = assertThrows(ResponseStatusException.class,() -> service.findEmpById(-1));

        assertEquals("Invalid Employee id", exception.getReason());
        assertEquals(204, exception.getStatusCode().value());
    }
}
