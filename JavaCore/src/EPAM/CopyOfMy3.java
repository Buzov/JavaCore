package EPAM;

public class CopyOfMy3 {

	public static void main(String[] args) {
		A x = new B();
		B y = new C();
		y.a();
		

	}
	
	public static class A{
		 A(){System.out.println("A"); a();}
		public void a() {System.out.println("A.a");}
	}
	
	public static class B extends A{
		
		public void a() {System.out.println("B.a");}
		public void b() {System.out.println("B.b");}
	}
	public static class C extends B{
		C(){System.out.println("C");}
		public void a() {System.out.println("C.a");}
		public void b() {System.out.println("C.b");}
		public void c() {System.out.println("C.c");}
	}

}
