package modelo.entidade;

public class Fatura {
	Double pagBasico;
	Double taxa;
	
	public Fatura() {
		
	}
	
	public Fatura(Double pagBasico, Double taxa) {
		super();
		this.pagBasico = pagBasico;
		this.taxa = taxa;	
	}

	public Double getPagBasico() {
		return pagBasico;
	}

	public void setPagBasico(Double pagBasico) {
		this.pagBasico = pagBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	public Double pagTotal() {
		return getPagBasico()+getTaxa();
	}
}
