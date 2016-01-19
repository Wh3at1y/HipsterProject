/**
 * 
 */
package hipster.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import hipster.model.*;
/**
 * @author CodyH
 * @version 0.x Nov 19, 2015
 *
 */
public class HipsterTest
{

	private Hipster testHipster;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testHipster = new Hipster();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		testHipster = null;
	}

	/**
	 * Test method for {@link hipster.model.Hipster#Hipster()}.
	 */
	@Test
	public void testHipster()
	{
		assertNotNull(testHipster.getHipsterBooks());
		assertNotNull(testHipster.getHipsterPhrases());
		assertTrue(testHipster.getHipsterBooks() instanceof Book[]);
		assertTrue(testHipster.getHipsterPhrases() instanceof String[]);
	}
	
	@Test
	public void testSetupBooks()
	{
		assertTrue(testHipster.getHipsterBooks().length >= 3);
		assertNotNull(testHipster.getHipsterBooks()[0]);
		assertNotNull(testHipster.getHipsterBooks()[1]);
		assertNotNull(testHipster.getHipsterBooks()[2]);
	}
	
	@Test
	public void testSetupArray()
	{
		assertTrue(testHipster.getHipsterPhrases().length >= 4);
		assertNotNull(testHipster.getHipsterPhrases()[0]);
		assertNotNull(testHipster.getHipsterPhrases()[1]);
		assertNotNull(testHipster.getHipsterPhrases()[2]);
		assertNotNull(testHipster.getHipsterPhrases()[3]);
	}

	

}
