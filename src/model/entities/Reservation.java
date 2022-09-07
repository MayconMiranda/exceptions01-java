package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    private int numeroQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }

    public Reservation(int numeroQuarto, Date entrada, Date saida) {
        this.numeroQuarto = numeroQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public long duracao(){
        long diferenca = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public String dataDeAtualizacao(Date entrada, Date saida){
        Date agora = new Date();
        if(entrada.before(agora) || saida.before(agora)){
            return "Erro na reserva: as datas de reserva para atualização devem ser datas futuras";
        }
        if (!saida.after(entrada)) {
            return"erro na reserva!,  a data de entrada tem que ser antes da data de saida";
        }
        this.entrada = entrada;
        this.saida = saida;
        return null;
    }

    @Override
    public String toString() {
        return "reserva: " +
                "quarto " + numeroQuarto +
                ", entrada -" + sdf.format(entrada) +
                "-, saida -" + sdf.format(saida)
                +"-, "
                + duracao()+ " noites";
    }
}
