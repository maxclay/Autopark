package com.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.main.Game;
import com.main.resource.Resource;
import com.prototype.SpareCache;
import com.state.ContextStation;

public class BuyPanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Game game;
	
	private Image gas;
	
	private Hashtable<String, JButton> buttons;
	
	public BuyPanel(Game game) {
		
		this.game = game;
		
		gas = Resource.getImage("gas_station_icon");
		
		buttons = new Hashtable<String, JButton>();
		
		setLayout(null);
		JLabel label = new JLabel("Order a month:");

		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(10, 10, 160, 40);
		label.setForeground(Color.white);
		add(label);
		
		label = new JLabel("<html>Engine oil<br>(7 000$ / month)</html>");
		label.setBounds(30, 70, 160, 40);
		label.setForeground(Color.white);
		add(label);
		
		JButton button = new JButton("To order");
		button.setBounds(30, 120, 120, 40);
		button.addActionListener(this);
		button.setActionCommand("oil");
		buttons.put("oil", button);
		add(button);
		
		label = new JLabel("<html>Casings<br>(10 000$ / month)</html>");
		label.setBounds(30, 210, 160, 40);
		label.setForeground(Color.white);
		add(label);
		
		button = new JButton("To order");
		button.setBounds(30, 250, 120, 40);
		button.addActionListener(this);
		button.setActionCommand("casings");
		buttons.put("casings", button);
		add(button);
		
		label = new JLabel("<html>Paint<br>(12 000$ / month)</html>");
		label.setBounds(200, 70, 120, 40);
		label.setForeground(Color.white);
		add(label);
		
		button = new JButton("To order");
		button.setBounds(200, 120, 120, 40);
		button.addActionListener(this);
		button.setActionCommand("paint");
		buttons.put("paint", button);
		add(button);
		
		label = new JLabel("<html>Spare parts<br>(21 000$ / month)</html>");
		label.setBounds(200, 210, 160, 40);
		label.setForeground(Color.white);
		add(label);
		
		button = new JButton("To order");
		button.setBounds(200, 250, 120, 40);
		button.addActionListener(this);
		button.setActionCommand("spare");
		buttons.put("spare", button);
		add(button);
		
		label = new JLabel("Gas station:");

		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(500, 10, 160, 40);
		label.setForeground(Color.white);
		add(label);
		
		label = new JLabel("<html>With gas station you can refuel the used car. Its cost will be higher."
				+ "<br><br>It is also necessary to buy fuel and repair the gas station.</html>");
		label.setBounds(655, 40, 160, 200);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		add(label);
		
		button = new JButton("Gas station");
		button.setBounds(510, 250, 100, 40);
		button.addActionListener(this);
		button.setActionCommand("gas");
		buttons.put("gas", button);
		add(button);
		
		label = new JLabel("(10 000$)");
		label.setBounds(535, 280, 100, 40);
		add(label);
		
		button = new JButton("Fuel");
		button.setBounds(620, 250, 100, 40);
		button.addActionListener(this);
		button.setActionCommand("fuel");
		buttons.put("fuel", button);
		button.setEnabled(false);
		add(button);
		
		label = new JLabel("(2 000$)");
		label.setBounds(645, 280, 100, 40);
		add(label);
		
		button = new JButton("Repair");
		button.setBounds(730, 250, 100, 40);
		button.addActionListener(this);
		button.setActionCommand("repair");
		button.setEnabled(false);
		buttons.put("repair", button);
		add(button);
		
		label = new JLabel("(3 000$)");
		label.setBounds(755, 280, 100, 40);
		add(label);
		
	}
	
	public void update() {
		game.update();
		
		if(game.getGasStation() != null) {
			if(!buttons.get("fuel").isEnabled() && game.getGasStation().getName().equals("empty gas station"))
				buttons.get("fuel").setEnabled(true);
			
			if(!buttons.get("repair").isEnabled() && game.getGasStation().getName().equals("broken gas station"))
				buttons.get("repair").setEnabled(true);
		}
		
		if(!Game.isEstablishCasingDelivery()) {
			buttons.get("casings").setEnabled(true);
		}
		
		if(!Game.isEstablishOilDelivery()) {
			buttons.get("oil").setEnabled(true);
		}
		
		if(!Game.isEstablishPaintDelivery()) {
			buttons.get("paint").setEnabled(true);
		}
		
		if(!Game.isEstablishSparePartDelivery()) {
			buttons.get("spare").setEnabled(true);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);
		
		g.drawImage(gas, 500, 60, null);
		

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("oil") && game.getMoney() >= 7000) {
			game.setMoney(game.getMoney() - 7000);
			if(!SpareCache.isLoading())
				SpareCache.loadCache();
			
			game.establishOilDelivery();
			buttons.get("oil").setEnabled(false);
		}
		
		if(event.getActionCommand().equals("casings") && game.getMoney() >= 10000) {
			game.setMoney(game.getMoney() - 10000);
			if(!SpareCache.isLoading())
				SpareCache.loadCache();
			
			game.establishCasingDelivery();
			buttons.get("casings").setEnabled(false);
		}
		
		if(event.getActionCommand().equals("paint") && game.getMoney() >= 12000) {
			game.setMoney(game.getMoney() - 12000);
			if(!SpareCache.isLoading())
				SpareCache.loadCache();
			
			game.establishPaintDelivery();
			buttons.get("paint").setEnabled(false);
		}
		
		if(event.getActionCommand().equals("spare") && game.getMoney() >= 21000) {
			game.setMoney(game.getMoney() - 21000);
			if(!SpareCache.isLoading())
				SpareCache.loadCache();
			
			game.establishSparePartDelivery();
			buttons.get("spare").setEnabled(false);
		}
		
		if(event.getActionCommand().equals("gas")) {
			
			if(game.getMoney() >= 10000) {
				game.setMoney(game.getMoney() - 10000);
				game.setGasStation(new ContextStation());
				buttons.get("gas").setEnabled(false);
			}
		}
		
		if(event.getActionCommand().equals("fuel")) {
			if(game.getMoney() >= 2000) {
				game.setMoney(game.getMoney() - 2000);
				game.getGasStation().setState(ContextStation.GasStationStateSetting.Ready);
				buttons.get("fuel").setEnabled(false);
			}
		}
		
		if(event.getActionCommand().equals("repair")) {
			
			if(game.getMoney() >= 3000) {
				game.setMoney(game.getMoney() - 3000);
				game.getGasStation().setState(ContextStation.GasStationStateSetting.Ready);
				buttons.get("repair").setEnabled(false);
			}
		}
		
	}

}
