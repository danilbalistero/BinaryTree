public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
        return novoNo;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void remover(int valor){
        //buscando elemento
        No atual = this.raiz;
        No pai = null;

        while (atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }

        //se o no nao foi encontrado
        if (atual == null) {
            System.out.println("Valor não encontrado na árvore.");
            return;
        }

        //no folha
        if (atual.getEsq() == null && atual.getDir() == null){
            if (pai == null) {
                raiz = null; //se não tiver um pai, é a raiz e com isto é apenas colocar null
            } else {
                if (pai.getEsq() == atual) {
                    pai.setEsq(null);
                } else {
                    pai.setDir(null);
                }
            }
        }

        //no com um filho a direita
        if(atual.getEsq() == null && atual.getDir() != null) { //se atual esquerda = null e atual direita diferente de null
            if (pai == null) {
                raiz = atual.getDir(); //passa a ser filho direto do nó
            } else if (pai.getEsq() == atual) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
        }

        //no com um filho a esquerda
        if (atual.getDir() == null && atual.getEsq() != null){
            if (pai == null) {
                raiz = atual.getEsq();
            } else if (pai.getDir() == atual) {
                pai.setDir(atual.getEsq());
            } else {
                pai.setEsq(atual.getEsq());
            }
        }

        //no com dois filhos
        if(atual.getDir() != null && atual.getEsq() != null){ //verificando se contem dois filhos
            No sucessor = atual.getDir();
            No paiSucessor = atual;
            while (sucessor.getEsq() != null) { //encontrando o menor nó da subarvore esquerda
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }

            atual.setValor(sucessor.getValor()); //copia o valor do sucessor no nó atual
            //remove o sucessor
            if (paiSucessor == atual) {
                paiSucessor.setDir(sucessor.getDir());
            } else {
                paiSucessor.setEsq(sucessor.getDir());
            }
        }
    }
}
