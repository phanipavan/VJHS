/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.Class_Strength;

/**
 * @author wasimakram.sutar
 *
 */
public interface ClassStrengthOperations {

	boolean addClassStrength(Class_Strength class_Strength);

	boolean updateClassStrength(Class_Strength class_Strength);

	Class_Strength getClassStrength(String class_name);
	
	List<Class_Strength> getClassStrengthList();
}
