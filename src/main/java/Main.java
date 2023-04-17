import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rubrica rubrica = new Rubrica();

        boolean exit=false, start=true;
        int op;
        do{
            if(start==true){
                op=0;
                start=false;
            }else{
                do {
                    System.out.println("Che operazione vuoi fare?\n0) Aggiungi contatto\n1) Rimuovi contatto\n2) Cerca contatto\n3) Stampa l'intera rubrica");
                    op = scanner.nextInt();
                    scanner.nextLine();
                }while(op<0 || op>3);
            }
            switch(op){
                case 0:
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
                        System.out.println(rubrica.get(str));
                    }
                    break;
            }
        }while(exit==false);

    }
}
