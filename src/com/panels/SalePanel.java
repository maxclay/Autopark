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

public class SalePanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final static int INFO_X = 370;
	private final static int NEW_CARS_X = 10;
	private final static int REPAIRED_CARS_X = 180;
	
	private Game game;
	
	private static boolean updateCarList;
	private static boolean updateRepairedList;
	
	private String[] cars_names;
	private Vehicle car;
	
	private JLabel info_label;
	private JLabel name_label;
	private JLabel cost_label;
	private JLabel serial_label;
	private JLabel date_label;
	private JLabel passanger_label;
	
	private JButton sale_button;
	
	@SuppressWarnings("rawtypes")
	private JList new_cars_list;
	
	@SuppressWarnings("rawtypes")
	private JList repaired_cars_list;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SalePanel(Game game) {
		this.game = game;
		
		if(game.getNewCars() != null) {
			
			int size = game.getNewCars().size();
			cars_names = new String[size];
			
			for(int i = 0; i < size; i++) {
				if(i < 9)
					cars_names[i] = i + 1 + ".   " + game.getNewCars().get(i).getName();
				else
					cars_names[i] = i + 1 + ". " + game.getNewCars().get(i).getName();
			}
		}
		
		new_cars_list = new JList();
		if(cars_names != null)
			new_cars_list.setListData(cars_names);
	
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		new_cars_list.setBackground(Color.DARK_GRAY);
		new_cars_list.setForeground(Color.WHITE);
		new_cars_list.setBorder(loweredetched);
		new_cars_list.setBounds(NEW_CARS_X, 60, 150, 365);
		new_cars_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(new_cars_list.getSelectedValue() != null) {
						String tmp = (String) new_cars_list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1, "new");
						repaired_cars_list.clearSelection();
						
					}
				}
				
			}
        });
		updateCarList = false;

        add(new_cars_list);
        
        JLabel label = new JLabel("New cars:");
        label.setBounds(NEW_CARS_X, 10, 120, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
        
        cars_names = null;
        if(game.getRepairedCars() != null) {
			
			int size = game.getRepairedCars().size();
			cars_names = new String[size];
			
			for(int i = 0; i < size; i++) {
				if(i < 9)
					cars_names[i] = i + 1 + ".   " + game.getRepairedCars().get(i).getName();
				else
					cars_names[i] = i + 1 + ". " + game.getRepairedCars().get(i).getName();
			}
		}
		
		repaired_cars_list = new JList();
		if(cars_names != null)
			repaired_cars_list.setListData(cars_names);
	
		
		repaired_cars_list.setBackground(Color.DARK_GRAY);
		repaired_cars_list.setForeground(Color.WHITE);
		repaired_cars_list.setBorder(loweredetched);
		repaired_cars_list.setBounds(REPAIRED_CARS_X, 60, 150, 365);
		repaired_cars_list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting()) {
					
					if(repaired_cars_list.getSelectedValue() != null) {
						String tmp = (String) repaired_cars_list.getSelectedValue();
						int index = tmp.indexOf('.');

						showCar(Integer.parseInt(tmp.substring(0, index)) - 1, "repaired");
						new_cars_list.clearSelection();
						
					}
				}
				
			}
        });

        add(repaired_cars_list);
        
        label = new JLabel("Repaired cars:");
        label.setBounds(REPAIRED_CARS_X, 10, 140, 40);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setForeground(Color.white);
        add(label);
        
	}
	
	
	@SuppressWarnings("unchecked")
	public void update() {
		game.update();
		        
        
        if(updateCarList) {
        	cars_names = null;
			if(game.getNewCars() != null) {
				
				int size = game.getNewCars().size();
				cars_names = new String[size];
				
				for(int i = 0; i < size; i++) {
					if(i < 9)
						cars_names[i] = i + 1 + ".   " + game.getNewCars().get(i).getName();
					else
						cars_names[i] = i + 1 + ". " + game.getNewCars().get(i).getName();
				}
			}
			
			if(cars_names != null)
				new_cars_list.setListData(cars_names);
			
			updateCarList = false;
		}
        
        if(updateRepairedList) {
        	cars_names = null;
			if(game.getRepairedCars() != null) {
				
				int size = game.getRepairedCars().size();
				cars_names = new String[size];
				
				for(int i = 0; i < size; i++) {
					if(i < 9)
						cars_names[i] = i + 1 + ".   " + game.getRepairedCars().get(i).getName();
					else
						cars_names[i] = i + 1 + ". " + game.getRepairedCars().get(i).getName();
				}
			}
			
			if(cars_names != null)
				repaired_cars_list.setListData(cars_names);
			
			updateRepairedList = false;
		}
        
        if(game.getSeller() != null && sale_button != null &&!sale_button.isEnabled())
        	sale_button.setEnabled(true);

	}
	
	private void showCar(int i, String type) {
		
		if(type.equals("new"))
			car = game.getNewCars().get(i);
		
		if(type.equals("repaired"))
			car = game.getRepairedCars().get(i);
		
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
        name_label.setForeground(Color.black);
        add(name_label);
        
        if(serial_label == null)
        	serial_label = new JLabel();
        
        serial_label.setText("Serial: " + car.getSerial());
        serial_label.setBounds(INFO_X, 235, 140, 20);
        serial_label.setForeground(Color.black);
        add(serial_label);
        
        if(cost_label == null)
        	cost_label = new JLabel();
        
        cost_label.setText("Cost: " + car.getCost());
        cost_label.setBounds(INFO_X, 260, 140, 20);
        cost_label.setForeground(Color.black);
        add(cost_label);
        
        if(passanger_label == null)
        	passanger_label = new JLabel();
        
        passanger_label.setText("Passanger num: " + car.getPassangerNum());
        passanger_label.setBounds(INFO_X, 285, 140, 20);
        passanger_label.setForeground(Color.black);
        add(passanger_label);
        
        if(date_label == null)
        	date_label = new JLabel();
        
        date_label.setText("Issue date: " + car.getIssueDate());
        date_label.setBounds(INFO_X, 310, 140, 20);
        date_label.setForeground(Color.black);
        add(date_label);
        
        if(sale_button == null) {
        	sale_button = new JButton("Sale");
        	sale_button.setActionCommand("sale");
        	sale_button.addActionListener(this);
        	sale_button.setBounds(INFO_X, 350, 100, 30);
        	sale_button.setEnabled(false);
        }
        add(sale_button);
        
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);
		
		if(car != null)
			car.drawIcon(g, INFO_X);
		
		if(game.getSeller() != null)
			game.getSeller().render(g);
	}
	
	public static void updateNewCarList() {
		updateCarList = true;
	}
	
	public static void updateRepairedCarList() {
		updateRepairedList = true;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("sale")) {
			game.getSeller().setCarForSale(car);
			
			if(game.getNewCars() != null && game.getNewCars().contains(car)) {
				game.getNewCars().remove(car);
				updateNewCarList();
			}
			
			if(game.getRepairedCars() != null && game.getRepairedCars().contains(car)) {
				game.getRepairedCars().remove(car);
				updateRepairedCarList();
			}
			
			car = null;
			GaragePanel.updateNewCarList();
			GaragePanel.updateRepairedCarList();
			GaragePanel.clearScreen();
			
			remove(name_label);
			remove(cost_label);
			remove(serial_label);
			remove(date_label);
			remove(passanger_label);
			remove(info_label);
			remove(sale_button);
			
			repaint();
			
		}
		
	}

}
