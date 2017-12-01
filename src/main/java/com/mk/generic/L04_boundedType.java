package com.mk.generic;

public class L04_boundedType {

	/**
	 * There may be times when you want to restrict the types that can be used as
	 * type arguments in a parameterized type. For example, a method that operates
	 * on numbers might only want to accept instances of Number or its subclasses.
	 * This is what bounded type parameters are for.
	 * 
	 * bounded type parameters allow you to invoke methods defined in the bounds For
	 * example extends Comparable -> we can use compareTo() method to compare items
	 * !!!
	 * 
	 * Type parameter can have multiple bounds: <T extends B1 & B2 & B3>
	 * 
	 * Important for algorithms !!!
	 * 
	 * for example we cant use ' > ; < ; == ' operators on T we have to make sure
	 * they are numbers or compare two strings we have to make sure they are strings
	 * !!!
	 * 
	 */

	private static <T extends Comparable<T>> T calculateMin(T t1, T t2) {
		if (t1.compareTo(t2) < 0) {
			return t1;
		}
		return t2;
	}

	public static void main(String[] args) {
		// String , Interger , Double all implements Comparable , so we can use them

		System.out.println(calculateMin(100, 23));
		System.out.println(calculateMin(13.3, 12.2));
		System.out.println(calculateMin("Hello", "World"));
		System.out.println(calculateMin(new Person("Mohit"), new Person("Rohit")));
	}

	private static class Person implements Comparable<Person>{
		private String name;

		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}

		public String getName() {
			return name;
		}

		public Person(String name) {
			super();
			this.name = name;
		}

		@Override
		public int compareTo(Person otherName) {
			return this.name.compareTo(otherName.getName());
		}
	}
}
