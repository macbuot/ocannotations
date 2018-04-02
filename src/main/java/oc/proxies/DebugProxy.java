package oc.proxies;

import oc.classes.StringInterface;

public class DebugProxy {
    public static void main(String[] args) {

        //utilisation d'un String normal
        String str1 = "    Ma phrase 1     ";
        System.out.println(str1);
        System.out.println(str1.hashCode());
        System.out.println("Sous chaîne : *" + str1.substring(5) + "*");
        System.out.println(str1.getClass());

        //Création d'un proxy de type UpperCase et utilisation des méthodes
        System.out.println("###############################################");
        StringInterface str2 = UpperCaseStringProxyFactory.newInstance(str1);
        System.out.println(str2);
        System.out.println(str2.hashCode());
        System.out.println("Sous chaîne : *" + str2.substring(5) + "*");
        //La sous chaîne est bien en majuscule ! ^^
        System.out.println(str2.getClass());
        //cette méthode ne faisant pas parti de l'interface, le gestionnaire n'est pas appelé

        //Création d'un proxy de type reverse et utilisation des méthodes
        System.out.println("###############################################");
        StringInterface str3 = ReverseStringProxyFactory.newInstance(str1);
        System.out.println(str3);
        System.out.println(str3.hashCode());
        System.out.println("Sous chaîne : *" + str3.substring(5) + "*");
        //La sous chaîne est bien à l'envers ! ;)
        System.out.println(str3.getClass());
        //cette méthode ne faisant pas parti de l'interface, le gestionnaire n'est pas appelé
    }
}
