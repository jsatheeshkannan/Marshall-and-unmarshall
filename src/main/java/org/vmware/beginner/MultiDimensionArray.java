package org.vmware.beginner;

public class MultiDimensionArray {
	
	public void multiArray(){
		System.out.println("Single dimision Array");
		String[] name=new String[]{"satheesh","kannan"};
		System.out.println(name[0]);
		System.out.println(name[1]);
		
		System.out.println("Multi dimision Array");
		String[][] dept=new String[][]{{"satheesh","kannan"},
			{"yogesh","kannan"}
		};
		
		System.out.println(dept[1][0]);

	
	}

}
