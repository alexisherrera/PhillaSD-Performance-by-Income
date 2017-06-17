import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by alexisherrera on 5/1/17.
 */
public class PhillyIncomeStats {

    private String link;
    private Document doc;


    //constructor which takes in the link to the website which contains all of the
    //data for income
    public PhillyIncomeStats(String link) {
        this.link = link;
        try {
            doc = Jsoup.connect(link).get();
        }
        catch (IOException e) { e.printStackTrace(); }

    }


    //create a hashmap that contains zip codes along with their corresponding
    //median income. These are all in Philly and I use JSoup to scrape them
    //from: http://zipatlas.com/us/pa/philadelphia/zip-code-comparison/median-household-income.htm
    //which is collected from the 2010 Census zipcode database
    public HashMap<Integer, Double> getMedianIncomeByZipCode() {
        Element table = doc.select("table").get(13);
        Elements rows = table.select("tr");

        HashMap<Integer, Double> zip_income_map = new HashMap<>();

        int first = 0;

        //iterate through the rows of the table and get zipcode and corresponding income
        for (Element row: rows) {
            //skip header
            if (first == 0) { first = 1; continue; }

            //get the zip code
            int zip = Integer.parseInt(row.select("td").get(1).text());

            //get income
            double income = Double.parseDouble(row.select("td").get(5).text().substring(1).replace(",", ""));

            //put into our hashmap
            zip_income_map.put(zip, income);
        }
        //System.out.println(rows);
        return zip_income_map;
    }
}
