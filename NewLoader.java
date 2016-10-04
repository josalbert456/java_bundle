import java.lang.reflect.Method;
import java.io.*;

public class NewLoader extends ClassLoader{
	public static void main(String[] args){
		NewLoader ml = new NewLoader();
		try{
			Test test = (Test)ml.loadClass("NewLoaderTest", true).newInstance();
			test.print();
		}catch(Exception e){

		}
		/*Class test = ml.findClass("Test");		
		Method[] methods = test.getMethods();
		for(Method m : methods){
			System.out.println(m.toString());
		}*/
	}

	String path;
	byte[] bts;
	public Class findClass(String name){
		File file = new File("../NewLoaderTest.class");
		bts = new byte[(int)file.length()];
		try{
			InputStream is = new FileInputStream(file);
			is.read(bts);
			return defineClass(name, bts, 0, bts.length);
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
		return null;
	}
	private byte[] loadClassData(String name){
		return bts;
	}
}