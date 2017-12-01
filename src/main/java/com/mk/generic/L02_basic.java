package com.mk.generic;



public class L02_basic {

	private static class Store<T> {

		private T item;

		public void setStoreItem(T item) {
			this.item = item;
		}

		public T getItem() {
			return this.item;
		}

		@Override
		public String toString() {
			return "" + this.item.toString();
		}
	}

	// MultipleGeneric Test
	private static class MultipleGeneric<K, V> {

		private K key;
		private V value;

		public MultipleGeneric(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return key.toString() + "-" + value.toString();
		}
	}
	
	
	public static void main(String[] args) {

		// raw type AVOID IT !!!
		Store store = new Store();
		store.setStoreItem(45);
		System.out.println(store);

		Store<Integer> stringStore = new Store<>(); // "diamond operator"
		stringStore.setStoreItem(45);
		System.out.println(stringStore);

		Integer item = stringStore.getItem();
		System.out.println(item);

		MultipleGeneric<String, Integer> hashtable = new MultipleGeneric<>("Hello world!", 55);
		System.out.println(hashtable);

	}
}
