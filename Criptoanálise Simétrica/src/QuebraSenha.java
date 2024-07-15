import javax.swing.JOptionPane;

public class QuebraSenha extends Thread {
	// Propriedades da classe
	private String criptograma = "";
	private String letraInicial = "";
	
	// Método construtor cheio da classe
	public QuebraSenha(String criptograma, String letraInicial) {
		super();
		this.criptograma = criptograma;
		this.letraInicial = letraInicial;
	}
	
	// Método de execução paralela da classe
	public void run() {
		String c1 = "";
		String c2 = "";
		String c3 = "";
		
		for (int i = 0 ; i < 128 ; i++) {
			c1 = "" + ((char) i);
			for (int j = 0 ; j < 128 ; j++) {
				c2 = "" + ((char) j);
				for (int k = 0 ; k < 128 ; k++) {
					c3 = "" + ((char) k);
						
					try {
						String senha = letraInicial + c1 + c2 + c3;
						String texto = CriptografiaAES.decifrar(
							criptograma, senha);
						System.out.println(senha);
						if (validarTexto(texto)){
							JOptionPane.showMessageDialog(null,
							"Senha: " + senha + "\n" +
							"Texto: " + texto);
							System.exit(0);
						}
					} catch (Exception erro) {}
				}
			}
		}
	}
	
	private boolean validarTexto(String texto) {
		int quantidade = 0;

		for (int i = 0 ; i < texto.length() ; i++) {
			if ((((int) texto.charAt(i)) < 30) ||
			  (((int) texto.charAt(i)) > 128)) {
				quantidade++;
			}
		}
		
		int percentual = ((100 * quantidade) / texto.length());
		
		return (percentual < 20);
	}
}