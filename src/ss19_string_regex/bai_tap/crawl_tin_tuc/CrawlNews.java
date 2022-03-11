package ss19_string_regex.bai_tap.crawl_tin_tuc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/THE-GIOI.HTM");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
//            System.out.println(content);
            content = content.replaceAll("\\n+", "");
//            System.out.println(content);
            Pattern p = Pattern.compile("<h3 class=\"article-title\"> <a .{0,500}\">(.{0,300})</a> </h3>");
            Matcher m = p.matcher(content);
            System.out.println("Result");
            while (m.find()) {
                System.out.println(m.group(1).replaceAll("&quot;","\"")); // escape HTML entity
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
