package application.modele;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Circle;

/**
 * Cette classe permet de modéliser un Asticot formé de plusieurs Troncon.
 * 
 * Un Asticot est défini par :
 * <ul>
 * <li>une largeur et une hauteur,</li>
 * <li>la liste des Troncon incluant sa tête</li>
 * <li>le Troncon de tête.</li>
 * </ul>
 * 
 */

public class Asticot {
   /**
    * Collection stockant les références des Troncon de l'Asticot y compris la tête.
    */
   private final List<Troncon> lesTroncons;
   private ArrayList<Circle> ListeunAsticot = new ArrayList<Circle>();
   
   /**
    * La tête de l'Asticot.
    */
   private Tete laTete;

   /**
    * Largeur de la zône (de dessin) où se déplace l'Asticot.
    */
   private final int largeur;

   /**
    * Hauteur de la zône (de dessin) où se déplace l'Asticot.
    */
   private final int hauteur;

   /**
    * Crée un Asticot en spécifiant la taille de la zone dans laquelle il se déplace, le rayon et le
    * nombre de ces Troncon.
    * 
    * @param largeur
    *           largeur de la zône de dessin.
    * @param hauteur
    *           hauteur de la zône de dessin.
    * @param r
    *           rayon des Troncon de l'Asticot.
    * @param nbTroncons
    *           nombre de Troncon de l'Asticot y compris la tête.
    */
   public Asticot(int largeur, int hauteur, int r, int nbTroncons) {
      this.largeur = largeur;
      this.hauteur = hauteur;

      // crée une tête au centre de la fenêtre et de cap 0
      setLaTete(new Tete(largeur / 2, hauteur / 2, r, 0.0));

      // créé les autres Troncon dans une collection

      int xTete = getLaTete().getX();
      int yTete = getLaTete().getY();
      // 1) créer la collection
      lesTroncons = new ArrayList<Troncon>();
      // 2) remplir la collection en créant les Troncon et en stockant
      // leur référence dans les éléments de la collection.
      for (int i = nbTroncons; i > 0; i--)
         lesTroncons.add(new Troncon(xTete - i * 2 * r, yTete, r));
      lesTroncons.add(getLaTete());
   }

   /**
    * Fait effectuer à l'Asticot un déplacement élémentaire en avant dans la direction indiquée par
    * son cap qui subit une déviation aléatoire d'un angle de plus ou moins 15 degrés. Si la tête de
    * l'Asticot atteint un des bords , son cap est alors dévié de 90°.
    */
   public void deplacer() {
      final double angle = 15.0;
      double devi;

      if (getLaTete().atteintBord(largeur, hauteur)) {
         if (getLaTete().cap > 360) {
            getLaTete().devierCap(-360);
         }
         getLaTete().devierCap(90.0);
      } else {
         devi = -angle + Math.random() * 2 * angle;
         getLaTete().devierCap(devi);
      }

      // fait avancer les Troncons.
      // mais en fait on enlève le premier, on écrase la tête, on ajoute une nouvelle tête
      lesTroncons.remove(0);
      lesTroncons.set(lesTroncons.indexOf(getLaTete()), new Troncon(getLaTete().getX(), getLaTete()
            .getY(), getLaTete().r));

      // fait avancer la tête
      getLaTete().deplacerSelonCap();
      lesTroncons.add(getLaTete());
   }

   /**
    * 
    * @return la tête
    */
   public Tete getLaTete() {
      return laTete;
   }

   /**
    * 
    * @param laTete
    *           tronçon de tête
    */
   public void setLaTete(Tete laTete) {
      this.laTete = laTete;
   }

   /**
    * @return the lesTroncons
    */
   public List<Troncon> getLesTroncons() {
      return lesTroncons;
   }

   public ArrayList<Circle> getListeunAsticot() {
      return ListeunAsticot;
   }
   
   

}// Asticot
