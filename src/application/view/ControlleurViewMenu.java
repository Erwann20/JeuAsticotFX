package application.view;

import application.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControlleurViewMenu {
   
   @FXML
   Text scoreText;
   
   MainApp mainApp;
   int score;
  
   
   @FXML
   public void initialize() {
      
   }
   
   /**
    * Quitte le jeu
    */
   @FXML
   public void buttonQuitter() 
   {
      Platform.exit();
   }
   
   /**
    * Permet de rejouer
    */
   @FXML
   public void buttonRejouer() {
      this.mainApp.initRootLayout();
   }
   
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;
      
     
   }
   
   /**
    * Affiche le score final de la partie
    * @param score
    */
   public void setScore(int score) {
      this.score = score;
      this.scoreText.setText(String.valueOf(this.score));
   }

 
   
   
}
