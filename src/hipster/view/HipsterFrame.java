package hipster.view;

import hipster.controller.HipsterController;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class HipsterFrame extends JFrame
{
	private HipsterPanel basePanel;
	private HipsterController baseController;
	
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
		
		setupFrame();
	}
	
	public String getResponse(String prompt)
	{
		String response = JOptionPane.showInputDialog(this, prompt);
		return response;
	}
	
	private void setupFrame()
	{
		this.setTitle("Hipster Stuff");
		this.setContentPane(basePanel);
		this.setSize(800, 500);
		this.setVisible(true);
	}
	
	public HipsterController getBaseController()
	{
		return baseController;
	}
}
