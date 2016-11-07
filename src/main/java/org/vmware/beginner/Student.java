package org.vmware.beginner;

import java.util.Collections;

public class Student implements Comparable{

	private String studentname;
	private int studentage;
	private int rollno;

	public Student(int rollno, String studentname, int studentage) {
		super(); //super() should there at first line of method
		this.studentname = studentname;
		this.studentage = studentage;
		this.rollno = rollno;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getStudentage() {
		return studentage;
	}

	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return "Student [studentname=" + studentname + ", studentage=" + studentage + ", rollno=" + rollno + "]";
	}



	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
