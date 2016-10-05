import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
interface GoodBase{
}
class Cup implements GoodBase{
}
class Shampoo implements GoodBase{
}
class Towel implements GoodBase{
}
class GoodsOutofMaxException extends Exception{
	@Override
	public String getMessage(){
		return "Goods out of MAX Exception";
	}
}

class Goods{
	private int MAX_REPOSITORY = 100;
	private Map<Class, Integer> goodCounter = new HashMap<Class, Integer>();
	private ArrayList<GoodBase> pack = new ArrayList<GoodBase>();

	public void add(GoodBase t) throws GoodsOutofMaxException{
		Class c = t.getClass();
		if(!goodCounter.containsKey(c)){
			goodCounter.put(c, 1);
		}else {
			if(goodCounter.get(c)==100)throw new GoodsOutofMaxException();
			goodCounter.put(c, goodCounter.get(c)+1);
		}
		pack.add(t);
	}
	public GoodBase get(int i){
		return pack.get(i);
	}
	public int count(Class c){
		return goodCounter.containsKey(c)?goodCounter.get(c):0;
	}
	public int getPackRemainSpace(Class c){
		int currentGoodsCounter = count(c);
		return MAX_REPOSITORY - currentGoodsCounter;
	}

}

public class ReflectTest{
	public static void main(String[] args){
		Goods goods = new Goods();
		for(int i=0; i<10; i++){
			try{
				goods.add(new Cup());
			}catch(GoodsOutofMaxException gome){

			}
		}

		for(int i=0; i<200; i++){
			try{
				goods.add(new Towel());
			}catch(GoodsOutofMaxException gome){
				System.out.println(gome.getMessage());
				break;
			}
		}
		for(int i=0; i<60; i++){
			try{
				goods.add(new Shampoo());
			}catch(GoodsOutofMaxException gome){
				System.out.println(gome.getMessage());
				break;
			}
		}
		System.out.println(goods.count(Towel.class));
		System.out.println(goods.count(Cup.class));
		System.out.println(goods.count(Shampoo.class));
		System.out.println(goods.getPackRemainSpace(Towel.class));
		System.out.println(goods.getPackRemainSpace(Cup.class));
		System.out.println(goods.getPackRemainSpace(Shampoo.class));

	}
}
