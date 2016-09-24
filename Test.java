package com.albert.test;
import com.google.gson.*;
import org.junit.*;
class Person{
	private String name;
	private String age;
	public void sayName(){
		System.out.println(name);
	}
}
public class Test{
	public static void main(String [] args){
		Gson gson = new Gson();
		String jsonData = "{\"name\":\"John\", \"age\":20}";
		Person person = gson.fromJson(jsonData, Person.class);
		person.sayName();
	}
}