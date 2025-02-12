import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Carro> carros = new ArrayList<>();

    private static void criarDadosIniciais() {
        /* Deves desenvolver o código para inserir os dados iniciais nas listas */

        Carro car1 = new Carro();//Carro
        Carro car2 = new Carro();//Carro
        Carro car3 = new Carro();//Carro
        Cliente c1 = new Cliente();//Cliente
        Cliente c2 = new Cliente();//Cliente

        /*Clientes inicio*/
        c1.setNome("Ivo");//Cliente 1
        c1.setNif(123123123);//Cliente 1
        c1.setnCliente(1);//Cliente 1
        c2.setNome("Alex");//Cliente 2
        c2.setNif(321321321);//Cliente 2
        c2.setnCliente(2);//Cliente 2
        /*Clientes fim*/

        /*Carros Inicio*/
        car1.setMarca("BMW");
        car1.setModelo("M3");
        car1.setMatricula("AX-34-9P");
        car1.setAlugado(false);


        car2.setMarca("Lamborghini");
        car2.setModelo("SVJ");
        car2.setMatricula("RJ-45-TC");
        car2.setAlugado(false);

        car3.setMarca("Toyota");
        car3.setModelo("Supra mk4");
        car3.setMatricula("66-0p-O0");
        car3.setAlugado(false);
        /*Carros fim*/

        clientes.add(c1);//Adicionando os clientes ao array
        clientes.add(c2);//Adicionando os clientes ao array

        carros.add(car1);//Adicionando os carros aos arrays
        carros.add(car2);//Adicionando os carros aos arrays
        carros.add(car3);//Adicionando os carros aos arrays

    }

    private static void visualizarCarrosPorMarca(String marca){
        for(Carro carroTemp :carros){
            if(carroTemp.getMarca().equals(marca)){
                System.out.println(carroTemp);
            }
        }
    }

    private static void visualizarClientesComCarrosAlugados(){
        int clientesComCarro=0;
        for(Cliente clienteTemp:clientes){
            if(!(clienteTemp.getCarro() == null)){
                System.out.println(clienteTemp);
            }
            else{
                clientesComCarro++;
            }
        }
        if(clientesComCarro == clientes.size()){
            System.out.println("Nao existem clientes com carros alugados");
        }

    }

    private static void visualizarCarrosDisponiveis(){
        int contarCarros=0;//Esta variavel conta o numero de carros alugados
        for(Carro carTemp: carros){
            if(carTemp.getAlugado().equals(false)){
                System.out.println(carTemp);
            }
            else{
                contarCarros++;
            }
        }
        if(contarCarros==carros.size()){
            System.out.println("Nao existem carros disponiveis");
        }//se o numero de carros contados que estam alugos for igual à quantida de carros que existem no array carros, ele mostrar que nao existem carros disponiceis pois todos os carros estao alugados
    }

    private static boolean registarAluguer(int nif, String matricula){
        if(!(nif == 9) && !(matricula == null)){
            for (Carro carro : carros) {
                if (carro.getMatricula().equals(matricula) && !carro.getAlugado()) {
                    for (Cliente cliente : clientes) {
                        if (cliente.getNif() == nif && cliente.getCarro() == null) {
                            cliente.setCarro(carro);
                            carro.setAlugado(true);
                            return true;//Registo com sucesso
                        }
                    }
                }
                else if(carro.getMatricula().equals(matricula) && carro.getAlugado()){
                    System.out.println("O carro ja esta alugado");
                    return false;
                }

                for (Cliente cliente : clientes) {
                    if (cliente.getNif() == nif && cliente.getCarro() != null) {
                        System.out.println("O cliente ja tem um carro alugado");
                        return false;
                    }
                }


            }
            return false;
        }
        else{
            System.out.println("Nif ou matricula incorrreta");
            return false;
        }
    }


    private static void visualizarClientes(){
        for(Cliente clienteTemp: clientes){
            System.out.println(clienteTemp);
        }

    }

    private static void visualizarCarros(){
        for(Carro carro: carros){
            System.out.println(carro);
        }
    }

    private static boolean devolverCarro(int nCliente){

        for(Cliente clienteTemp: clientes){
            if(clienteTemp.getCarro() != null && clienteTemp.getnCliente() == nCliente){
                for(Carro carroTemp:carros){
                    if(clienteTemp.getCarro().getMatricula().equals(carroTemp.getMatricula())){
                        carroTemp.setAlugado(false);
                        clienteTemp.setCarro(null);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean vereficarN(int nif){
        for(Cliente temp:clientes){
            if(nif == temp.getNif()){
                return true;
            }
        }
        return false;
    }//apenas pra poupar tempo

    public static void main(String[] args) {
        int sair = 1;

        criarDadosIniciais();
        
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Visualizar todos os clientes.");
            System.out.println("2 - Visualizar todos os carros");
            System.out.println("3 - Visualizar carros por marca");
            System.out.println("4 - Visualizar clientes com carros alugados");
            System.out.println("5 - Visualizar carros disponíveis");
            System.out.println("6 - Registar aluguer");
            System.out.println("7 - Devolver Carro");
            System.out.println("0 - Sair");
            int opcao = input.nextInt();

            switch (opcao){
                case 1:
                    visualizarClientes();
                    break;
                case 2:
                    visualizarCarros();
                    break;
                case 3:
                    System.out.println("Escreva a marca do carro");
                    Scanner verMarca =new Scanner(System.in);
                    String marcaInserirda = verMarca.nextLine();
                    visualizarCarrosPorMarca(marcaInserirda);
                    break;
                case 4:
                    visualizarClientesComCarrosAlugados();
                    break;
                case 5:
                    visualizarCarrosDisponiveis();
                    break;
                case 6:
                    Scanner nif =new Scanner(System.in);
                    Scanner matricula =new Scanner(System.in);
                    int x = 1;
                    Boolean teste=null;
                    System.out.println("Insere o nif-");
                    int nifInserido = nif.nextInt();
                    if(vereficarN(nifInserido)){
                        System.out.println("Insere a matricula- ");
                        String matriculaInserida = matricula.nextLine();

                        if(registarAluguer(nifInserido,matriculaInserida)){
                            System.out.println("Aluguer registado com sucesso!");
                        }
                        else{
                            System.out.println("Não foi possivel alugar");
                        }
                        break;
                    }
                    else {
                        System.out.println("NIF nao encontrado, voltando ao menu...");
                        break;
                    }

                case 7:
                    Scanner nCliente =new Scanner(System.in);
                    for(Cliente verClientes:clientes){
                        System.out.println(verClientes);
                    }
                    System.out.println("Insere o numero do cliente- ");
                    int nClienteTemp = nCliente.nextInt();
                    if(devolverCarro(nClienteTemp)){
                        System.out.println("Carro devolvido");
                    }
                    else{
                        System.out.println("O cliente nao tem um carro pra devolver");
                    }
                break;

                case 0:
                    System.out.println("Fim do programa");
                    sair=0;

                    /* Deves desenvolver os casos para o switch e chamar as respetivas funções */
            }
        }while(!(sair == 0));
        
    }
}