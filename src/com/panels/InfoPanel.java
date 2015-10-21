package com.panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.main.Game;

public class InfoPanel extends Panel{

	private static final long serialVersionUID = 1L;
	private Game game;
	
	private JLabel new_car_numb;
	private JLabel used_car_numb;
	
	private JLabel money;
	private JLabel day_label;
	
	private short used_cars;
	
	private int day;
	private float dd;
	
	private int week;
	private int month;
	
	public InfoPanel(Game game) {
		this.game = game;
		background = null;
		
		week = 1;
		month = 1;
		day = 1;
		dd = 1f;
		new_car_numb = new JLabel("New cars: 0/20");
		new_car_numb.setBounds(5, 8, 100, 14);
		new_car_numb.setForeground(Color.green);
		add(new_car_numb);
		
		used_car_numb = new JLabel("Used cars: 0/20");
		used_car_numb.setBounds(5, 27, 100, 14);
		used_car_numb.setForeground(Color.red);
		add(used_car_numb);
		
		money = new JLabel("Money: " +  game.getMoney() + "$");
		money.setBounds(120, 8, 200, 14);
		money.setForeground(Color.yellow);
		add(money);
		
		used_cars = 0;
		
		day_label = new JLabel("Day: " + day);
		day_label.setBounds(120, 27, 130, 14);
		day_label.setForeground(Color.white);
		add(day_label);
	}

	@Override
	public void update() {
		
		dd += 0.001f;
		day = (int) dd;
		
		if(day - week == 7) {
			week = day;
			Game.week();
		}
		
		if(day - month == 30) {
			month = day;
			Game.month();
		}
		
		if(game.getNewCars() != null) {
			new_car_numb.setText("New cars: " + game.getNewCars().size() + "/20");
		}
		
		if(game.getUsedCars() != null) {
			used_cars += game.getUsedCars().size();
		}
		
		if(game.getRepairedCars() != null) {
			used_cars += game.getRepairedCars().size();
		}
		
		used_car_numb.setText("Used cars: " + used_cars + "/20");
		used_cars = 0;
		
		money.setText("Money: " +  game.getMoney() + "$");
		day_label.setText("Day: " + day);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	public int getDay() {
		return day;
	}

}
