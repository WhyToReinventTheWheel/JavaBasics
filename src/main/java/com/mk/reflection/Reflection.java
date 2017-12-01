package com.mk.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * What is reflection?
 * 
 * Reflection is a language's ability to inspect and dynamically call classes,
 * methods, attributes
 * 
 * getClass() -> we can get the class ... we do not know at compile time
 * 
 * Why to use reflection?
 * 
 * Reflection is important since it lets you write programs that do not have to
 * "know" everything at compile time, making them more dynamic, since they can
 * be tied together at runtime !!!
 * 
 * - lots of modern frameworks uses reflection extensively for this reason - one
 * very common use case in Java is the usage with annotations
 * 
 * JUnit -> will use reflection to look through your classes for methods tagged
 * with the @Test annotation -> will then call them when running the unit test
 * !!!
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
	public String name();
}

public class Reflection {

	public static void main(String[] args) {

		Class<Person> personClass1 = Person.class;
		System.out.println(personClass1.getName());

		// in order to inspect the class we have to get a Class instance

		Class<Person> personClass = null;

		try {
			personClass = (Class<Person>) Class.forName("com.mk.reflection.L01_Intro$Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(personClass.getName());

		Class[] interfaces = personClass.getInterfaces();

		System.out.println("---------- interfaces Name ----------------------------------");
		for (Class c : interfaces)
			System.out.println(c.getName());

		System.out.println(personClass.getSuperclass().getName());

		Method[] methods = personClass.getDeclaredMethods();
		System.out.println("---------- Method Name ----------------------------------");
		for (Method f : methods) {
			f.setAccessible(true);
			System.out.println(f.getName());
		}

		System.out.println("---------- Package Name ----------------------------------");
		System.out.println(personClass.getPackage());

		System.out.println("---------- fields list ----------------------------------");
		System.out.println(personClass.getPackage());
		Field[] fields = personClass.getFields();
		for (Field field : fields) {
			System.out.println(field.getName() + " - " + field.getType());
		}

		System.out.println("---------- Method list and Anotaion----------------------------------");
		Method[] methodList = personClass.getMethods();
		for (Method m : methodList) {
			System.out.println("Name=" + m.getName() + ", ReturnType= " + m.getReturnType());
			if (m.isAnnotationPresent(MyAnnotation.class)) {
				System.out.println("--#Annotaion True#-");
				System.out.println("AnnotaionMethodName=" + m.getName());
			}
		}

		System.out.println("----------Create Object----------------------------------");
		try {
			Person person = (Person) personClass.newInstance();
			person.setName("Mohit");
			person.setAge(20);

			System.out.println(person);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public static class Person {
		private String name;
		private int age;

		@MyAnnotation(name = "mohit")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}
}
