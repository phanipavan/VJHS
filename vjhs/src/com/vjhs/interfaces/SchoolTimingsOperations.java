/**
 * 
 */
package com.vjhs.interfaces;

import com.vjhs.pojo.SchoolTimings;

/**
 * @author wasimakram.sutar
 *
 */
public interface SchoolTimingsOperations {

	boolean addSchoolTimings(SchoolTimings schoolTimings);
	boolean updateSchoolTimings(SchoolTimings schoolTimings);
	SchoolTimings getSchoolTimings();
}
