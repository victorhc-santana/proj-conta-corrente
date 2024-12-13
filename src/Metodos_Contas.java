//import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JOptionPane;

public class Metodos_Contas {
    
    //Função para cadastrar as contas após ler o arquivo com os dados necessários
    public Contas[] Cadastra_CC(Contas[] CC) throws IOException{
        int i;
        String fileName = "contas.txt";
        BufferedReader ler = new BufferedReader(new FileReader( fileName ));
        for (i = 0 ; i < (CC.length -1); i++) {
            CC[i] = new Contas(); 
        }
        while(ler.readLine() != null) {
            CC[i].codConta = Integer.parseInt(ler.readLine());
            CC[i].nomeCliente = ler.readLine();
            CC[i].saldoConta = Double.parseDouble(ler.readLine());
            CC[i].limiteConta = Double.parseDouble(ler.readLine());
            CC[i].tipoConta = Integer.parseInt(ler.readLine());
        }
        System.out.println("Usuários cadastrados com sucesso");
        ler.close();
        return CC;
    }
    
    //Função para cadastrar as contas após ler o arquivo de movimentação
    public MovimentoContas[] Cadastra_Movimento(MovimentoContas[] mov) throws IOException{
        int i;
        String fileName = "movimentos.txt";
        BufferedReader ler = new BufferedReader(new FileReader (fileName));
        for (i = 0; i < mov.length; i++){
            mov[i] = new MovimentoContas();
        }
        while (ler.readLine() != null){
            mov[i].codConta = Integer.parseInt(ler.readLine());
            mov[i].ValorMovimento = Double.parseDouble(ler.readLine());
            mov[i].TipoMovimento = Integer.parseInt(ler.readLine());
            mov[i].Status = Integer.parseInt(ler.readLine());
        }
        System.out.println("Cadastro dos movimentos realizados com sucesso");
        ler.close();
        return mov;
    }
    
    //Função para gerar o arquivo com as contas atualizadas
    public Contas[] Gera_Contas_Atualizadas(Contas[] CC, Contas[] CA, MovimentoContas[] mov) throws IOException{
        int i, j;
        for (i =0; i <CA.length; i++){
            CA[i] = new Contas();
        }
        for (i = 0; i < mov.length; i++){
            for (j = 0; j < CC.length; i++){
                if (mov[i].codConta ==  CC[j].codConta){
                    switch(mov[i].Status){
                        case 1 ->{
                            switch (mov[i].TipoMovimento) {
                            case 1 -> CC[j].saldoConta += mov[i].ValorMovimento;
                            case 2 -> CC[j].saldoConta -= mov[i].ValorMovimento;
                            default -> {
                            }
                            }
                        }
                        case 2 ->{
                        
                        }   
                    }    
                }
            }
        }
        return CA;    
    }
    
    //Função Para abrir o Menu de Consultas dos arquivos
    public void Consulta_Cadastros_Menu(Contas[] CC, Contas[] CA, MovimentoContas[] mov){
        int opt = 0;
        while (opt != 9 ){
            opt = Integer.parseInt(JOptionPane.showInputDialog("1 cadastrar CC 2 Cadastra mov 3 Atualiza 4 Consuta 9 Sair"));
            switch(opt){
                case 1 -> ConsultaCC(CC);
                case 2 -> ConsultaMovimento(mov);
                case 3 -> ConsultaAtualizado(CA);
                case 9 -> System.out.println("Consulta Encerrada");
                default -> System.out.println("Opcao invalida");
            }
        }
    }
    
    //Gera a consulta das contas correntes
    public void ConsultaCC(Contas[] CC){
        int i;
        System.out.println("Código da conta | Nome do cliente | Saldo da Conta | Limite da Conta | Tipo da Conta");
        for (i = 0; i < CC.length; i++){
            System.out.print("     "+CC[i].codConta+"     ");
            System.out.print(" "+CC[i].nomeCliente+" ");
            System.out.print(" "+CC[i].saldoConta+" ");
            System.out.print(" "+CC[i].limiteConta+" ");
            System.out.print("     "+CC[i].tipoConta+"     ");
        }
        System.out.println("Consulta de contas correntes efetuada com sucesso !");
    }
    
    //Gera a consulta dos movimentos
    public void ConsultaMovimento(MovimentoContas[] mov){
        int i;
        System.out.println("Codigo da conta | Valor de Movimento | Tipo de Movimento | Status");
        for (i = 0; i < mov.length; i++){
            System.out.print("     "+mov[i].codConta+"     ");
            System.out.print("     "+mov[i].ValorMovimento+"     ");
            System.out.print("     "+mov[i].TipoMovimento+"     ");
            System.out.print("     "+mov[i].Status+"     ");
        }
        System.out.println("Consulta de movimentação efetuada com sucesso !");
    }
    
    //Gera a consulta das contas atualizadas
    public void ConsultaAtualizado(Contas[] CA){
        int i;
        System.out.println("Código da conta | Nome do cliente | Saldo da Conta | Limite da Conta | Tipo da Conta");
        for (i = 0; i < CA.length; i++){
            System.out.print("     "+CA[i].codConta+"     ");
            System.out.print(" "+CA[i].nomeCliente+" ");
            System.out.print(" "+CA[i].saldoConta+" ");
            System.out.print(" "+CA[i].limiteConta+" ");
            System.out.print("     "+CA[i].tipoConta+"     ");
        }
        System.out.println("Consulta das contas atualizadas efetuada com sucesso !");
    }
}