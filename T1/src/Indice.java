import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Indice {
    private NodoPalavra refHeadPalavra = null;
    private NodoPalavra refTailPalavra;

    private class NodoPalavra {
        private String palavra;
        private NodoPagina refHeadPagina;
        private NodoPagina refTailPagina;
        private NodoPalavra refNextPalavra;
        public String getPalavra(){
            return palavra;
        }
        public void setPalavra(String palavra){
            this.palavra=palavra;
        }
        public NodoPalavra getRefNext(){
            return refNextPalavra;
        }
        public void setRefNext(NodoPalavra refNextPalavra){
            this.refNextPalavra = refNextPalavra;
        }
        public boolean addPagina(int numero){
            NodoPagina novaPagina = new NodoPagina();
            novaPagina.setPagina(numero);
            if(refHeadPagina==null){
                refHeadPagina=novaPagina;
                refTailPagina=novaPagina;
            }else{
                refTailPagina.setRefNextPagina(novaPagina);
                refTailPagina=novaPagina;
            }
            return true;
        }
    }

    private class NodoPagina {
        private int pagina;
        private NodoPagina refNextPagina;
        public int getPagina(){return pagina;}
        public void setPagina(int pagina){this.pagina=pagina;}
        public NodoPagina getRefNextPagina(){return refNextPagina;}
        public void setRefNextPagina(NodoPagina nextPagina){refNextPagina=nextPagina;}
    }

    public NodoPagina containsPagina(NodoPalavra palavra, int pagina){
        NodoPagina aux= palavra.refHeadPagina;
        while(aux!=null){
            if(aux.getPagina()==pagina){
                return aux;
            }
            aux = aux.getRefNextPagina();
        }
        return aux;
    }

    public boolean addPalavraPagina(String palavra, int pagina){
        NodoPalavra aux=refHeadPalavra;
        if(aux==null){
            addLastPalavraPagina(palavra, pagina);
        }else{
            NodoPalavra aux2=null;
            while (aux!=null) {
                if (palavra.compareTo(aux.getPalavra()) == 0) {
                    NodoPagina containsPagina=containsPagina(aux,pagina);
                    if(containsPagina==null){
                        aux.addPagina(pagina);
                        return true;
                    }else{
                        return false;
                    }
                }else if(palavra.compareTo(aux.getPalavra()) < 0) {
                    if(aux==refHeadPalavra){
                        addFirstPalavraPagina(palavra,pagina);
                        return true;
                    }else{
                        addBeetwenPalavraPagina(palavra,pagina,aux2,aux);
                        return true;
                    }
                }
                aux2=aux;
                aux = aux.refNextPalavra;
            }
            addLastPalavraPagina(palavra, pagina);
        }
        return true;
    }

    public boolean addFirstPalavraPagina(String palavra, int pagina){
        NodoPalavra novaPalavra = new NodoPalavra();
        novaPalavra.setPalavra(palavra);
        novaPalavra.addPagina(pagina);
        novaPalavra.setRefNext(refHeadPalavra);
        refHeadPalavra=novaPalavra;
        return true;
    }

    public boolean addBeetwenPalavraPagina(String palavra, int pagina, NodoPalavra anterior, NodoPalavra posterior){
        NodoPalavra novaPalavra = new NodoPalavra();
        novaPalavra.setPalavra(palavra);
        novaPalavra.addPagina(pagina);
        anterior.setRefNext(novaPalavra);
        novaPalavra.setRefNext(posterior);
        return true;
    }

    public boolean addLastPalavraPagina(String palavra, int pagina){
        NodoPalavra novaPalavra = new NodoPalavra();
        novaPalavra.setPalavra(palavra);
        novaPalavra.addPagina(pagina);
        if(refHeadPalavra==null){
            refHeadPalavra=novaPalavra;
            refTailPalavra=novaPalavra;
        }else{
            refTailPalavra.setRefNext(novaPalavra);
            refTailPalavra=novaPalavra;
        }
        return true;
    }

    public boolean readBook(String fileName){
        Path path = Paths.get(fileName);
        int contPage=1;
        int contLines=0;
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(contLines==40){
                    contLines=0;
                    contPage++;
                }
                line = line.toLowerCase().replaceAll("[-,+.\"()\\[\\]_*:{}$&%@#/'æ£°!?;]"," ");
                for (String l: line.split(" ")){
                    if (l.length()>0){
                        addPalavraPagina(l,contPage);
                    }
                }
                contLines++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
        return true;
    }

    public String searchPalavra(String p) {
        NodoPalavra aux = refHeadPalavra;
        String paginas = "";
        while (aux!=null) {
            if (refHeadPalavra != null) {
                if (aux.getPalavra().equals(p.toLowerCase())) {
                    NodoPagina auxPag = aux.refHeadPagina;
                    while (auxPag != null) {
                        paginas += auxPag.getPagina() + "; ";
                        auxPag = auxPag.refNextPagina;
                    }
                    return "A palavra \"" + aux.getPalavra() + "\" aparece nas seguintes paginas:\n" + paginas;
                } else {
                    aux = aux.getRefNext();
                }
            }
        }
        return "A palavra \""+p+"\" não foi encontrada";
    }

    public String toString(){
        NodoPalavra aux=refHeadPalavra;
        String indices="";
        while(aux!=null){
            if(refHeadPalavra != null)
            {
                String paginas="";
                NodoPagina auxPag=aux.refHeadPagina;
                while (auxPag!=null){
                    paginas+=auxPag.getPagina()+"; ";
                    auxPag=auxPag.refNextPagina;
                }
                indices+= aux.getPalavra()+":\n\tpágina(s) => "+paginas+"\n";
                aux = aux.getRefNext();
            }
        }
        return indices;
    }
}