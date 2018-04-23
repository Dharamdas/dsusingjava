package searching;

public class BinarySearch {

	public static void main(String[] args) {
			
		recursiveBinarySearch();
		
		}
	
  public static void binarySearch()
  {
		int arr[]={10,20,21,23,41,43,67,90,101,201};
		int low=0,up=arr.length-1,ele=23;
		boolean flag=false;
		for(int mid=(low+up)/2;low<=up;mid=(low+up)/2)
		{
			if(arr[mid]==ele)
			{
				flag=true;
				break;
			}
			if(ele<arr[mid])
				up=mid-1;
			if(ele>arr[mid])
				low=mid+1;
		}
		if(flag)
		System.out.println(ele+" Element is Fount");
		else
			System.out.println(ele+" Element is not Fount");

  }
  
  public static void recursiveBinarySearch()
  {
	  int arr[]={10,20,21,23,41,43,67,90,101,201};
		int low=0,up=arr.length-1,ele=23;
		
		search(arr,low,up,ele);
  }
  public static void search(int arr[], int low,int up,int key)
  {
	  int mid =(low+up)/2;
	  if(arr[mid]==key)
	  {  System.out.println(key+ " element is fount at "+mid);
		  return ;
	  }
	  if(low>up)
		  return ;
	  if(key<arr[mid])
	  {
		  up = mid-1;
		 search(arr,low,up,key);
	  }
	  if(key>arr[mid])
	  {
		  low = mid+1;
		   search(arr,low,up,key);
	  }
	  return;
  }
}
