package com.mk.generic;

public class L03_genericMethod {

	private static class GenericMethod {
		public <T> void showArray(T[] array) {
			for (T item : array)
				System.out.print(item.toString() + " -> ");
		}

		public <T> T showItem(T t) {
			System.out.println("The item is: " + t.toString());
			return t;
		}
	}

	public static void main(String[] args) {

		GenericMethod genericMethod = new GenericMethod();
		genericMethod.showItem(34.7);
		System.out.println("The returned item is: " + genericMethod.showItem(45));

		Integer[] integerArray = { 3, 4, 5, 2, 1 };
		genericMethod.showArray(integerArray);

		String[] names = { "Kevin", "Joe", "Adam", "Smith" };
		genericMethod.showArray(names);
	}
}
