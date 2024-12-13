public class MovimentoContas {
    int codConta;
    double ValorMovimento;
    int TipoMovimento;
    int Status;
    
    MovimentoContas(){
        this (0, 0, 0, 0);
    }
    MovimentoContas(int cod, double valor, int tipo, int status){
        codConta = cod;
        ValorMovimento = valor;
        TipoMovimento = tipo;
        Status = status;
    }
}
