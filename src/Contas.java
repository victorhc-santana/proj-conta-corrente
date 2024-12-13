/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Contas {
    int codConta;
    String nomeCliente;
    double saldoConta;
    double limiteConta;
    int tipoConta;
    
    Contas(){
        this (0, "", 0,0,0);
    }
    Contas(int cod, String nome, double saldo, double limite, int tipo){
        codConta = cod;
        nomeCliente = nome;
        saldoConta = saldo;
        limiteConta = limite;
        tipoConta = tipo;
    }
}
