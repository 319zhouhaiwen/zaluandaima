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
			DocumentBuilder buidler = factory.newDocumentBuilder();// ����document���󹤳�
			Document document = buidler.parse(new File(acb));// �������ͽṹ
			NodeList list = document.getElementsByTagName("users");// �Ȼ�ȡ�����е�data(ͨ�����ڵ�õ����е��ĵ�����)
			Node node = list.item(0);// ѭ����ȡÿ������ //users�õ�����Ľڵ㣬�����Ǹ��ڵ���Ϊ���ڵ�ֻ��һ�������Ծ�ֱ��д0�±�
			System.out.println("���ڵ㣺" + node.getNodeName());// ��ӡ���ڵ�
			NodeList user = node.getChildNodes();// ͨ�����ڵ�õ����е��ӽڵ�
			for (int i = 0; i < user.getLength(); i++) {// ѭ��
				Node users = user.item(i);// ѭ����ȡ���õ������ÿһ���ڵ�
				System.out.println(users.getNodeName());// ��ӡ���ڵ���һ���ÿһ���ڵ�
				if (users.hasAttributes()) {// �ж�users�Ƿ�������
					NamedNodeMap ids = users.getAttributes();// �õ��ӽڵ����������
					Node id = ids.item(0);// �����±�õ�ָ��λ�õ����Զ���
					System.out.println(id.getNodeName() + " " + id.getNodeValue());// ��ӡ���������Ͷ�������
				}
				NodeList cas = users.getChildNodes();// ͨ�����ڵ�õ����е��ӽڵ���һ����ֽڵ�
				for (int j = 0; j < cas.getLength(); j++) {// ѭ��
					Node asb = cas.item(j);// ѭ����ȡ���õ������ÿһ���ڵ�
					if (asb.hasChildNodes()) {// �ж��Ƿ����ֽڵ�
						System.out.println(asb.getNodeName() + "  " + asb.getFirstChild().getNodeValue());// ��Ϊdom��Ϊ�ı�����Ҳ�Ǳ�ǩ���ӽڵ㣬������Ҫ��ȡ������ڵ��ڻ�ȡ���ֵ�ֵ
					}
					NodeList fm = asb.getChildNodes();// ͨ�����ڵ�õ����е��ӽڵ���һ����ֽڵ�����һ����ӽڵ�
					for (int k = 0; k < fm.getLength(); k++) {// ѭ��
						Node fms = fm.item(k);// ѭ����ȡ���õ������ÿһ���ڵ�
						if (fms.hasChildNodes()) {// �ж��Ƿ����ֽڵ�
							System.out.println(fms.getNodeName() + "   " + fms.getFirstChild().getNodeValue());// ��Ϊdom��Ϊ�ı�����Ҳ�Ǳ�ǩ���ӽڵ㣬������Ҫ��ȡ������ڵ��ڻ�ȡ���ֵ�ֵ
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