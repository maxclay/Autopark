package com.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.panels.CarsPanel;
import com.panels.GaragePanel;
import com.panels.InfoPanel;
import com.panels.Panel;
import com.panels.RepairPanel;
import com.panels.SalePanel;
import com.panels.BuyPanel;
import com.panels.StaffPanel;

public class AnimationPanel extends JPanel implements Runnable, ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Hashtable<String, JButton> buttons;
	
	private GaragePanel garage_panel;
	private StaffPanel staff_panel;
	private CarsPanel cars_panel;
	private BuyPanel spares_panel;
	private RepairPanel repair_panel;
	private SalePanel sale_panel;
	private InfoPanel info_panel;
	
	private JPanel button_panel;
	
	private Panel current_panel;
	
	private Thread animationThread;
	private int animationDelay = 16;//FPS = 1000ms / 16ms = 60;
	
	private Game game;
	
	
	public AnimationPanel() {
		
		this.buttons = new Hashtable<String, JButton>();
		game = new Game();
		
		info_panel = new InfoPanel(game);
		info_panel.setLayout(null);
		info_panel.setBackground(Color.GRAY);
		info_panel.setBounds(6 * GamePanel.INSET_WIDTH + 2 * GamePanel.INDENTATION, 0, 
				GamePanel.WIDTH - (6 * GamePanel.INSET_WIDTH + 2 * GamePanel.INDENTATION),
				GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION);
		
		
		
		info_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		add(info_panel);
		
		createButtonPanel();
		
	    animationThread = new Thread(this);
	    animationThread.start();

	}
	
	private void createButtonPanel() {
		
		button_panel = new JPanel();
		button_panel.setLayout(null);
		button_panel.setBounds(0, 0, 6 * GamePanel.INSET_WIDTH + 2 * GamePanel.INDENTATION, 
				GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION);
		
		JButton button = new JButton("Garage");
		button.setBounds(GamePanel.INDENTATION, GamePanel.INDENTATION, GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("garage");
		button.setEnabled(false);
		buttons.put("garage", button);
		button_panel.add(button);
		
		button = new JButton("Staff");
		button.setBounds(GamePanel.INDENTATION + GamePanel.INSET_WIDTH, 
				GamePanel.INDENTATION, GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("staff");
		buttons.put("staff", button);
		button_panel.add(button);
		
		button = new JButton("Cars");
		button.setBounds( GamePanel.INDENTATION + 2 * GamePanel.INSET_WIDTH, GamePanel.INDENTATION, 
				GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("cars");
		buttons.put("cars", button);
		button_panel.add(button);
		
		
		button = new JButton("Buy");
		button.setBounds(GamePanel.INDENTATION + 3 * GamePanel.INSET_WIDTH, 
				GamePanel.INDENTATION, GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("spares");
		buttons.put("spares", button);
		button_panel.add(button);
		
		button = new JButton("Repair");
		button.setBounds(GamePanel.INDENTATION + 4 * GamePanel.INSET_WIDTH, 
				GamePanel.INDENTATION, GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("repair");
		buttons.put("repair", button);
		button_panel.add(button);
		
		button = new JButton("Sale");
		button.setBounds(GamePanel.INDENTATION + 5 * GamePanel.INSET_WIDTH, 
				GamePanel.INDENTATION, GamePanel.INSET_WIDTH, GamePanel.INSET_HEIGHT);
		button.addActionListener(this);
		button.setActionCommand("sale");
		buttons.put("sale", button);
		button_panel.add(button);
		

		button_panel.setBackground(Color.DARK_GRAY);
		button_panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
	
		

		add(button_panel);
	}

	@Override
	public void run() {
		
		long time = System.currentTimeMillis();
	    
		while (true) {
	

			update();
			
			try {
				
				time += animationDelay;
				Thread.sleep(Math.max(0,time - System.currentTimeMillis()));
				
			}catch (InterruptedException e) {
				System.out.println(e);
				
			}
			
		}
		
	}
	
	private void update() {
		
		if(current_panel != null) {
			current_panel.repaint();
			current_panel.update();
		}
		info_panel.repaint();
		info_panel.update();
		
	}
	
	
	public void showGaragePanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("garage").setEnabled(false);
		
		buttons.get("staff").setEnabled(true);
		buttons.get("cars").setEnabled(true);
		buttons.get("spares").setEnabled(true);
		buttons.get("repair").setEnabled(true);
		buttons.get("sale").setEnabled(true);
		
		if(garage_panel == null) {
			garage_panel = new GaragePanel(game);
			garage_panel.setLayout(null);
			garage_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = garage_panel;
		add(garage_panel);
		repaint();
	}
	
	
	public void showStaffPanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("staff").setEnabled(false);
	
		buttons.get("garage").setEnabled(true);
		buttons.get("cars").setEnabled(true);
		buttons.get("spares").setEnabled(true);
		buttons.get("repair").setEnabled(true);
		buttons.get("sale").setEnabled(true);
		
		if(staff_panel == null) {
			staff_panel = new StaffPanel(game);
			staff_panel.setLayout(null);
			staff_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = staff_panel;
		add(staff_panel);
		repaint();
	}
	
	public void showCarsPanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("cars").setEnabled(false);
	
		buttons.get("garage").setEnabled(true);
		buttons.get("staff").setEnabled(true);
		buttons.get("spares").setEnabled(true);
		buttons.get("repair").setEnabled(true);
		buttons.get("sale").setEnabled(true);
		
		if(cars_panel == null) {
			cars_panel = new CarsPanel(game);
			cars_panel.setLayout(null);
			cars_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = cars_panel;
		add(cars_panel);
		repaint();
	}
	
	public void showSparesPanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("spares").setEnabled(false);
	
		buttons.get("garage").setEnabled(true);
		buttons.get("staff").setEnabled(true);
		buttons.get("cars").setEnabled(true);
		buttons.get("repair").setEnabled(true);
		
		if(spares_panel == null) {
			spares_panel = new BuyPanel(game);
			spares_panel.setLayout(null);
			spares_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = spares_panel;
		add(spares_panel);
		repaint();
	}
	
	public void showRepairPanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("repair").setEnabled(false);
	
		buttons.get("garage").setEnabled(true);
		buttons.get("staff").setEnabled(true);
		buttons.get("cars").setEnabled(true);
		buttons.get("spares").setEnabled(true);
		buttons.get("sale").setEnabled(true);
		
		if(repair_panel == null) {
			repair_panel = new RepairPanel(game);
			repair_panel.setLayout(null);
			repair_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = repair_panel;
		add(repair_panel, null);
		repaint();
	}
	
	public void showSalePanel() {
		
		if(current_panel != null)
			remove(current_panel);
		
		buttons.get("sale").setEnabled(false);
	
		buttons.get("garage").setEnabled(true);
		buttons.get("staff").setEnabled(true);
		buttons.get("cars").setEnabled(true);
		buttons.get("spares").setEnabled(true);
		buttons.get("repair").setEnabled(true);
		
		if(sale_panel == null) {
			sale_panel = new SalePanel(game);
			sale_panel.setLayout(null);
			sale_panel.setBounds(0, GamePanel.INSET_HEIGHT + 2 * GamePanel.INDENTATION, GamePanel.WIDTH, GamePanel.HEIGHT);

		}
		
		current_panel = sale_panel;
		add(sale_panel);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("garage")) {
			showGaragePanel();
		}
		
		if(event.getActionCommand().equals("staff")) {
			showStaffPanel();
		}
		
		if(event.getActionCommand().equals("cars")) {
			showCarsPanel();
		}
		
		if(event.getActionCommand().equals("spares")) {
			showSparesPanel();
		}
		
		if(event.getActionCommand().equals("repair")) {
			showRepairPanel();
		}
		
		if(event.getActionCommand().equals("sale")) {
			showSalePanel();
		}
		
	}

}
