package com.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

import com.util.Constant;
import com.util.GameUtil;
import com.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane plane = new Plane("images/plane.png",50,50);
	
	ArrayList bulletList = new ArrayList();
	
	Date startTime;
	Date endTime;
	Explode exp;
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
//		exp.draw(g);
		
		for(int i=0;i<bulletList.size();i++) {
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测与飞机的碰撞
			boolean peng = b.getRect().intersects(plane.getRect());
			if(peng) {
				plane.setLive(false); 		//飞机死掉
				Bullet.setGameLive(false);
				endTime = new Date();
				
				
				
//				plane = new Plane();
			}
		}
		
		
		if(!plane.isLive()) {
			if(exp==null) 
				exp = new Explode(plane.x,plane.y);
			exp.draw(g);
			printInfo(g, "GAME OVER", 50,100,200,Color.WHITE,"宋体");
			long period = (endTime.getTime()-startTime.getTime())/1000;
			printInfo(g, "时间"+period+"秒", 10, 120, 260, Color.WHITE, "宋体");		
			plane = new Plane();

		}
		
		
		
//		printInfo(g, "分数：100", 10, 50, 50, Color.YELLOW, "宋体");
		
		
	}
	
	/**
	 * 在窗口上打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color,String font){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font(font,Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
		
	}
	
	
	
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void launchFrame() {
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i=0;i<10;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();

	}
	
	//定义为内部类，可以方便使用外部类的普通属性
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			plane.startMove(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			plane.stopMove(e);
		}
		
		
		
	}

}
