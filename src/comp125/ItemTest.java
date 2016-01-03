package comp125;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void setRandomItem1() 
	{
		Random generator = new Random(123);
		int minValue, maxValue, minWeight, maxWeight;
				
		for(int i = 1; i <= 10; i++)
		{			
			minValue = generator.nextInt(10); 
			maxValue = minValue + generator.nextInt(10); 
			
			minWeight = generator.nextInt(10); 
			maxWeight = minWeight + generator.nextInt(10); 
			
			Item item = new Item();
			item.setRandomItem(minValue, maxValue, minWeight, maxWeight, generator);
			int value = item.getValue();
			int weight = item.getWeight();
			
			assertTrue(value >= minValue && value <= maxValue && weight >= minWeight && weight <=  maxWeight);
		}		
	}
	
	@Test
	public void setRandomItem2() 
	{
		Random generator = new Random(123);
		int maxValue, maxWeight;
				
		for(int i = 1; i <= 10; i++)
		{			
			maxValue = 1 + generator.nextInt(10); 			
			maxWeight = 1 + generator.nextInt(10); 
			
			Item item = new Item();
			item.setRandomItem(maxValue, maxWeight, generator);
			int value = item.getValue();
			int weight = item.getWeight();
			
			assertTrue(value >= 1 && value <= maxValue && weight >= 1 && weight <=  maxWeight);
		}		
	}
}