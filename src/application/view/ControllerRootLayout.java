package application.view;


import java.util.ArrayList;
import java.util.Random;

import application.MainApp;
import application.modele.Asticot;
import application.modele.AsticotCouleur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ControllerRootLayout {
   
  
   private MainApp mainApp;
   private int nbAsticot = 50;
   private ArrayList<Asticot> lesAsticots = new ArrayList<Asticot>();
   private Integer score = 0;
   
   private AnchorPane principal;
  
        
   @FXML
   public void initialize() {
      
   }
   /**
    * Initialise les cercles représentant les asticots
    * et gestion du score
    * @throws InstantiationException
    */
   public void initAsticot() throws InstantiationException {
      this.principal.getChildren().clear();
      
      for(Asticot unAsticot: this.lesAsticots) {
         
         
         unAsticot.deplacer();
         
         ArrayList<Circle> ListeunAsticot = new ArrayList<Circle>();
         
            this.createTronçon(unAsticot, ListeunAsticot);
         
         
            Circle unCercle = new Circle();
            
            this.createTete(unCercle, unAsticot, ListeunAsticot);
            this.gestionScore(unCercle, ListeunAsticot, unAsticot);
              
            for (Circle cercle: ListeunAsticot) {
               
               this.principal.getChildren().add(cercle);
            }
        
      }
      
      
   }
   
   /**
    * Création des tronçon graphique en utilisant la classe Circle
    * @param unAsticot
    * @param ListeunAsticot
    */
   public void createTronçon(Asticot unAsticot, ArrayList<Circle>ListeunAsticot ) {
      for(int i = 0; i<unAsticot.getLesTroncons().size();i++) {
         
         Circle unCercle = new Circle();
         
         unCercle.setCenterX(unAsticot.getLesTroncons().get(i).getX());
         unCercle.setCenterY(unAsticot.getLesTroncons().get(i).getY());
         unCercle.setRadius(unAsticot.getLesTroncons().get(i).getR());
         unCercle.setFill(((AsticotCouleur) unAsticot).getCouleur());
         unCercle.setStrokeWidth(5);
         ListeunAsticot.add(unCercle);
             
         
      }
   }
   
   /**
    * Création la tete graphique en utilisant la classe Circle
    * @param unAsticot
    * @param ListeunAsticot
    */
   public void createTete(Circle unCercle, Asticot unAsticot, ArrayList<Circle>ListeunAsticot) {
      unCercle.setCenterX(unAsticot.getLaTete().getX());
      unCercle.setCenterY(unAsticot.getLaTete().getY());
      unCercle.setRadius(unAsticot.getLaTete().getR());
      unCercle.setFill(((AsticotCouleur) unAsticot).getCouleur());
      unCercle.setStroke(Color.BLACK);
      unCercle.setStrokeWidth(5);
   
      ListeunAsticot.add(unCercle);
   }
   
   /**
    * Gestion du score et de l'évenement de l'utilisateur
    * @param unCercle
    * @param listeunAsticot
    * @param unAsticot
    */
   public void gestionScore(Circle unCercle, ArrayList<Circle> listeunAsticot, Asticot unAsticot) {

      unCercle.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
         
         int max = this.lesAsticots.size();
         
            
         if ((e.getPickResult().getIntersectedPoint().getX()- lesAsticots.get(max - 1).getLaTete().getX()) <= 100
         && (e.getPickResult().getIntersectedPoint().getX()- lesAsticots.get(max - 1).getLaTete().getX()) >= 0) {
         if ((e.getPickResult().getIntersectedPoint().getY()
         - lesAsticots.get(max - 1).getLaTete().getY()) <= 100
         && (e.getPickResult().getIntersectedPoint().getY()
         - lesAsticots.get(max - 1).getLaTete().getY()) >= 0) {
         e.consume();
         
         if (!(max < 0)) {
            
            listeunAsticot.clear();
            this.score +=1;
            this.mainApp.getPrimaryStage().setTitle(this.mainApp.getTitre() + " | Score : " + score);
            
            this.lesAsticots.remove(lesAsticots.get(max-1));
           
         }
         if (score == this.nbAsticot) {
            mainApp.afficherVue(score);
         }
         }
         }});
            

        
   }
   
   /**
    * initialise des asticotes selon l'argument nb
    * @param nb
    */
   public void initLesAsticots(int nb) {
      int i = 0; // id de l'asticot créer
      
      while(i != nb) {
         Random rand = new Random(); 
         
         Double r = rand.nextDouble();
         Double g = rand.nextDouble();
         Double b = rand.nextDouble();
         
         Asticot unAsticot = new AsticotCouleur(480, 680, 5, 4, new Color(r,g,b,1));
         this.lesAsticots.add(unAsticot);
         
         i++;
      }
      
     
   }
   
   /**
    * Récupére le mainApp
    * @param mainApp
    */
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;
      
     
      final KeyFrame keyFrameAt750ms = new KeyFrame(Duration.millis(20), actionEvent -> {
         try {
            this.initAsticot();
         } catch (InstantiationException e) {
           
            e.printStackTrace();
         }
      });
      
      
      
      final Timeline timeline = new Timeline(keyFrameAt750ms); 
      timeline.setCycleCount(Timeline.INDEFINITE); 
      timeline.setAutoReverse(true); 
      timeline.playFromStart();
        
   }
      
   /**
    * Récupére le AnchorPane
    * @param principal
    * @throws InstantiationException
    */
   public void setPrincipal(AnchorPane principal) throws InstantiationException {
      this.principal = principal;
      this.initLesAsticots(nbAsticot);
      this.initAsticot();
      
      
     
   }
   


}
