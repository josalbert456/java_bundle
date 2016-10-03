import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
enum FLOWER_TYPE{
	WATER, GROUND, MOUNTAIN
}
class Flower{
	int age;
	String name;
	FLOWER_TYPE type;
	public Flower(){

	}
	public Flower(String name, FLOWER_TYPE type, int age){
		this.age = age;
		this.name = name;
		this.type = type;
	}
	public Flower(String name, FLOWER_TYPE type){
		this.name = name;
		this.type = type;		
	}
	public void grow(){
		age ++;
	}
}
public class ClassInfoExtractor{
	public static void main(String[] args){
		Flower flower = new Flower("Rose", FLOWER_TYPE.GROUND);
		try{
			Class<?> c = Class.forName("java.lang.Class");
			Method[] methods = c.getMethods();
			for(Method m: methods){
				System.out.println(m.toString());
			}
			Field[] fields = c.getFields();
			for(Field f: fields){
				System.out.println(f.toString());
			}
			fields = c.getDeclaredFields();
			for(Field f: fields){
				System.out.println(f.toString());
			}
			Constructor constructors[] = c.getConstructors();
			for(Constructor con:constructors){
				System.out.println(con.toString());
			}
		}catch(ClassNotFoundException cnfe){

		}
	}
}