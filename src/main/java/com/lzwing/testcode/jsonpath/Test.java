package com.lzwing.testcode.jsonpath;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/6
 * Time: 16:24
 */
public class Test {

    public static void getChildren(ReadContext context,int indent,StringBuilder sb) {

        Object name = context.read("$.name");
        Object children = null;
        Object type = null;
        Object url = null;
        try {
            type = context.read("$.type");
            url = context.read("$.url");
        } catch (Exception e) {

        }
        if ("url".equals(type)&&url!=null) {
            sb.append(String.format("%s[%s](%s)%s", StringUtils.repeat("#",indent),name,url,"\n"));
        }else{
            sb.append(String.format("%s%s%s",StringUtils.repeat("#",indent),name,"\n"));
        }
        try {
            children = context.read("$.children");
        } catch (Exception e) {

        }
        if (children != null) {
            int level = indent+1;
            for (Object subItm : (List)children) {
                ReadContext subItmCtx = JsonPath.parse(subItm);
                getChildren(subItmCtx,level,sb);
            }
        }


    }

    public static void main(String[] args) throws Exception{
        String path = "D:\\test\\bookmarks.json";
        String jsonStr = FileUtils.readFileToString(new File(path));

        String writeFile = "C:\\Users\\Administrator\\Desktop\\test\\bookmark.md";

        StringBuilder sb = new StringBuilder();

        ReadContext context = JsonPath.parse(jsonStr);
        List<Object> itms = context.read("$.roots.bookmark_bar.children[7].children[*]");
        for (Object itm : itms) {
            ReadContext itmCtx = JsonPath.parse(itm);
            getChildren(itmCtx,1,sb);
        }

        FileUtils.writeStringToFile(new File(writeFile),sb.toString());

        System.out.println("OK...");
    }
}
