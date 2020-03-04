package application.modele;

/**
 * La classe Tete permet de définir la tête d'un Asticot. Une Tete est un Troncon particulier qui en
 * plus des attributs d'un Troncon possède un cap (direction de déplacement).<BR>
 * Quand la tête rencontre un bord de zone, l'Asticot doit changer de cap. <BR>
 *
 */
public class Tete extends Troncon {

   // ------- variables d'instance (attributs) --------------------------

   /**
    * Cap de la tête, il est exprimé en degrés.
    */
   protected double cap;

   // -------- Constructeurs ---------------------------------------------

   /**
    * Crée une tête en fixant sa position initiale, son rayon et son cap
    * 
    * @param xInit
    *           abscisse du centre de la Tete.
    * @param yInit
    *           ordonnée du centre de la Tete.
    * @param rInit
    *           rayon de la Tete.
    * @param cInit
    *           le cap intial (en degrés).
    */
   public Tete(int xInit, int yInit, int rInit, double cInit) {
      super(xInit, yInit, rInit);
      cap = cInit;
   }


   /**
    * Crée une tête en fixant sa position initiale. Son rayon et son cap sont fixés avec les valeurs
    * par défaut.
    * 
    * @param xInit
    *           abscisse du centre de la Tete.
    * @param yInit
    *           ordonnée du centre de la Tete.
    */
   public Tete(int xInit, int yInit) {
      this(xInit, yInit, R, 0.0);
   }

   // -------- Méthodes ---------------------------------------------

   /**
    * Modifie le cap de l'Asticot. Le cap courant de l'Asticot est modifié en lui ajoutant une
    * variation de cap passée en paramètre.
    * 
    * @param deltaC
    *           la variation à appliquer au cap de l'Asticot (en degrés).
    */
   public void devierCap(double deltaC) {
      cap += deltaC;
   }


   /**
    * Déplace le centre de la Tete de l'Asticot de manière à ce que le déplacement effectué
    * corresponde à un déplacement d'une distance égale au diamètre de la tête dans la direction
    * indiquée par le cap.
    */
   public void deplacerSelonCap() {
      x = (int) (x + 2 * r * Math.cos(Math.PI * cap / 180) + 0.5);
      y = (int) (y + 2 * r * Math.sin(Math.PI * cap / 180) + 0.5);
   }

   /**
    * Détecte si la Tete atteint le bord d'une zône (de dessin)
    * 
    * @param xMax
    *           la taille en x de la zône.
    * @param yMax
    *           la taille en y de la zône.
    * @return true si la distance entre le centre de la Tete et l'un des bords de la zône est
    *         inférieure au rayon de la Tete.
    */
   public boolean atteintBord(int xMax, int yMax) {
      return ((x <= r) || (x + r >= xMax) || (y <= r) || (y + r >= yMax));
   }

   /**
    * Retourne le cap.
    * 
    * @return cap.
    * 
    */
   public double getCap() {
      return cap;
   }
}
