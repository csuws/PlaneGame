package com.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.util.Constant;

public class Bullet extends GameObject{

	private double degree;
	private static boolean gameLive = false;
	
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		if(gameLive) {
			x += speed*Math.cos(degree);
			y += speed*Math.sin(degree);
		}
		//x += speed*Math.cos(degree);
		//y += speed*Math.sin(degree);
		
		if(y>Constant.GAME_HEIGHT-height||y<30) {
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}
		g.setColor(c);

	}
	public boolean isGameLive() {
		return gameLive;
	}
	static public void setGameLive(boolean gameLive) {
		Bullet.gameLive = gameLive;
	}
	public Bullet() {
		gameLive = true;
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		speed = (int) (Math.random()*10)+1;
		width = 10;
		height = 10;
	}
}
