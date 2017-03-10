package com.fiap.Teste;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Scanner;

import com.fiap.estoquebo.EstoqueBOStub;
import com.fiap.estoquebo.EstoqueBOStub.ConsultarProduto;
import com.fiap.estoquebo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.estoquebo.EstoqueBOStub.GetLista;
import com.fiap.estoquebo.EstoqueBOStub.GetListaResponse;
import com.fiap.estoquebo.EstoqueBOStub.ProdutoTO;

public class TesteEstoque {
	
	
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		try {
			EstoqueBOStub bo = new EstoqueBOStub();
			ConsultarProduto p = new ConsultarProduto();
			System.out.print("Digite o código do produto: ");
			int codigo = t.nextInt();
			p.setCodigo(codigo);
			
			ConsultarProdutoResponse resp = bo.consultarProduto(p);
			System.out.println("Código:" + resp.get_return().getCodigo());
			System.out.println("Nome:" + resp.get_return().getNome());
			NumberFormat nF = NumberFormat.getCurrencyInstance();
			System.out.println("Valor:" + nF.format(resp.get_return().getValor()));
			System.out.println("Quantidade: " + resp.get_return().getQuantidade());
			
			GetLista getLista0 = new GetLista();
			GetListaResponse lista = bo.getLista(getLista0);
			
			for (ProdutoTO pp : lista.get_return()) {
				System.out.println(pp.getNome());
			}
			
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
		
		t.close();
	}

}
