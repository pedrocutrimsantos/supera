package br.com.supera.game.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class ItemCompra {
	@Entity
	@Table(name = "ItensCompra")
	public class ItensCompra implements Serializable {

		public ItensCompra() {
			super();
		}

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@ManyToOne
		private Product product;

		@ManyToOne
		private Venda compra;

		private Integer quantidade;

		private Double valorUnitario = 0.;

		private Double valorTotal = 0.;

		public Double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Product getProduto() {
			return product;
		}

		public void setProduto(Product produto) {
			this.product = produto;
		}

		public Venda getCompra() {
			return compra;
		}

		public void setCompra(Venda compra) {
			this.compra = compra;
		}

		public Integer getQuantidade() {
			if (quantidade == null) {
				quantidade = 0;
			}
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

		public Double getValorUnitario() {
			return valorUnitario;
		}

		public void setValorUnitario(Double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}

	}

}
