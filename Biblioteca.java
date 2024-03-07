import java.util.ArrayList;
import java.util.List;
public class Biblioteca {
    private ArrayList<Livro> Livros;

    public Biblioteca() {
        this.Livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        Livros.add(livro);

    }

    public void editarLivro(String titulo, Livro novoLivro) {
        for (Livro livro : Livros) {
            if (livro.getTitulo().equals(titulo)) {
                livro.setTitulo(novoLivro.getTitulo());
                livro.setAutor(novoLivro.getAutor());
                livro.setAnoPublicacao(novoLivro.getAnoPublicacao());

                break;
            }
        }
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : Livros) {
            if (livro.getTitulo().equals(titulo)){
                if (!livro.verificarEmprestimo()) {
                    livro.setEmprestado(true);
                    System.out.println("Livro emprestado com sucesso.");
                } else {
                    System.out.println("livro já esta emprestado.");

                }
                return;
            }
        }
        System.out.println("Livro não encontrado na biblioteca.");
    }

    public void devolverLivro(String titulo){
        for (Livro livro : Livros) {
            if (livro.getTitulo().equals(titulo)) {
               if (!livro.verificarEmprestimo()) {
                    System.out.println("livro já foi devolvido");
                }else {
                   livro.setEmprestado(false);
                   System.out.println(" livro devolvido com sucesso");
                }
               return;
            }
        }
        System.out.println("Livro não encontrado na biblioteca.");
    }

}