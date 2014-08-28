package Collection;

import java.util.HashMap;
import java.util.Map;

public class JavaMap2 {
	public static void main(String[] args)
	{
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("first", "Mama");
	    map.put("second", "Mila");
	    map.put("third", "Ramu");
	    
	    for (Map.Entry<String, String> pair : map.entrySet())
	    {
	        String key = pair.getKey();
	        String value = pair.getValue();
	        System.out.println(key + ":" + value);
	    } 
	}
}
