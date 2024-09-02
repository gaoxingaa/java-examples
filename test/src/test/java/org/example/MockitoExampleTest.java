package org.example;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class MockitoExampleTest {
    @InjectMocks
    MockitoExample example = new MockitoExample();

    @Mock
    private Example hello;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(example);

    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetString() {
        assertEquals(example.getHello(), hello);
    }
}