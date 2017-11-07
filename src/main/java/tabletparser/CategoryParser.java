package tabletparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;


public class CategoryParser {

    public static void parse_category(String url) throws IOException {
        File dir = new File("data");
        dir.mkdir();
        Document website = Jsoup.connect(url).get();
        Elements nums = website.getElementsByClass("paginator-catalog-l-link");
        String ele = nums.last().attr("onclick");
        int value_index = nums.last().attr("onclick").indexOf("value:'");
        int number_of_pages = ele.charAt(value_index+7);
        for (int i = 1; i < number_of_pages + 1; i++) {
            String pg = url + "page=" + i;
            parse_category_page(pg);
        }


    }
