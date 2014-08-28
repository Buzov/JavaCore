package JavaException;

public class Exception2 {

	public static void main(String[] args) {
		String[] s = new String[3];
		
		try{
			System.out.println(s[5]);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println(ex);
		}

	}

}
