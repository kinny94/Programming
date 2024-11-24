package algorithms.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFSWebCrawler {

    public Queue<String> queue;
    public List<String> discoveredWebsites;

    public BFSWebCrawler() {
        queue = new LinkedList<>();
        discoveredWebsites = new ArrayList<>();
    }

    public void discoverWebsites(String root) {
        this.queue.add(root);
        this.discoveredWebsites.add(root);
        while (!this.queue.isEmpty()) {
            String currentWebsite = this.queue.remove();
            String rawHtml = readUrl(currentWebsite);
            String regEx = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()) {
                String w = matcher.group();
                if (!this.discoveredWebsites.contains(w)) {
                    this.discoveredWebsites.add(w);
                    System.out.println("Found website: " + w);
                    queue.add(w);
                }
            }
        }
    }

    private String readUrl(String v) {
         StringBuilder rawHtml = new StringBuilder("");
        try {
            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                rawHtml.append(line);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Problem while crawling website");
        }
        return rawHtml.toString();
    }

    public static void main(String[] args) {
        BFSWebCrawler crawler = new BFSWebCrawler();
        crawler.discoverWebsites("https://www.bbc.com");
    }
}
