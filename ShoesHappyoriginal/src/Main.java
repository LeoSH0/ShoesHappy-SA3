import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> clients = new ArrayList<Person>();

    public static void main(String[] args) {

        List<Person> clients = new ArrayList<Person>();
        boolean exit = true;

        while(exit) {



            System.out.println("Selecione o que desejas fazer");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Editar");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    addClient(clients);

                    break;

                case 2:
                    System.out.println("Qual o nome que desejas buscar?");
                    String nameFinder = scanner.nextLine();
                    findClient(clients, nameFinder);

                    break;

                case 3:
                    editClient();

                    break;

                case 4:
                    removeClient();

                    break;

                case 5:
                    exit = false;

                    break;

            }
        }
    }

    private static void addClient(List<Person> clients){
        Person client = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do cliente!");
        client.name = scanner.nextLine();
        clients.add(client);
        System.out.println("Cadastro feito com sucesso");
    }

    private static Integer findClient(List<Person> clients, String clientName) {
        Integer position =null;

        for (int i = 0; i < clients.size(); i++) {
            Person clientt = clients.get(i);
            if (clientt.equals(clientName)) {
                position = i;
                System.out.println(clientName + " foi encontrado");
            }
        }
        return position;
    }

    private static void editClient(){
        System.out.println("Qual nome que queres editar?");
        String name = scanner.next();
        Integer position = findClient(clients, name);
        if(position != null){
            Person p1 = clients.get(position.intValue());
            System.out.println("Digite o novo nome!");
            name = scanner.next();
            p1.name = name;
        }
    }

    private static void removeClient(){
        System.out.println("Qual nome que desejas remover?");
        String name = scanner.next();
        Integer position = findClient(clients, name);
        if(position != null){
            clients.remove(position.intValue());
        }
    }
}