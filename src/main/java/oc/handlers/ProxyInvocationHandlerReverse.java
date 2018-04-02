package oc.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import oc.classes.StringInterfaceImpl;

public class ProxyInvocationHandlerReverse implements InvocationHandler {
    //On y stocke l'objet d'origine, le proxy donc
    private StringInterfaceImpl monString;

    public ProxyInvocationHandlerReverse(StringInterfaceImpl str){
        monString = str;
    }

    //Méthode à redéfinir pour y coder le fonctionnement souhaité
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //On récupère le nom de la méthode
        String methodName = method.getName();

        //Vous verrez que ceci sera affiché
        //à l'invocation des méthodes présentent dans l'interface
        System.out.println("----------------------------------------------------");
        System.out.println("Invocation de la méthode " + methodName);

        if(methodName.equals("substring")){
            System.out.println("avant substring ! ");
            //Dans cet objet, nous allons retourner notre chaîne de caractère
            //avant l'appel de la méthode

            char[] initial = monString.getString().toCharArray();
            String reverse = new String();

            for(int i = (initial.length-1); i > 0; i--)
                reverse += initial[i];

            monString.setString(new String(reverse));
        }

        //invocation de la méthode concernée
        return method.invoke(monString, args);
    }
}
