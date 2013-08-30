
package com.ulflander.jpipes;

import com.ulflander.jpipes.Pipable;
import com.ulflander.jpipes.Pipe;

public class SimplePipeTestPipe extends Pipe {

	@Override
	public void process (PipeStream data) {

		((PipeTestStream) data).data += "0" ;

	}



}
