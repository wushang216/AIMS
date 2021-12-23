package com.chang.entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
public class createVCode {
    private static final int WIDTH = 120;
    private static final int HEIGHT = 50;
    //可选字符
    private static final String str = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXVZ";
    private static String text;

    //调用该方法获得验证码
    public BufferedImage getImage(){
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        StringBuilder stringBuffer = new StringBuilder();
        drawLines(image);
        for (int i = 0; i < 7; i++) {
            String s = getVCode()+"";
            stringBuffer.append(s);
            //设置字的x、y的坐标
            float x = i * 1.0F * WIDTH/7;
            g2.setFont(getFont());
            g2.setColor(getColor());
            g2.drawString(s,x,HEIGHT-5);
        }
        text = stringBuffer.toString();
        return image;
    }

    //创建BufferImage
    private static BufferedImage createImage(){
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        g2.setColor(new Color(255,255,255));
        g2.fillRect(0,0,WIDTH,HEIGHT);
        return image;
    }

    //画干扰线
    private static void drawLines(BufferedImage image){
        int num = 10;
        Random random = new Random();
        Graphics2D g2 = (Graphics2D) image.createGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(WIDTH);
            int x2 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int y2 = random.nextInt(HEIGHT);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1,y1,x2,y2);
        }
    }

    //生成随机色
    private static Color getColor(){
        Random random = new Random();
        return new Color(random.nextInt(150),random.nextInt(150),random.nextInt(150));
    }
    //获取字体
    private static Font getFont(){
        Random random = new Random();
        String[] str = {"微软雅黑","Algerian","Castellar","华文行楷"};
        //生成随即字体
        String font = str[random.nextInt(str.length)];
        //生成样式：0（无样式）、1（粗体）、2（斜体）、3（粗体+斜体）
        int style = random.nextInt(3);
        //生成字体大小24~28
        int size = 24 + random.nextInt(4);
        return new Font("st",style,size);
    }
    //获取验证码
    private static char getVCode(){
        Random random = new Random();
        return str.charAt(random.nextInt(str.length()));
    }
    //保存图片到指定的流中
    public void output(BufferedImage image, OutputStream os) throws IOException {
        ImageIO.write(image,"JPEG",os);
    }
    public String getText(){
        return text;
    }
}
