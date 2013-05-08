import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JPanel implements ActionListener {
	
	private JPanel _north, _south, _center;
	private JLabel _kund, _fNamn, _eNamn, _alder, _empty1, _empty2, _empty3, _empty4, _iButik, _iKo1, _iKo2, _flytta;
	private JTextField _fText, _eText, _aText;
	private JButton _skapa, _ko1, _ko2, _betjana1, _betjana2;
	private JList _allaKunder,_listKo1, _listKo2;
	private Affär _affär;
	private Kö _defAlla, _defKo1, _defKo2;
	
	public GUI(){
		super(new BorderLayout());
		_defAlla = new Kö();
		_defKo1 = new Kö();
		_defKo2 = new Kö();
		
		_affär = new Affär(_defAlla, _defKo1, _defKo2);
		
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
		
		_allaKunder = new JList(_defAlla.getList());
		_listKo1 = new JList(_defKo1.getList());
		_listKo2 = new JList(_defKo2.getList());
		
		_allaKunder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_listKo1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_listKo2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
		_betjana1 = new JButton("Betj. Kassa 1.");
		_betjana2 = new JButton("Betj. Kassa 2.");
		
		_south.add(_flytta);
		_south.add(_ko1);
		_south.add(_ko2);
		_south.add(_betjana1);
		_south.add(_betjana2);
		
		_ko1.addActionListener(this);
		_ko2.addActionListener(this);
		_betjana1.addActionListener(this);
		_betjana2.addActionListener(this);
		
		_south.setAlignmentX(LEFT_ALIGNMENT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==_skapa){
			if(_affär.checkAlder(_aText.getText())==true){
				_affär.createPerson(_fText.getText(),_eText.getText(),_aText.getText());
				_fText.setText("");
				_eText.setText("");
				_aText.setText("");
			}
			
		}
		
		else if(e.getSource()==_ko1){
			if(_allaKunder.isSelectionEmpty() == false)
				_affär.moveToQueue1(_allaKunder.getSelectedValue());
				_allaKunder.clearSelection();
		}
		
		else if(e.getSource()==_ko2){
			if(_allaKunder.isSelectionEmpty() == false){
			_affär.moveToQueue2(_allaKunder.getSelectedValue());
			_allaKunder.clearSelection();
			}
		}
		
		else if(e.getSource()==_betjana1)
			_affär.serveQueue1(_ko1.getSelectedObjects());
		
		else if(e.getSource()==_betjana2)
			_affär.serveQueue2(_ko1.getSelectedObjects());
	}
	
	
}
