package org.freecode.sample3;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class JsoupDomOperation {
	public static void main(String[] args) {
		Document doc = null;
		try {
			// 数据输入: 目标 编码    baseUri
			doc = Jsoup.parse(JsoupDomOperation.class.getResourceAsStream("index.html"),"UTF-8","http://www.jsoup.org/");
//Dom 方式获取元素			
			//获取导航栏
			Elements navDivTag = doc.getElementsByClass("nav-sections");
//Css 选择器获取元素			
			//使用CSS 选择器的方式获取多余行。使用CSS选择器使用doc.select方法
			Elements liTag = doc.select("li:contains(多余)");
			Element h1TitleElement = doc.select(".title").get(0);
//修改元素内容			
			h1TitleElement.text("Jsoup 官方导航栏");
//移除属性			
			h1TitleElement.removeAttr("align");
			
//移除元素	移除多余行		
			liTag.remove();
			//  <li class="n1-try"><a href="http://try.jsoup.org/">Try jsoup</a></li>
//创建元素			
			Element tagLiElement = new Element(Tag.valueOf("li"), "");
			Element tagAElement = new Element(Tag.valueOf("a"), "");
//添加属性
			tagLiElement.addClass("n1-try");
			tagAElement.attr("href","http://try.jsoup.org/");
//添加文本
			tagAElement.text("Try jsoup");
//追加元素          //添加一个子元素
			tagLiElement.appendChild(tagAElement);
			//ul 添加子元素 tagLiElement
			doc.select(".nav-sections ul").get(0).appendChild(tagLiElement);
			
			//获得第一个元素ul 获取所有a标签元素
			Elements aTagList = navDivTag.get(0).getElementsByTag("a");
//打印绝对路径和相对路径			
			// absUrl 方法会将baseUri追加到href前面。等价于 aTag.attr("abs:href")
			for(Element aTag: aTagList) {
				System.out.println(String.format("绝对路径：%s\t相对路径：%s", aTag.absUrl("href"),aTag.attr("href")));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
