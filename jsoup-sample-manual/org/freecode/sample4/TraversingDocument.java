package org.freecode.sample4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/**
 * 遍历 DOM 树示例代码
 * 
 * @author root
 *
 */
public class TraversingDocument {

	private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36";
	private static final int timeout = 5 * 1000;

	public static void main(String... args) throws IOException {
		String url = "http://www.zhihu.com";

		Document doc = Jsoup.connect(url).userAgent(userAgent).timeout(timeout)
				.get();

//遍历一： 移除所有class 和 style 属性
//		RemoveNodeElemntVisitor removeAttriVisitor = new RemoveNodeElemntVisitor();

		// 它将遍历Dom 并移除所有元素的class 和 style 属性
//		removeAttriVisitor.handleHTML(doc);

//		System.out.println(doc);
//遍历二：获得所有Node节点
		NodeCollectVisitor traversorNodeVisitor = new NodeCollectVisitor(doc);
		List<Node> allNodeList = traversorNodeVisitor.getAllNode();
		
		System.out.println(allNodeList.size());
		for(Node node : allNodeList){
//			System.out.println(node.nodeName());
		}
		
	}

	/**
	 * 移除元素中的class 和 style 属性
	 *
	 */
	public static class RemoveNodeElemntVisitor implements NodeVisitor {
		@Override
		public void tail(Node node, int depth) {
			if (node instanceof Element) {
				Element e = (Element) node;
				e.removeAttr("class");
				e.removeAttr("style");
			}
		}

		@Override
		public void head(Node node, int arg1) {
		}

		public void handleHTML(Element element) {
			RemoveNodeElemntVisitor customVisitor = new RemoveNodeElemntVisitor();
			// 使用NodeTraversor来装载 customVisitor
			NodeTraversor traversor = new NodeTraversor(customVisitor);
			// 进行遍历
			traversor.traverse(element);
		}
	}

	/**
	 * 将所有节点元素加入集合
	 *
	 */
	public static class NodeCollectVisitor implements NodeVisitor {

		public ArrayList<Node> nodes = null;
		
		public NodeCollectVisitor(Element element) {
			nodes = new ArrayList<Node>();
			NodeTraversor traversor = new NodeTraversor(this);
			// 进行遍历
			traversor.traverse(element);
		}

		@Override
		public void head(Node node, int depth) {
			nodes.add(node);
		}

		@Override
		public void tail(Node node, int depth) {
		}

		public List<Node> getAllNode() {
			return nodes;
		}
	}
}
