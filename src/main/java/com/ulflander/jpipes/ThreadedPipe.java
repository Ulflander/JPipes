
package com.ulflander.jpipes;

public class ThreadedPipe extends Pipe implements Runnable {

	protected PipeStream data = null ;

	public void in ( PipeStream data )
	{
		this.data = data ;
	}

	@Override
	public void process(PipeStream data)
	{
		// ...
	}


	@Override
	public void run ()
	{
		if ( data != null )
		{
			this.process(data);
		}
	}

	public PipeStream out ()
	{
		return data ;
	}
}
