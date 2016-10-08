class Test{}

class PlanetBase{}
class Sun extends PlanetBase{}
class Earth extends PlanetBase{}
class Moon extends PlanetBase{}

class PlanetTypeException extends Exception{
	private String message;
	public PlanetTypeException(String className){
		this.message = className + " is not subclass of PlanetBase";
	}
	@Override 
	public String getMessage(){
		return message;
	}
}

class PlanetManager<T>{
	T t;
	private PlanetManager(){}
	public PlanetManager(T t) throws PlanetTypeException{
		this.t = t;
		if(!(t instanceof PlanetBase))throw new PlanetTypeException(t.getClass().getName());
		if(t instanceof Sun){
			System.out.println("Sun");
		}else if(t instanceof Moon){
			System.out.println("Moon");
		}else if(t instanceof Earth){
			System.out.println("Earth");
		}
	}
}

public class TemplateTest{
	public static void main(String[] args){
		try{
			PlanetManager<Sun> sun = new PlanetManager<Sun>(new Sun());
			PlanetManager<Test> p = new PlanetManager<Test>(new Test());

		}catch(PlanetTypeException pte){
			System.out.println(pte.getMessage());
		}		
	}
}