package com.ds.queue.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ds.queue.MyQueue;
import com.ds.queue.NoElementFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MyQueueTest {

	static MyQueue queue = null;
	
	@BeforeAll
    static void initAll() {
		queue = new MyQueue();
	}

    @BeforeEach
    void init() {
    	queue = new MyQueue();
    }

    
    @Test
    void testPushTwoElements() {
		try {
			queue.enqueue(1);
			assertEquals(queue.dequeue(),1);
			
			queue.enqueue(2);
			assertEquals(queue.dequeue(),2);
			
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    void testPushMultipleElements() {
    	try {
    		queue.enqueue(1);
    		queue.enqueue(2);
    		queue.enqueue(3);
    		queue.enqueue(4);
			
			assertEquals(queue.dequeue(),1);
			assertEquals(queue.dequeue(),2);
			assertEquals(queue.dequeue(),3);
			assertEquals(queue.dequeue(),4);	
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    void testPushSingleElement() {
    	try {
    		queue.enqueue(1);
			assertEquals(queue.dequeue(),1);		
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    	
    }

    
    @Test
    void testExceptionWhenNoElementPresent() {
    	Throwable exception = assertThrows(NoElementFoundException.class, () -> {
    		queue.dequeue();
        });
        assertEquals(new NoElementFoundException().getClass(), exception.getClass());
    }
    
    
    @Test
    void testExceptionWhenAllElementsArePopped() {
    	queue.enqueue(1);
    	queue.enqueue(2);
    	
    	try {
    		queue.dequeue();
    		queue.dequeue();
		} catch (NoElementFoundException e) {
			e.printStackTrace();
		}
    	
    	Throwable exception = assertThrows(NoElementFoundException.class, () -> {
    		queue.dequeue();
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
