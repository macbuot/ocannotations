package oc.handlers;

import oc.annotation.Crypted;
import oc.classes.StringInterfaceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.MessageDigest;

public class ProxyInvocationHandlerUpperCase implements InvocationHandler {
    //On y stocke l'objet d'origine, le proxy donc
    private StringInterfaceImpl monString;

    public ProxyInvocationHandlerUpperCase(StringInterfaceImpl str){
        monString = str;
    }

    //Méthode à redéfinir pour y coder le fonctionnement souhaité
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //On récupère le nom de la méthode
        String methodName = method.getName();

        //Vous verrez que ceci sera afficher
        //à l'invocation des méthodes présentent dans l'interface
        System.out.println("----------------------------------------------------");
        System.out.println("Invocation de la méthode " + methodName);

        String monStringInitial = monString.getString();

        Method methodeToCapture = null;

        //S'il y a des arguments, c'est qu'il s'agit de la méthode substring...
        if((args != null)){
            //Notre méthode substring(int start) attend un objet de type int
            //Par conséquent, nous devons passer int.class dans notre recherche de méthode
            //Si nous avions utilisé args[0].class, le type passé aurait été Integer.class
            //et aurait provoqué une exception lors de la recherche de méthode
            //car cette signature n'existe pas dans l'objet String
            methodeToCapture = monString.getClass().getMethod(method.getName(), int.class);
        }
        else{

            //Aucun paramètre ne doit être passé à la méthode toString()
            //Par conséquent, nous devons passer null dans notre recherche de méthode
            methodeToCapture = monString.getClass().getMethod(method.getName(), null);

        }

        //Nous vérifions que la méthode appelée est annotée
        Crypted crypt = methodeToCapture.getAnnotation(Crypted.class);
        //Si tel est le cas, on traite l'annotation
        if(crypt != null){

            //On récupère la chaîne à crypter
            String str = monString.getString();
            //On créer une instance de cet objet qui va se charger de crypter notre chaîne
            //Le paramètre passé correspond au type de cryptage
            MessageDigest md = MessageDigest.getInstance(crypt.type().toString());
            //Cet objet travail avec un tableau de byte, nous lui donnons donc
            //le tableau de byte correpondant à la chaîne à crypter
            md.update(str.getBytes());
            //On crypte le tout
            byte[] strByte =  md.digest();

            //Le cryptage n'étant pas lisible pour un œil humain
            //nous devons le transformer en caractère hexadécimal
            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<strByte.length;i++) {
                //Cette instruction permet de transformer chaque byte en caractère hexadécimal
                hexString.append(Integer.toHexString(0xFF & strByte[i]));
            }
            //Il ne nous reste plus qu'à mettre à jour notre chaîne
            monString.setString(hexString.toString());
        }

        //invocation de la méthode concernée
        Object o = method.invoke(monString, args);

        //Après que la méthode en question soit invoquée
        if(methodName.equals("toString")){
            System.out.println("Après toString ! ");
            //On passe notre chaîne en majuscule après l'invocation de toString
            //et cette modification n'est effective qu'après l'exécution de la méthode
            monString.setString(monString.getString().toUpperCase());
        }

        //Cette instruction retourne le résultat de l'invocation de la méthode
        //donc, dans notre cas, soit le hashcode soit la chaîne de caractères
        return o;
    }
}
