package modelo.servicos;

import modelo.entidade.AluguelCarro;
import modelo.entidade.Fatura;

public class ServicosAluguel {

	private Double precoDiario;
	private Double precoHora;
	
	private TaxaServico taxaServico;

	public ServicosAluguel(Double precoDiario, Double precoHora, TaxaServico taxaServico) {
		super();
		this.precoDiario = precoDiario;
		this.precoHora = precoHora;
		this.taxaServico = taxaServico;
	}
	
	public void processoFatura(AluguelCarro aluguelCarro) {
		long t1 = aluguelCarro.getInicio().getTime();
		long t2 = aluguelCarro.getFim().getTime();
		double horas = (double)(t2-t1)/1000/60/60;
		
		double pagBasico;
		
		if(horas <= 12.00) {
			pagBasico =  precoHora * Math.ceil(horas);
		}else {
			pagBasico =  precoDiario * Math.ceil(horas/24);
		}
		double taxa = taxaServico.taxa(pagBasico);
		
			aluguelCarro.setFatura(new Fatura(pagBasico, taxa));	
	}
}
