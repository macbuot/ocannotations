package oc.classes;

import oc.annotation.Niveau;
import oc.annotation.Todo;
import oc.annotation.Todos;

public class TodoClasse1 {
    @Todos(
            annotTodo = {
                    @Todo(   auteur = "zozor",
                  niveau = Niveau.AMELIORATION,
                  commentaire = "Tu ferais mieux d'utiliser un double...", 
                  destinataire = "cysboy"),
                    @Todo(
                            commentaire = "Utiliser l'annotation @SuppressWarning",
                  destinataire = "cysboy")
      }
    )    
    private short entier = 0;

    public TodoClasse1(){ }

    @Todos(
         annotTodo = {
            @Todo(
                  commentaire = "Qu'est-ce que c'est que cette m�thode ?", 
                  destinataire = "zozor",
                  niveau = Niveau.CRITIQUE)
         }
    )
    public void makeSomething(){ }
}
