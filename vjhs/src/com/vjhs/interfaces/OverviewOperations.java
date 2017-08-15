/**
 * 
 */
package com.vjhs.interfaces;

import com.vjhs.pojo.Overview;

/**
 * @author AMMA & NANNA
 *
 */
public interface OverviewOperations {

	boolean addOverview(Overview overview);

	boolean updateOverview(Overview overview);
	
	Overview getOverview();
}
