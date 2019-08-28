package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Books {
	public static void ac(String acb) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder buidler = factory.newDocumentBuilder();// 建立document对象工厂
			Document document = buidler.parse(new File(acb));// 创建树型结构
			NodeList list = document.getElementsByTagName("users");// 先获取得所有的data(通过根节点得到所有的文档数据)
			Node node = list.item(0);// 循环获取每个数据 //users得到具体的节点，这里是根节点因为根节点只有一个，所以就直接写0下标
			System.out.println("根节点：" + node.getNodeName());// 打印根节点
			NodeList user = node.getChildNodes();// 通过根节点得到所有的子节点
			for (int i = 0; i < user.getLength(); i++) {// 循环
				Node users = user.item(i);// 循环获取，得到具体的每一个节点
				System.out.println(users.getNodeName());// 打印根节点下一层的每一个节点
				if (users.hasAttributes()) {// 判断users是否有属性
					NamedNodeMap ids = users.getAttributes();// 得到子节点的所有属性
					Node id = ids.item(0);// 根据下标得到指定位置的属性对象
					System.out.println(id.getNodeName() + " " + id.getNodeValue());// 打印对象名，和对象内容
				}
				NodeList cas = users.getChildNodes();// 通过根节点得到所有的子节点下一层的字节点
				for (int j = 0; j < cas.getLength(); j++) {// 循环
					Node asb = cas.item(j);// 循环获取，得到具体的每一个节点
					if (asb.hasChildNodes()) {// 判断是否还有字节点
						System.out.println(asb.getNodeName() + "  " + asb.getFirstChild().getNodeValue());// 因为dom认为文本内容也是标签的子节点，所以需要获取到这个节点在获取文字的值
					}
					NodeList fm = asb.getChildNodes();// 通过根节点得到所有的子节点下一层的字节点在下一层的子节点
					for (int k = 0; k < fm.getLength(); k++) {// 循环
						Node fms = fm.item(k);// 循环获取，得到具体的每一个节点
						if (fms.hasChildNodes()) {// 判断是否还有字节点
							System.out.println(fms.getNodeName() + "   " + fms.getFirstChild().getNodeValue());// 因为dom认为文本内容也是标签的子节点，所以需要获取到这个节点在获取文字的值
						}
					}
				}

			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		String acb = "E:\\wk2\\sy\\src\\xml\\books.xml";
		ac(acb);
	}
}