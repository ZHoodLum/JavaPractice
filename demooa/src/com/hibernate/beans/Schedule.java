/*
 * Created Tue Aug 28 18:29:29 CST 2007 by MyEclipse Hibernate Tool.
 */ 
package com.hibernate.beans;

import java.io.Serializable;

/**
 * A class that represents a row in the 'schedule' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Schedule
    extends AbstractSchedule
    implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2721706340682681504L;

	/**
     * Simple constructor of Schedule instances.
     */
    public Schedule()
    {
    }

    /**
     * Constructor of Schedule instances given a simple primary key.
     * @param id
     */
    public Schedule(java.lang.Integer id)
    {
        super(id);
    }

    /* Add customized code below */

}
