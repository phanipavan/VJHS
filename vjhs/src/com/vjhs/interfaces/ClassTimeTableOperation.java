/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.ClassTimeTable;

/**
 * @author wasimakram.sutar
 *
 */
public interface ClassTimeTableOperation {

	boolean addClassTimeTable(List<ClassTimeTable> clsTTList);

	boolean updateClassTimeTable(ClassTimeTable classTimeTable);

	List<ClassTimeTable> getClassTimeTable(String className);

	boolean isClassAvail(String cls, String day);
}
