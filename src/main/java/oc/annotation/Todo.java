package oc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Inherited
public @interface Todo {
    Niveau niveau() default Niveau.BUG;
    String auteur() default "vboc";
    String destinataire();
    String commentaire();
}
