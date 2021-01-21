package com.lzwing.testcode.excel;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/7/29
 * Time: 15:55
 */
public class Html2image {

    public static void main(String[] args) throws Exception{
        String htmlPath = "/Users/longzhiwu/downloads/test.html";
        File htmlFile = new File(htmlPath);
        String imageHtml = FileUtils.readFileToString(htmlFile);
        MyHtmlImageGenerator imageGenerator = new MyHtmlImageGenerator();
        String imageName = "/Users/longzhiwu/downloads/test.png";
        imageGenerator.loadHtml(imageHtml);
        //Thread.sleep(1000); //有时会有加载图片延迟，因此这里设置下延时
        imageGenerator.getBufferedImage();
        //Thread.sleep(2000);
        imageGenerator.saveAsImage(imageName);

    }
}
