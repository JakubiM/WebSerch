import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class Main {

    private static String Url = "https://pogoda.interia.pl/prognoza-dlugoterminowa-ciosmy,cId,4885";
    private static int timeout = 20000;

    public static void main(String[] args){


        Document document;
        try
        {
            document = Jsoup.parse(new URL(Url), timeout);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return;
        }

        Elements temperatura = document.select(".weather-currently-temp-strict");
        assert (temperatura.size() == 1);
        String aktualnaTemp = temperatura.first().text();

        Elements miejscowosc = document.select(".weather-currently-city");
        assert (temperatura.size() == 1);
        String akutalnaMiejsc = miejscowosc.first().text();





        System.out.println("Aktualna temperatura w " + akutalnaMiejsc +" to: " + aktualnaTemp);
    }
}
