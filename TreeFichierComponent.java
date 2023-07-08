import java.util.ArrayList;
import java.util.List;
//interface composant representant a la fois les composites et les feuilles
interface TreeFichierComponent {
    //methode utilisable pour les classes
    void display(StringBuilder stringBuilder, String prefix);
}
//classe qui comprend le nom des fichiers (feuille ou children)
class FichierTree implements TreeFichierComponent {
    private String name;
//declaration des noms des fichiers
    public FichierTree(String name) {
        this.name = name;
    }
//la methode pour afficher l arborescence de stringbuilder avec display
    @Override
    public void display(StringBuilder stringBuilder, String prefix) {
        stringBuilder.append(prefix).append("- ").append(name).append("\n");
    }
}
//classe composite dans lequel on pourra stocker les fichiers, les sous repertoires etc..
class RepertoireTree implements TreeFichierComponent {
    private String name;
    private List<TreeFichierComponent> children;
//declaraton la liste des noms des sous classes (children) 
    public RepertoireTree(String name) {
        this.name = name;
        children = new ArrayList<>();
    }
//ajouter des sous classes
    public void addComponent(TreeFichierComponent component) {
        children.add(component);
    }
//supprimer les sous classes (children)
    public void removeComponent(TreeFichierComponent component) {
        children.remove(component);
    }
//afficher le nom du repertoire sous forme de tiret- ensuite afficher l arborescence (afficher sous forme de tiret - les sous classes children avec leur prefix:nom)
    @Override
    public void display(StringBuilder stringBuilder, String prefix) {
        stringBuilder.append(prefix).append("- Répertoire: ").append(name).append("\n");
        for (TreeFichierComponent component : children) {
            component.display(stringBuilder, prefix + "  ");
        }
    }
}

