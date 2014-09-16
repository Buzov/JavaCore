package JavaArray;

import java.util.ArrayList;

public class JavaStringArray {

	public static void main(String[] args) {
		String[] names ={"dsgsdfh", "sd vsd"};
	    String[] values ={"dfs xdfs d", "sisd nas"};
	    

	    ArrayList<String[]> allArrays = new ArrayList<String[]>();      
	    allArrays.add(names);
	    allArrays.add(values);
	    ArrayList<Object[]> allArrays2 = new ArrayList<Object[]>(); 
	    allArrays2.add(names);
	    allArrays2.add(values);
	    
	    
	    

	    for (String a[]:allArrays){
	        for (String b:a){
	            System.out.println(b);
	        }
	    }
	}

}
