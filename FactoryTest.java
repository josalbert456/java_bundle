import java.util.List;
import java.util.ArrayList;
class Fruit{
	public String toString(){
		return getClass().getSimpleName();
	}
}
class Apple extends Fruit{
	public static class FruitFactory implements Factory<Apple>{
		@Override
		public Apple create(){
			return new Apple();
		}
	}
}
class Pear extends Fruit{
	public static class FruitFactory implements Factory<Pear>{
		@Override
		public Pear create(){
			return new Pear();
		}
	}
}
class Peach extends Fruit{
	public static class FruitFactory implements Factory<Peach>{
		@Override
		public Peach create(){
			return new Peach();
		}
	}
}


class FruitsFacotry{

	public ArrayList<Fruit> factory = new ArrayList<Fruit>();
	public void manufacture(Class goods){
		try{
			Fruit f = (Fruit)goods.newInstance();
			factory.add(f);
		}catch(InstantiationException ie){

		}catch (IllegalAccessException e) {
			
		}catch(ClassCastException cce){}
	}
}

class FacotryOne<T>{
	public ArrayList<T> factory = new ArrayList<T>();
	public void manufacture(Class goods){
		try{
			T f = (T)goods.newInstance();
			factory.add(f);
		}catch(InstantiationException ie){

		}catch (IllegalAccessException e) {
			
		}catch(ClassCastException cce){}
	}
}
public class FactoryTest{
	public static void main(String[] args){
		FacotryOne<Fruit> fruitsFactory = new FacotryOne<Fruit>();
		fruitsFactory.manufacture(Pear.class);
		fruitsFactory.manufacture(Peach.class);
		System.out.println(fruitsFactory.factory.get(1).getClass().getSimpleName());
		System.out.println(fruitsFactory.factory.get(0).getClass().getSimpleName());
		
		FruitsFacotry ff = new FruitsFacotry();
		ff.manufacture(Peach.class);
		System.out.println(ff.factory.get(0).getClass().getSimpleName());
		List<Factory<? extends Fruit>> fruitFactory 
			= new ArrayList<Factory<? extends Fruit>>();
		fruitFactory.add(new Apple.FruitFactory());
		fruitFactory.add(new Apple.FruitFactory());
		fruitFactory.add(new Apple.FruitFactory());
		fruitFactory.add(new Peach.FruitFactory());
		for(Factory f:fruitFactory){
			System.out.println(f.create());
		}
	}
}