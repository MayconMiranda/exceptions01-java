package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("numero do quarto: ");
        int numeroQuarto = leitor.nextInt();
        System.out.print("data de entrada dd/MM/yyyy: ");
        Date entrada = sdf.parse(leitor.next());
        System.out.print("data de saida dd/MM/yyyy: ");
        Date saida = sdf.parse(leitor.next());

        if (!entrada.before(saida)){
            System.out.println("erro na reserva!,  a data de entrada tem que ser antes da data de saida");
        }else {
            Reservation reserva = new Reservation(numeroQuarto, entrada, saida);

            System.out.println(reserva);
            System.out.println();
            System.out.println("insira os dados para atualizar a reserva:");
            System.out.print("data de entrada dd/MM/yyyy: ");
            entrada = sdf.parse(leitor.next());
            System.out.print("data de saida dd/MM/yyyy: ");
            saida = sdf.parse(leitor.next());


            String erro = reserva.dataDeAtualizacao(entrada, saida);
            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            }
            else{
                System.out.println(reserva);
            }


        }

        leitor.close();
    }
}
