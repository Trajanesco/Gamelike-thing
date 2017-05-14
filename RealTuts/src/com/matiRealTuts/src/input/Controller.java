package com.matiRealTuts.src.input;

import java.awt.Graphics2D;
import java.util.LinkedList;

import com.matiRealTuts.src.objects.Enemy;

public class Controller {

	static LinkedList<Enemy> e = new LinkedList<Enemy>();
	Enemy TempEnemy;
	
	public Controller(){
		addEnemy(new Enemy(100, 100));
		addEnemy(new Enemy(80, 300));
		addEnemy(new Enemy(300, 200));
		addEnemy(new Enemy(300, 100));
		addEnemy(new Enemy(200, 70));
	}
	
	public void draw(Graphics2D g2d){
		for(int i = 0; i < e.size(); i++){
			TempEnemy = e.get(i);
			TempEnemy.draw(g2d);
		}
		
	}
	public void update(){
		for(int i = 0; i < e.size(); i++){
			TempEnemy = e.get(i);
			TempEnemy.update();
		}		
	}
	public void addEnemy(Enemy enemy){
		e.add(enemy);
	}
	public void removeEnemy(Enemy enemy){
		e.remove(enemy);
	}
	public static LinkedList<Enemy> getEnemyBounds(){
		return e;
	}
	
}
