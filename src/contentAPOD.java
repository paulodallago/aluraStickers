import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class contentAPOD implements contentExtractor {
    public List<Conteudo> extraiConteudo(String json) {

        //extrair título, poster e classificação
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteúdos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }

        return conteudos;
    }
}