package oc.classes;

import oc.annotation.Crypted;

public class StringInterfaceImpl implements StringInterface {
    private String monString;

    public StringInterfaceImpl(String str){
        monString = str;
    }

    @Crypted(type = TypeCryptage.SHA1)
    @Override
    public String substring(int start) {
        //nous allons retirer les espaces en début et en fin de chaîne
        //avant de faire notre substring...
        return monString.trim().substring(start);
    }

    @Crypted
    @Override
    public String toString() {
        return monString;
    }

    @Override
    public int hashCode() {
        return monString.hashCode();
    }

    //Méthodes qui vont nous servir à illustrer le principe du proxy
    public String getString(){
        return monString;
    }
    public void setString(String str){
        monString = str;
    }
}
