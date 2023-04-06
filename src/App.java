import java.util.List;
import java.util.Map;
import java.net.URL;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception {

        //Api pública Nasa
        // String url = "https://api.nasa.gov/planetary/apod?api_key=RzqhhvuF5WfclH3nHbnMHy9XCAADvZrQxVPoLWZH&start_date=2022-06-12&end_date=2022-06-14";
        // contentExtractor extrator = new contentAPOD();

        //Api pública IMDB
        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // contentExtractor extrator = new contentIMDB();

        //Minha Api (linguagens de programação)
        String url = "http://localhost:8080/linguagens";
        contentExtractor extrator = new contentIMDB();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        //exibir e manipular dados
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        var geradora = new geradoraDeFigurinhas();
        
        for(int i=0; i<3; i++){
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "../out/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo, conteudo.getTitulo());
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
