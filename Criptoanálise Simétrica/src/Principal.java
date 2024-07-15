public class Principal {
	public static void main(String[] args) {
		String criptograma = "PuKub9qdO/tS2wOoJTxkne8RwhaH/cHZw9Ecg5IOh1l2mTxHS8uAIpxOcsczwkS1";
		
		for (int i = 97 ; i < 123 ; i++) { // Letras minúsculas
			new QuebraSenha(criptograma, "" + ((char) i)).start();
		}
		for (int i = 65 ; i < 91 ; i++) { // Letras maiúsculas
			new QuebraSenha(criptograma, "" + ((char) i)).start();
		}
		for (int i = 0 ; i < 10 ; i++) { // Números
			new QuebraSenha(criptograma, "" + i).start();
		}
	}
}