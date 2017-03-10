package com.fiap.EstoqueBO;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.beans.ProdutoTO;

public class EstoqueBO {
	
	private List<ProdutoTO> lista = new ArrayList<>();
	
	public EstoqueBO(){
		ProdutoTO p = new ProdutoTO("Camiseta Masculina Manga Curta Branca.", 401, 123.12, 10);
		this.getLista().add(p);
		p = new ProdutoTO("Camiseta Feminina Manga Longa Rosa.", 402, 345.21, 20);
		this.getLista().add(p);
	}
	
	public ProdutoTO consultarProduto(int codigo) throws AxisFault{
		ProdutoTO produto = null;
		for (ProdutoTO pro : lista) {
			if (pro.getCodigo() == codigo)
				produto = pro;
		}
		if(produto == null)
			throw new AxisFault("Produto Não encontrado");
		return produto;
	}
	
	public List<ProdutoTO> listar(){
		return lista;
	}

	public List<ProdutoTO> getLista() {
		return lista;
	}

	public void setLista(List<ProdutoTO> lista) {
		this.lista = lista;
	}
}
