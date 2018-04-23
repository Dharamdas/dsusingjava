package methodoverloading;

import java.io.FileNotFoundException;

/*private method can be overloaded
return type does not matter
final method can be overloaded
static method can be overloaded
exception can be thrown from over loaded method 
*/
public class MethodOverLoading {
	
	public static void main(String[] args) {

	}
	
	protected void m1(){
		System.out.println("M1()");
	} 

	protected int m1(int a)throws NullPointerException
	{
		System.out.println("M1()");
		return 0;
	} 
	

	protected void m1(int a,int b)throws FileNotFoundException
	{
		System.out.println("M1()");
	} 

	
}
