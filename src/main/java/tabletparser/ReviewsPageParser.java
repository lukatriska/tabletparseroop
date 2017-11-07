package tabletparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewsPageParser {

    public static List parse_reviews_page(String url) throws IOException {
        Document website = Jsoup.connect(url).get();
        List sentiments = new ArrayList();
        Elements reviews = website.select("article.pp-review-i");
        for (Element review : reviews) {
            Elements star = review.select("span.g-rating-stars-i");
            Elements text = review.select("div.pp-review-text");
            if (star.attr("content") != "") {
                List inner = new ArrayList();
                inner.add(star.attr("content"));
                inner.add(text.first().text());
                sentiments.add(inner);
            }
        }
        return sentiments;
    }

}
