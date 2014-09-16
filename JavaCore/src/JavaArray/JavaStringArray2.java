package JavaArray;

/*Необходимо предложить алгоритм вывода
всех чисел, которые деляться на 3, из 
массива неограниченной вложенности*/

public class JavaStringArray2 {

	public static void main(String[] args) {
		Object[] n1 ={3, 6};//Object-массив из чисел
		Object[] n2 ={9, 12, 15, 18};//Object-массив из чисел
	    Integer[] n3 ={28, 39, 70, 95, 50};//Integer-массив
	    
	    Object[] n5 = {n1, 39, n2, 95, n1};//Object-массив из чисел и массивов
	    Object[] n4 ={n1, n5, 60, n2, n3, n1, 50, 90};//Object-массив из чисел и массивов
	    
	    printNumber(n4);//
	    
	    
	   
	}
	
	
	
	public static void printNumber(Object[] mass)
	{
		for(Object a:mass)//проходим по элементам одномерного массива
		{
	    	if(a instanceof Integer && (Integer) a%3==0) 
	    		//если элемент является числом и делиться на 3, то выводимего
	    		System.out.println(a);
	    	if(a instanceof Object[]) 
	    		//если элемент Object-массив, то вызываем рекурсивно функцию
	    		printNumber((Object[])a);
	    	
	    }
	}

}

