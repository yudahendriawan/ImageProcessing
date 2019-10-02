/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphaTest;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @see https://stackoverflow.com/questions/5838842
 * @see https://stackoverflow.com/questions/5864490
 */
public class AlphaTest {

    private static void display() throws IOException {
        JFrame f = new JFrame("AlphaTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BufferedImage image = ImageIO.read(AlphaTest.class.getResource("Cat.jpg"));
        //BufferedImage image = new BufferedImage()
       // ImageIcon icon = new ImageIcon("image.jpg");
        final AlphaPanel ip = new AlphaPanel(image, 0.75);
        final JSlider slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int v = slider.getValue();
                ip.setAlpha((float) v / slider.getMaximum());
                ip.repaint();
            }
        });
        f.add(ip, BorderLayout.CENTER);
        f.add(slider, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        AlphaTest alpha = new AlphaTest();
            @Override
            public void run() {
            try {
                alpha.display();
            } catch (IOException ex) {
                Logger.getLogger(AlphaTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
    }
}

class AlphaPanel extends JPanel {

    private BufferedImage bi;
    private float[] scales = {1f, 1f, 1f, 0.5f};
    private float[] offsets = new float[4];
    private RescaleOp rop;

    public AlphaPanel(BufferedImage icon, double scale) {

        int width = (int) (scale * icon.getWidth());
        int height = (int) (scale * icon.getHeight());
        this.setPreferredSize(new Dimension(width, height));
        this.bi = new BufferedImage(
            width, height, BufferedImage.TYPE_INT_ARGB);
        this.bi.createGraphics().drawImage(
            icon, 0, 0, width, height, null);
        rop = new RescaleOp(scales, offsets, null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bi, rop, 0, 0);
    }

    public void setAlpha(float alpha) {
        this.scales[3] = alpha;
        this.rop = new RescaleOp(scales, offsets, null);
    }
}
