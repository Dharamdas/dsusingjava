package immutableclass;

import java.util.HashMap;


public class ImmutableTest {

	public static void main(String[] args) {
		
		    Integer localId=new Integer(1); //local
	        String localName=new String("ankit"); //local
	        HashMap<Integer, String> localMap = new HashMap<Integer,String>(); //local
	        localMap.put(11, "audi");
	      
	        EmployeeImmutable immutableClass = new EmployeeImmutable(localId, localName, localMap);
	        
	        System.out.println("----Display ImmutableClass members before changing----");
	        System.out.println(immutableClass.getName());  // "ankit"
	        System.out.println(immutableClass.getId());        // 1
	        System.out.println(immutableClass.getMap());   //{11=audi}
	        
	        
	      //Comparing ImmutableClass members with local before changing
	        System.out.println(localName==immutableClass.getName());  //true
	        System.out.println(localId==immutableClass.getId());      //true
	        System.out.println(localMap == immutableClass.getMap());  //false
	        
	      //change local
	        localId = new Integer(2);
	        localName = new String("mittal");
	        localMap.put(12, "ferarri");
	        
	        System.out.println("\n----Display ImmutableClass members after changing----");
	        System.out.println(immutableClass.getName());  // "ankit"
	        System.out.println(immutableClass.getId());        // 1
	        System.out.println(immutableClass.getMap());   //{11=audi}
	 
	        //Comparing ImmutableClass members with local after changing
	        System.out.println(localName==immutableClass.getName());  //false
	        System.out.println(localId==immutableClass.getId());      //false
	        System.out.println(localMap == immutableClass.getMap());  //false
	        
	}

}
