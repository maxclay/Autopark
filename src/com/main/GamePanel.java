package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.panels.MenuPanel;


public class GamePanel implements ActionListener {
	
	public static final int WIDTH = 854;
	public static final int HEIGHT = 480;
	private static final int BUTTON_WIDTH = 180;
	private static final int BUTTON_HEIGHT = 40;
	public static final int INDENTATION = 10;
	
	public static final int INSET_WIDTH = 95;
	public static final int INSET_HEIGHT = 30;
	
	private JFrame frame;
	
	private AnimationPanel animation_panel;
	private MenuPanel menu_panel;
	
	public GamePanel() {
		
		frame = new JFrame("Autopark");
		frame.setSize(WIDTH, HEIGHT + INSET_HEIGHT + 2 * INDENTATION);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		menu_panel = new MenuPanel();
		menu_panel.setBounds(0, 0, WIDTH, HEIGHT + INSET_HEIGHT + 2 * INDENTATION);
		menu_panel.setLayout(null);
		frame.add(menu_panel);
		addButtons();
		
		
	}
	
	private void addButtons() {
		
		menu_panel.removeAll();
		
		JLabel label = new JLabel("Autopark");
		label.setBounds((WIDTH - BUTTON_WIDTH) /2, 10, 300, 80);
		label.setFont(new Font("Dialog", Font.BOLD, 42));
		label.setForeground(Color.black);
		menu_panel.add(label);
		
		JButton newGameButton = new JButton("New game");
		newGameButton.setActionCommand("newGame");
		newGameButton.setBounds((WIDTH - BUTTON_WIDTH) /2, 2 * BUTTON_HEIGHT + 4 * INDENTATION, BUTTON_WIDTH, BUTTON_HEIGHT);
		newGameButton.addActionListener(this);
		
		JButton aboutButton = new JButton("About");
		aboutButton.setActionCommand("about");
		aboutButton.setBounds((WIDTH - BUTTON_WIDTH) /2, 3 * BUTTON_HEIGHT + 5 * INDENTATION, BUTTON_WIDTH, BUTTON_HEIGHT);
		aboutButton.addActionListener(this);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setActionCommand("exit");
		exitButton.setBounds((WIDTH - BUTTON_WIDTH) /2, 4 * BUTTON_HEIGHT + 6 * INDENTATION, BUTTON_WIDTH, BUTTON_HEIGHT);
		exitButton.addActionListener(this);
		
		menu_panel.add(newGameButton);
		menu_panel.add(aboutButton);
		menu_panel.add(exitButton);
		
		menu_panel.repaint();
		frame.repaint();
	}
	
	private void createGame() {
		
		animation_panel = new AnimationPanel();
		animation_panel.setLayout(null);
		animation_panel.setBounds(0, 0, WIDTH, HEIGHT + INSET_HEIGHT + 2 * INDENTATION);
		animation_panel.showGaragePanel();
		
		frame.add(animation_panel);
	}


	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("newGame")) {
			
			frame.getContentPane().removeAll();
			
			createGame();
			
			frame.repaint();
			
		}
		
		if(event.getActionCommand().equals("about")) {
			
			menu_panel.removeAll();
			
			
			JLabel aboutLabel = new JLabel("<html>"
					+ "'Autopark' - buy or repair cars,<br>hire specialized workers and <br>make your wallet thick!</html>");
			aboutLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			aboutLabel.setBounds(330, 40, 5 * BUTTON_WIDTH, 5 * BUTTON_HEIGHT);
			menu_panel.add(aboutLabel);
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("cancel");
			cancelButton.setBounds((WIDTH - BUTTON_WIDTH) /2, 10 * BUTTON_HEIGHT + 3 * INDENTATION, BUTTON_WIDTH, BUTTON_HEIGHT);
			cancelButton.addActionListener(this);
			menu_panel.add(cancelButton);
			menu_panel.repaint();
			frame.repaint();
		
		}
		
		if(event.getActionCommand().equals("exit")) {
			
			System.exit(0);
		}
		
		if(event.getActionCommand().equals("cancel")) {
			
			addButtons();
		}
		
	}
}
