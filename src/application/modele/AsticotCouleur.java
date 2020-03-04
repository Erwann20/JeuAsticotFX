package application.modele;

import javafx.scene.paint.Color;

/**
 * Une espèce particulière d'Asticot. Les Asticot colorés.
 *
 */

public class AsticotCouleur extends Asticot {
   /**
    * La couleur de l'Asticot
    */
   private final Color couleur;

   /**
    * Crée un Asticot en spécifiant la taille de la zone dans laquelle il se déplace, le rayon et le
    * nombre de ces Troncon et la couleur désirée.
    * 
    * @param largeur
    *           largeur de la zône (de dessin).
    * @param hauteur
    *           hauteur de la zône (de dessin).
    * @param r
    *           rayon du Troncon de l'Asticot.
    * @param nbTroncons
    *           nombre de Troncon de l'Asticot.
    * @param color
    *           la couleur de l'Asticot.
    */
   public AsticotCouleur(int largeur, int hauteur, int r, int nbTroncons, Color color) {
      super(largeur, hauteur, r, nbTroncons);
      this.couleur = color;
   }

   /**
    * @return the couleur
    */
   public Color getCouleur() {
      return couleur;
   }

}// AsticotCouleur
