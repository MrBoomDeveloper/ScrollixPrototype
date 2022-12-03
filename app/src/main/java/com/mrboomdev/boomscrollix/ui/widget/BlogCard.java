package com.mrboomdev.boomscrollix.ui.widget;

/*  Данный класс я создал, 
	чтобы научиться создавать анонимные классы  */

public class BlogCard {
	public void testRun() {
		Animal animal = new Animal("Nikolay");
		animal.scream();
		
		//Using lambda
		animal.doAction(() -> {
			System.out.println("Auf");
		});
		
		//Using new anonymous class
		animal.doAction(new AnimalCustomAction() {
			public void run() {
				System.out.println("Lmao");
			}
		});
	}
	
	public class Animal {
		private String name;
		
		public Animal(String name) {
			this.name = name;
		}
		
		public void scream() {
			System.out.println("AAAA!");
		}
		
		public void doAction(AnimalCustomAction action) {
			action.run();
		}
	}
	
	public interface AnimalCustomAction {
		public void run();
	}
}