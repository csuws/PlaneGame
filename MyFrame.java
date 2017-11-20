package com.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.plane.Plane;


public class MyFrame extends Frame{
	
	
	
	/**
	 * ���ش���
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(60, 30);
		setVisible(true);
		
		
		new PaintThread().start();  //�����ػ��߳�  
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private Image offScreenImages = null; 		//����˫���弼�������˸
	public void update(Graphics g) {
		if(offScreenImages == null)
			offScreenImages = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImages.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImages, 0, 0, null);
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ��ࡣ
	 * @author 10235
	 *
	 */
	class PaintThread extends Thread{
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}


}
