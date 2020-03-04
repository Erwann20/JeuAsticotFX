package application;
	

import application.view.ControllerRootLayout;
import application.view.ControlleurViewMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;



public class MainApp extends Application {
   /** The primary stage. */
   private Stage primaryStage;
   private String titre = "jeu asticot ";
   /** The principal. */
   private AnchorPane principal;
   private static MainApp instance;
   
   /**
    * Lance l'application
    * @param args
    */
	public static void main(String[] args) {
		launch(args);
	}

   @Override
   public void start(Stage primaryStage) throws Exception {
      instance = this;
      this.primaryStage = primaryStage;
      
      this.initRootLayout();
      
      
   }
   
   /**
    * lance la vue ou il y'a le jeu
    */
   public void initRootLayout() {
      try {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
         
         this.principal = (AnchorPane) loader.load();
         
         Scene scene = new Scene(principal);
         this.primaryStage.setScene(scene);
         
         ControllerRootLayout controleur = loader.getController();
         controleur.setMainApp(this);
         controleur.setPrincipal(principal);
         
         this.primaryStage.setTitle(titre);
         
         this.primaryStage.show();
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   /**
    * Lance la vue ou il y'a le menu
    * @param score
    */
   public void afficherVue(int score) {
      try {
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("view/ViewMenu.fxml"));

         this.principal = (AnchorPane) loader.load();
         
         Scene scene = new Scene(principal);
         this.primaryStage.setScene(scene);
         
         
        ControlleurViewMenu controleur = loader.getController();
         controleur.setMainApp(this);
         controleur.setScore(score);
         
         this.primaryStage.show();
      
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


   public String getTitre() {
      return titre;
   }

   public static MainApp getInstance() {
      return instance;
   }

   public Stage getPrimaryStage() {
      return primaryStage;
   }
   
   
   
}
