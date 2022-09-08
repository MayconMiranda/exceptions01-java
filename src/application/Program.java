package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("numero do quarto: ");
            int numeroQuarto = leitor.nextInt();
            System.out.print("data de entrada dd/MM/yyyy: ");
            Date entrada = sdf.parse(leitor.next());
            System.out.print("data de saida dd/MM/yyyy: ");
            Date saida = sdf.parse(leitor.next());

            Reservation reserva = new Reservation(numeroQuarto, entrada, saida);
            System.out.println(reserva);

            System.out.println();
            System.out.println("insira os dados para atualizar a reserva:");
            System.out.print("data de entrada dd/MM/yyyy: ");
            entrada = sdf.parse(leitor.next());
            System.out.print("data de saida dd/MM/yyyy: ");
            saida = sdf.parse(leitor.next());

            reserva.dataDeAtualizacao(entrada, saida);
            System.out.println(reserva);
        }
        catch (ParseException e){
            System.out.println("data invalida! ");
        }
        catch (DomainException e){
            System.out.println("erro na reserva: "+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("erro: Insira numeros inteiros");
        }
        catch (RuntimeException e){
            System.out.println("erro inesperado");
        }

        leitor.close();
    }
}
