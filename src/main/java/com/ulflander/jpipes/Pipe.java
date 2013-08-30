
package com.ulflander.jpipes;

/**
 * A Pipe is a simple abstract class that implements basic methods.
 *
 * If not set, name of a pipeline is the name of the concrete pipeline class.
 *
 * @author Xavier Laumonier <xlaumonier@gmail.com>
 */
public class Pipe implements Pipable {


    private String name = null ;

	/**
	 * Executes the process
	 *
	 * @see Pipable
	 * @param data
	 */
	@Override
	public void process(PipeStream data)
	{
		// ...
	}

	/**
	 * Set the name of the pipeline.
	 *
	 * Useful for debugging and logging.
	 *
	 * @param name Name of the pipeline
	 */
	public void setName ( String name )
	{
		this.name = name ;
	}

	/**
	 * Get the name of the pipeline.
	 *
	 * @return The name of the pipeline
	 */
	public String getName ()
	{
		if ( name == null )
		{
			return this.getClass().getSimpleName() ;
		}
		
		return name ;
	}
}
