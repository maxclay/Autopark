package com.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

import com.abstractfactory.FordCompany;
import com.abstractfactory.HondaCompany;
import com.abstractfactory.VolkswagenCompany;
import com.main.Game;
import com.main.resource.Resource;
import com.strategy.UsedCar;
import com.strategy.UsedMotorbike;
import com.strategy.UsedTruck;

public class CarsPanel extends Panel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Game game;
	
	private boolean accord;
	private boolean hrv;
	private boolean golf;
	private boolean tiguan;
	private boolean focus;
	private boolean escape;
	
	private boolean used_car;
	private boolean used_bike;
	private boolean used_truck;
	
	private Image accord_img;
	private Image hrv_img;
	private Image golf_img;
	private Image tiguan_img;
	private Image focus_img;
	private Image escape_img;
	
	private Image used_car_img;
	private Image used_bike_img;
	private Image used_truck_img;
	
	private JButton buy_button;
	private JLabel info_label;
	private JLabel used_label;
	
	private VolkswagenCompany volkswagen_cmp;
	private FordCompany ford_cmp;
	private HondaCompany honda_cmp;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CarsPanel(Game game) {
		this.game = game;
		
		volkswagen_cmp = new VolkswagenCompany();
		ford_cmp = new FordCompany();
		honda_cmp = new HondaCompany();
		
		accord = false;
		hrv = false;
		golf = false;
		tiguan = false;
		focus = false;
		escape = false;
		
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		accord_img = Resource.getImage("accord_img");
		hrv_img = Resource.getImage("hrv_img");
		golf_img = Resource.getImage("golf_img");
		tiguan_img = Resource.getImage("tiguan_img");
		escape_img = Resource.getImage("escape_img");
		focus_img = Resource.getImage("focus_img");
		
		
		used_car_img = Resource.getImage("used_car_img");
		used_bike_img = Resource.getImage("used_bike_img");
		used_truck_img = Resource.getImage("used_truck_img");
		
		setLayout(null);
		
		JLabel label = new JLabel("Volkswagen:");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setForeground(Color.white);
		label.setBounds(10, 10, 120, 40);
		add(label);
		
		String[] vlksw_names = new String[2];
		vlksw_names[0] = "Golf";
		vlksw_names[1] = "Tiguan";
		
		JList list = new JList(vlksw_names);
		
		list.setBounds(10, 60, 120, 60);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		list.setBorder(loweredetched);
		
		add(list);
		
		label = new JLabel("Ford:");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setForeground(Color.white);
		label.setBounds(10, 130, 120, 40);
		add(label);
		
		String[] ford_names = new String[2];
		ford_names[0] = "Focus";
		ford_names[1] = "Escape";
		
		JList ford = new JList(ford_names);
		
		ford.setBounds(10, 180, 120, 60);
		
		ford.setBackground(Color.DARK_GRAY);
		ford.setForeground(Color.WHITE);
		ford.setBorder(loweredetched);
		
		add(ford);
		
		label = new JLabel("Honda:");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setForeground(Color.white);
		label.setBounds(10, 250, 120, 40);
		add(label);
		
		String[] honda_names = new String[2];
		honda_names[0] = "Accord";
		honda_names[1] = "HR-V";
		
		JList honda = new JList(honda_names);
		
		honda.setBounds(10, 300, 120, 60);
		honda.setBackground(Color.DARK_GRAY);
		honda.setForeground(Color.WHITE);
		honda.setBorder(loweredetched);
		
		add(honda);
		
		label = new JLabel("Used:");
		label.setForeground(Color.white);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(715, 10, 120, 40);
		add(label);
		
		String[] used_names = new String[3];
		used_names[0] = "Motorbike";
		used_names[1] = "Car";
		used_names[2] = "Truck";
		
		JList used = new JList(used_names);
		
		used.setBounds(715, 60, 120, 58);
		used.setBackground(Color.DARK_GRAY);
		used.setForeground(Color.WHITE);
		used.setBorder(loweredetched);
		add(used);
		
		used.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting() && used.getSelectedValue() != null ) {
					if(used.getSelectedValue().equals("Motorbike")) {
						showUsedBike();
					}
					
					if(used.getSelectedValue().equals("Car")) {
						showUsedCar();
					}
					
					if(used.getSelectedValue() != null && used.getSelectedValue().equals("Truck")) {
						showUsedTruck();
					}
					list.clearSelection();
					ford.clearSelection();
					honda.clearSelection();
				}
				
			}
        });
		
		honda.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting() && honda.getSelectedValue() != null ) {
					if(honda.getSelectedValue().equals("Accord")) {
						showAccord();
					}
					
					if(honda.getSelectedValue().equals("HR-V")) {
						showHRV();
					}
					list.clearSelection();
					ford.clearSelection();
					used.clearSelection();
				}
				
			}
        });
		
		ford.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting() && ford.getSelectedValue() != null ) {
					if(ford.getSelectedValue().equals("Focus")) {
						showFocus();
					}
					
					if(ford.getSelectedValue().equals("Escape")) {
						showEscape();
					}
					list.clearSelection();
					honda.clearSelection();
					used.clearSelection();
				}
				
			}
        });
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				if(!event.getValueIsAdjusting() && list.getSelectedValue() != null ) {
					
					if(list.getSelectedValue().equals("Golf")) {
						showGolf();
					}
					
					if(list.getSelectedValue().equals("Tiguan")) {
						showTiguan();
					}
					honda.clearSelection();
					ford.clearSelection();
					used.clearSelection();
				}
				
			}
        });
		
	}
	
	protected void showUsedTruck() {
		
		tiguan = false;
		accord = false;
		escape = false;
		golf = false;
		hrv = false;
		focus = false;
		
		used_car = false;
		used_bike = false;
		used_truck = true;
		
		if(used_label == null) {
			used_label = new JLabel("USED CAR");
			used_label.setBounds(180, 30, 220, 20);
			used_label.setFont(new Font("Dialog", Font.BOLD, 18));
			used_label.setForeground(Color.red);
			add(used_label);
		}
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 80);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Isuzu NQR <br>Graduation Year: 2000"
				+ "<br>Cost: 17000$</html>");
		

		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("used_truck");
		
	}

	protected void showUsedBike() {
		
		tiguan = false;
		accord = false;
		escape = false;
		golf = false;
		hrv = false;
		focus = false;
		
		used_car = false;
		used_bike = true;
		used_truck = false;
		
		if(used_label == null) {
			used_label = new JLabel("USED CAR");
			used_label.setBounds(180, 30, 220, 20);
			used_label.setFont(new Font("Dialog", Font.BOLD, 18));
			used_label.setForeground(Color.red);
			add(used_label);
		}
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 80);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Yamaha YBR-250 <br>Graduation Year: 2000"
				+ "<br>Cost: 3000$</html>");
		

		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("used_bike");
		
	}

	protected void showUsedCar() {
		
		tiguan = false;
		accord = false;
		escape = false;
		golf = false;
		hrv = false;
		focus = false;
		
		used_car = true;
		used_bike = false;
		used_truck = false;
		
		if(used_label == null) {
			used_label = new JLabel("USED CAR");
			used_label.setBounds(180, 30, 220, 20);
			used_label.setFont(new Font("Dialog", Font.BOLD, 18));
			used_label.setForeground(Color.red);
			add(used_label);
		}
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 80);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Opel Vectra <br>Graduation Year: 2000"
				+ "<br>Cost: 14000$</html>");
		

		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("used_car");
		
	}

	protected void showTiguan() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		tiguan = true;
		
		accord = false;
		escape = false;
		golf = false;
		hrv = false;
		focus = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Volkswagen Tiguan <br>Graduation Year: 2013"
				+ "<br>Cost: 240000$</html>");
		

		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("tiguan");
		
	}

	protected void showGolf() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		golf = true;
		
		accord = false;
		escape = false;
		tiguan = false;
		hrv = false;
		focus = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Volkswagen Golf <br>Graduation Year: 2001"
				+ "<br>Cost: 170000$</html>");
		
		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("golf");
		
	}

	protected void showEscape() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		escape = true;
		
		accord = false;
		golf = false;
		tiguan = false;
		hrv = false;
		focus = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Ford Escape <br>Graduation Year: 2013"
				+ "<br>Cost: 150000$</html>");
		
		
		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("escape");

		
	}

	protected void showFocus() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		focus = true;
		
		accord = false;
		golf = false;
		tiguan = false;
		hrv = false;
		escape = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Ford Focus <br>Graduation Year: 2012"
				+ "<br>Cost: 130000$</html>");
		
		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("focus");
		
	}

	protected void showHRV() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		hrv = true;
		
		accord = false;
		golf = false;
		tiguan = false;
		focus = false;
		escape = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Honda HR-V <br>Graduation Year: 2013"
				+ "<br>Cost: 200000$</html>");
		
		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("hrv");
		
	}

	protected void showAccord() {
		
		if(used_label != null) {
			remove(used_label);
			repaint();
			used_label = null;
		}
		
		accord = true;
		
		hrv = false;
		golf = false;
		tiguan = false;
		focus = false;
		escape = false;
		used_car = false;
		used_bike = false;
		used_truck = false;
		
		if(info_label == null) {
			info_label = new JLabel();
			info_label.setBounds(180, 60, 220, 50);
			info_label.setFont(new Font("Dialog", Font.BOLD, 14));
			info_label.setForeground(Color.white);
			add(info_label);
		}
		
		info_label.setText("<html>Name: Honda Accord <br>Graduation Year: 2012"
				+ "<br>Cost: 120000$</html>");
		
		if(buy_button == null) {
			buy_button = new JButton("Buy");
			buy_button.setBounds(180, 180, 120, 40);
			buy_button.addActionListener(this);
			add(buy_button);
		}
		
		buy_button.setActionCommand("accord");
		
	}

	public void update() {

		game.update();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		if(game.getGasStation() != null)
			game.getGasStation().render(g);

		
		if(accord)
			g.drawImage(accord_img, 340, 140, null);
		if(hrv)
			g.drawImage(hrv_img, 285, 75, null);
		if(golf)
			g.drawImage(golf_img, 340, 150, null);
		if(tiguan)
			g.drawImage(tiguan_img, 340, 140, null);
		if(focus)
			g.drawImage(focus_img, 350, 155, null);
		if(escape)
			g.drawImage(escape_img, 340, 140, null);
		
		if(used_car)
			g.drawImage(used_car_img, 320, 200, null);
		if(used_bike)
			g.drawImage(used_bike_img, 430, 190, null);
		if(used_truck)
			g.drawImage(used_truck_img, 340, 50, null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getActionCommand().equals("accord")) {
			
			
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 120000) {
					game.setMoney(game.getMoney() - 120000);
					game.addNewCar(honda_cmp.getCar());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("hrv")) {
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 200000) {
					game.setMoney(game.getMoney() - 200000);	
					game.addNewCar(honda_cmp.getJeep());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("golf")) {
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 170000) {
					game.setMoney(game.getMoney() - 170000);
					game.addNewCar(volkswagen_cmp.getCar());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("tiguan")) {
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 240000) {
					game.setMoney(game.getMoney() - 240000);
					game.addNewCar(volkswagen_cmp.getJeep());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("focus")) {
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 130000) {
					game.setMoney(game.getMoney() - 130000);
					game.addNewCar(ford_cmp.getCar());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("escape")) {
			if(game.getNewCars() == null || (game.getNewCars() != null && game.getNewCars().size() < 20 )) {
				if(game.getMoney() >= 150000) {
					game.setMoney(game.getMoney() - 150000);
					game.addNewCar(ford_cmp.getJeep());
					GaragePanel.updateNewCarList();
					SalePanel.updateNewCarList();
				}
			}
		}
		
		if(event.getActionCommand().equals("used_car")) {
			
			RepairPanel.updateUsedCarList();
			GaragePanel.updateUsedCarList();
			
			int size = 0;
			if(game.getUsedCars() != null)
				size += game.getUsedCars().size();
			
			if(game.getRepairedCars() != null)
				size += game.getRepairedCars().size();
			
			if(size < 20) {
				if(game.getMoney() >= 14000) {
					game.setMoney(game.getMoney() - 14000);
					game.addUsedCar(new UsedCar());
				}
			}
			
		}
		
		if(event.getActionCommand().equals("used_bike")) {
			
			RepairPanel.updateUsedCarList();
			GaragePanel.updateUsedCarList();
			
			int size = 0;
			if(game.getUsedCars() != null)
				size += game.getUsedCars().size();
			
			if(game.getRepairedCars() != null)
				size += game.getRepairedCars().size();
			
			if(size < 20) {
				if(game.getMoney() >= 3000) {
					game.setMoney(game.getMoney() - 3000);
					game.addUsedCar(new UsedMotorbike());
				}
			}
		}
		
		if(event.getActionCommand().equals("used_truck")) {
			
			RepairPanel.updateUsedCarList();
			GaragePanel.updateUsedCarList();
			
			int size = 0;
			if(game.getUsedCars() != null)
				size += game.getUsedCars().size();
			
			if(game.getRepairedCars() != null)
				size += game.getRepairedCars().size();
			
			if(size < 20) {
				if(game.getMoney() >= 17000) {
					game.setMoney(game.getMoney() - 17000);
					game.addUsedCar(new UsedTruck());
				}
			}
		}
	}

}
