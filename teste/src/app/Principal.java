package app;
import java.util.Scanner;
public class Principal {
	private static Scanner sc = new Scanner(System.in);
    public static void main(String[]args){
        DAOX x  = new DAOX();
        int escolha = 0;
        do{
            System.out.print("Escolha uma opção->");
            escolha = sc.nextInt();
            switch(escolha){
                case 1:
                    X[]vetX = x.Listar();
                    for(int i = 0; i < vetX.length; i++)
                        System.out.println(i+" Posição->"+vetX[i].getNome());
                break;

                case 2:
                    String nome = "";
                    nome = sc.nextLine();
                    x.inserir(new X(nome));
                break;

                case 3:
                    int idEscolhido = 0;
                    idEscolhido = sc.nextInt();
                    x.excluir(idEscolhido);
                break;

                case 4:
                    int idEscolhido1 = 0;
                    idEscolhido1 = sc.nextInt();
                    String nome1 = "";
                    nome1 = sc.nextLine();
                    x.atualizar(idEscolhido1, nome1);
                break;
            }
        }while(escolha != 0);
    }


	

}
