package com.guanqi.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class GithubRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
  /*      page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
        if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
   */
       // Document document = Jsoup.parse("http://music.163.com/");

        //System.out.println("================="+document.toString());
        //page.putField("html", page.getHtml());
        ////h2[@class='csdn-tracking-statistics']//a//text()
        //"csdn-tracking-statistics  ='csdn-tracking-statistics'
      // page.addTargetRequests(page.getUrl().regex("//https://\\.music.163\\.com/\\.").all());
        page.putField("html", page.getHtml().xpath("//*[@id=\"index-banner\"]/"));
        String html = page.getResultItems().get("html").toString();
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider spider = Spider.create(new GithubRepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://music.163.com/")
                //开启5个线程抓取
                .thread(5);
        //启动爬虫
        spider.run();
    }
}
