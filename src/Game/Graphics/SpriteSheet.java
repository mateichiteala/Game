package Game.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private final BufferedImage spriteSheet;
    private static final int    titleWidth=48;
    private static final int    titleHeight=48;

    public SpriteSheet(BufferedImage buffImg){
        spriteSheet=buffImg;
    }

    public BufferedImage crop(int x,int y){
        return spriteSheet.getSubimage(x* titleWidth,y*titleHeight,titleWidth,titleWidth);
    }
    public BufferedImage crop2(int x,int y){ return spriteSheet;}
}
