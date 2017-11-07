package tabletparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryPageParser {

    public static void parse_category_page(String url) throws IOException {
        Document website = Jsoup.connect(url).get();
        Elements elements = website.getElementsByClass("g-i-tile-i-title");

        for (Element ele : elements) {
            String link = ele.getElementsByTag("a").attr("href");

            ReviewsParser rp = new ReviewsParser();
            rp.parse_reviews(link + "comments/"); //final version
        }
    }
}
