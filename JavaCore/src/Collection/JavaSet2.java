package Collection;

import java.util.HashSet;
import java.util.Set;

public class JavaSet2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
	    set.add("Mama");
	    set.add("Mila");
	    set.add("Ramu");
	    
	    for (String text : set)
	    {
	        System.out.println(text);
	    }   

	}

}
