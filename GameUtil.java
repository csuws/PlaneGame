package com.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * ��Ϸ������d�����ࣨ���磺����ͼƬ�ȷ�����
 * @author 10235
 *
 */
public class GameUtil {
	public static Image getImage(String path) {
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
//		ImageIcon imge=new ImageIcon(path);
//		Image image=imge.getImage();
//		return image;
		
	}

}
