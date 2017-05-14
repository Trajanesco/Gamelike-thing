package com.matiRealTuts.src.objects;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.matiRealTuts.GlobalPosition;
import com.matiRealTuts.src.input.Controller;

//import com.matiRealTuts.src.input.KeyInput;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class Player extends GlobalPosition {
	private String playerImage = "/imgs/playerImg.png";
	int velX = 0;
	int velY = 0;
	private LinkedList<Enemy> e = Controller.getEnemyBounds();
	int j = 0;
	
	public Player(int x, int y){
		super (x, y);
		
	}
	
	public void update(){
		x += velX;
		y += velY;
		
		if(x < 1){
			x = 0;
		}
		if(y < 1){
			y = 0;
		}
		if(x > 604){
			x = 604;
		}
		if(y > 420){
			y = 420;
		}
		Collision();
		
		
	}
	public void Collision(){
		
		for(int i = 0; i < e.size(); i++){
			
			if(getBounds().intersects(e.get(i).getBounds())){
				
				
				System.out.println("COLLISION NUMBER ");
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			this.velX = 4;
		}else if(key==KeyEvent.VK_LEFT){
			this.velX = -4;
		}else if(key == KeyEvent.VK_DOWN){
			this.velY = 4;
		}else if(key==KeyEvent.VK_UP){
			this.velY = -4;
		}
	}
	
	 public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			this.velX = 0;
		}else if(key==KeyEvent.VK_LEFT){
			this.velX = 0;
		}else if(key == KeyEvent.VK_DOWN){
			this.velY = 0;
		}else if(key==KeyEvent.VK_UP){
			this.velY = 0;
		}
	}
	 public Rectangle getBounds(){
		 return new Rectangle(x, y, 33, 33);
	 }

	public void draw(Graphics2D g2d){
		g2d.drawImage(getPlayerImage(), x, y, null);
	}
	
	public Image getPlayerImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
	}
}
