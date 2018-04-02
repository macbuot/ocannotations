package oc.proxies;

import oc.classes.StringInterface;

public class DebugCrypted {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String str1 = new String("    Ma phrase 1     ");
        StringInterface str2 = UpperCaseStringProxyFactory.newInstance(str1);
        System.out.println(str2);
        System.out.println(str2.hashCode());
        System.out.println("Sous chaîne : *" + str2.substring(5) + "*");

    }
}
