package dbaccess;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
   Inventory obj;
   
	@Before
	public void setUp() throws Exception {
 obj = new Inventory();
 
	}

	@After
	public void tearDown() throws Exception {
		obj = null;
	}

	@Test
	public void testSearchItemByCode() {
		assertEquals("Orange",obj.SearchItemByCode(2));
		
	}
	@Test
	public void testSearchPricebycode() {
		assertEquals(2,obj.SearchPricebycode(1));
		
	}
	@Test
	public void testSearchstockbycode() {
		assertEquals(150,obj.Searchstockbycode(3));
		
	}

}
