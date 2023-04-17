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
    public void aggiungi(Persona p){
        String key = p.nome.toLowerCase() + "." + p.cognome.toLowerCase();
        System.out.println("Added!\nKey = " + key);
        add(key, p);
    }
    public void rimuovi(String nome, String cognome){
        Persona presente = cerca(nome, cognome);
        if(presente!=null){
            String key = nome.toLowerCase() + "." + cognome.toLowerCase();
            System.out.println("Removed!\nKey = " + key);
            rm(key);
        }else{
            System.out.println("Contatto inesistente");
        }
    }
    public Persona cerca(String nome, String cognome){
        String key = nome.toLowerCase() + "." + cognome.toLowerCase();
        return get(key);
    }

}
