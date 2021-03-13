package Game.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*! \class Image Loader pentru a incarca imagini
 */
public class ImageLoader {

    /*! public static BufferedImage LoadImage(String path)
        \brief Incarca o imagine intr-un obiect de tip BufferedImage si returneaza o referinta catre ea
        \path e calea relativa spre imagine
     */
    public static BufferedImage LoadImage(String path){
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
