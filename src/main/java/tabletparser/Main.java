package tabletparser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class Main {
//    public static void parse_category(String url) throws IOException {
//        File dir = new File("data");
//        dir.mkdir();
//        Document website = Jsoup.connect(url).get();
//        Elements nums = website.getElementsByClass("paginator-catalog-l-link");
//        String ele = nums.last().attr("onclick");
//        int value_index = nums.last().attr("onclick").indexOf("value:'");
//        int number_of_pages = ele.charAt(value_index+7);
//        for (int i = 1; i < number_of_pages + 1; i++) {
//            String pg = url + "page=" + i;
//            parse_category_page(pg);
//        }
//    }
//
//
//    public static void parse_category_page(String url) throws IOException {
//        Document website = Jsoup.connect(url).get();
//        Elements elements = website.getElementsByClass("g-i-tile-i-title");
//
//        for (Element ele : elements) {
//            String link = ele.getElementsByTag("a").attr("href");
//
//
//            parse_reviews(link + "comments/"); //final version
//        }
//    }
//
//
//    public static void parse_reviews(String url) throws IOException {
//        Document website = Jsoup.connect(url).get();
//        Elements nums = website.getElementsByClass("paginator-catalog-l-link");
//        int number_of_pages = 0;
//        if (nums.hasAttr("onclick")) {
//            String ele = nums.last().attr("onclick");
//            ele = ele.replaceAll("[^\\d]", "");
//            number_of_pages = Integer.parseInt(ele);
//        }
//
//        List sentiments = new ArrayList();
//
//        for (int i = 1; i < number_of_pages + 1; i++) {
//            String pg = url + "page=" + i;
//            sentiments.add(parse_reviews_page(pg));
//        }
//        if (!sentiments.isEmpty()) {
//            System.out.println(sentiments);
//        }
//        System.out.println(sentiments.size() + " reviews from " + url);
//    }
//
//
//    public static List parse_reviews_page(String url) throws IOException {
//        Document website = Jsoup.connect(url).get();
//        List sentiments = new ArrayList();
//        Elements reviews = website.select("article.pp-review-i");
//        for (Element review : reviews) {
//            Elements star = review.select("span.g-rating-stars-i");
//            Elements text = review.select("div.pp-review-text");
//            if (star.attr("content") != "") {
//                List inner = new ArrayList();
//                inner.add(star.attr("content"));
//                inner.add(text.first().text());
//                sentiments.add(inner);
//            }
//        }
//        return sentiments;
//    }
//
//
    public static void main(String [] args) throws IOException {
        String url = "https://rozetka.com.ua/ua/tablets/c130309/filter/";
        parse_category(url);
    }
}
