package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidade.AluguelCarro;
import modelo.entidade.Veiculo;
import modelo.servicos.ServicosAluguel;
import modelo.servicos.TaxaServicosBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:ss");
	
	System.out.println("INSIRA OS DADOS DE ALUGUEL:");
	System.out.print("Modelo do carro: ");
	String modeloCarro = sc.nextLine();
	System.out.print("Inicio (dd/MM/yyyy hh:ss): ");
	Date inicio = sdf.parse(sc.nextLine());
	System.out.print("Retorno (dd/MM/yyyy hh:ss): ");
	Date fim = sdf.parse(sc.nextLine());
	
	AluguelCarro ac = new AluguelCarro(inicio, fim, new Veiculo(modeloCarro));
	
	System.out.print("Insira o valor por hora: ");
	double precoHora = sc.nextDouble();
	System.out.print("Insira o valor por dia: ");
	double precoDia = sc.nextDouble();
	
	ServicosAluguel sa = new ServicosAluguel(precoDia,precoHora, new TaxaServicosBrasil());
	
	sa.processoFatura(ac);
	
	System.out.println("FATURA: ");
	System.out.println("PAGAMENTO BÁSICO: " + String.format("%.2f", ac.getFatura().getPagBasico()));
	System.out.println("TAXA: " + String.format("%.2f", ac.getFatura().getTaxa()));
	System.out.println("PAGAMENTO TOTAL: " + String.format("%.2f", ac.getFatura().pagTotal()));
	sc.close();
	}

}
