import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI extends JPanel implements ActionListener {
	
	private JPanel _north, _east, _south, _west, _center;
	private JLabel _kund, _fNamn, _eNamn, _alder, _empty1, _empty2, _empty3, _empty4, _iButik, _iKo1, _iKo2, _flytta;
	private JTextField _fText, _eText, _aText;
	private JButton _skapa, _ko1, _ko2, _betjana, _taBort;
	private JOptionPane _taBortAlert;
	private JList _allaKunder,_listKo1, _listKo2;
	private String _strAlder;
	private Memory _memory;
	
	public GUI(){
		super(new BorderLayout());
		_memory = new Memory();
		
		_north = new JPanel();
		_north.setBackground(Color.LIGHT_GRAY);
		_north.setLayout(new GridLayout(3,4));
		createNorth();
		
		_center = new JPanel();
		_center.setBackground(Color.LIGHT_GRAY);
		_center.setLayout(new GridLayout(2,3));
		createCenter();
		
		_south = new JPanel();
		_south.setBackground(Color.LIGHT_GRAY);
		createSouth();
		
		this.add(_north, BorderLayout.NORTH);
		this.add(_center, BorderLayout.CENTER);
		this.add(_south, BorderLayout.SOUTH);
	}
	
	private void createNorth(){
		_kund = new JLabel("Skapa kund");
		_empty1 = new JLabel();
		_empty2 = new JLabel();
		_empty3 = new JLabel();
		_empty4 = new JLabel();
		_fNamn = new JLabel("Förnamn");
		_eNamn = new JLabel("Efternamn");
		_alder = new JLabel("Ålder");
		
		_fText = new JTextField(10);
		_eText = new JTextField(20);
		_aText = new JTextField(3);
		
		_skapa = new JButton("Skapa kund");
		_skapa.addActionListener(this);
		
		_north.add(_kund);
		_north.add(_empty1);
		_north.add(_empty2);
		_north.add(_empty3);
		_north.add(_fNamn);
		_north.add(_eNamn);
		_north.add(_alder);
		_north.add(_empty4);
		_north.add(_fText);
		_north.add(_eText);
		_north.add(_aText);
		_north.add(_skapa);
	}
	
	private void createCenter(){
		_iButik = new JLabel("I Butik");
		_iKo1 = new JLabel("I kö 1:");
		_iKo2 = new JLabel("I kö 2:");
		
		_allaKunder = new JList();
		_listKo1 = new JList();
		_listKo2 = new JList();
		
		_allaKunder.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		_listKo1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		_listKo2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		_center.add(_iButik);
		_center.add(_iKo1);
		_center.add(_iKo2);
		_center.add(_allaKunder);
		_center.add(_listKo1);
		_center.add(_listKo2);
	}
	
	private void createSouth(){
		_flytta = new JLabel("Flytta till:");
		
		_ko1 = new JButton("Kö 1");
		_ko2 = new JButton("Kö 2");
		_betjana = new JButton("Betjäna");
		_taBort = new JButton("Ta bort kund.");
		
		_south.add(_flytta);
		_south.add(_ko1);
		_south.add(_ko2);
		_south.add(_betjana);
		_south.add(_taBort);
		
		_ko1.addActionListener(this);
		_ko2.addActionListener(this);
		_betjana.addActionListener(this);
		_taBort.addActionListener(this);
		
		_south.setAlignmentX(LEFT_ALIGNMENT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==_skapa){
			if(_memory.checkAlder(_aText.getText())==true){
				_memory.createPerson(_fText.getText(),_eText.getText(),_aText.getText());
				_fText.setText("");
				_eText.setText("");
				_aText.setText("");
			}
			
		}
		
		else if(e.getSource()==_ko1){
			System.out.println("Kö1");
		}
		
		else if(e.getSource()==_ko2){
			System.out.println("Kö2");
		}
		
		else if(e.getSource()==_betjana){
			System.out.println("Betjäna");
		}
		
		else if(e.getSource()==_taBort){
			System.out.println("Test");
			_taBortAlert = new JOptionPane();
			Object[] options = {"Nej",
                    "Ja"};
			int n = JOptionPane.showOptionDialog(_taBortAlert,
					"Vill du verkligen ta bort kunden?",
							"Ta bort kund",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.OK_CANCEL_OPTION,
							null,
							options,
							options[1]);
		}
	}
	
	
}
