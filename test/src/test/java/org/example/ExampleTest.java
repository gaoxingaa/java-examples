package org.example;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleTest {

    @Mock
    private String hello;

    @InjectMocks
    private Example example;

    @BeforeMethod
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        assertEquals(example.getName(), hello);
    }
}
