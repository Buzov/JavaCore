package Collection;

import java.util.ArrayList;
import java.util.List;

public class JavaList2 {
	public static void main(String[] args)
	{
			List<String> list = new ArrayList<String>();
		    list.add("Mama");
		    list.add("Mila");
		    list.add("Ramu");
		    
		    for (String text : list)
		    {
		        System.out.println(text);
		    }  
	}

}
