
package com.ulflander.jpipes;

import org.junit.Test;
import static org.junit.Assert.*;

public class PipelinesTest {

	/**
	 *
	 * PipesTest adds "0" to PipeTestStream.data
	 * PipesTest adds "1" to PipeTestStream.data
	 *
	 */
    @Test
	public void testSimplePipes ()
	{
		PipeTestStream test = new PipeTestStream () ;

		Pipeline queue = new Pipeline() ;

		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());

		queue.process(test) ;

		assertEquals(
			"Should be 000",
			"000",
			test.data
		) ;
	}

    @Test
	public void testThreadedPipes ()
	{
		PipeTestStream test = new PipeTestStream () ;

		Pipeline queue = new Pipeline() ;

		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());

		queue.process(test) ;

		assertEquals(
			"Should be 111",
			"111",
			test.data
		) ;
	}

    @Test
	public void testSimpleAndThreadedPipes ()
	{
		PipeTestStream test = new PipeTestStream () ;

		Pipeline queue = new Pipeline() ;

		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());

		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());

		queue.process(test) ;

		assertEquals(
			"Should be 111000",
			"111000",
			test.data
		) ;
	}

    @Test
	public void testComplexPipes ()
	{
		PipeTestStream test = new PipeTestStream () ;

		Pipeline queue = new Pipeline() ;

		queue.add(new ThreadedPipeTestPipe());

		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());
		queue.add(new SimplePipeTestPipe());

		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());

		queue.add(new SimplePipeTestPipe());

		queue.add(new ThreadedPipeTestPipe());
		queue.add(new ThreadedPipeTestPipe());

		queue.add(new SimplePipeTestPipe());
		
		queue.process(test) ;

		assertEquals(
			"Should be 1000110110",
			"1000110110",
			test.data
		) ;

		test = new PipeTestStream () ;

		queue.process(test) ;

		assertEquals(
			"Should be 1000110110",
			"1000110110",
			test.data
		) ;

	}
    @Test
    public void testSleepingComplexPipes ()
    {
        PipeTestStream test = new PipeTestStream () ;

        Pipeline queue = new Pipeline() ;

        queue.add(new SleepingThreadedPipe());

        queue.add(new SimplePipeTestPipe());
        queue.add(new SimplePipeTestPipe());
        queue.add(new SimplePipeTestPipe());

        queue.add(new SleepingThreadedPipe());
        queue.add(new SleepingThreadedPipe());

        queue.add(new SimplePipeTestPipe());

        queue.add(new SleepingThreadedPipe());
        queue.add(new SleepingThreadedPipe());

        queue.add(new SimplePipeTestPipe());

        queue.process(test) ;

        assertEquals(
                "Should be 1000110110",
                "1000110110",
                test.data
        ) ;

        test = new PipeTestStream () ;

        queue.process(test) ;

        assertEquals(
                "Should be 1000110110",
                "1000110110",
                test.data
        ) ;

    }
}
