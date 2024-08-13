public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(75);
        arvore.inserir(54);
        arvore.inserir(66);
        arvore.inserir(52);
        arvore.inserir(35);
        arvore.inserir(60);
        arvore.inserir(83);
        arvore.inserir(79);
        arvore.inserir(87);
        arvore.inserir(91);
        arvore.inserir(80);
        arvore.inserir(81);

        System.out.println("Árvore em ordem antes da remoção:");
        arvore.emOrdem(arvore.getRaiz());
        System.out.println("");
        System.out.println("========================================================================================");
        arvore.remover(75);

        System.out.println("Árvore em ordem após remoção de folhas:");
        arvore.emOrdem(arvore.getRaiz());




    }
}