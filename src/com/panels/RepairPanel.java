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


import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.main.Game;
import com.strategy.Mechanic;
import com.strategy.UsedCarStrategy;

public class RepairPanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Game game;
	private Mechanic mechanic;
	
	@SuppressWarnings("rawtypes")
	private JList list;
	private String[] used_cars_names;
	private UsedCarStrategy used_car;
	
	private static boolean updateCarList;
	private static boolean clearScreen;
	
	private JLabel info_label;
	private JLabel name_label;
	private JLabel cost_label;
	private JLabel serial_label;
	private JLabel date_label;
	private JLabel passanger_label;
	
	private JLabel reparing_label;
	
	private JButton repair_button;
	
	private int progress_value;
	private JProgressBar progressBar;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RepairPanel(Game game) {
		this.game = game;
		setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setBounds(600, 10, 200, 20);
		
		reparing_label = new JLabel("The progress of repair:");
		reparing_label.setFont(new Font("Dialog", Font.BOLD, 14));
		reparing_label.setForeground(Color.white);
		reparing_label.setBounds(420, 4, 200, 30);
		
		
		progress_value = 0;
		
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
		
		list = new JList();
		if(used_cars_names != null)
			list.setListData(used_cars_names);
	
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		list.setBorder(loweredetched);
		list.setBounds(10, 60, 130, 365);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(list.getSelectedValue() != null) {
						String tmp = (String) list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1);
					}
				}
				
			}
        });
		updateCarList = false;
		clearScreen = false;
        add(list);
        
        JLabel label = new JLabel("To repairs:");
        label.setBounds(10, 10, 120, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
		
	}
	
	@SuppressWarnings("unchecked")
	public void update() {
		game.update();
		
		if(mechanic == null && game.getMechanic() != null) {
			mechanic = game.getMechanic();
		}
		
		if(updateCarList) {
			
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
				list.setListData(used_cars_names);
			
			updateCarList = false;
		}
		
		if(clearScreen) {
				
				if(used_car!= null && used_car.isRepaired()) {
				
					used_car = null;
					
					remove(name_label);
					remove(cost_label);
					remove(serial_label);
					remove(date_label);
					remove(passanger_label);
					remove(info_label);
					remove(repair_button);
					remove(progressBar);
					remove(reparing_label);
					
					repaint();
				}
				clearScreen = false;
			}
		
		if(mechanic != null && mechanic.isRepair() && mechanic.getRepairingTime() > 0) {
			int tmp = (int) ((System.currentTimeMillis() - mechanic.getStartRepairingTime() - 
					mechanic.getRepairingTime() ) / mechanic.getPercentScale() + 100);
			if(progress_value != tmp) {
				
				progress_value = tmp;
				progressBar.setValue(progress_value);
			}
			
		}
		

	}
	
	private void showCar(int i) {
		used_car = (UsedCarStrategy) game.getUsedCars().get(i);
		
		 if(info_label == null)
			 info_label = new JLabel();
		info_label = new JLabel("Info:");
		info_label.setBounds(170, 10, 120, 40);
		info_label.setFont(new Font("Dialog", Font.BOLD, 18));
		info_label.setForeground(Color.white);
        add(info_label);
        
        if(name_label == null)
        	name_label = new JLabel();
        
        name_label.setText("Name: " + used_car.getName());
        name_label.setBounds(170, 210, 140, 20);
        name_label.setForeground(Color.white);
        add(name_label);
        
        if(serial_label == null)
        	serial_label = new JLabel();
        
        serial_label.setText("Serial: " + used_car.getSerial());
        serial_label.setBounds(170, 235, 140, 20);
        serial_label.setForeground(Color.white);
        add(serial_label);
        
        if(cost_label == null)
        	cost_label = new JLabel();
        
        cost_label.setText("Cost: " + used_car.getCost());
        cost_label.setBounds(170, 260, 140, 20);
        cost_label.setForeground(Color.white);
        add(cost_label);
        
        if(passanger_label == null)
        	passanger_label = new JLabel();
        
        passanger_label.setText("Passanger num: " + used_car.getPassangerNum());
        passanger_label.setBounds(170, 285, 140, 20);
        passanger_label.setForeground(Color.white);
        add(passanger_label);
        
        if(date_label == null)
        	date_label = new JLabel();
        
        date_label.setText("Issue date: " + used_car.getIssueDate());
        date_label.setBounds(170, 310, 140, 20);
        date_label.setForeground(Color.white);
        add(date_label);
        
        if(repair_button == null) {
        	repair_button = new JButton("Repair");
        	repair_button.setActionCommand("repair");
        	repair_button.addActionListener(this);
        	repair_button.setBounds(170, 350, 100, 30);
        	repair_button.setEnabled(false);
        }
        add(repair_button);
        
	}
	
	public static void updateUsedCarList() {
		updateCarList = true;
	}
	
	public static void clearScreen() {
		clearScreen = true;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);
		
		if(mechanic != null) {
			mechanic.render(g);
			
			if(repair_button != null && !repair_button.isEnabled() && !mechanic.isRepair()) {
				repair_button.setEnabled(true);
				remove(progressBar);
				remove(reparing_label);
			}
			
			if(list != null && !list.isEnabled()&& !mechanic.isRepair() )
				list.setEnabled(true);
		}
		
		if(used_car != null)
			used_car.drawIcon(g, 170);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("repair")) {
			
			repair_button.setEnabled(false);
			list.setEnabled(false);
			mechanic.setBrokenCar(used_car);
			mechanic.repairBrokenCar();
			add(progressBar);
			add(reparing_label);
			
		}
		
	}

}
