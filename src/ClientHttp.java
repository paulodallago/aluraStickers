import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;

public class ClientHttp {
    
    public String buscaDados(String url) {
        try {
            //fazer a conexão http e buscar filmes
            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}