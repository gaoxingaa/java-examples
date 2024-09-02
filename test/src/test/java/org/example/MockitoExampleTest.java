package org.example;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class MockitoExampleTest {
    @InjectMocks
    MockitoExample example;

    @Mock
    private Example hello;

    @BeforeClass
    public void setUp() {
        System.out.println("setUp");

        MockitoAnnotations.openMocks(this);

    }

    @AfterClass
    public void tearDown() {
        System.out.println("tearDown");

    }


    @BeforeMethod
    public void setUpMethod() {
        System.out.println("setUpMethod");

        when(hello.getName()).thenReturn("Jane");

    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("tearDownMethod");

        Mockito.reset(hello);
    }

    @Test
    public void testGetString() {
        assertEquals(example.getName(), "Jane");
    }

    @Test
    public void testGetStringAgain() {
        when(hello.getName()).thenReturn("Again");
        assertEquals(example.getName(), "Again");
    }

}