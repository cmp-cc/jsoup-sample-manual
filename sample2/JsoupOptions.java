package org.freecode.sample2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.parser.Parser;

/**
 * 通常，开发者使用Jsoup的默认选项
 */
public class JsoupOptions {

	public static void main(String[] args) throws IOException {
		String url = "http://baidu.com/";
		
		//设置输入选项。将一个URL 地址内容转换为文档对象(Document)
		Document doc = Jsoup.connect(url)  
								.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36") // 无默认值
								.ignoreContentType(false) //默认为：false 
								.timeout(5*1000) //默认为： 3000
								.parser(Parser.htmlParser()) // 默认为：Parser.htmlParser()
								.data("key","value") //无默认值
								.post(); //post请求

		
		//设置输出选项。
		Document.OutputSettings settings = new Document.OutputSettings();
		settings.charset("utf-8") //字符集为UTF-8           默认为：UTF-8
		        .indentAmount(4)  //4个空格缩进                  默认为：1
		        .outline(true)    //自动换行                          默认：false
		        .escapeMode(EscapeMode.base)//转义模式    默认为：Entities.EscapeMode.base
		        .prettyPrint(true);//优雅输出                       默认为：true
		
		doc = doc.outputSettings(settings);
		
		System.out.println(doc.html());
		
	}
	
}	

 

