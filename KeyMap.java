import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
class StringMap<K, V> extends HashMap<K, V>{
	ArrayList<K> keys;
	public StringMap(){
		keys = new ArrayList<K>();
	}
	@Override
	public V put(K key, V v){
		super.put(key, v);
		keys.add(key);
		return get(key);
	}
	public void listKeys(){
		for(int i=0; i<keys.size(); i++){
			System.out.println(keys.get(i));
		}
	}
}
public class KeyMap{
	public static void main(String[] args){
		StringMap<String, String> sm = new StringMap<String, String>();
		sm.put("aaa", "bbb");
		sm.put("xxx", "yyyy");
		sm.listKeys();
	}
}