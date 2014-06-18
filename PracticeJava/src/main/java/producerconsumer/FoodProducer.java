package producerconsumer;

public class FoodProducer implements Runnable {
	private Basket basket;
	
	public FoodProducer(Basket basket) {
		this.basket = basket;
	}
	
	public void produceFood() throws Exception{
		Boolean b = basket.offerFood();
		if(b) {
			System.out.println("Food offer successfully");
		}
	}
	
	public void run() {
		try{
			while(true) {
				this.produceFood();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		Basket basket = new Basket();
		FoodProducer fp = new FoodProducer(basket);
		FoodConsumer fc = new FoodConsumer(basket);
		Thread t1 = new Thread(fp);
		Thread t2 = new Thread(fc);
		t1.start();
		t2.start();
	}
}
