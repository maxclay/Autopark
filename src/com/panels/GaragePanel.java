package com.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.abstractfactory.Vehicle;
import com.main.Game;

public class GaragePanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static final int NEW_CARS_X = 10;
	private static final int USED_CARS_X = 190;
	private static final int REPAIRED_CARS_X = 370;
	private static final int INFO_X = 600;
	
	private Game game;
	
	@SuppressWarnings("rawtypes")
	private JList used_car_list;
	
	@SuppressWarnings("rawtypes")
	private JList new_car_list;
	
	@SuppressWarnings("rawtypes")
	private JList repaired_car_list;
	
	private String[] used_cars_names;
	private String[] new_cars_names;
	private String[] repaired_cars_names;
	private Vehicle car;
	
	private static boolean updateUsedCarList;
	private static boolean updateNewCarList;
	private static boolean updateRepairedCarList;
	private static boolean clearScreen;
	
	private JLabel info_label;
	private JLabel name_label;
	private JLabel cost_label;
	private JLabel serial_label;
	private JLabel date_label;
	private JLabel passanger_label;
	private JLabel capacity_label;
	private JLabel full_label;
	
	private JButton fill;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GaragePanel(Game game) {
		this.game = game;
		
		clearScreen = false;
		
		setLayout(null);
		
		if(game.getUsedCars() != null) {
			
			int size = game.getUsedCars().size();
			used_cars_names = new String[size];
			
			for(int i = 0; i < size; i++) {
				if(i < 9)
					used_cars_names[i] = i + 1 + ".   " + game.getUsedCars().get(i).getName();
				else
					used_cars_names[i] = i + 1 + ". " + game.getUsedCars().get(i).getName();
			}
		}
		
		used_car_list = new JList();
		if(used_cars_names != null)
			used_car_list.setListData(used_cars_names);
	
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		used_car_list.setBackground(Color.DARK_GRAY);
		used_car_list.setForeground(Color.white);
		used_car_list.setBorder(loweredetched);
		used_car_list.setBounds(USED_CARS_X, 60, 150, 365);
		used_car_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(used_car_list.getSelectedValue() != null) {
						String tmp = (String) used_car_list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1, "used");
						repaired_car_list.clearSelection();
						new_car_list.clearSelection();
					}
				}
				
			}
        });
		updateUsedCarList = false;
        add(used_car_list);
        
        JLabel label = new JLabel("Used cars:");
        label.setBounds(USED_CARS_X, 10, 120, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
        
		if(game.getNewCars() != null) {
			
			int size = game.getNewCars().size();
			new_cars_names = new String[size];
			
			for(int i = 0; i < size; i++) {
				if(i < 9)
					new_cars_names[i] = i + 1 + ".   " + game.getNewCars().get(i).getName();
				else
					new_cars_names[i] = i + 1 + ". " + game.getNewCars().get(i).getName();
			}
		}
		
		new_car_list = new JList();
		if(new_cars_names != null)
			new_car_list.setListData(new_cars_names);
	
		
		new_car_list.setBackground(Color.DARK_GRAY);
		new_car_list.setForeground(Color.white);
		new_car_list.setBorder(loweredetched);
		new_car_list.setBounds(NEW_CARS_X, 60, 150, 365);
		new_car_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(new_car_list.getSelectedValue() != null) {
						String tmp = (String) new_car_list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1, "new");
						repaired_car_list.clearSelection();
						used_car_list.clearSelection();
					}
				}
				
			}
        });
		updateNewCarList = false;
        add(new_car_list);
        
        label = new JLabel("New cars:");
        label.setBounds(NEW_CARS_X, 10, 120, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
        
		if(game.getRepairedCars() != null) {
			
			int size = game.getRepairedCars().size();
			repaired_cars_names = new String[size];
			
			for(int i = 0; i < size; i++) {
				if(i < 9)
					repaired_cars_names[i] = i + 1 + ".   " + game.getRepairedCars().get(i).getName();
				else
					repaired_cars_names[i] = i + 1 + ". " + game.getRepairedCars().get(i).getName();
			}
		}
		
		repaired_car_list = new JList();
		if(repaired_cars_names != null)
			repaired_car_list.setListData(repaired_cars_names);
	
		
		repaired_car_list.setBackground(Color.DARK_GRAY);
		repaired_car_list.setForeground(Color.white);
		repaired_car_list.setBorder(loweredetched);
		repaired_car_list.setBounds(REPAIRED_CARS_X, 60, 150, 365);
		repaired_car_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(repaired_car_list.getSelectedValue() != null) {
						String tmp = (String) repaired_car_list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1, "repaired");
						new_car_list.clearSelection();
						used_car_list.clearSelection();
					}
				}
				
			}
        });
		updateRepairedCarList = false;
        add(repaired_car_list);
        
        label = new JLabel("Repaired:");
        label.setBounds(REPAIRED_CARS_X, 10, 120, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
		
	}
	
	private void showCar(int i, String category) {
		
		if(category.equals("used"))
			car = (Vehicle) game.getUsedCars().get(i);

		if(category.equals("new"))
			car = (Vehicle) game.getNewCars().get(i);
		
		if(category.equals("repaired"))
			car = (Vehicle) game.getRepairedCars().get(i);
		
		 if(info_label == null)
			 info_label = new JLabel();
		info_label = new JLabel("Info:");
		info_label.setBounds(INFO_X, 10, 120, 40);
		info_label.setFont(new Font("Dialog", Font.BOLD, 18));
		info_label.setForeground(Color.white);
        add(info_label);
        
        if(name_label == null)
        	name_label = new JLabel();
        
        name_label.setText("Name: " + car.getName());
        name_label.setBounds(INFO_X, 210, 180, 20);
        name_label.setForeground(Color.BLACK);
        add(name_label);
        
        if(serial_label == null)
        	serial_label = new JLabel();
        
        serial_label.setText("Serial: " + car.getSerial());
        serial_label.setBounds(INFO_X, 235, 140, 20);
        serial_label.setForeground(Color.BLACK);
        add(serial_label);
        
        if(cost_label == null)
        	cost_label = new JLabel();
        
        cost_label.setText("Cost: " + car.getCost());
        cost_label.setBounds(INFO_X, 260, 140, 20);
        cost_label.setForeground(Color.BLACK);
        add(cost_label);
        
        if(passanger_label == null)
        	passanger_label = new JLabel();
        
        passanger_label.setText("Passanger num: " + car.getPassangerNum());
        passanger_label.setBounds(INFO_X, 285, 140, 20);
        passanger_label.setForeground(Color.BLACK);
        add(passanger_label);
        
        if(date_label == null)
        	date_label = new JLabel();
        
        date_label.setText("Issue date: " + car.getIssueDate());
        date_label.setBounds(INFO_X, 310, 140, 20);
        date_label.setForeground(Color.BLACK);
        add(date_label);
        
        if(capacity_label == null)
        	capacity_label = new JLabel();
        
        capacity_label.setText("Capacity: " + car.getCapacity());
        capacity_label.setBounds(INFO_X, 335, 140, 20);
        capacity_label.setForeground(Color.BLACK);
        add(capacity_label);
        
        if(full_label == null)
        	full_label = new JLabel();
        
        full_label.setText("Is full: " + car.isFull());
        full_label.setBounds(INFO_X, 360, 140, 20);
        full_label.setForeground(Color.BLACK);
        add(full_label);
        
        if(fill == null) {
        	fill = new JButton("Fill");
        	fill.setBounds(INFO_X, 385, 100, 40);
        	fill.setActionCommand("fill");
        	fill.addActionListener(this);
        }
        
        if(game.getGasStation() == null || car.isFull())
        	fill.setEnabled(false);
        
        add(fill);
        
	}
	
	public static void updateUsedCarList() {
		
		updateUsedCarList = true;
	}
	
	public static void updateNewCarList() {
		
		updateNewCarList = true;
	}
	
	public static void updateRepairedCarList() {
		
		updateRepairedCarList = true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void update() {
		game.update();
		
		if(fill != null && !fill.isEnabled() && game.getGasStation() != null && car != null && !car.isFull())
			fill.setEnabled(true);
		
		if(updateUsedCarList) {
			
			if(game.getUsedCars() != null) {

				int size = game.getUsedCars().size();
				used_cars_names = new String[size];
				
				for(int i = 0; i < size; i++) {
					if(i < 9)
						used_cars_names[i] = i + 1 + ".   " + game.getUsedCars().get(i).getName();
					else
						used_cars_names[i] = i + 1 + ". " + game.getUsedCars().get(i).getName();
				}
			}
			
			if(used_cars_names != null)
				used_car_list.setListData(used_cars_names);
			
			updateUsedCarList = false;
		}
		
		if(updateNewCarList) {
			
			if(game.getNewCars() != null) {

				int size = game.getNewCars().size();
				new_cars_names = new String[size];
				
				for(int i = 0; i < size; i++) {
					if(i < 9)
						new_cars_names[i] = i + 1 + ".   " + game.getNewCars().get(i).getName();
					else
						new_cars_names[i] = i + 1 + ". " + game.getNewCars().get(i).getName();
				}
			}
			
			if(new_cars_names != null)
				new_car_list.setListData(new_cars_names);
			
			updateNewCarList = false;
		}
		
		if(updateRepairedCarList) {
			
			if(game.getRepairedCars() != null) {
				int size = game.getRepairedCars().size();
				repaired_cars_names = new String[size];
				
				for(int i = 0; i < size; i++) {
					if(i < 9)
						repaired_cars_names[i] = i + 1 + ".   " + game.getRepairedCars().get(i).getName();
					else
						repaired_cars_names[i] = i + 1 + ". " + game.getRepairedCars().get(i).getName();
				}
			}
			
			if(repaired_cars_names != null)
				repaired_car_list.setListData(repaired_cars_names);
			
			updateRepairedCarList = false;
		}
		
		if(clearScreen) {
			
			if(car!= null) {
			
				car = null;
				
				remove(name_label);
				remove(cost_label);
				remove(serial_label);
				remove(date_label);
				remove(passanger_label);
				remove(info_label);
				remove(capacity_label);
				remove(full_label);
				remove(fill);
				
				repaint();
			}
			clearScreen = false;
		}
		
		
	}
	
	public static void clearScreen() {
		clearScreen = true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);
		
		if(car != null)
			car.drawIcon(g, INFO_X);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("fill")) {
			if(car != null) {
			int liter = car.getCapacity();
			car.fill(game.getGasStation().fillCar(liter));
			}
			fill.setEnabled(false);
			
			clearScreen();
		}
		
	}
}
