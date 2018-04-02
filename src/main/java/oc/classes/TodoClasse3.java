package oc.classes;

import oc.annotation.Niveau;
import oc.annotation.Todo;
import oc.annotation.Todos;

public class TodoClasse3 {
    @Todos(
         annotTodo = {
            @Todo(
                  commentaire = "Penser � faire les initialisations...", 
                  destinataire = "zozor",
                  niveau = Niveau.BUG),
            @Todo(
                  commentaire = "Aucune gestion d'exception ! ", 
                  destinataire = "zozor",
                  niveau = Niveau.AMELIORATION)
         }
    )
    public void doSomething(
            @Todo(
                    niveau = Niveau.BUG,
                    commentaire = "Vérifier le contenu de ce paramètre",
                    destinataire = "cysboy"
            )
                    String str){
        //....
    }
}
