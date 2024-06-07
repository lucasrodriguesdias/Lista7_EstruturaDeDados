package Fila_Array;

public class Fila {
        private int[] fila;
        private int tamanho;
        private int capacidade;
        private int inicio;
        private int fim;

        // Fila com capacidade fixa determinado pelo usuario
        public Fila(int capacidade) {
            this.capacidade = capacidade;
            this.fila = new int[capacidade];
            this.tamanho = 0;
            this.inicio = 0;
            this.fim = 0;
        }
    // Inserir um elemento na fila
    public boolean inserirValor(int valor) {
        //verifica fila vazia
        if (tamanho == capacidade) {
            System.out.println("Fila cheia. Não é possível inserir o valor: " + valor);
            return false;
        }

        fila[fim] = valor;
        fim++;
        //verifica se a fila atingiu a capacidade máxima
        if (fim == capacidade) {
            fim = 0; // Volta ao início do array
        }
        tamanho++;
        return true;
    }

    // Remover um elemento da fila
    public Integer removerValor() {
        if (tamanho == 0) {
            System.out.println("Fila vazia. Não há elementos para remover.");
            return null;
        }
        int valorRemovido = fila[inicio];
        inicio++;
        if (inicio == capacidade) {
            inicio = 0; // Volta ao início do array
        }
        tamanho--;
        return valorRemovido;
    }

    public void exibir() {
        if (tamanho == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < tamanho; i++) {
            int index = inicio + i;

            if (index >= capacidade) {
                index -= capacidade; // ajustar o índice quando ultrapassa a capacidade por conta da circularidade
            }
            System.out.print(fila[index]);

            if (i < tamanho - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Retornar o número de elementos na fila
    public int tamanho() {
        return tamanho;
    }

    // Verificar se um valor específico está armazenado na fila
    public boolean pesquisar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            int index = inicio + i;
            if (index >= capacidade) {
                index -= capacidade; // ajustar o índice quando ultrapassa a capacidade para tratar a circularidade da fila
            }
            if (fila[index] == valor) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Fila fila = new Fila(5); // Capacidade fixa de 5 elementos
        fila.inserirValor(5);
        fila.inserirValor(10);
        fila.inserirValor(50);
        fila.inserirValor(45);
        fila.inserirValor(60);
        System.out.println("Tamanho da fila: " + fila.tamanho());
        fila.exibir();
        System.out.println("Pesquisar 45: " + fila.pesquisar(45));
        System.out.println("Pesquisar 90: " + fila.pesquisar(90));
        System.out.println("Elemento removido: " + fila.removerValor());
        System.out.println("Elemento removido: " + fila.removerValor());
        System.out.println("Tamanho da fila: " + fila.tamanho());
        fila.exibir();
    }
}
