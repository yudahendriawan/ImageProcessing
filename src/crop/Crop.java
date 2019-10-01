/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crop;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class Crop {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        BufferedImage originalImage = ImageIO.read(Crop.class.getResource("Cat.jpg"));
        Image image = cropImage(originalImage, 150, 150, 600, 600);
        //  BufferedImage crop = new Crop().crop(0.5);
        //  System.out.println(crop.getWidth() + "x" + crop.getHeight());
       // ImageIO.write(image, "jpg", new File("C:\\Users\\dell\\Documents\\NetBeansProjects\\Crop\\src\\crop\\anjing100.jpg"));
        displayImage(image,"Hasil");
//        System.out.println("Crop Berhasil");
//        System.out.println("Tampilkan Gambar\n1.Ya\t2.Tidak");
//
//        int masukkanAngka = input.nextInt();
//
//        if (masukkanAngka == 1) {
//            BufferedImage imageHasil = ImageIO.read(Crop.class.getResource("anjing100.jpg"));
//            displayImage(imageHasil, "image");
//        } else {
//            System.out.println("OKE");
//        }
    }

    /**
     * Crops an image to the specified region
     *
     * @param bufferedImage the image that will be crop
     * @param x the upper left x coordinate that this region will start
     * @param y the upper left y coordinate that this region will start
     * @param width the width of the region that will be crop
     * @param height the height of the region that will be crop
     * @return the image that was cropped.
     */
    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height) {
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

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

//    public BufferedImage crop(double amount) throws IOException {
//        BufferedImage originalImage = ImageIO.read(Crop.class.getResource("Cat.jpg"));
//        int height = originalImage.getHeight();
//        int width = originalImage.getWidth();
//
//        int targetWidth = (int)(width * amount);
//        int targetHeight = (int)(height * amount);
//        // Coordinates of the image's middle
//        int xc = (width - targetWidth) / 2;
//        int yc = (height - targetHeight) / 2;
//
//        // Crop
//        BufferedImage croppedImage = originalImage.getSubimage(
//                        xc, 
//                        yc,
//                        targetWidth, // widht
//                        targetHeight // height
//        );
//        return croppedImage;
//    }
}
