package crsjk;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.AuthService;

public class Books extends ConnDao {
	public static void ac(String acb) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder buidler = factory.newDocumentBuilder();// 建立document对象工厂
			Document document = buidler.parse(new File(acb));// 创建树型结构
			NodeList list = document.getElementsByTagName("auths");// 先获取得所有的data(通过根节点得到所有的文档数据)
			Node node = list.item(0);// 循环获取每个数据 //users得到具体的节点，这里是根节点因为根节点只有一个，所以就直接写0下标
			System.out.println("根节点：" + node.getNodeName());// 打印根节点
			NodeList user = node.getChildNodes();// 通过根节点得到所有的子节点
			for (int i = 0; i < user.getLength(); i++) {// 循环
				Auth a1=new Auth();
				Node users = user.item(i);// 循环获取，得到具体的每一个节点
				NodeList cas = users.getChildNodes();// 通过根节点得到所有的子节点下一层的字节点
				for (int j = 0; j < cas.getLength(); j++) {// 循环
					Auth auth=new Auth();
					Node asb = cas.item(j);// 循环获取，得到具体的每一个节点
					if (asb.hasChildNodes()) {// 判断是否还有字节点
						if(asb.getNodeName().equals("name")&&null==auth.getName()) {
							auth.setName(asb.getFirstChild().getNodeValue());
							a1.setName(asb.getFirstChild().getNodeValue());
						}else if(asb.getNodeName().equals("code")&&null==auth.getName()) {
							auth.setCode(asb.getFirstChild().getNodeValue());
							a1.setCode(asb.getFirstChild().getNodeValue());
						}else if(asb.getNodeName().equals("url")&&null==auth.getName()) {
							auth.setUrl(asb.getFirstChild().getNodeValue());
							a1.setUrl(asb.getFirstChild().getNodeValue());
						}else if(asb.getNodeName().equals("p_code")&&null==auth.getName()) {
							auth.setpCode(asb.getFirstChild().getNodeValue());
							a1.setpCode(asb.getFirstChild().getNodeValue());
						}else if(asb.getNodeName().equals("is_button")&&null==auth.getName()) {
							auth.setIsButton(asb.getFirstChild().getNodeValue());
							a1.setIsButton(asb.getFirstChild().getNodeValue());
						}
					}
				}
				if(null!=a1.getName()) {
					AuthService authservice=new AuthService();
					authservice.insert(a1);
				}
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		String acb = "E:\\wk2\\sy\\src\\crsjk\\books.xml";
		ac(acb);
	}
}