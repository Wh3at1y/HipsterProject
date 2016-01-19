/**
 * 
 */
package hipster.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hipster.view.HipsterPanel;
import hipster.controller.HipsterController;

/**
 * @author CodyH
 * @version 0.x Nov 19, 2015
 *
 */
public class HipsterPanelTest
{
	private HipsterPanel testPanel;
	private HipsterController testController;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		testController = new HipsterController();
		testPanel = new HipsterPanel(testController);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		testController = null;
		testPanel = null;
	}

	/**
	 * Test method for {@link hipster.view.HipsterPanel#HipsterPanel(hipster.controller.HipsterAppController)}.
	 */
	@Test
	public void testHipsterPanel()
	{
		assertTrue(testPanel.getComponents().length >= 8);
		assertTrue(testPanel.getLayout() instanceof javax.swing.SpringLayout);
	}
	
	@Test
	public void testSetupListeners()
	{
		for(java.awt.Component temp : testPanel.getComponents())
		{
			if (temp instanceof javax.swing.JComboBox<?>)
			{
				assertTrue(((javax.swing.JComboBox<String>) temp).getActionListeners().length > 0);
			}
			else if(temp instanceof javax.swing.JButton)
			{
				assertTrue(((javax.swing.JButton) temp).getActionListeners().length > 0);
			}
		}
	}

}
