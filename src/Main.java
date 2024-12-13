import java.io.IOException;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) throws IOException {
        Contas CC[] = new Contas[5];
        Contas CA[] = new Contas[5];
        MovimentoContas Mov[] = new MovimentoContas[10];
        
        Metodos_Contas function =  new Metodos_Contas();
        
        int opt = 0;
        while (opt != 9){
            opt = Integer.parseInt(JOptionPane.showInputDialog("1 cadastrar CC 2 Cadastra mov 3 Atualiza 4 Consuta 9 Sair"));
            switch(opt){
                case 1 -> CC = function.Cadastra_CC(CC);
                case 2 -> Mov = function.Cadastra_Movimento(Mov);
                case 3 -> CA = function.Gera_Contas_Atualizadas(CC, CA, Mov);
                case 4 -> function.Consulta_Cadastros_Menu(CC,CA, Mov);
                case 9 -> System.out.println("Sistema encerrado");
                default -> System.out.println("opção inválida");
            }
        }
    }
}
