package com.matiRealTuts;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.matiRealTuts.src.input.Controller;
import com.matiRealTuts.src.input.KeyInput;
import com.matiRealTuts.src.objects.Player;



public class Game extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Timer gameloopTimer;
	Player p;
	Controller c;
	private String background = "/imgs/background.png";
	
	public Game(){
		setFocusable(true);
		gameloopTimer = new Timer(10, this);
		gameloopTimer.start();
		p = new Player(100, 100);
		c = new Controller();
		addKeyListener(new KeyInput(p));
		
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getBackgroundImage(),0,0,null);
		p.draw(g2d);
		c.draw(g2d);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		p.update();
		c.update();
	}
	
	public Image getBackgroundImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
	}
	
	
}
