import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();

        boolean exit=false, start=true;
        int op, sceltaFile;
        do{
            //sceltaFile=2;
            //try{
                System.out.println("Vuoi caricare i dati da file? Si(1)/No(0)");
                sceltaFile = scanner.nextInt();
                scanner.nextInt();
            //}catch(InputMismatchException i){
                //System.out.println("Eccezione: " + i);
            //}
        }while(sceltaFile!=0 && sceltaFile!=1);
        if(sceltaFile==1){
            try{
                FileInputStream f = new FileInputStream("Rubrica.dat");
                ObjectInputStream fIN = new ObjectInputStream(f);
                Hashtable<String, Persona> p = (Hashtable<String, Persona>) fIN.readObject();
                rubrica.rubrica = p;
                f.close();
                start=false;
            }catch (ClassNotFoundException | IOException e) {
                System.out.println("Eccezione: " + e.getMessage());
            }
        }

        do{
            if(start==true){
                op=0;
                start=false;
            }else{
                do {
                    System.out.println("Che operazione vuoi fare?\n0) Aggiungi contatto\n1) Rimuovi contatto\n2) Cerca contatto\n3) Stampa l'intera rubrica\n4) Salva configurazione corrente su file\n5) Esci") ;
                    op = scanner.nextInt();
                    scanner.nextLine();
                }while(op<0 || op>5);
            }
            switch(op){
                case 0:
                    System.out.println("Inserisci un contatto");
                    System.out.println("Inserisci il Nome");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci il Cognome");
                    String cognome = scanner.nextLine();
                    System.out.println("Inserisci il Numero di telefono");
                    String telefono = scanner.nextLine();

                    Persona persona = new Persona(nome, cognome, telefono);

                    rubrica.aggiungi(persona);
                    break;
                case 1:
                    System.out.println("Inserisci il Nome");
                    String rmnome = scanner.nextLine();
                    System.out.println("Inserisci il Cognome");
                    String rmcognome = scanner.nextLine();

                    rubrica.rimuovi(rmnome, rmcognome);
                    break;
                case 2:
                    System.out.println("Inserisci il Nome");
                    String cercaNome = scanner.nextLine();
                    System.out.println("Inserisci il Cognome");
                    String cercaCognome = scanner.nextLine();

                    Persona cerca = rubrica.cerca(cercaNome, cercaCognome);
                    System.out.println(cerca);
                    break;
                case 3:
                    Set<String> keys = rubrica.rubrica.keySet();
                    Iterator<String> itr = keys.iterator();
                    while(itr.hasNext()){
                        String str = itr.next();
                        System.out.println(str + " " + rubrica.get(str));
                    }
                    break;
                case 4:
                    try {
                        FileOutputStream fo = new FileOutputStream("Rubrica.dat");
                        ObjectOutputStream fOUT = new ObjectOutputStream(fo);

                        fOUT.writeObject(rubrica.rubrica);
                        fOUT.flush();
                        fo.close();
                    } catch (IOException e) {
                        System.out.println("Eccezione: " + e.getMessage());
                    }
                    break;
                case 5:
                    exit=true;
                default:
            }
        }while(exit==false);

    }
}
