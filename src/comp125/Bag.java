package comp125;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Bag for assignment 3
 * @author: Bao-lim Smith 
 * @student number: 43277047
 */

public class Bag 
{
	private int weightCapacity; // The maximal weight that a bag can carry.

	private ArrayList<Boolean> mostExpensiveFirstSelection;	// Selection of items corresponding to strategy A.
	private ArrayList<Boolean> optimalSelection;            // Selection of items corresponding to strategy B.
	
	private int valueMostExpensiveFirstSelection;  // Total value of items picked with strategy A. 
	private int valueOptimalSelection;			   // Total value of items picked with strategy B. 

	private int weightMostExpensiveSelection;      // Combined weight of items picked with strategy A.
	private int weightOptimalSelection;            // Combined weight of items picked with strategy B.
	private boolean runAgain;                      // If all items within the bag are not chosen, preventing useless checks.
	
	private int weightRemaining; // The weight remaining in the bag to be utilised (My Own Parameter).
	
	public Bag()
	{
		weightCapacity = 1;
		
		mostExpensiveFirstSelection = new ArrayList<Boolean>();
		optimalSelection = new ArrayList<Boolean>();
		
		valueMostExpensiveFirstSelection = 0;
		valueOptimalSelection = 0;	
		
		runAgain = false;
	}
		
	public Bag(int myWeightCapacity)
	{
		weightCapacity = myWeightCapacity;
		weightRemaining = weightCapacity; // My own addition.
		
		mostExpensiveFirstSelection = new ArrayList<Boolean>();
		optimalSelection = new ArrayList<Boolean>();
		
		valueMostExpensiveFirstSelection = 0;
		valueOptimalSelection = 0;
	}
	
	/**
	 * @returns a deep copy of the list mostExpensiveFirstSelection
	 */
	public ArrayList<Boolean> getMostExpensiveFirstSelection()
	{	
		ArrayList<Boolean> deepCopy = new ArrayList<Boolean>();
		for(int i = 0; i < mostExpensiveFirstSelection.size(); i++)
			deepCopy.add(mostExpensiveFirstSelection.get(i));
		return deepCopy;
	}

	/**
	 * @returns a deep copy of the list optimalSelection
	 */
	public ArrayList<Boolean> getOptimalSelection()
	{
		ArrayList<Boolean> deepCopy = new ArrayList<Boolean>();
		for(int i = 0; i < optimalSelection.size(); i++)
			deepCopy.add(optimalSelection.get(i));

		return deepCopy;
	}
	
	public int getValueMostExpensiveFirstSelection()
	{	
		return valueMostExpensiveFirstSelection;
	}

	public int getValueOptimalSelection()
	{	
		return valueOptimalSelection;
	}
	
	public int getWeightOptimalSelection()
	{	
		return weightOptimalSelection;
	}

	/**
	 * This method updates mostExpensiveFirstSelection with the selection of items
	 * which corresponds to picking the most valuable item that fits in the bag at any stage
	 * 
	 * Initially the method checks if all items within the bag can be chosen, and if so
	 * turns all entries in mostExpensiveFirstSelection to true, and exits the method.
	 * 
	 * This method then works by searching through the totalListOfItems to find the largest
	 * value, then updating the reference number that corresponds to that item in 
	 * MostExpensiveFirstSelection to true. 
	 * This then repeats, and searches for the next highest value.
	 * 
	 * @param totalListOfItems
	 * @complexity
	 * 
	 * Time Complexity:
	 * In the worst case, the time complexity would be O(n^2). This is due to the two for
	 * loops (checking for the maximum value, and checking whether all items have been picked.
	 * 
	 * However, I think it might be reasonable for the complexity to be O(n^n) in the worse case,
	 * yet I don't think this is quite reasonable, and it might be more appropriate to 
	 * define it based on the weight parameters. 
	 * For example:
	 * O(n^(totalBagCapacity/averageWeightOfEachItem)), and possibly multiplying n by
	 * the number of items in the list.
	 * 
	 * On even further determination, it seems that this would actually be O(n*n^2) = O(n^3).
	 * As the main body with a complexity of O(n^2) is executed n times in the worst case. 
	 * 
	 * Space Complexity:
	 * 6 Integers -- 192 bits
	 * 1 Boolean -- 1 bit
	 * 1 ArrayList <Boolean>(n) -- n bits
	 * 1 ArrayList <Item>(n) -- 64n bits
	 * 65n + 192 bits ~ O(n) bits
	 */
	public void pickMostExpensiveFirst(ArrayList<Item> totalListOfItems)
	{
		// Size of totalListOfItems and mostExpensiveFirstSelection.
		int listSize = totalListOfItems.size();
		
		// Checks if all items can fit inside the bag.
		if (!runAgain) // Prevents useless checks.
		{
			for (int l = 0; l <= listSize; l++)
			{
				if (l != listSize)
					weightMostExpensiveSelection += totalListOfItems.get(l).getWeight();

				if (weightMostExpensiveSelection > weightCapacity)
					break;

				else if (l == listSize)
				{
					for (int m = 0; m < listSize; m++)
						mostExpensiveFirstSelection.add(true);
					return; // Exits the method.
				}
			}
		}
		
		// To help when comparisons are made from optimalSelection to this method.
		mostExpensiveFirstSelection.clear();
		
		// Initialises the mostExpensiveFirstList
		for (int k = 0; k < totalListOfItems.size(); k++)
			mostExpensiveFirstSelection.add(false);
		
		// Finds all the items that correspond to the most value.
		findMostExpensiveItems(totalListOfItems, listSize);
		
		// If you need to call the method multiple times.
		weightRemaining = weightCapacity;
	}
	
	/**
	 * This method updates optimalSelection with the selection of items
	 * which corresponds to an optimal value and weight.
	 * 
	 * This takes a similar approach to findMostExpensiveFirstSelection(), except instead of
	 * checking for the highest value, this considers the value/weight ratio, and
	 * the highest ratio and down until the bag can't be filled with anymore Items.
	 * It first determines the largest ratio out of the Items, and then sets it's 
	 * position in the optimalSelection to true, and repeats.
	 * 
	 * This method then uses pickMostExpensiveFirstSelection to check if the chosen 
	 * Item's do truly correspond to the most optimal selection, if not the 
	 * optimalSelection ArrayList is updated to mirror mostExpensiveFirstSelection.
	 * 
	 * I determined that the only scenario when this would occur, is when the ratio of one Item is less 
	 * than all other Items, but it's value is much greater than if you were to pick based on ratio
	 * alone, leaving that Item not picked. Because if you have one Item as such, then you can only have 
	 * (n - Item of lowest ratio) [Where n is the amount of Items] Items of higher ratios, but lower values. 
	 * Thus, pickMostExpensiveFirstSelection() will always return the correct selection.
	 * 
	 * However, while this case is somewhat rare, it does increase the average complexity of
	 * the method; but not the big-O notation.
	 * 
	 * @param totalListOfItems
	 * @complexity
	 * 
	 * Time Complexity:
	 * Since it's similar to findMostExpensiveFirstSelection(), I would expect the worst
	 * case complexity to be identical, so O(n^3).
	 * 
	 * Space Complexity:
	 * 6 Integers -- 192 bits
	 * 2 Doubles -- 64 bits
	 * 2 Boolean -- 2 bit
	 * 1 ArrayList <Item>(n) -- 64n bits
	 * 1 ArrayList <Boolean>(n) -- n bits
	 * Plus pickMostExpensiveFirstSelection's space complexity [O(n)].
	 * Thus ~ O(n) bits
	 */
	public void findOptimalItems(ArrayList<Item> totalListOfItems)
	{		
		// Size of both optimalSelection and totalListOfItems. 
		int listSize = totalListOfItems.size();
				
		// Initialises the optimalSelection list based on if all items can fit within it.
		for (int l = 0; l <= listSize; l++)
		{
			if (l != listSize)
				weightOptimalSelection += totalListOfItems.get(l).getWeight();

			if (weightOptimalSelection > weightCapacity)
				break;

			else if (l == listSize)
			{
				for (int m = 0; m < listSize; m++)
					optimalSelection.add(true);
				return; // Exits the method.
			}
		}
		
		// If for some reason you want to call this method multiple times in a row.
		optimalSelection.clear();
		
		// To prevent the above method being run again in pickMostExpensiveFirstSelection().
		runAgain = true;
		
		// Only if all items cannot fit within the list.
		for (int k = 0; k < listSize; k++)
			optimalSelection.add(false);

		// Finds the most optimal solution.
		findMostOptimalItems(totalListOfItems, listSize);
		
		// If you need to call the method multiple times.
		weightRemaining = weightCapacity;
				
		// Finds the true optimalSelection.
		checkSelection(totalListOfItems, listSize);
	}
	
	/**
	 * This confirms that the optimalSelection was the most optimal choice.
	 * It does so by comparing it to what pickMostExpensiveFirst()
	 * finds is the value, and if its value is higher corrects the Items to be
	 * picked in optimalSelection().
	 */
	public void checkSelection(ArrayList<Item> totalListOfItems, int listSize)
	{
		// Picks the most expensive items on totalListOfItems.
		pickMostExpensiveFirst(totalListOfItems);

		// Compares if pickExpensiveFirst gives you a more optimal value.
		if (valueMostExpensiveFirstSelection > valueOptimalSelection)
			for (int p = 0; p < listSize; p++)
				optimalSelection.set(p, mostExpensiveFirstSelection.get(p));
	}
	
	/**
	 * Finds the items within totaListOfItems that is the highest in value, takes 
	 * its relative position, and then updates that position within mostExpensiveFirstSelection.
	 * This then repeats until all items possible have been selected.
	 */
	public void findMostExpensiveItems(ArrayList<Item> totalListOfItems, int listSize)
	{
		// Variable initialisation.
		int maxValue = 0;
		int weight = totalListOfItems.get(0).getWeight();
		int currentWeight = 0;
		int currentValue = 0;
		
		int takeItemPosition = 0;
		boolean end = false;
		
		while (weightRemaining > 0 && !end)
		{				
			// Finds the Item with the most value in the list.
			for (int i = 0; i <= listSize; i++)
			{
				if (i == 0)
					maxValue = 0;		
				
				if (i != listSize && mostExpensiveFirstSelection.get(i) != true)
				{
					currentValue = totalListOfItems.get(i).getValue();
					currentWeight = totalListOfItems.get(i).getWeight();

					/**
					 *  Finds the item with the largest value within the ArrayList, 
					 *  and it's corresponding weight, and position.
					 *  Else if the two items have the same value, takes the one
					 *  with the lowest weight.					 
					 */
					if (currentWeight <= weightRemaining)
					{
						if (currentValue > maxValue)
						{

							maxValue = currentValue;
							weight = currentWeight;

							takeItemPosition = i;
						}
						else if (currentValue == maxValue && currentWeight < weight)
						{
							maxValue = currentValue;
							weight = currentWeight;

							takeItemPosition = i;
						}
					}
				}
				else if (i == listSize && weight <= weightRemaining)
				{
					takeItem(totalListOfItems, weight, i, takeItemPosition, end);
					valueMostExpensiveFirstSelection += maxValue;
				}
				else if (weight > weightRemaining) // Stopping statement(s).
					end = true;	
			}
		}
	}
	
	/** 
	 * Finds the item with the most optimal value, by value-weight ratio. 
	 * Then takes the position of that item within totalListOfItems and then sets
	 * its relative position in optimalSelection to true.
	 * 
	 * Then repeats this process until all items that can be selected have been.
	 */
	public void findMostOptimalItems(ArrayList<Item> totalListOfItems, int listSize)
	{
		// Variable initialisation.
		double maxRatio = 0;
		double currentRatio = 0;
		int weight = totalListOfItems.get(0).getWeight();
		int currentWeight = 0;
		int currentValue = 0;
		int tempValue = 0; // If two items have the same ratio.
		
		int takeItemPosition = 0;
		boolean end = false;
		
		while (weightRemaining > 0 && !end)
		{				
			// Finds the Item with the highest value/weight ratio.
			for (int i = 0; i <= listSize; i++)
			{
				if (i == 0)
				{
					maxRatio = 0; 	
					tempValue = 0;
				}
				
				if (i != listSize && optimalSelection.get(i) == false)
				{
					// Finds the current value-weight ratio.
					currentValue = totalListOfItems.get(i).getValue();
					currentWeight = totalListOfItems.get(i).getWeight();
										
					// Requires the cast to double or else it will normally give a value of 0.
					currentRatio = ((double) currentValue/ (double) currentWeight);

					/**
					 *  Finds the item with the largest value to weight ratio 
					 *  within the ArrayList, and it's corresponding weight, and 
					 *  position.
					 *  Else if the two items have the same ratio, takes the one
					 *  with the lowest weight.					 
					 */
					if (currentWeight <= weightRemaining)
					{
						if (currentRatio > maxRatio)
						{
							// Updates what the current best Item to pick is.
							maxRatio = currentRatio;
							weight = currentWeight;
							
							tempValue = currentValue;

							takeItemPosition = i;
						}
						// Helps if the two items have the same ratio.
						else if (currentRatio == maxRatio && currentValue >= tempValue)
						{
							maxRatio = currentRatio;
							weight = currentWeight;

							tempValue = currentValue;

							takeItemPosition = i;
						}
					}
				}				
				else if (i == listSize && weight <= weightRemaining)
				{
					// Changes the optimalSelection ArrayList Item's position to true, for the selected item.
					takeItemOptimal(totalListOfItems, weight, i, takeItemPosition, end);
					valueOptimalSelection += maxRatio*weight;
				}
				else if (weight > weightRemaining)
					end = true;
			}
		}
	}
	
	/**
	 * Sets the position of the Item to be chosen, relative to mostExpensiveFirstSelection,
	 * and updates the remaining bag capacity.
	 * Also checks if all possible Items have been picked, and if not restarts the main body loop
	 * to search for the next most valuable Item.
	 */
	public void takeItem(ArrayList<Item> givenList, int weight, int i, int itemPosition, boolean end)
	{
		weightRemaining = weightRemaining - weight;

		mostExpensiveFirstSelection.set(itemPosition, true);

		// Checks if all items that can be selected have been.
		for (int j = 0; j < mostExpensiveFirstSelection.size(); j++)
		{
			if (mostExpensiveFirstSelection.get(j) == true || givenList.get(j).getWeight() > weightRemaining)
				end = true;
			else
			{
				end = false;
				i = -1;

				break;
			}
		}
	}
	
	/**
	 * Sets the Item to be chosen, position in optimalSelection to true.
	 * Also updates the remaining weight of the bag.
	 * Checks if all selectable Items have been chosen, and if not restarts searching for the next 
	 * optimal Item.
	 */
	public void takeItemOptimal(ArrayList<Item> givenList, int weight, int i, int itemPosition, boolean end)
	{
		weightRemaining = weightRemaining - weight;

		optimalSelection.set(itemPosition, true);

		// Checks if all items that can be selected have been.
		for (int j = 0; j < optimalSelection.size(); j++)
		{
			if (optimalSelection.get(j) == true || givenList.get(j).getWeight() > weightRemaining)
				end = true; // Stopping statement.
			else
			{
				end = false;
				i = -1;

				break;
			}
		}
	}
		
	public static void main(String[] args) 
	{	
		ArrayList<Item> totalListOfItems = new ArrayList<Item>(); // list containing all the items to choose from 

		Random generator = new Random(123); // use a seed to produce the same random items

		Item item;
		for(int i = 0; i < 5; i++)
		{
			item = new Item();
			item.setRandomItem(15, 10, generator);
			totalListOfItems.add(item);
			System.out.println("Item " + i + ": value and weight are " + item.getValue() + " and " + item.getWeight());
		}
		
		System.out.println();
		Bag bag = new Bag(50);  // this bag has a weightCapcity of 50 
		
		bag.pickMostExpensiveFirst(totalListOfItems); // updates mostExpensiveFirstSelection
			
		int totalWeight = 0, totalValue = 0;
		
		System.out.println("pickMostExpensiveFirst()");
		ArrayList<Boolean> selection =  bag.getMostExpensiveFirstSelection();
		
		for(int i = 0; i < selection.size(); i++)
		{
			System.out.print(selection.get(i) + " ");
			if(selection.get(i))
			{
				totalValue += totalListOfItems.get(i).getValue();
				totalWeight += totalListOfItems.get(i).getWeight();
			}
		}
		
		System.out.println();
		System.out.println("Total Value: " + totalValue +  " and total weight: " + totalWeight);

		System.out.println();
		System.out.println("findOptimalSelection()");
		long start = System.nanoTime();
		bag.findOptimalItems(totalListOfItems);
		long timeTaken = System.nanoTime() - start;
		
		totalWeight = 0;
		totalValue = 0;

		//selection =  bag.getMostExpensiveFirstSelection(); 
		selection =  bag.getOptimalSelection();
		
		for(int i = 0; i < selection.size(); i++)
		{
			System.out.print(selection.get(i) + " ");
			if(selection.get(i))
			{
				totalValue += totalListOfItems.get(i).getValue();
				totalWeight += totalListOfItems.get(i).getWeight();
			}
		}
		System.out.println();
		System.out.println("Total Value: " + totalValue +  " and total weight: " + totalWeight);
        System.out.println("Time used: " + timeTaken/1000000. + "µs"); 
	}	
}