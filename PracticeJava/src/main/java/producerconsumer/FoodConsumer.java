package producerconsumer;

public class FoodConsumer implements Runnable {
	private Basket basket;
	
	public FoodConsumer(Basket basket) {
		this.basket = basket;
	}
	
	public void consumeFood() throws Exception{
		Food f = basket.pollFood();
		System.out.println(f);
	}
	
	public void run() {
		try {
			while(true) {
				this.consumeFood();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}