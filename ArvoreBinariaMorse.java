public class ArvoreBinariaMorse {
    public No raiz;

    public void inicializar() {
        raiz = new No();
        construirArvoreMorse();
    }

    // Inserir Caractere

    //percorre a arvore, se for . move para o esquerdo, se for - move para o direito (se não existir cria um novo nó)
    // no final é inserido o caractere
    public void inserir(String codigoMorse, char caractere) {
        No atual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                if (atual.esquerdo == null) {
                    atual.esquerdo = new No();
                }
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) {
                    atual.direito = new No();
                }
                atual = atual.direito;
            } else {
                return;
            }
        }
        atual.caractere = caractere;
    }




    // buscar um caracter na arvore, se for . move para o esquerdo, se for - move para o direito
    //percorre a arvore simbolo por simbolo
    //algum nó durante o percurso for null, a função retorna null (feito pq o morse vai ser invalido)
    //caso tenha sucesso retorna o correspondente
    public Character buscar(String codigoMorse) {
        No atual = raiz;
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                atual = atual.direito;


            } else {
                return null;
            }
            if (atual == null) {
                return null;
            }
        }
        return atual.caractere;
    }



    // decodificar Morse
    //usa o buscar para encontrar o caractere correspondente
    //se o caractere não for encontrado adiciona um ?
    public String decodificarMensagem(String mensagemMorse) {
        StringBuilder resultado = new StringBuilder();
        String[] codigos = mensagemMorse.trim().split("\\s+"); // Divide por espaços em branco

        for (String codigo : codigos) {
            if (codigo.equals("/")) {
                // Separa palavras
                resultado.append(" ");
            } else {
                Character caractere = buscar(codigo);
                if (caractere != null) {
                    resultado.append(caractere);
                } else {
                    resultado.append("?"); // Desconhecido
                }
            }
        }
        return resultado.toString();
    }

    // Construir arvore base
    private void construirArvoreMorse() {
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }
}
