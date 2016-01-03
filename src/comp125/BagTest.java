package comp125;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class BagTest {


	/**
	 * Compare list1 and list2 and return true if and only if 
	 * the lists contain the same values
	 *  
	 * @param list1
	 * @param list2
	 * @return a boolean 
	 */
	public static boolean isEqual(ArrayList<Boolean> list1, ArrayList<Boolean> list2)
	{
		if(list1.size() != list2.size())
			return false;
		else
			for(int i = 0; i < list1.size(); i++)
				if(list1.get(i) != list2.get(i))
					return false;	

		return true;					
	}

	/**
	 * Checks if selection corresponds to an optimal solution
	 * @param totalListOfItems
	 * @param selection
	 * @param value
	 * @param weight
	 * @return
	 */
	public static boolean isOptimal(ArrayList<Item> totalListOfItems, ArrayList<Boolean> selection, int value, int weight)
	{
		int valueOptimalSelection = 0;
		int weightOptimalSelection = 0;

		if(selection.size() != totalListOfItems.size())
			return false;

		for(int i = 0; i < totalListOfItems.size(); i++)
		{
			if(selection.get(i))
			{
				valueOptimalSelection += totalListOfItems.get(i).getValue();
				weightOptimalSelection += totalListOfItems.get(i).getWeight();
			}			
		}

		if(valueOptimalSelection == value && weightOptimalSelection == weight)
			return true;
		else 
			return false;
	}	

	@Test
	public void testPickMostExpensiveFirst03() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst04() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(28);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst05() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(45);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst06() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 30);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 30);
		totalListOfItems.add(item);	
		item = new Item(17, 30);
		totalListOfItems.add(item);	

		Bag bag = new Bag(30);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst07() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 30);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 30);
		totalListOfItems.add(item);	
		item = new Item(17, 30);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	
	@Test
	public void testPickMostExpensiveFirst08() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(21, 30);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 30);
		totalListOfItems.add(item);	
		item = new Item(22, 30);
		totalListOfItems.add(item);	
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 60);
		totalListOfItems.add(item);	
		item = new Item(17, 50);
		totalListOfItems.add(item);	
		item = new Item(20, 40);
		totalListOfItems.add(item);
		item = new Item(10, 3);
		totalListOfItems.add(item);	
		item = new Item(15, 10);
		totalListOfItems.add(item);	
		item = new Item(17, 30);
		totalListOfItems.add(item);	

		Bag bag = new Bag(150);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	
	@Test
	public void testPickMostExpensiveFirst09() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 30);
		totalListOfItems.add(item);
		item = new Item(10, 30);
		totalListOfItems.add(item);	
		item = new Item(35, 10);
		totalListOfItems.add(item);	
		item = new Item(17, 10);
		totalListOfItems.add(item);	

		Bag bag = new Bag(40);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst12() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 30);
		totalListOfItems.add(item);
		item = new Item(10, 30);
		totalListOfItems.add(item);	
		item = new Item(3, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 10);
		totalListOfItems.add(item);	

		Bag bag = new Bag(0);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst11() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(15, 20);
		totalListOfItems.add(item);
		item = new Item(12, 30);
		totalListOfItems.add(item);	
		item = new Item(40, 10);
		totalListOfItems.add(item);	
		item = new Item(10, 10);
		totalListOfItems.add(item);	
		item = new Item(10, 30);
		totalListOfItems.add(item);
		item = new Item(10, 30);
		totalListOfItems.add(item);	
		item = new Item(30, 10);
		totalListOfItems.add(item);	
		item = new Item(12, 10);
		totalListOfItems.add(item);	
		 item = new Item(10, 40);
		totalListOfItems.add(item);
		item = new Item(20, 30);
		totalListOfItems.add(item);	
		item = new Item(3, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 10);
		totalListOfItems.add(item);	

		Bag bag = new Bag(120);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(true);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst10() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 10);
		totalListOfItems.add(item);
		item = new Item(14, 20);
		totalListOfItems.add(item);	
		item = new Item(3, 20);
		totalListOfItems.add(item);	
		item = new Item(14, 30);
		totalListOfItems.add(item);	
		 item = new Item(10, 20);
		totalListOfItems.add(item);
		item = new Item(10, 12);
		totalListOfItems.add(item);	
		item = new Item(30, 15);
		totalListOfItems.add(item);	
		item = new Item(1, 5);
		totalListOfItems.add(item);

		Bag bag = new Bag(50);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst13() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 30);
		totalListOfItems.add(item);
		item = new Item(10, 30);
		totalListOfItems.add(item);	
		item = new Item(3, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 10);
		totalListOfItems.add(item);	
		item = new Item(12, 30);
		totalListOfItems.add(item);

		Bag bag = new Bag(30);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst14() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(50, 12);
		totalListOfItems.add(item);
		item = new Item(10, 9);
		totalListOfItems.add(item);	
		item = new Item(32, 62);
		totalListOfItems.add(item);	
		item = new Item(11, 17);
		totalListOfItems.add(item);	
		item = new Item(12, 26);
		totalListOfItems.add(item);
		 item = new Item(22, 44);
		totalListOfItems.add(item);
		item = new Item(10, 31);
		totalListOfItems.add(item);	
		item = new Item(31, 14);
		totalListOfItems.add(item);	
		item = new Item(1, 19);
		totalListOfItems.add(item);	
		item = new Item(12, 49);
		totalListOfItems.add(item);

		Bag bag = new Bag(50);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add (true);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst15() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 50);
		totalListOfItems.add(item);
		item = new Item(140, 100);
		totalListOfItems.add(item);	
		item = new Item(30, 110);
		totalListOfItems.add(item);	
		item = new Item(1300, 410);
		totalListOfItems.add(item);	
		item = new Item(1200, 300);
		totalListOfItems.add(item);
		item = new Item(50, 70);
		totalListOfItems.add(item);
		item = new Item(1000, 310);
		totalListOfItems.add(item);	
		item = new Item(190, 350);
		totalListOfItems.add(item);	
		item = new Item(1250, 500);
		totalListOfItems.add(item);	
		item = new Item(80, 678);
		totalListOfItems.add(item);
		item = new Item(30, 30);
		totalListOfItems.add(item);
		item = new Item(60, 85);
		totalListOfItems.add(item);	
		item = new Item(400, 1000);
		totalListOfItems.add(item);	
		item = new Item(1, 10);
		totalListOfItems.add(item);	
		item = new Item(120, 302);
		totalListOfItems.add(item);
		 item = new Item(104, 304);
		totalListOfItems.add(item);
		item = new Item(103, 330);
		totalListOfItems.add(item);	
		item = new Item(300, 450);
		totalListOfItems.add(item);	
		item = new Item(12, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 30);
		totalListOfItems.add(item);

		Bag bag = new Bag(1285);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testPickMostExpensiveFirst() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 30);
		totalListOfItems.add(item);
		item = new Item(10, 30);
		totalListOfItems.add(item);	
		item = new Item(35, 10);
		totalListOfItems.add(item);	
		item = new Item(17, 10);
		totalListOfItems.add(item);	

		Bag bag = new Bag(40);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	@Test
	public void testFindOptimal02() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 50, 57));
	}	
	@Test
	public void testFindOptimal03() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(3, 1);
		totalListOfItems.add(item);
		item = new Item(12, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 8);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(6, 4);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 32, 31));
	}
	@Test
	public void testFindOptimal04() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 50);
		totalListOfItems.add(item);
		item = new Item(12, 10);
		totalListOfItems.add(item);	
		item = new Item(1, 8);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(6, 4);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 29, 30));
	}	
	@Test
	public void testFindOptimal05() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 8);
		totalListOfItems.add(item);
		item = new Item(12, 8);
		totalListOfItems.add(item);	
		item = new Item(1, 8);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(6, 4);
		totalListOfItems.add(item);	

		Bag bag = new Bag(20);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 28, 20));
	}	
	@Test
	public void testFindOptimal06() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 8);
		totalListOfItems.add(item);
		item = new Item(12, 8);
		totalListOfItems.add(item);	
		item = new Item(1, 8);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(6, 4);
		totalListOfItems.add(item);	

		Bag bag = new Bag(30);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 38, 28));
	}	
	@Test
	public void testFindOptimal07() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 8);
		totalListOfItems.add(item);
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(1, 9);
		totalListOfItems.add(item);	
		item = new Item(1, 9);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	

		Bag bag = new Bag(26);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 30, 24));
	}	
	@Test
	public void testFindOptimal08() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 8);
		totalListOfItems.add(item);
		item = new Item(15, 9);
		totalListOfItems.add(item);	
		item = new Item(12, 10);
		totalListOfItems.add(item);	
		item = new Item(11, 11);
		totalListOfItems.add(item);	
		item = new Item(7, 12);
		totalListOfItems.add(item);	

		Bag bag = new Bag(25);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 27, 19));
	}	
	@Test
	public void testFindOptimal09() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(50, 38);
		totalListOfItems.add(item);
		item = new Item(24, 29);
		totalListOfItems.add(item);	
		item = new Item(100, 50);
		totalListOfItems.add(item);	
		item = new Item(70, 45);
		totalListOfItems.add(item);	
		item = new Item(35, 25);
		totalListOfItems.add(item);	

		Bag bag = new Bag(155);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 229, 149));
	}	
	@Test
	public void testFindOptimal01() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 8);
		totalListOfItems.add(item);
		item = new Item(12, 8);
		totalListOfItems.add(item);	
		item = new Item(1, 8);
		totalListOfItems.add(item);	
		item = new Item(10, 8);
		totalListOfItems.add(item);	
		item = new Item(6, 4);
		totalListOfItems.add(item);	

		Bag bag = new Bag(20);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 28, 20));
	}
	
	@Test
	public void testPickMostExpensiveFirst01() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		totalListOfItems.add(item);
		item = new Item(11, 3);
		totalListOfItems.add(item);	
		item = new Item(35, 45);
		totalListOfItems.add(item);	
		item = new Item(17, 26);
		totalListOfItems.add(item);	

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}

	@Test
	public void testPickMostExpensiveFirst16() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(13, 21);
		totalListOfItems.add(item);			
		item = new Item(13, 18);
		totalListOfItems.add(item);		
		item = new Item(7, 18);
		totalListOfItems.add(item);	
		item = new Item(17, 30);
		totalListOfItems.add(item);				

		Bag bag = new Bag(60);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(true);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	
	@Test
	public void testPickMostExpensiveFirst17() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(24, 25);
		totalListOfItems.add(item);			
		item = new Item(1, 21);
		totalListOfItems.add(item);			
		item = new Item(46, 14);
		totalListOfItems.add(item);
		item = new Item(19, 9);
		totalListOfItems.add(item);	
		item = new Item(31, 6);
		totalListOfItems.add(item);			
		item = new Item(41, 27);
		totalListOfItems.add(item);
		item = new Item(35, 11);
		totalListOfItems.add(item);
		item = new Item(21, 24);
		totalListOfItems.add(item);	
		item = new Item(6, 23);
		totalListOfItems.add(item);	
		item = new Item(17, 21);
		totalListOfItems.add(item);	
		item = new Item(4, 6);
		totalListOfItems.add(item);	
		item = new Item(40, 25);
		totalListOfItems.add(item);	
		item = new Item(32, 19);
		totalListOfItems.add(item);	
		item = new Item(7, 15);
		totalListOfItems.add(item);	
		item = new Item(42, 17);
		totalListOfItems.add(item);	
		item = new Item(45, 8);
		totalListOfItems.add(item);	
		item = new Item(32, 16);
		totalListOfItems.add(item);	
		item = new Item(10, 16);
		totalListOfItems.add(item);	


		Bag bag = new Bag(105);
		ArrayList<Boolean> selection = new ArrayList<Boolean>();

		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(false);
		selection.add(false);
		selection.add(true);
		selection.add(true);
		selection.add(false);
		selection.add(false);

		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	
	@Test
	public void testFindOptimal11() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(48, 37);
		totalListOfItems.add(item);
		item = new Item(29, 26);
		totalListOfItems.add(item);
		item = new Item(39, 20);
		totalListOfItems.add(item);
		item = new Item(38, 10);
		totalListOfItems.add(item);
		item = new Item(45, 29);
		totalListOfItems.add(item);
		item = new Item(18, 37);
		totalListOfItems.add(item);

		Bag bag = new Bag(60);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 122, 59));
	}
	
	@Test(timeout = 2000)
	public void testFindOptimal10() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(28, 30);
		totalListOfItems.add(item);
		item = new Item(31, 72);
		totalListOfItems.add(item);
		item = new Item(9, 89);
		totalListOfItems.add(item);
		item = new Item(24, 63);
		totalListOfItems.add(item);
		item = new Item(1, 106);
		totalListOfItems.add(item);
		item = new Item(13, 16);
		totalListOfItems.add(item);
		item = new Item(55, 29);
		totalListOfItems.add(item);
		item = new Item(36, 32);
		totalListOfItems.add(item);
		item = new Item(32, 55);
		totalListOfItems.add(item);
		item = new Item(3, 44);
		totalListOfItems.add(item);

		Bag bag = new Bag(125);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		
		assertTrue(isOptimal(totalListOfItems, selection, 132, 107));
	}
	
	@Test(timeout = 2000)
	public void testFindOptimalHard03() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(43, 46);
		totalListOfItems.add(item);
		item = new Item(41, 100);
		totalListOfItems.add(item);
		item = new Item(10, 22);
		totalListOfItems.add(item);
		item = new Item(25, 96);
		totalListOfItems.add(item);
		item = new Item(50, 47);
		totalListOfItems.add(item);
		item = new Item(5, 36);
		totalListOfItems.add(item);
		item = new Item(8, 79);
		totalListOfItems.add(item);
		item = new Item(14, 45);
		totalListOfItems.add(item);
		item = new Item(22, 6);
		totalListOfItems.add(item);
		item = new Item(49, 100);
		totalListOfItems.add(item);
		item = new Item(24, 89);
		totalListOfItems.add(item);
		item = new Item(11, 18);
		totalListOfItems.add(item);
		item = new Item(50, 17);
		totalListOfItems.add(item);
		item = new Item(31, 39);
		totalListOfItems.add(item);
		item = new Item(26, 13);
		totalListOfItems.add(item);
		item = new Item(17, 51);
		totalListOfItems.add(item);
		item = new Item(37, 76);
		totalListOfItems.add(item);
		item = new Item(33, 33);
		totalListOfItems.add(item);
		item = new Item(52, 15);
		totalListOfItems.add(item);
		item = new Item(6, 95);
		totalListOfItems.add(item);
		item = new Item(15, 27);
		totalListOfItems.add(item);
		item = new Item(20, 47);
		totalListOfItems.add(item);
		item = new Item(19, 40);
		totalListOfItems.add(item);
		item = new Item(35, 21);
		totalListOfItems.add(item);
		item = new Item(24, 19);
		totalListOfItems.add(item);
		item = new Item(49, 46);
		totalListOfItems.add(item);
		item = new Item(54, 54);
		totalListOfItems.add(item);
		item = new Item(4, 25);
		totalListOfItems.add(item);
		item = new Item(6, 93);
		totalListOfItems.add(item);
		item = new Item(26, 9);
		totalListOfItems.add(item);
		item = new Item(11, 32);
		totalListOfItems.add(item);
		item = new Item(53, 74);
		totalListOfItems.add(item);
		item = new Item(16, 92);
		totalListOfItems.add(item);
		item = new Item(11, 28);
		totalListOfItems.add(item);
		item = new Item(37, 48);
		totalListOfItems.add(item);

		Bag bag = new Bag(53);
		
		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 150, 47));
	}
	
	@Test
	public void testFindOptimalHard04()
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();
		
		Item item = new Item(60, 2);
		totalListOfItems.add(item);
		item = new Item(30, 1);
		totalListOfItems.add(item);
		item = new Item(90, 3);
		totalListOfItems.add(item);

		
		Bag bag = new Bag(4);
		
		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		
		assertTrue(isOptimal(totalListOfItems, selection, 120, 4));
	}
	
	@Test
	public void testFindOptimalHard05()
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();
		
		Item item = new Item(90, 3);
		totalListOfItems.add(item);
		item = new Item(60, 2);
		totalListOfItems.add(item);
		item = new Item(60, 2);
		totalListOfItems.add(item);
		item = new Item(40, 1);
		totalListOfItems.add(item);
		item = new Item(60, 2);
		totalListOfItems.add(item);
		item = new Item(60, 2);
		totalListOfItems.add(item);

		
		Bag bag = new Bag(4);
		
		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		
		assertTrue(isOptimal(totalListOfItems, selection, 130, 4));
	}
	
	@Test
	public void testFindOptimalHard06()
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();
		
		Item item = new Item(30, 4);
		totalListOfItems.add(item);
		item = new Item(15, 1);
		totalListOfItems.add(item);

		Bag bag = new Bag(4);
		
		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		
		assertTrue(isOptimal(totalListOfItems, selection, 30, 4));
	}
	
	@Test
	public void testFindExpensiveHard04()
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();
		
		Item item = new Item(30, 1);
		totalListOfItems.add(item);
		item = new Item(30, 1);
		totalListOfItems.add(item);
		item = new Item(30, 1);
		totalListOfItems.add(item);
		
		Bag bag = new Bag(5);
		
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		selection.add(true);
		selection.add(true);
		selection.add(true);
		
		bag.pickMostExpensiveFirst(totalListOfItems);
		assertTrue(isEqual(bag.getMostExpensiveFirstSelection(), selection));
	}
	
	@Test(timeout = 2000)
	public void testFindOptimalZZMade01()
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(16, 13);
		totalListOfItems.add(item);
		item = new Item(15, 5);
		totalListOfItems.add(item);
		item = new Item(4, 3);
		totalListOfItems.add(item);
		item = new Item(13, 19);
		totalListOfItems.add(item);
		item = new Item(13, 16);
		totalListOfItems.add(item);
		item = new Item(8, 9);
		totalListOfItems.add(item);
		item = new Item(2, 9);
		totalListOfItems.add(item);
		item = new Item(12, 7);
		totalListOfItems.add(item);

		Bag bag = new Bag(50);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();
		System.out.println(selection);
		assertTrue(isOptimal(totalListOfItems, selection, 64, 50));
	}

	@Test
	public void testFindOptimalHARD() 
	{
		int numberOfItems = 10000;
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(22, 28);
		for (int i = 0; i < numberOfItems/2; i++)
			totalListOfItems.add(item);

		item = new Item(10, 1);
		for (int i = 0; i < numberOfItems/2; i++)
			totalListOfItems.add(item);

		Bag bag = new Bag(numberOfItems/2);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, numberOfItems*10/2, numberOfItems/2));
	}
	
	@Test
	public void testFindOptimalHARD01() 
	{
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 1);
		totalListOfItems.add(item);
		item = new Item(15, 4);
		totalListOfItems.add(item);
		item = new Item(15, 4);
		totalListOfItems.add(item);
		item = new Item(10, 1);
		totalListOfItems.add(item);
		item = new Item(10, 1);
		totalListOfItems.add(item);
		item = new Item(10, 1);
		totalListOfItems.add(item);

		Bag bag = new Bag(8);

		bag.findOptimalItems(totalListOfItems);
		ArrayList<Boolean> selection = bag.getOptimalSelection();

		selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, 55, 8));
	}
	
	@Test
	public void testFindOptimalHARD02() 
	{
		int numberOfItems = 1000;
		ArrayList<Item> totalListOfItems = new ArrayList<Item>();

		Item item = new Item(10, 1);
		for (int i = 0; i < numberOfItems; i++)
			totalListOfItems.add(item);

		Bag bag = new Bag(numberOfItems);

		bag.findOptimalItems(totalListOfItems);

		ArrayList<Boolean> selection = bag.getOptimalSelection();

		selection = bag.getOptimalSelection();

		assertTrue(isOptimal(totalListOfItems, selection, numberOfItems*10, numberOfItems));
	}
}
