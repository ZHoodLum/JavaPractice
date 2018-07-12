/*
 * Created Tue Aug 28 18:29:30 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the 'worklog' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Worklog
    extends AbstractWorklog
    implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5909626655474305129L;

	/**
     * Simple constructor of Worklog instances.
     */
    public Worklog()
    {
    }

    /**
     * Constructor of Worklog instances given a simple primary key.
     * @param id
     */
    public Worklog(java.lang.Integer id)
    {
        super(id);
    }

    /* Add customized code below */

}
