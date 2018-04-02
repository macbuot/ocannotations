package oc.classes;

public enum TypeCryptage {
    MD5("MD5"), SHA1("SHA1");

    private String type;

    TypeCryptage(String typ){
        type = typ;
    }

    public String toString(){
        return type;
    }
}
