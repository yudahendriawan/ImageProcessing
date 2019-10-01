/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop.grayscalling;

import crop.Crop;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GrayScale {

   BufferedImage  image;
   int width;
   int height;
   
   public static void displayImage(Image img, String title) {
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(img.getWidth(null) + 50, img.getHeight(null) + 50);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
    }
   
   public GrayScale() {
       
   
      try {
         //File input = new File("Cat.jpg");
         image = ImageIO.read(GrayScale.class.getResource("Cat.jpg"));
        // image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         
         for(int i=0; i<height; i++) {
         
            for(int j=0; j<width; j++) {
            
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() * 0.3);
               int green = (int)(c.getGreen() * 0.3);
               int blue = (int)(c.getBlue() *0.3);
               Color newColor = new Color(red+green+blue,
               red+green+blue,red+green+blue);     
               image.setRGB(j,i,newColor.getRGB());
            }
         }
//         File ouptut = new File("grayscale.jpg");
//         ImageIO.write(image, "jpg", ouptut);
         
         displayImage(image,"judul");
         
      } catch (Exception e) {}
      
      //displayImage(image,"judul");
   }
   
   static public void main(String args[]) throws Exception {
      GrayScale obj = new GrayScale();
     
   }
}
