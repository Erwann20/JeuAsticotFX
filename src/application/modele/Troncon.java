package application.modele;


/**
 *
 * La classe Troncon permet de définir les Troncon d'un Asticot. Un Troncon est défini par :<BR>
 * <UL>
 * <LI>les coordonnées x et y de son centre</LI>
 * <LI>son rayon</LI>
 * </UL>
 * <BR>
 */

public class Troncon {

   // -------------- constantes ----------------------------------------

   /**
    * rayon par défaut du Troncon égale 5
    */
   public final static int R = 5;

   // -------------- variables d'instance (attributs)--------------------

   /**
    * abscisse du centre du Troncon
    */
   protected int x;

   /**
    * ordonnée du centre du Troncon
    */
   protected int y;

   /**
    * rayon du Troncon
    */
   protected int r;

   // ------ Constructeurs ---------------------------------------------

   /**
    * crée un Troncon en fixant la position initiale de son centre et son rayon.
    * 
    * @param xInit
    *           abscisse du centre du Troncon
    * @param yInit
    *           ordonnée du centre du Troncon
    * @param rInit
    *           rayon du Troncon
    */
   public Troncon(int xInit, int yInit, int rInit) {
      placerA(xInit, yInit);
      this.r = rInit;
   }

   /**
    * crée un Troncon en fixant la position initiale de son centre et avec la valeur par défaut pour
    * son rayon.
    * 
    * @param xInit
    *           abscisse du centre du Troncon
    * @param yInit
    *           ordonnée du centre du Troncon
    */
   public Troncon(int xInit, int yInit) {
      this(xInit, yInit, R);
   }

   // ------ Méthodes -------------------------------------------------

   /**
    * retourne abscisse du centre du Troncon
    * 
    * @return abscisse du centre
    */
   public int getX() {
      return x;
   }

   /**
    * retourne ordonnée du centre du Troncon
    * 
    * @return ordonnée du centre
    */
   public int getY() {
      return y;
   }

   /**
    * positionne le centre du Troncon en un point donné
    * 
    * @param px
    *           nouvelle abscisse du centre
    * @param py
    *           nouvelle ordonnée du centre
    */
   public void placerA(int px, int py) {
      x = px;
      y = py;
   }

   /**
    * @return the r
    */
   public int getR() {
      return r;
   }
}
