package app;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public final class ImageLoader {
    private ImageLoader() {
    }

    public static ImageIcon createScaledIcon(String imagePath, int newHeight) {
        URL imageUrl = ImageLoader.class.getResource(imagePath);
        if (imageUrl == null) {
            throw new IllegalArgumentException("画像が見つかりません: " + imagePath);
        }

        ImageIcon icon = new ImageIcon(imageUrl);
        int originalWidth = icon.getIconWidth();
        int originalHeight = icon.getIconHeight();
        int newWidth = originalWidth * newHeight / originalHeight;
        Image scaledImg = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
