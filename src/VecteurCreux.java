import java.util.Iterator;

/**
 * 
 * Coulibaly Ibrahim Francis Junior
 *
 */
public class VecteurCreux implements Iterable<Double> { 
	/**
	 * Contenant utilise pour les Maillons de la chaine qui 
	 * repr�sentera le VecteurCreux.
	 * @author vos noms
	 *
	 */
	private class Maillon {
            
            public double valeur;
            public int indiceDeCase;
            public Maillon valeurSuivante;
            public int indiceDeCaseValeurSuivante;
            
            public Maillon (double valeur,int indiceDeCase){
                this.valeur = valeur;
                this.indiceDeCase = indiceDeCase + 1;
                this.valeurSuivante = null;
            }
            
            public Maillon (double valeur,int indiceDeCase, Maillon valeurSuivante, int indiceDeCaseValeurSuivante){
                this.valeur = valeur;
                this.indiceDeCase = indiceDeCase + 1;
                this.valeurSuivante = valeurSuivante;
                this.indiceDeCaseValeurSuivante = indiceDeCaseValeurSuivante + 1;
            }
                
	}

	/**
	 * Contenant utilise pour les iterateurs qui permettront de parcourir 
	 * le VecteurCreux.
	 * @author vos noms
	 *
	 */
	public class IterateurVecteurCreux implements Iterator<Double> {   
		
            Maillon courrant;
            
                @Override   
		public boolean hasNext() {    
                    return null != courrant;
		}
                
		@Override   
		public Double next() {
                    
                    Double resultat = courrant.valeur;
			
                    courrant = courrant.valeurSuivante;
			
                    return resultat;
		}
	}

	/**
	 * Construis un VecteurCreux o� toutes les valeurs sont � 0. 
	 * @param indiceMax le nombre de valeur dans le vecteur.
	 */
	public VecteurCreux( int indiceMax ) { 
            double [] vecteurCreux = new double [indiceMax];
	}

	/**
	 * Construis un VecteurCreux � partir d'un tableau.
	 * Le vecteur construit aura une taille �gale � celle du tableau en
	 * argument. 
	 * @param vecteurFixe tableau dont les �l�ments sont plac�s dans le vecteur
	 *        construit.
	 */
	public VecteurCreux( double [] vecteurFixe ) { 
            
	}

	/**
	 * Addition de 2 vecteurs.
	 * <P>
	 * Mathematique : l'addition de deux vecteurs est faite �l�ment � �l�ment :
	 * L'addition d'un vecteur \(\vec{u}\) avec un vecteur \(\vec{v}\) nous donne un 
	 * vecteur \(\vec{r}\) o� : \(\forall i \in [0..taille()], r_i = u_i + v_i\).
	 * @param v2 le vecteur additionne a 'this'.
	 * @return le vecteur r�sultant de l'addition du vecteur 'this' avec
	 *         le vecteur 'v2'.  Le vecteur retourne est un nouveau vecteur.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public VecteurCreux addition( VecteurCreux v2 ) throws IndexOutOfBoundsException { 
		return null;
	}

	/**
	 * Construit un nouveau VecteurCreux parall�le (ou anti-parall�le) � 'this' avec une 
	 * norme multipli�e par 's'.
	 * <P>
	 * Mathematique : La multiplication d'un vecteur \(\vec{u}\) par un scalaire \(s\) nous 
	 * donne le vecteur \(\vec{r}\) suivant :
	 * \(\forall i \in [0..taille()], r_i = s \cdot u_i\)    
	 * @param s Le facteur d'agrandissement.
	 * @return Un vecteur parall�le (ou anti-parall�le) au vecteur 'this' o� chaque valeur a 
	 *         �t� multiplie par 's'.
	 */
	public VecteurCreux agrandir( double s ) {  
		return null;
	}

	/**
	 * Compare deux vecteurs : 'this' et 'objet'.
	 * <P>
	 * Mathematique : \(r = \forall i \in [0..taille()], u_i = v_i\)   
	 * @param objet le deuxi�me vecteur � compar�.
	 * @return True si les vecteurs ont les m�mes valeur
	 *         indice � indice.  False s'ils n'ont pas la m�me
	 *         taille ou s'ils n'ont pas les m�mes �l�ments ou
	 *         si 'objet' est null ou n'est pas un VecteurCreux.
	 */
	public boolean equals( Object objet ) {   
		return false;
	}

	/**
	 * Verifie si deux vecteurs ('this' et 'v2') sont anti-parall�le (pointe en direction oppos�).
	 * <P>
	 * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont anti-parall�le si
	 * la condition suivante est respect�e :
	 * \(r = \exists s \lt 0, \forall i \in [0..taille()], s \cdot u_i = v_i\)
	 * @param v2 le vecteur qui est compare � 'this'. 
	 * @return True si les vecteurs sont anti-parall�le.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public boolean estAntiParallelA( VecteurCreux v2 ) throws IndexOutOfBoundsException {   
		return false;
	}

	/**
	 * Verifie si deux vecteurs ('this' et 'v2') sont oppos�s (pointes en 
	 * direction oppos�e, mais ont la m�me taille).
	 * <P>
	 * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont oppos�s si
	 * la condition suivante est respect�e :
	 * \(r = \forall i \in [0..taille()], -u_i = v_i\)
	 * @param v2 le vecteur qui est compar� � 'this'.
	 * @return True si les vecteurs sont opposes.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public boolean estOpposeA( VecteurCreux v2 ) throws IndexOutOfBoundsException {  
		return false;
	}

	/**
	 * V�rifie si deux vecteurs ('this' et 'v2') sont parall�le (pointe dans la m�me direction).
	 * <P>
	 * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont parall�le si
	 * la condition suivante est respect�e :
	 * \(r = \exists s \gt 0, \forall i \in [0..taille()], s \cdot u_i = v_i\)   
	 * @param v2 le vecteur qui est compar� � 'this'.
	 * @return True si les vecteurs sont parall�le.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public boolean estParallelA( VecteurCreux v2 ) throws IndexOutOfBoundsException {  
		return false;
	}

	/**
	 * Lis et retourne une valeur du vecteur.  La case '1' est la premi�re case du vecteur
	 * et la case 'taille()' est la derni�re case du vecteur.
	 * @param indice une valeur entre 1 et taille() indiquant la case lue.
	 * @return la valeur contenue dans le vecteur � la case 'indice'.
	 * @throws IndexOutOfBoundsException lancer si l'indice est plus petit que 1 ou
	 *         plus grand que taille().
	 */
	public double get( int indice ) throws IndexOutOfBoundsException { 
		return 0.0;
	}

	/**
	 * Construis un it�rateur sur les �l�ments du vecteur, y compris les z�ros.
	 * @return un Iterator sur les Doubles contenus dans le vecteur.
	 */
	@Override  public Iterator<Double> iterator() {  
		return null;
	}

	/**
	 * Multiplication scalaire entre 2 vecteurs.
	 * <P>
	 * Mathematique : la multiplication scalaire de deux vecteurs est faite �l�ment � �l�ment :
	 * La multiplication d'un vecteur \(\vec{u}\) avec un vecteur \(\vec{v}\) nous donne un 
	 * scalaire \(r\) o� : \(r = \sum^{taille()}_{i = 0} u_i \cdot v_i\)
	 * @param v2 le vecteur multiplie par 'this'.
	 * @return le scalaire (double) r�sultant de la multiplication du vecteur 'this' avec
	 *         le vecteur 'v2'.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public double multiplicationScalaire( VecteurCreux v2 ) throws IndexOutOfBoundsException {
		return 0.0;
	}

	/**
	 * Calcule la norme euclidienne du vecteur 'this'.
	 * <P>
	 * Mathematique : La norme euclidienne d'un vecteur \(\vec{u}\) est calcul� comme suit :
	 * \(r = \sqrt{ \sum^{taille()}_{i = 0} u_i^2 }\)   
	 * @return la norme du vecteur.
	 */
	public double normeEucledienne() {
		return 0.0;
	}

	/**
	 * Construis un vecteur oppos� au vecteur 'this'.
	 * <P>
	 * Mathematique : Le vecteur \(\vec{r}\) oppos� � \(\vec{u}\) contient les m�mes valeurs
	 * avec des signes oppos�s.
	 * \(\forall i \in [0..taille()], r_i = -u_i\).
	 * @return Un nouveau VecteurCreux oppos� au vecteur 'this'.
	 */
	public VecteurCreux oppose(){  
		return null;
	}

	/**
	 * Modifi une valeur du vecteur.  La case '1' est la premi�re case du vecteur
	 * et la case 'taille()' est la derni�re case du vecteur.
	 * @param indice une valeur entre 1 et taille() indiquant la case modifi�.
	 * @param valeur La valeur place dans la case modifi�.
	 * @throws IndexOutOfBoundsException lancer si l'indice est plus petit que 1 ou
	 *         plus grand que taille().
	 */
	public void set( int indice, double valeur ) throws IndexOutOfBoundsException {

	}

	/**
	 * Soustraction de 2 vecteurs.
	 * <P>
	 * Mathematique : la soustraction de deux vecteurs est faite �l�ment � �l�ment :
	 * La soustraction du vecteur \(\vec{v}\) au vecteur \(\vec{u}\) nous donne un 
	 * vecteur \(\vec{r}\) o� : \(\forall i \in [0..taille()], r_i = u_i - v_i\).
	 * @param v2 le vecteur soustrait de 'this'.
	 * @return le vecteur r�sultant de la soustraction du vecteur 'v2' au vecteur 'this'
	 *         Le vecteur retourn� est un nouveau vecteur.
	 * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
	 *         est diff�rent.
	 */
	public VecteurCreux soustraction( VecteurCreux v2 ) throws IndexOutOfBoundsException { 
		return null;
	}

	/**
	 * Retourne le nombre d'�l�ments que le vecteur contient.
	 * Cela comprend les z�ros et les non-z�ros.
	 * @return le nombre d'�l�ment du vecteur.
	 */
	public int taille() {  
		return 0;
	}

	/**
	 * Construis un VecteurCreux unitaire parall�le � 'this'.
	 * <P>
	 * Mathematique : Un vecteur unitaire est un vecteur de norme '1.0'.
	 * Soit \(n\) la norme euclidienne du vecteur \(\vec{v}\), alors le
	 * vecteur \(\vec{r}\) unitaire et parall�le � \(\vec{v}\) est calcul� comme suit :
	 * \(\forall i \in [0..taille()], r_i = n \cdot v_i\)   
	 * @return le vecteur unitaire parall�le � 'this'.
	 */
	public VecteurCreux unitaire() {  
		return null;
	}
}