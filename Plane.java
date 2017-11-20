package com.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.util.GameUtil;

public class Plane extends GameObject{
	
	private boolean left,up,right,down;
	
	private boolean live = false;
	
	
	public void draw(Graphics g) {
		// TODO 自动生成的方法存根
		if(live) {
		g.drawImage(img, (int)x, (int)y, null);
		move();
		}
	}

	public Plane(String imgpath, double x, double y) {
		super();
		live = true;
		this.img = GameUtil.getImage(imgpath);
		this.width = 30;
		this.height = 30;
		this.x = x;
		this.y = y;
		this.speed = 10;
	}

	public Plane() {
		
	}
	
	public void move() {
		
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	public void startMove(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;

		default:
			break;
		}
		
	}
	
	public void stopMove(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;

		default:
			break;
		}
		
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
