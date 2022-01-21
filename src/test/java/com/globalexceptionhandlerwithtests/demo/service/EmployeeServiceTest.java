package com.globalexceptionhandlerwithtests.demo.service;

import com.globalexceptionhandlerwithtests.demo.entity.Employee;
import com.globalexceptionhandlerwithtests.demo.entity.Name;
import com.globalexceptionhandlerwithtests.demo.exception.EmptyInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService underTest;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addEmployeeReturnsExpectedEmployee() {
        Employee expected = new Employee(1L, new Name("Aaron", "Burk"));
        final Employee result = underTest.addEmployee(expected);
        assertNotSame(expected, result);
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getName().getFirstName(), result.getName().getFirstName());
        assertEquals(expected.getName().getLastName(), result.getName().getLastName());
    }

    @Test(expected = EmptyInputException.class)
    public void addEmployeeWithNoFirstNameThrowsEmptyInputException() {
        Employee badEmployee = new Employee(1L, new Name("", "Burk"));
        underTest.addEmployee(badEmployee);
    }

    @Test
    public void addEmployeeWithNoFirstNameThrowsEmptyInputExceptionWithProperMessage() {
        Employee badEmployee = new Employee(1L, new Name("", "Burk"));
        exception.expect(EmptyInputException.class);
        exception.expectMessage("first name is missing");
        underTest.addEmployee(badEmployee);
    }

}