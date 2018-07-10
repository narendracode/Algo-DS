package com.ds.stack.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ds.stack.MyStack;
import com.ds.stack.NoElementFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyStackTest {
	static MyStack stack = null;
		
	@BeforeAll
    static void initAll() {
		stack = new MyStack();
	}

    @BeforeEach
    void init() {
    	stack = new MyStack();
    }

    
    @Test
    void testPushTwoElements() {
		try {
			stack.push(1);
			assertEquals(stack.pop(),1);
			
			stack.push(2);
			assertEquals(stack.pop(),2);
			
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    void testPushMultipleElements() {
    	try {
	    	stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			
			assertEquals(stack.pop(),4);
			assertEquals(stack.pop(),3);
			assertEquals(stack.pop(),2);
			assertEquals(stack.pop(),1);	
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    void testPushSingleElement() {
    	try {
    		stack.push(1);
			assertEquals(stack.pop(),1);		
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    	
    }

    
    @Test
    void testExceptionWhenNoElementPresent() {
    	Throwable exception = assertThrows(NoElementFoundException.class, () -> {
    		stack.pop();
        });
        assertEquals(new NoElementFoundException().getClass(), exception.getClass());
    }
    
    
    @Test
    void testExceptionWhenAllElementsArePopped() {
    	stack.push(1);
    	stack.push(2);
    	
    	try {
			stack.pop();
			stack.pop();
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    	
    	Throwable exception = assertThrows(NoElementFoundException.class, () -> {
    		stack.pop();
        });
        assertEquals(new NoElementFoundException().getClass(), exception.getClass());
    }
    
    
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
