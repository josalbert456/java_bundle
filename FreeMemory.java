import java.util.*;
class MemTaker{
	int i = 0;
	String TAG = getClass().getName();
	public String toString(){
		return TAG;
	}
}
public class FreeMemory{
	public static void main(String[] args){
		System.out.println((Runtime.getRuntime()).freeMemory());
		ArrayList<MemTaker> a = new ArrayList<MemTaker>();
		for(int i=0; i<10000; i++){
			a.add(new MemTaker());
		}
		System.out.println((Runtime.getRuntime()).freeMemory());
		/*try{
						MemTaker mt = new MemTaker();
						Thread.sleep(1000);				
				}catch(InterruptedException ie){

				}	
		for(int i=0; i<10000; i++){
			System.out.println(a.get(i));
		}*/
	}
}