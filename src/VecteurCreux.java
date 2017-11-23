import java.util.Iterator;

/**
 *
 * Coulibaly Ibrahim Francis Junior
 * Code permanent : COUI03069706
 * Palscal-Ali Ducharme
 * Code permanent : DUCP01079101
 * 
 */
public class VecteurCreux implements Iterable<Double> {

    /**
     * Contenant utilise pour les Maillons de la chaine qui repr�sentera le
     * VecteurCreux.
     *
     * @author vos noms
     *
     */
    private class Maillon {

        public double valeur;
        public int indiceDeCase;
        public Maillon maillonSuivant;

        public Maillon(double valeur, int indiceDeCase) {
            this.valeur = valeur;
            this.indiceDeCase = indiceDeCase + 1;
            this.maillonSuivant = null;
        }

    }

    /**
     * Contenant utilis� pour les it�rateurs qui permettront de parcourir le
     * VecteurCreux.
     *
     * @author vos noms
     *
     */
    public class IterateurVecteurCreux implements Iterator<Double> {

        int courrant = 0;
        Double [] tabIter;
        IterateurVecteurCreux( VecteurCreux v ){ 
            tabIter = new Double [v.taille()];
            for (int i = 1; i <= v.taille(); i++) {
                tabIter[i-1] = v.get(i);
            }
        }
        
        @Override
        public boolean hasNext() {
            return courrant != tabIter.length;
        }

        @Override
        public Double next() {

            Double resultat = tabIter[courrant];

            courrant = courrant + 1;

            return resultat;
        }
    }

    public      double[]    vecteurCreux;
    protected   Maillon     vecteur = null;
    protected   Maillon     debut = null;
    protected   int         nbElement = 0;
    protected   Maillon     tmp = null;

    /**
     * Construis un VecteurCreux o� toutes les valeurs sont � 0.
     *
     * @param indiceMax le nombre de valeur dans le vecteur.
     */
    public VecteurCreux(int indiceMax) {
        vecteurCreux = new double [indiceMax];
        nbElement = indiceMax;
    }

    /**
     * Construis un VecteurCreux � partir d'un tableau. Le vecteur construit
     * aura une taille �gale � celle du tableau en argument.
     *
     * @param vecteurFixe tableau dont les �l�ments sont plac�s dans le vecteur
     * construit.
     */
    public VecteurCreux(double[] vecteurFixe) {
        vecteurCreux = new double[vecteurFixe.length];
        
        for (int j = 0; j < vecteurFixe.length; j++) {
            vecteurCreux[j] = vecteurFixe[j];
        }
        
        int i = 0;
        int compteur = 0;
        Maillon nouveau = null;
        nbElement = vecteurFixe.length;
        while (i < vecteurCreux.length && compteur == 0) {
            if (vecteurCreux[i] != 0) {
                compteur = compteur + 1;
                vecteur = new Maillon(vecteurCreux[i], i);
                if (debut == null) {
                    debut = vecteur;
                }
                for (compteur = 1; compteur < vecteurCreux.length; compteur++) {
                    nouveau = new Maillon(vecteurCreux[compteur], compteur);
                    if (vecteurCreux[compteur] != 0) {
                        vecteur.maillonSuivant = nouveau;
                        vecteur = nouveau;
                    }
                }
            }
            i++;
        }
    }

    /**
     * Addition de 2 vecteurs.
     * <P>
     * Mathematique : l'addition de deux vecteurs est faite �l�ment � �l�ment :
     * L'addition d'un vecteur \(\vec{u}\) avec un vecteur \(\vec{v}\) nous
     * donne un vecteur \(\vec{r}\) o� : \(\forall i \in [0..taille()], r_i =
     * u_i + v_i\).
     *
     * @param v2 le vecteur additionne a 'this'.
     * @return le vecteur r�sultant de l'addition du vecteur 'this' avec le
     * vecteur 'v2'. Le vecteur retourne est un nouveau vecteur.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public VecteurCreux addition(VecteurCreux v2) throws IndexOutOfBoundsException {

        VecteurCreux v3;
        double indexV3 [];
        double total = 0;

        if (this.taille() != v2.taille()){

            throw new IndexOutOfBoundsException() ;

        }else {

            indexV3 = new double[this.taille()];
            v3 = new VecteurCreux(indexV3);

            for (int i = 0 ; i < this.taille() ; i++){

                total = this.get(i + 1) + v2.get(i + 1);
                v3.set(i+1 , total);
                total = 0;
            }

        }
        return v3;

    }
    /**
     * Construit un nouveau VecteurCreux parall�le (ou anti-parall�le) � 'this'
     * avec une norme multipli�e par 's'.
     * <P>
     * Mathematique : La multiplication d'un vecteur \(\vec{u}\) par un scalaire
     * \(s\) nous donne le vecteur \(\vec{r}\) suivant : \(\forall i \in
     * [0..taille()], r_i = s \cdot u_i\)
     *
     * @param s Le facteur d'agrandissement.
     * @return Un vecteur parall�le (ou anti-parall�le) au vecteur 'this' o�
     * chaque valeur a �t� multiplie par 's'.
     */
     public VecteurCreux agrandir(double s) {

        double resultat = 0;
        int taille = this.taille();
        VecteurCreux v3 = new VecteurCreux(taille);

        for (int i = 0 ; i < taille ; i++){

            resultat = this.get(i + 1) * s ;
            v3.set(i + 1 , resultat);

        }

        return v3;


    }
    
    /**
     * donne le nombre d'éléments qui ne sont pas égal a zero
     *
     * @return le nombre d'éléments quine sont pas égal a zero
     */
    public int nbrElementNonZero(){

        int total = 0;

        for (int i = 0 ; i < vecteurCreux.length ; i++) {
            if (vecteurCreux[i] != 0) {
                total++;
            }
        }

        return total;
    }
    


    /**
     * Compare deux vecteurs : 'this' et 'objet'.
     * <P>
     * Mathematique : \(r = \forall i \in [0..taille()], u_i = v_i\)
     *
     * @param objet le deuxi�me vecteur � compar�.
     * @return True si les vecteurs ont les m�mes valeur indice � indice. False
     * s'ils n'ont pas la m�me taille ou s'ils n'ont pas les m�mes �l�ments ou
     * si 'objet' est null ou n'est pas un VecteurCreux.
     */
    @Override
    public boolean equals(Object objet) {
        boolean egaux = false;
        if(objet instanceof VecteurCreux && objet != null){
            VecteurCreux vTemp = (VecteurCreux) objet;
            if (this.taille()== vTemp.taille()) {
                egaux = true;
                for (int i = 1; i <= vecteurCreux.length; i++){
                    if (this.get(i) != vTemp.get(i)){
                        egaux = false;
                    }
                }
            }
        }
        
        return egaux;
    }

    /**
     * Verifie si deux vecteurs ('this' et 'v2') sont anti-parall�le (pointe en
     * direction oppos�).
     * <P>
     * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont
     * anti-parall�le si la condition suivante est respect�e : \(r = \exists s
     * \lt 0, \forall i \in [0..taille()], s \cdot u_i = v_i\)
     *
     * @param v2 le vecteur qui est compare � 'this'.
     * @return True si les vecteurs sont anti-parall�le.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public boolean estAntiParallelA(VecteurCreux v2) throws IndexOutOfBoundsException {
        return false;
    }

    /**
     * Verifie si deux vecteurs ('this' et 'v2') sont oppos�s (pointes en
     * direction oppos�e, mais ont la m�me taille).
     * <P>
     * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont oppos�s si
     * la condition suivante est respect�e : \(r = \forall i \in [0..taille()],
     * -u_i = v_i\)
     *
     * @param v2 le vecteur qui est compar� � 'this'.
     * @return True si les vecteurs sont opposes.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public boolean estOpposeA(VecteurCreux v2) throws IndexOutOfBoundsException {
        boolean oppose = false;
            if (this.taille() != v2.taille()){
                throw new IndexOutOfBoundsException();
            } else {
                oppose = true;
                for (int i = 1; i <= taille(); i++){
                    if ( this.get(i) != -(v2.get(i))){
                        oppose = false;
                    }
                }
            }
        return oppose;
    }

    /**
     * V�rifie si deux vecteurs ('this' et 'v2') sont parall�le (pointe dans la
     * m�me direction).
     * <P>
     * Mathematique : deux vecteurs \(\vec{u}\) et \(\vec{v}\) sont parall�le si
     * la condition suivante est respect�e : \(r = \exists s \gt 0, \forall i
     * \in [0..taille()], s \cdot u_i = v_i\)
     *
     * @param v2 le vecteur qui est compar� � 'this'.
     * @return True si les vecteurs sont parall�le.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public boolean estParallelA(VecteurCreux v2) throws IndexOutOfBoundsException {
        return false;
    }

    /**
     * Lis et retourne une valeur du vecteur. La case '1' est la premi�re case
     * du vecteur et la case 'taille()' est la derni�re case du vecteur.
     *
     * @param indice une valeur entre 1 et taille() indiquant la case lue.
     * @return la valeur contenue dans le vecteur � la case 'indice'.
     * @throws IndexOutOfBoundsException lancer si l'indice est plus petit que 1
     * ou plus grand que taille().
     */
    public double get(int indice) throws IndexOutOfBoundsException {
        if (indice < 1 || indice > nbElement) {
            throw new IndexOutOfBoundsException();
        }
        return vecteurCreux[indice-1];
    }

    /**
     * Construis un it�rateur sur les �l�ments du vecteur, y compris les z�ros.
     *
     * @return un Iterator sur les Doubles contenus dans le vecteur.
     */
    @Override
    public Iterator<Double> iterator() {
        return new IterateurVecteurCreux(this);
    }

    /**
     * Multiplication scalaire entre 2 vecteurs.
     * <P>
     * Mathematique : la multiplication scalaire de deux vecteurs est faite
     * �l�ment � �l�ment : La multiplication d'un vecteur \(\vec{u}\) avec un
     * vecteur \(\vec{v}\) nous donne un scalaire \(r\) o� : \(r =
     * \sum^{taille()}_{i = 0} u_i \cdot v_i\)
     *
     * @param v2 le vecteur multiplie par 'this'.
     * @return le scalaire (double) r�sultant de la multiplication du vecteur
     * 'this' avec le vecteur 'v2'.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public double multiplicationScalaire(VecteurCreux v2) throws IndexOutOfBoundsException {
        double scalaire = 0;
            if (this.taille() != v2.taille()){
                throw new IndexOutOfBoundsException();
            } else {
                for (int i = 1; i <= taille(); i++){
                    if ( this.get(i) != 0 && v2.get(i) != 0){
                        scalaire = scalaire + (this.get(i)*v2.get(i));
                    }
                }
            }
        return scalaire;
    }

    /**
     * Calcule la norme euclidienne du vecteur 'this'.
     * <P>
     * Mathematique : La norme euclidienne d'un vecteur \(\vec{u}\) est calcul�
     * comme suit : \(r = \sqrt{ \sum^{taille()}_{i = 0} u_i^2 }\)
     *
     * @return la norme du vecteur.
     */
    public double normeEucledienne() {
        double r = 0;
            for(int i = 1; i <= this.taille(); ++i){
                if(this.get(i) != 0){
                    r = r + Math.pow(this.get(i), 2);
                }
            }
        return Math.sqrt(r);
    }

    /**
     * Construis un vecteur oppos� au vecteur 'this'.
     * <P>
     * Mathematique : Le vecteur \(\vec{r}\) oppos� � \(\vec{u}\) contient les
     * m�mes valeurs avec des signes oppos�s. \(\forall i \in [0..taille()], r_i
     * = -u_i\).
     *
     * @return Un nouveau VecteurCreux oppos� au vecteur 'this'.
     */
    public VecteurCreux oppose() {
        VecteurCreux vecteurOppose = new VecteurCreux (this.taille());
        double r = 0;
        for(int i = 1; i <= this.taille(); i++){
            if(this.get(i) != 0){
                r = -1 * this.get(i);
                vecteurOppose.set(i, r);
            } else {
                vecteurOppose.set(i, 0);
            }
        }
        return vecteurOppose;
    }

    /**
     * Modifi une valeur du vecteur. La case '1' est la premi�re case du vecteur
     * et la case 'taille()' est la derni�re case du vecteur.
     *
     * @param indice une valeur entre 1 et taille() indiquant la case modifi�.
     * @param valeur La valeur place dans la case modifi�.
     * @throws IndexOutOfBoundsException lancer si l'indice est plus petit que 1
     * ou plus grand que taille().
     */
    public void set(int indice, double valeur) throws IndexOutOfBoundsException {
        if (indice < 1 || indice > vecteurCreux.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int indiceReel = indice - 1;
            
            if (vecteurCreux[indiceReel] != 0 && valeur != 0){
                tmp = debut;
                while (tmp != null && tmp.indiceDeCase != indice) {
                    if (tmp.indiceDeCase == indice){
                        tmp.valeur = valeur;
                    } else {
                        tmp = tmp.maillonSuivant;
                    }
                }
            } else if (vecteurCreux[indiceReel] == 0 && valeur != 0){
                
                if (debut == null) {
                    debut = new Maillon(valeur, indiceReel);
                } else {
                    tmp = debut;
                    while (tmp.maillonSuivant != null){
                        tmp = tmp.maillonSuivant; 
                    }
                    tmp.maillonSuivant = new Maillon(vecteurCreux[indiceReel], indiceReel);
                    
                }
            } else if (vecteurCreux[indiceReel] != 0 && valeur == 0){
                
                tmp = debut;
                while (tmp != null && tmp.indiceDeCase != indice) {
                    if (tmp.indiceDeCase == indice){
                        tmp.maillonSuivant = tmp.maillonSuivant.maillonSuivant;
                    } else {
                        tmp = tmp.maillonSuivant;
                    }
                }
            }
            vecteurCreux[indiceReel] = valeur;
        }
    }

    /**
     * Soustraction de 2 vecteurs.
     * <P>
     * Mathematique : la soustraction de deux vecteurs est faite �l�ment �
     * �l�ment : La soustraction du vecteur \(\vec{v}\) au vecteur \(\vec{u}\)
     * nous donne un vecteur \(\vec{r}\) o� : \(\forall i \in [0..taille()], r_i
     * = u_i - v_i\).
     *
     * @param v2 le vecteur soustrait de 'this'.
     * @return le vecteur r�sultant de la soustraction du vecteur 'v2' au
     * vecteur 'this' Le vecteur retourn� est un nouveau vecteur.
     * @throws IndexOutOfBoundsException lancer si la taille() des deux vecteurs
     * est diff�rent.
     */
    public VecteurCreux soustraction(VecteurCreux v2) throws IndexOutOfBoundsException {

        VecteurCreux v3;
        double indexV3 [];
        double total = 0;

        if (this.taille() != v2.taille()){

            throw new IndexOutOfBoundsException() ;

        }else {

            indexV3 = new double[this.taille()];
            v3 = new VecteurCreux(indexV3);

            for (int i = 0 ; i < this.taille() ; i++){

                total = this.get(i + 1) - v2.get(i + 1);
                v3.set(i+1 , total);
                total = 0;
            }

        }
        return v3;

    }

    /**
     * Retourne le nombre d'�l�ments que le vecteur contient. Cela comprend les
     * z�ros et les non-z�ros.
     *
     * @return le nombre d'�l�ment du vecteur.
     */
    public int taille() {
        return nbElement;
    }

    /**
     * Construis un VecteurCreux unitaire parall�le � 'this'.
     * <P>
     * Mathematique : Un vecteur unitaire est un vecteur de norme '1.0'. Soit
     * \(n\) la norme euclidienne du vecteur \(\vec{v}\), alors le vecteur
     * \(\vec{r}\) unitaire et parall�le � \(\vec{v}\) est calcul� comme suit :
     * \(\forall i \in [0..taille()], r_i = n \cdot v_i\)
     *
     * @return le vecteur unitaire parall�le � 'this'.
     */
    public VecteurCreux unitaire() {
        VecteurCreux vecteurUnitaire  = new VecteurCreux (this.taille());
        double n = this.normeEucledienne();
        double r = 0;
        for(int i = 1; i <= this.taille(); i++){
            if(this.get(i) != 0){
                r = this.get(i) / n;
                vecteurUnitaire.set(i, r);
            } else {
                vecteurUnitaire.set(i, 0);
            }
        }
        return vecteurUnitaire;
    }
}
