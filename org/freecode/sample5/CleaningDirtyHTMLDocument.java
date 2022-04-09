package org.freecode.sample5;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

public class CleaningDirtyHTMLDocument {
	
	// 读取一个带有 XSS攻击的html文件
	static File file = new File(CleaningDirtyHTMLDocument.class.getResource("XSSed.html").getFile());
	public static void main(String[] args) {
		//使用Jsoup清洗HTML代码，避免XSS攻击。
		
		try {
			Document doc = Jsoup.parse(file,"utf-8");
			//创建 Whitelist.
			Whitelist allowList = Whitelist.relaxed();
			// 添加更多允许标签
			allowList
			  .addTags("meta", "title", "script", "iframe")
			  .addAttributes("meta", "charset")
			  .addAttributes("iframe", "src")
			  .addProtocols("iframe", "src", "http", "https");
			
			// 创建 Cleaner, 这将完成清洁任务
			Cleaner cleaner = new Cleaner(allowList);
			
			// 清洁脏的HTML。
			Document newDoc = cleaner.clean(doc);
			
			System.out.println(newDoc.html());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
