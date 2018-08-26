/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Leo
 */
public class Uiutil {

    private Uiutil() {

    }

    //修改窗体图标
    public static void setFrameImage(JFrame jf) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        //获取图片

        Image i = tk.getImage("src\\resource\\jjcc.jpg");

        jf.setIconImage(i);

    }

    public static void setFrameCenter(JFrame jf) {

        
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        //获取屏幕宽高
        Dimension di = tk.getScreenSize();
        double screenWidth = di.getWidth();
        double screenHeight = di.getHeight();

        //设置新的窗口宽高
       // int frameWidth = (int) (screenWidth) / 2;
        //int frameHeight = (int) (screenHeight) / 2;
//        //获取窗体宽高
       int frameWidth=jf.getWidth();
        int frameHeight=jf.getHeight();
        //设置新的宽高
        int width = (int) (screenWidth - frameWidth) / 2;
        int height = (int) (screenHeight - frameHeight) / 2;

        //jf.setBounds(width, height, frameWidth, frameHeight);
        jf.setLocation(width, height);
        jf.setResizable(false);
        //设置坐标
        //    jf.setLocation(width,height);
    }
}
