package me.jjh.refactoring.chapter08.ReplaceTypeCodeWithSubclasses.refactoring;

public class Engineer extends Employee_refactoring {

	@Override
	public int getType() {
		return Employee_refactoring.ENGINEER;
	}
	
}
