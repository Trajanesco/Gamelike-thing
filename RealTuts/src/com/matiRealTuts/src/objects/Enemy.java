package com.matiRealTuts.src.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.matiRealTuts.GlobalPosition;
import com.matiRealTuts.MainClass;


public class Enemy extends GlobalPosition {

	private String enemyimg = "/imgs/enemyImg.png";
	int speed = 7;
	
	public Enemy(int x, int y){
		super(x,y);
	}
	
	public void update(){
		x += speed;
		if(x > MainClass.WIDTH - 32){
			speed = -7;
		}
		if(x < 0){
			speed = 7;
		}
	}
	public Rectangle getBounds(){
		 return new Rectangle(x, y, 33, 33);
	 }
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getEnemyImage(), x, y, null);
	}
	
	public Image getEnemyImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(enemyimg));
		return i.getImage();
	}
}
