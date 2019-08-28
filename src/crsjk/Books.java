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
			DocumentBuilder buidler = factory.newDocumentBuilder();// ����document���󹤳�
			Document document = buidler.parse(new File(acb));// �������ͽṹ
			NodeList list = document.getElementsByTagName("auths");// �Ȼ�ȡ�����е�data(ͨ�����ڵ�õ����е��ĵ�����)
			Node node = list.item(0);// ѭ����ȡÿ������ //users�õ�����Ľڵ㣬�����Ǹ��ڵ���Ϊ���ڵ�ֻ��һ�������Ծ�ֱ��д0�±�
			System.out.println("���ڵ㣺" + node.getNodeName());// ��ӡ���ڵ�
			NodeList user = node.getChildNodes();// ͨ�����ڵ�õ����е��ӽڵ�
			for (int i = 0; i < user.getLength(); i++) {// ѭ��
				Auth a1=new Auth();
				Node users = user.item(i);// ѭ����ȡ���õ������ÿһ���ڵ�
				NodeList cas = users.getChildNodes();// ͨ�����ڵ�õ����е��ӽڵ���һ����ֽڵ�
				for (int j = 0; j < cas.getLength(); j++) {// ѭ��
					Auth auth=new Auth();
					Node asb = cas.item(j);// ѭ����ȡ���õ������ÿһ���ڵ�
					if (asb.hasChildNodes()) {// �ж��Ƿ����ֽڵ�
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