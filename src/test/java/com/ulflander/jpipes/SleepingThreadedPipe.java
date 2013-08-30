
package com.ulflander.jpipes;

import java.util.Random;

public class SleepingThreadedPipe extends Pipe {

	@Override
	public void process(PipeStream data) {

		((PipeTestStream) data).data += "1" ;
        Random randomGenerator = new Random();
        try {
            Thread.sleep((long) randomGenerator.nextInt(2) * 1000);
        } catch(Exception e) {}

	}
}
