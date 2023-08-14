package com.lppnb.snapup.snapup.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitSnapupTask {
    public void execute() {
        String url = "https://www.cctalk.com/m/group/90928519";

        final WebClient webClient = new WebClient(BrowserVersion.EDGE);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象

        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);//不启用ActiveX
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClient.getOptions().setDownloadImages(false);//不下载图片
        webClient.getOptions().setTimeout(60000);//设置超时时间
        webClient.getOptions().setRedirectEnabled(true);//允许重定向
        webClient.getCookieManager().setCookiesEnabled(true);//允许cookie

        HtmlPage page = null;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }

        webClient.waitForBackgroundJavaScript(10000);//异步JS执行需要耗时,所以这里线程要阻塞10秒,等待异步JS执行结束

        System.out.println(page.asXml());
    }
}
