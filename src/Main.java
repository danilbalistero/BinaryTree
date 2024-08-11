public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(72);
        arvoreBinaria.inserir(87);
        arvoreBinaria.inserir(37);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(12);
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("----------------------------");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("----------------------------");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

    }
}