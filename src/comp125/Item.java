package comp125;

import java.util.Random;

/********************************************************/
/*                        Do not                        */
/*                        modify                        */   
/*                      this file                       */
/********************************************************/

public class Item 
{	
	private int value;   // value of the item
	private int weight;  // weight of the item
	
	public Item()
	{
		value = 1;
		weight = 1;
	}
	
	public Item(int myValue, int myWeight)
	{
		value = myValue;
		weight = myWeight;
	}

	/**
	 * Gives the value and the weight a random value in the range [minValue, maxValue] and 
	 * [minWeight, maxWeight] respectively
	 * 
	 * @param minValue
	 * @param maxValue
	 * @param minWeight
	 * @param maxWeight
	 * @param generator: passed as a parameter to provide easy control on its behaviour
	 * in particular with respect to the use of a seed. See main in Bag.java for details. 
	 */
	public void setRandomItem(int minValue, int maxValue, int minWeight, int maxWeight, Random generator)
	{
		value = minValue + generator.nextInt(maxValue - minValue + 1);
		weight = minWeight + generator.nextInt(maxWeight - minWeight + 1);
	}
	
	/**
	 * 
	 * Similar to the previous method except that the range is [1, maxValue] and [1, maxWeight] respectively
	 * 
	 * @param maxValue
	 * @param maxWeight
	 * @param generator
	 */
	public void setRandomItem(int maxValue, int maxWeight, Random generator)
	{
		setRandomItem(1, maxValue, 1, maxWeight, generator);
	}
	
	public int getValue()
	{
		return value;
	}	
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setValue(int myValue)
	{
		value = myValue;
	}
	
	public void setWeight(int myWeight)
	{
		weight = myWeight;
	}
	
	public void setValueWeight(int myValue, int myWeight)
	{
		value = myValue;
		weight = myWeight;
	}
}
