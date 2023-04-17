import java.util.*;

public class Rubrica {

    /**HashTable<String, Persona> contenente come chiave (tutto minuscolo) nome.cognome*/
    Hashtable<String, Persona> rubrica;

    public Rubrica(){
        rubrica = new Hashtable<String, Persona>();
    }
    public void add(String k, Persona v){
        rubrica.put(k, v);
    }
    public void rm(String k){
        rubrica.remove(k);
    }
    public Persona get(String k){
        return rubrica.get(k);
    }
    public int size(){
        return rubrica.size();
    }

}
