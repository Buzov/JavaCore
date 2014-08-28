package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaList {
	public static void main(String[] args)
	{
			List<String> list = new ArrayList<String>();
		    list.add("Mama");
		    list.add("Mila");
		    list.add("Ramu");
		    
		    Iterator<String> iterator = list.iterator();
		    
		    while (iterator.hasNext())
		    {
		        String text = iterator.next();
		        
		        System.out.println(text);
		     }  
	}

}
