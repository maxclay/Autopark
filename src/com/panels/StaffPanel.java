package com.panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.decorator.ExpertSeller;
import com.decorator.ProSeller;
import com.decorator.StandartSeller;
import com.main.Game;
import com.main.resource.Resource;
import com.strategy.Mechanic;

public class StaffPanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Game game;
	
	private Image mechanic;
	private Image seller;
	
	private boolean show_mechanic;
	private boolean show_seller;
	
	private JLabel description;
	
	private Hashtable<String, JButton> buttons;
	
	public StaffPanel(Game game) {
		this.game = game;
		
		setLayout(null);
		
		buttons = new Hashtable<String, JButton>();
		JButton button = new JButton("Car mechanic");
		button.setBounds(10, 40, 120, 40);
		button.setActionCommand("mechanic");
		button.addActionListener(this);
		buttons.put("mechanic", button);
		add(button);
		
		button = new JButton("Car seller");
		button.setBounds(10, 100, 120, 40);
		button.setActionCommand("seller");
		button.addActionListener(this);
		buttons.put("seller", button);
		add(button);
		
		mechanic = Resource.getImage("mechanic");
		seller = Resource.getImage("seller1");
		
		show_mechanic = false;
		show_seller = false;
		
		description = new JLabel();
		description.setBounds(420, 60, 400, 400);
		description.setFont(new Font("Dialog", Font.BOLD, 14));
		add(description);
	}
	
	public void update() {
		game.update();
		
		if(game.getMechanic() == null && buttons.contains("hire_mechanic")) {
			buttons.get("hire_mechanic").setEnabled(true);
		}
		
		if(game.getSeller() == null && buttons.contains("hire_seller")) {
			buttons.get("hire_seller").setEnabled(true);
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);
		
		if(show_mechanic)
			g.drawImage(mechanic, 160, 40, null);
		
		if(show_seller)
			g.drawImage(seller, 160, 40, null);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("mechanic")) {
			showMechanic();
		}
		
		if(event.getActionCommand().equals("seller")) {
			showSeller();
		}
		
		if(event.getActionCommand().equals("hire_mechanic")) {
			Mechanic mechanic = new Mechanic();
			mechanic.setGame(game);
			game.setMechanic(mechanic);
			buttons.get("hire_mechanic").setEnabled(false);

		}
		
		if(event.getActionCommand().equals("hire_seller")) {
			
			game.setSeller(new StandartSeller());
			
			JButton button = buttons.get("hire_seller");
			buttons.remove("hire_seller");
			
			button.setText("To teach to expert");
			button.setActionCommand("first_seller_teach");
			buttons.put("first_seller_teach", button);
		}
		
		if(event.getActionCommand().equals("first_seller_teach")) {
			
			ExpertSeller expert_seller = new ExpertSeller();
			expert_seller.toTeach(game.getSeller());
			game.setSeller(expert_seller);
			
			
			JButton button = buttons.get("first_seller_teach");
			buttons.remove("first_seller_teach");
			
			button.setText("To teach to pro");
			button.setActionCommand("second_seller_teach");
			buttons.put("second_seller_teach", button);
			
			seller = Resource.getImage("seller2");
		}
		
		if(event.getActionCommand().equals("second_seller_teach")) {
			
			ProSeller pro_seller = new ProSeller();
			pro_seller.toTeach(game.getSeller());
			game.setSeller(pro_seller);
			
			buttons.get("second_seller_teach").setEnabled(false);
			
			seller = Resource.getImage("seller3");
		}
		
	}

	private void showSeller() {
		
		repaint();
		description.setText("<html>To hire a seller to sell the cars.<br><br>"
				+ "Standart seller:<br>Skill: plus 3-5 percent of the car price<br>"
				+ "Salary: 600$ / week<br><br>Expert seller:<br>Skill: plus 5-7 percent of the car price<br>"
				+ "Salary: 900$ / week<br><br>Professional seller:<br>Skill: plus 5-15 percent of the car price<br>"
				+ "Salary: 1000$ / week</html>");
		
		show_mechanic = false;
		show_seller = true;		
		buttons.get("mechanic").setEnabled(true);
		buttons.get("seller").setEnabled(false);
		
		if(buttons.get("hire_mechanic") != null)
			remove(buttons.get("hire_mechanic"));
		
		JButton button = new JButton("Hire a seller");
		button.setActionCommand("hire_seller");
		buttons.put("hire_seller", button);
		
		if(game.getSeller() != null) {
			if(game.getSeller().getName().equals("standart seller")) {
				
				button.setText("To teach to expert");
				button.setActionCommand("first_seller_teach");
				buttons.put("first_seller_teach", button);
			}
			if(game.getSeller().getName().equals("expert seller")) {
				
				button.setText("To teach to pro");
				button.setActionCommand("second_seller_teach");
				buttons.put("second_seller_teach", button);
				
			}
			if(game.getSeller().getName().equals("pro seller")) {
				button.setText("To teach to pro");
				buttons.put("second_seller_teach", button);
				button.setEnabled(false);
			}
			
		}
		
		button.setBounds(200, 360, 180, 40);
		button.addActionListener(this);
		add(button);
		
	}

	private void showMechanic() {
		
		description.setText("<html>To hire a mechanic to repair the used cars.<br><br>"
				+ "Skill: after repair plus 30% of the bike price, 40% of the car price"
				+ " and 50% of the truck price<br>Salary: 300$ / week</html>");
		
		repaint();
		
		show_mechanic = true;
		show_seller = false;		
		buttons.get("mechanic").setEnabled(false);
		buttons.get("seller").setEnabled(true);
		
		if(buttons.get("hire_seller") != null)
			remove(buttons.get("hire_seller"));
		if(buttons.get("first_seller_teach") != null)
			remove(buttons.get("first_seller_teach"));
		if(buttons.get("second_seller_teach") != null)
			remove(buttons.get("second_seller_teach"));
		
		JButton button = new JButton("Hire a mechanic");
		button.setBounds(200, 360, 180, 40);
		button.setActionCommand("hire_mechanic");
		button.addActionListener(this);
		buttons.put("hire_mechanic", button);
		if(game.getMechanic() != null)
			button.setEnabled(false);
		add(button);
	}

}
