package rainy2D.element.image;

import java.awt.image.BufferedImage;

/**
 * 构造器：inset
 * 超类：offset
 * 实现了以中心点来实现一切活动
 * 高级类都继承于它
 */
public class ElementImageInset extends ElementImageOffset {

    public ElementImageInset(double x, double y, int width, int height, BufferedImage img) {

        super(x -(float) width / 2, y -(float) height / 2, width, height, img);

    }

    public ElementImageInset(int width, int height, BufferedImage img) {

        super(-(float) width / 2, -(float) height / 2, width, height, img);

    }

}
