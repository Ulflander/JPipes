
package com.ulflander.jpipes;

import com.ulflander.jpipes.PipeStream;
import com.ulflander.jpipes.Pipe;

public class ThreadedPipeTestPipe extends Pipe {

	@Override
	public void process(PipeStream data) {

		((PipeTestStream) data).data += "1" ;

	}
}
