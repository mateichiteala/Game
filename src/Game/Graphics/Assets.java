package Game.Graphics;

import java.awt.image.BufferedImage;
import java.util.Vector;

/*! \class Assets
    \brief Pastreaza imaginile pentru joc
 */
public class Assets {
    public static BufferedImage         heroLeft;
    public static BufferedImage         heroRight;
    public static BufferedImage         soil;
    public static BufferedImage         grass;
    public static BufferedImage         mountain;
    public static BufferedImage         water;
    public static BufferedImage         tree;
    public static BufferedImage         ladder;
    public static BufferedImage         under;
    public static BufferedImage         stone;
    public static BufferedImage         background;
    public static BufferedImage         background2;
    public static BufferedImage         backgroundDead;
    public static BufferedImage         attack;
    public static BufferedImage         skeleton;
    public static Vector<BufferedImage> runs    = new Vector<BufferedImage>();
    public static Vector<BufferedImage> runsm   = new Vector<BufferedImage>();
    public static Vector<BufferedImage> jumps   = new Vector<BufferedImage>();
    public static Vector<BufferedImage> enemy   = new Vector<BufferedImage>();
    public static Vector<BufferedImage> dead    = new Vector<BufferedImage>();

    /* \fn publoc static void Init()
        \brief Initializeaza si creeaza SpriteSheet-urile pentru joc
     */
    public static void Init(){
        SpriteSheet sheet1  = new SpriteSheet(ImageLoader.LoadImage("/image1/under.png"));
        SpriteSheet sheet2  = new SpriteSheet(ImageLoader.LoadImage("/image3/grass.png"));
        SpriteSheet sheet3  = new SpriteSheet(ImageLoader.LoadImage("/dead/kids_see_ghostx.png"));
        SpriteSheet sheet4  = new SpriteSheet(ImageLoader.LoadImage("/image/Hero.png"));
        SpriteSheet sheet5  = new SpriteSheet(ImageLoader.LoadImage("/image4/ladder.png"));
        SpriteSheet sheet6  = new SpriteSheet(ImageLoader.LoadImage("/image5/stone.png"));
        SpriteSheet sheet8  = new SpriteSheet(ImageLoader.LoadImage("/image6/skeleton.png"));
        SpriteSheet sheet9  = new SpriteSheet(ImageLoader.LoadImage("/dead/Black_Screenx.png"));
        SpriteSheet sheet10 = new SpriteSheet(ImageLoader.LoadImage("/attack_hero/attackx.png"));
        SpriteSheet sheet11 = new SpriteSheet(ImageLoader.LoadImage("/Tree/treex.png"));
        SpriteSheet sheet12 = new SpriteSheet(ImageLoader.LoadImage("/background.png"));

        Vector<SpriteSheet> sheets          = new Vector<SpriteSheet>();
        Vector<SpriteSheet> sheetsm         = new Vector<SpriteSheet>();
        Vector<SpriteSheet> sheets_jumps    = new Vector<SpriteSheet>();
        Vector<SpriteSheet> sheets_enemy    = new Vector<SpriteSheet>();
        Vector<SpriteSheet> sheets_dead     = new Vector<SpriteSheet>();


        under           = sheet1.crop(0,0);
        grass           = sheet2.crop(0, 0);
        heroLeft        = sheet4.crop(0,2);
        heroRight       = sheet4.crop(1,2);
        ladder          = sheet5.crop(0,0);
        stone           = sheet6.crop(0,0);
        background      = sheet3.crop2(0,0);
        background2     = sheet12.crop2(0,0);
        backgroundDead  = sheet9.crop2(0,0);
        attack          = sheet10.crop(0,0);
        skeleton        = sheet8.crop(0,0);
        tree            = sheet11.crop(0,0);

        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run1.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run2.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run3.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run4.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run5.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run6.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run7.png")));
        sheets.add(new SpriteSheet(ImageLoader.LoadImage("/run/run8.png")));

        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run1mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run2mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run3mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run4mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run5mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run6mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run7mx.png")));
        sheetsm.add(new SpriteSheet(ImageLoader.LoadImage("/runm/run8mx.png")));

        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump1.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump2.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump3.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump4.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump5.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump6.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump7.png")));
        sheets_jumps.add(new SpriteSheet(ImageLoader.LoadImage("/jumpm/jump8.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost1mx.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost1mx.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost1mx.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost2m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost2m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost2m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost3m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost4m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost5m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost6m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost6m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost6m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost7m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost7m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost7m.png")));

        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));
        sheets_enemy.add(new SpriteSheet(ImageLoader.LoadImage("/enemyx/ghost8m.png")));


        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead1x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead2x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead3x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead4x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead5x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead6x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead7x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead8x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));
        sheets_dead.add(new SpriteSheet(ImageLoader.LoadImage("/dead/dead9x.png")));

        for(int i=0;i<sheets.size();++i)
            runs.add(sheets.get(i).crop(0,0));

        for(int i=0;i<sheetsm.size();++i)
            runsm.add(sheetsm.get(i).crop(0,0));

        for(int i=0;i<sheets_jumps.size();++i)
            jumps.add(sheets_jumps.get(i).crop(0,0));

        for(int i=0;i<sheets_enemy.size();++i)
            enemy.add(sheets_enemy.get(i).crop(0,0));

        for(int i=0;i<sheets_dead.size();++i)
            dead.add(sheets_dead.get(i).crop(0,0));

    }
}
