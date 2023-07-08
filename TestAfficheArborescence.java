import java.util.ArrayList;
import java.util.List;
//class qui permet de creer et de stocker les sous repertoire et les fichiers dans la classe composite(RepertoireTree)ensuite de les tester
public class TestAfficheArborescence {
    public static void main(String[] args) {
        // Création des fichiers
        TreeFichierComponent fichier1 = new FichierTree("fichier1.txt");
        TreeFichierComponent fichier2 = new FichierTree("fichier2.txt");
        TreeFichierComponent fichier3 = new FichierTree("fichier3.txt");

        // Création des répertoires
        TreeFichierComponent repertoire1 = new RepertoireTree("Répertoire 1");
        TreeFichierComponent repertoire2 = new RepertoireTree("Répertoire 2");

        // Ajout des fichiers dans les répertoires
        ((RepertoireTree) repertoire1).addComponent(fichier1);
        ((RepertoireTree) repertoire1).addComponent(fichier2);
        ((RepertoireTree) repertoire2).addComponent(fichier3);

        // Ajout d'un répertoire dans un autre répertoire
        ((RepertoireTree) repertoire1).addComponent(repertoire2);

        // Construction de la structure de l'arborescence dans un StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        displayArborescence(repertoire1, stringBuilder, "");

        // Affichage de la structure de l'arborescence
        System.out.println(stringBuilder.toString());
    }

    public static void displayArborescence(TreeFichierComponent component, StringBuilder stringBuilder, String prefix) {
        component.display(stringBuilder, prefix);
    }
}
