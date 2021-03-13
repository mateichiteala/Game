package Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    /*! \class Audio
        \brief Sunet fundal pentru joc
     */

    private Clip clip; ///< referinta la clipul muzical

    /* \fn public Audio(String nume)
        \brief Constructor cu parametrul nume care reprezinta numele melodiei
     */
   public Audio(String nume){
       try{
           File path = new File(nume);
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path);
           clip = AudioSystem.getClip();
           clip.open(audioInputStream);

       } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
           e.printStackTrace();
       }
   }

   /*! \fn public void stop()
        \brief opreste muzica pentru joc
    */
   public void stop(){
       if(clip.isRunning())
           clip.stop();
   }

   /*! \fn public void play()
        \brief porneste muzica
    */
   public void play(){
       if(clip == null)
           return;
       stop();
       clip.setFramePosition(0);
       clip.start();
   }
}
