import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.InputStream;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.Color;
// import java.net.URL;

public class geradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo, String titulo) throws Exception{

        //leitura da imagem
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase
        graphics.drawString(titulo, 0, novaAltura-100);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
