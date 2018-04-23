package immutableclass;

import java.util.HashMap;


public final class EmployeeImmutable{
	private final Integer id; //Immutable member variable
    private final String name; //Immutable member variable
    private final HashMap<Integer,String> map; //mutable member variable
    
    public EmployeeImmutable(Integer id, String name, HashMap<Integer,String> map){
        this.id=id;
        this.name=name;
       
        //assign all mutable member variable using new keyword.
        this.map=new HashMap<Integer, String>(map);
    }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<Integer, String> getMap() {
		return (HashMap<Integer, String>) map.clone();
	}
    
    
}
