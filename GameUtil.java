package com.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 游戏开发中d工具类（比如：加载图片等方法）
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
