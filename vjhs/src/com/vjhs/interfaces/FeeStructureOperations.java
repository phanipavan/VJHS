/**
 * 
 */
package com.vjhs.interfaces;

import java.util.List;

import com.vjhs.pojo.FeeStructure;

;

/**
 * @author AMMA & NANNA
 *
 */
public interface FeeStructureOperations {

	boolean addFeeStructure(FeeStructure feeStructure);

	boolean updateFeeStructure(FeeStructure feeStructure);

	FeeStructure getFeeStructure(String className);
	
	List<FeeStructure> getFeeStructureList();
}
