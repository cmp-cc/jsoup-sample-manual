package org.freecode.sample6;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class JsoupUtils {

	/**
	 * 将经过HTML转义后的字符串转换为转义之前的字符串。<br>
	 * 
	 * <pre>
	 * 比如：
	 *      > 转义之后就变成了 &amp;gt;
	 *      < 转义之后就变成了 &amp;lt;
	 *      & 转义之后就变成了 &amp;amp;
	 * </pre>
	 * 
	 * 同样可以使用common-lang 中 StringEscapeUtils
	 * 
	 * @param text
	 *            HTML escaped string
	 * @return 没有经过HTML转移的字符串
	 * @since 1.0
	 */
	public static String unescape(String text) {
		return org.jsoup.parser.Parser.unescapeEntities(text, false);
	}

	/**
	 * 
	 * 清除HTML标签保留换行
	 * 
	 * @return
	 */
	public static String cleanHTMLTagKeepNewline(String html) {
		if (html == null)
			return html;
		
		Document document = Jsoup.parse(html);
		Document.OutputSettings setting = new Document.OutputSettings()
		                                              .prettyPrint(false);
		document.outputSettings(setting);
		
		document.select("br").append("\n");
		return Jsoup.clean(document.html(), "", Whitelist.none(),
				setting);
	}
}
