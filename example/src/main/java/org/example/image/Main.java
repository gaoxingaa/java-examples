package org.example.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Main implements ImageObserver {
    private BufferedImage newImage;
    private BufferedImage imageA;
    private BufferedImage imageB;

    public void init() {
        try {
            this.imageA = ImageIO.read(new File("C:\\LargeImage.jpg"));
            this.imageB = ImageIO.read(new File("C:\\SmallImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void paint(Graphics g) {
        Graphics2D w = (Graphics2D) g;
        w.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        w.drawImage(this.imageA, 0, 0, 50, 50, this);// This takes a while to do (scaling down and drawing)...
        w.drawImage(this.imageB, 10, 10, null);// While this is drawn quickly, before A is done.

    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        System.out.println("ImageObserver fired, done drawing image.  NEVER CALLED!");
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();


    }
}