package hipster.view;

import hipster.controller.HipsterController;
import hipster.model.Book;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HipsterPanel extends JPanel
{
	private SpringLayout baseLayout;
	private HipsterController baseController;
	private JComboBox<String> phraseComboBox;
	
	private JLabel pageCountLabel;
	private JLabel authorLabel;
	private JLabel subjectLabel;
	private JLabel titleLabel;
	private JLabel priceLabel;
	private JButton changeBookButton;
	
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		phraseComboBox = new JComboBox<String>();
		
		pageCountLabel = new JLabel("Book Pages:");
		authorLabel = new JLabel("Book Author:");
		subjectLabel = new JLabel("Book Subject:");
		titleLabel = new JLabel("Book Title:");
		priceLabel = new JLabel("Book Price:");
		changeBookButton = new JButton("Change Book");
		
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
		this.add(pageCountLabel);
		this.add(authorLabel);
		this.add(subjectLabel);
		this.add(titleLabel);
		this.add(priceLabel);
		this.add(changeBookButton);
	}
	
	private void setupLayout()
	{
		pageCountLabel.setFont(new Font("Myriad Hebrew", Font.PLAIN, 15));
		authorLabel.setFont(new Font("Myriad Hebrew", Font.PLAIN, 15));
		subjectLabel.setFont(new Font("Myriad Hebrew", Font.PLAIN, 15));
		titleLabel.setFont(new Font("Myriad Hebrew", Font.PLAIN, 15));
		priceLabel.setFont(new Font("Myriad Hebrew", Font.PLAIN, 15));
		
		baseLayout.putConstraint(SpringLayout.WEST, pageCountLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, authorLabel, 0, SpringLayout.WEST, pageCountLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, authorLabel, -28, SpringLayout.NORTH, pageCountLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, subjectLabel, 6, SpringLayout.SOUTH, authorLabel);
		baseLayout.putConstraint(SpringLayout.WEST, subjectLabel, 0, SpringLayout.WEST, pageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, pageCountLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleLabel, -6, SpringLayout.NORTH, authorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, priceLabel, 4, SpringLayout.SOUTH, pageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, priceLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, pageCountLabel, 75, SpringLayout.SOUTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 1, SpringLayout.NORTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 22, SpringLayout.EAST, changeBookButton);
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
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Book[] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				
				if(startClick < maxClicks)
				{
					titleLabel.setText("Book Title: " + tempBooks[startClick].getTitle());
					authorLabel.setText("Book Author: " + tempBooks[startClick].getAuthor());
					subjectLabel.setText("Book Subject: " + tempBooks[startClick].getSubject());
					pageCountLabel.setText("Book Pages: " + tempBooks[startClick].getPageCount());
					priceLabel.setText("Book Price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					titleLabel.setText("Book Title: ");
					authorLabel.setText("Book Author: ");
					subjectLabel.setText("Book Subject: ");
					pageCountLabel.setText("Book Pages: ");
					priceLabel.setText("Book Price: ");
				}
			}
		});
	}
}
