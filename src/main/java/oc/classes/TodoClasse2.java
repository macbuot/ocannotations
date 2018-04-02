package oc.classes;

import oc.annotation.Niveau;
import oc.annotation.Todo;
import oc.annotation.Todos;

@Todo(
        niveau = Niveau.CRITIQUE,
        commentaire = "Il faudrait penser à terminer la classe.",
        destinataire = "zozor"
)
public class TodoClasse2 extends TodoClasse1 {

    @Todos(
         annotTodo = {
            @Todo(
                  commentaire = "Mais que fait cette m�thode ?", 
                  destinataire = "z�ro",
                  niveau = Niveau.BUG),
            @Todo(
                  commentaire = "Pourquoi tant de N !", 
                  destinataire = "cysboy",
                  niveau = Niveau.AMELIORATION)
         }
   )

   public String doSomething(){
      return "something :p ";
   }
}
