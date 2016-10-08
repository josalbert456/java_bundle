import java.util.ArrayList;
class Test{}

class PlanetConfig{
	public int size;
	public String name;
	public Class classType;
	public PlanetType planetType;
	public float restitution;
	public PlanetConfig(){}
	public String toString(){
		return "Name: " + name + "\n" + "Size: " + size;
	}
}
class PlanetBase{	
	public void print(){
		System.out.println(this.getClass().getName());
	}
}
class Sun extends PlanetBase{
	public static float restitution = 1.0f;
}
class Earth extends PlanetBase{
	public static float restitution = 2.0f;
}
class Moon extends PlanetBase{
	public static float restitution = 3.0f;
}

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
enum PlanetType{
	SUN, EARTH, MOON
};
class PlanetManager<T>{
	T t;
	private PlanetConfig planetConfig;
	public void configPlanet(int size, String name, Class classType, PlanetType planetType, float restitution){		
		planetConfig.size = size;
		planetConfig.name = name;
		planetConfig.classType = classType;
		planetConfig.planetType = planetType;
		planetConfig.restitution = restitution;
	}
	PlanetType planetType;
	private PlanetManager(){}
	public PlanetManager(T t) throws PlanetTypeException{
		planetConfig = new PlanetConfig();
		this.t = t;
		if(!(t instanceof PlanetBase))throw new PlanetTypeException(t.getClass().getName());
		// or if(t instanceof PlanetBase || t instance of AnotherBaseClass)...
		if(t instanceof Sun){
			System.out.println("Sun");
			configPlanet(100, "Sun", Sun.class, PlanetType.SUN, Sun.restitution);
		}else if(t instanceof Moon){
			System.out.println("Moon");
			configPlanet(30, "Moon", Moon.class, PlanetType.MOON, Moon.restitution);
		}else if(t instanceof Earth){
			System.out.println("Earth");
			configPlanet(60, "Earth", Earth.class, PlanetType.EARTH, Earth.restitution);				
		}
		System.out.println(planetConfig);

	}
	public float collisionTesting(PlanetBase u){
		if(planetConfig.classType==u.getClass()){
			return 0.f;
		}
		if(u instanceof Sun){
			return planetConfig.restitution + Sun.restitution;
		}else if(u instanceof Earth){
			return planetConfig.restitution + Earth.restitution;
		}else if(u instanceof Moon){
			return planetConfig.restitution + Moon.restitution;
		}

		return 0.f;
	}

}

public class TemplateTest{
	public static void main(String[] args){
		try{
			PlanetManager<Sun> sun = new PlanetManager<Sun>(new Sun());
			PlanetManager<Earth> earth = new PlanetManager<Earth>(new Earth());
			ArrayList<PlanetManager> planets = new ArrayList<PlanetManager>();
			planets.add(new PlanetManager<Sun>(new Sun()));
			System.out.println(sun.collisionTesting(new Sun()));
			System.out.println(sun.collisionTesting(new Earth()));
			System.out.println(sun.collisionTesting(new Moon()));

			PlanetManager<Test> p = new PlanetManager<Test>(new Test());

		}catch(PlanetTypeException pte){
			System.out.println(pte.getMessage());
		}		
	}
}