package producerconsumer;

import java.util.*;
public class Basket{
	private Queue<Food> queue = new LinkedList<Food>();
	
	public Boolean offerFood(){
		synchronized(this) {
			Boolean b = queue.offer(new Food());
			notifyAll();
			return b;
		}
	}
	
	public Food pollFood() throws Exception{
		synchronized(this) {
			Food f = queue.poll();
			if(f == null) {
				wait();
				return this.pollFood();
			} else {
				return f;
			}
		}
	}
}

class Food {
	private static int foodId = 0;
	public Food() {
		foodId++;
	}
	
	@Override
	public String toString() {
		return "Food Number :" + foodId + " is delicious";
	}
}