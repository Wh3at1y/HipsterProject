package hipster.view;

import hipster.controller.HipsterController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HipsterPanel extends JPanel
{
	private SpringLayout baseLayout;
	private HipsterController baseController;
	private JComboBox<String> phraseComboBox;
	private JLabel showText;
	
	
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController baseController)
	{
		baseLayout = new SpringLayout();
		this.baseController = baseController;

		showText = new JLabel("I listened to dubstep before everyone else did. Now it sucks.");
		
		phraseComboBox = new JComboBox<String>();
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(phraseComboBox);
		this.add(showText);

	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, showText, 0, SpringLayout.NORTH, phraseComboBox);
		baseLayout.putConstraint(SpringLayout.WEST, showText, 30, SpringLayout.EAST, phraseComboBox);
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
			
		});
	}
}
