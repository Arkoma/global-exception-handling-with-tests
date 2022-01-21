package com.globalexceptionhandlerwithtests.demo.service;

import com.globalexceptionhandlerwithtests.demo.entity.Employee;
import com.globalexceptionhandlerwithtests.demo.entity.Name;
import com.globalexceptionhandlerwithtests.demo.exception.EmptyInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService underTest;

    @Test
    void addEmployeeReturnsExpectedEmployee() {
        Employee expected = new Employee(1L, new Name("Aaron", "Burk"));
        final Employee result = underTest.addEmployee(expected);
        assertAll(
            () -> assertNotSame(expected, result),
            () -> assertEquals(expected.getId(), result.getId()),
            () -> assertEquals(expected.getName().getFirstName(), result.getName().getFirstName()),
            () -> assertEquals(expected.getName().getLastName(), result.getName().getLastName())
        );
    }

    @Test
    void addEmployeeWithNoFirstNameThrowsEmptyInputException() {
        Employee badEmployee = new Employee(1L, new Name("", "Burk"));
        EmptyInputException exception = assertThrows(EmptyInputException.class, () -> underTest.addEmployee(badEmployee));
        final String expectedMessage = "first name is missing";
        final String actualMessage = exception.getErrorMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}