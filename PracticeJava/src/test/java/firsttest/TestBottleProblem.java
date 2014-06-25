package firsttest;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;
import static org.junit.Assert.*;
import org.junit.Test;

import arc.BottleProblem;


public class TestBottleProblem {

	@Test
	public void testCalculateTotalBottles() {
		
		BottleProblem bottleProblem = new BottleProblem();
		bottleProblem.calculateTotalBottles(1000, 2);
		assertThat(bottleProblem.getTotalBottles(), equalTo(1999));
		assertThat(bottleProblem.getRemainder(), is(1));
		
		BottleProblem bottleProblem2 = new BottleProblem();
		bottleProblem2.calculateTotalBottles(5, 3);
		assertThat(bottleProblem2.getTotalBottles(), equalTo(7));
		assertThat(bottleProblem2.getRemainder(), is(1));
		
	}
}
