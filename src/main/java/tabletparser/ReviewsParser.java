package tabletparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReviewsParser extends ReviewsPageParser{



    public static void parse_reviews(String url) throws IOException {
        Document website = Jsoup.connect(url).get();
        Elements nums = website.getElementsByClass("paginator-catalog-l-link");
        int number_of_pages = 0;
        if (nums.hasAttr("onclick")) {
            String ele = nums.last().attr("onclick");
            ele = ele.replaceAll("[^\\d]", "");
            number_of_pages = Integer.parseInt(ele);
        }

        List sentiments = new ArrayList();

        for (int i = 1; i < number_of_pages + 1; i++) {
            String pg = url + "page=" + i;
            ReviewsPageParser prp = new ReviewsPageParser();
            sentiments.add(prp.parse_reviews_page(pg));
        }
        if (!sentiments.isEmpty()) {
            System.out.println(sentiments);
        }
        System.out.println(sentiments.size() + " reviews from " + url);
    }

}
