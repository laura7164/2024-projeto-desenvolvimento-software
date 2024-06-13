package Controllers;
import Models.Funcionario;
import Models.InterfaceFuncionario;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AcaoController {

    Scanner leitor = new Scanner(System.in);

    List<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public void realizarCompra(){

    }

    public void reporProduto(){

    }

    public void baterPontoEntrada(){
        System.out.print("Informe o seu ID: ");
        int idFuncionario = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionario == funcionarios.get(i).getIdFuncionario()){
                funcionarios.get(i).baterPontoEntrada();
                //incompleto
            }
        }
    }

    public void baterPontoSaida(){
        System.out.print("Informe o seu ID: ");
        int idFuncionario = leitor.nextInt();

        for(int i = 0; i < funcionarios.size(); i++){
            if(idFuncionario == funcionarios.get(i).getIdFuncionario()){
                funcionarios.get(i).baterPontoSaida();
                //incompleto
            }
        }
    }
    
}