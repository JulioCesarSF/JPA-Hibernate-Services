package br.com.fiap.view;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Buscar;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;

public class Tela {

	protected Shell shlDesk;
	private Text txtNome;
	private Text txtDescricao;
	private Text txtPreco;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDesk.open();
		shlDesk.layout();
		while (!shlDesk.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDesk = new Shell();
		shlDesk.setSize(272, 312);
		shlDesk.setText("Desktop Requester");

		Label lblNome = new Label(shlDesk, SWT.NONE);
		lblNome.setBounds(10, 29, 55, 15);
		lblNome.setText("Nome");

		txtNome = new Text(shlDesk, SWT.BORDER);
		txtNome.setBounds(71, 26, 175, 21);

		Label lblDescrio = new Label(shlDesk, SWT.NONE);
		lblDescrio.setBounds(10, 83, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");

		txtDescricao = new Text(shlDesk, SWT.BORDER);
		txtDescricao.setBounds(71, 80, 175, 42);

		Label lblPreo = new Label(shlDesk, SWT.NONE);
		lblPreo.setBounds(10, 56, 55, 15);
		lblPreo.setText("Pre\u00E7o");

		txtPreco = new Text(shlDesk, SWT.BORDER);
		txtPreco.setBounds(71, 53, 175, 21);

		ProgressBar progressBar = new ProgressBar(shlDesk, SWT.SMOOTH);
		progressBar.setBounds(10, 246, 236, 17);

		Label txtStatus = new Label(shlDesk, SWT.NONE);
		txtStatus.setBounds(10, 226, 236, 15);
		txtStatus.setText("Status:");

		Button btnEnviar = new Button(shlDesk, SWT.NONE);
		btnEnviar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						String nome = txtNome.getText();
						String desc = txtDescricao.getText();
						float valor = Float.parseFloat(txtPreco.getText());
						txtStatus.setText("Preparando...");
						progressBar.setSelection(10);
						// Executa no clique do botão
						try {
							PratoBOStub stub = new PratoBOStub();
							progressBar.setSelection(20);
							// valores para o webservice
							Cadastrar params = new Cadastrar();
							Prato prato = new Prato();
							txtStatus.setText("Preparando entity");
							progressBar.setSelection(30);
							prato.setDescricao(desc);
							prato.setNome(nome);
							prato.setPreco(valor);
							params.setEntity(prato);
							txtStatus.setText("Cadastrando...");
							progressBar.setSelection(60);
							stub.cadastrar(params);
							txtStatus.setText("Cadastrado!");
							progressBar.setSelection(100);

							MessageBox dialog = new MessageBox(shlDesk, SWT.OK);
							dialog.setMessage("SUCESSO!");
							dialog.open();
						} catch (Exception e1) {
							e1.printStackTrace();
							txtStatus.setText("Erro" + e1.getMessage());
						}
					}
				});
			}

		});
		btnEnviar.setBounds(71, 128, 175, 25);
		btnEnviar.setText("Enviar");

		Label lblCadastrar = new Label(shlDesk, SWT.NONE);
		lblCadastrar.setBounds(10, 10, 55, 15);
		lblCadastrar.setText("Cadastrar");

		Label lblBuscar = new Label(shlDesk, SWT.NONE);
		lblBuscar.setBounds(10, 167, 55, 15);
		lblBuscar.setText("Buscar");

		Label lblId = new Label(shlDesk, SWT.NONE);
		lblId.setBounds(10, 188, 55, 15);
		lblId.setText("Id");

		txtCodigo = new Text(shlDesk, SWT.BORDER);
		txtCodigo.setBounds(71, 185, 76, 21);

		Button btnBuscar = new Button(shlDesk, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						int codigo = Integer.parseInt(txtCodigo.getText());

						PratoBOStub bo;
						txtStatus.setText("Iniciando busca...");
						progressBar.setSelection(10);
						try {
							bo = new PratoBOStub();
							Buscar b = new Buscar();
							b.setId(codigo);
							
							progressBar.setSelection(20);
							txtStatus.setText("Buscando..");
							progressBar.setSelection(40);
							
							Prato prato = bo.buscar(b).get_return();
							if (prato != null) {
								txtNome.setText(prato.getNome());
								progressBar.setSelection(60);
								txtDescricao.setText(prato.getDescricao());
								progressBar.setSelection(80);
								txtPreco.setText(String.valueOf(prato.getPreco()));
								progressBar.setSelection(100);
								txtStatus.setText("Concluído!");
							} else {
								progressBar.setSelection(100);
								txtStatus.setText("Prato não encontrado!");
							}
						} catch (AxisFault e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							txtStatus.setText("Erro:" + e1.getMessage());
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							txtStatus.setText("Erro:" + e1.getMessage());
						}

					}
				});

			}
		});
		btnBuscar.setBounds(171, 183, 75, 25);
		btnBuscar.setText("Buscar");

	}
}
