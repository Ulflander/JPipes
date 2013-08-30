package com.ulflander.jpipes;

import java.util.ArrayList;

public class Pipeline {

	ArrayList<Pipable> pipes = new ArrayList<Pipable>();
	
	String name;

	int index = -1 ;

	int size = 0 ;

	public Pipeline() {
		this.name = "";
	}

	public Pipeline(String name) {
		this.name = name;
	}

	public void add(Pipable pipe) {

		if ( pipe != null )
		{
			size ++ ;

			pipes.add( pipe ) ;
		}
	}

	public void remove(Pipable pipe) {

		if ( pipe != null && pipes.contains(pipe)	)
		{
			size -- ;

			pipes.remove( pipe ) ;
		}
	}

	public Pipable next ()
	{
		if ( index + 1 < size )
		{
			index ++ ;

			return pipes.get(index) ;
		}

		this.reset () ;

		return null ;
	}

	public Boolean hasNext ()
	{
		if ( index + 1 < size )
		{
			return true ;
		}

		return false ;
	}

	public void reset ()
	{
		index = -1 ;
	}

	public Boolean isNextThreaded ()
	{
		if ( index + 1 < size && ThreadedPipe.class.isInstance( pipes.get( index + 1 ) ) )
		{
			return true ;
		}

		return false ;
	}

	public Boolean process(PipeStream data)
	{

		while ( hasNext () )
		{
			if ( isNextThreaded() )
			{
				ArrayList<ThreadedPipe> pipes = new ArrayList<ThreadedPipe> () ;

				pipes.add ( (ThreadedPipe) this.next () ) ;

				while ( isNextThreaded() )
				{
					pipes.add ( (ThreadedPipe) this.next () ) ;
				}

				try {
					processThreadedPipes ( pipes , data ) ;
				} catch ( InterruptedException e )
				{
					this.reset () ;

					return false ;
				}
				
			} else {
				this.next().process(data) ;
			}
		}

		this.reset () ;

		return true ;
	}

	private void processThreadedPipes ( ArrayList<ThreadedPipe> pipes , PipeStream data ) throws InterruptedException
	{
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for ( ThreadedPipe pipe : pipes )
		{
			pipe.in(data);

			Thread t = new Thread( pipe );

			t.setName( pipe.getClass().getSimpleName() );

			t.start();

			threads.add(t);
		}

		for (Thread t : threads) {
			t.join();
		}
	}
}
