import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by Tommy on 2017/6/4.
 */
public class HospitalPageProcessor implements PageProcessor {

    private Site site = Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");

    public static void main(String[] args) {
        Spider.create(new HospitalPageProcessor()).addUrl("http://twypage.com/c4-%e4%b8%8d%e5%88%86%e7%a7%91%e8%a8%ba%e6%89%80.html")
                .addPipeline(new JsonFilePipeline("I:\\醫療相關資料\\crawler")).thread(5).run();
    }

    public void process(Page page) {

        // 部分二：定义如何抽取页面信息，并保存下来
      //  page.putField("body", page.getHtml());
        page.putField("link", page.getHtml().links().regex("http://twypage.com/c1-.+-.*.htnl").all().toString());
       // page.putField("linkHtml", page.getHtml().xpath("//*[@id=\"form1\"]/div/div/div/div/ul").all().toString());
        page.putField("linkHtmlRawText", page.getHtml().xpath("//*[@id=\"form1\"]/div/div/div/div[@itemscope]").all().toString());
      //  page.putField("linkHtmlcss", page.getHtml().css("html body form#form1 div.WRAPPER div.CONTAINER div.MAIN div.store_list ul.s2").all().toString());


       // page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
        // 抓頁面相關的連結繼續爬
        page.addTargetRequests(page.getHtml().links().regex("http://twypage.com/c1-*.+").all());
    }

    public Site getSite() {
        return site;
    }
}
