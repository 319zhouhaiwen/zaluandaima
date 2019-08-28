package jdom;

import java.io.File;
import java.io.FileWriter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdomsr {
	/**
	 * @param lj
	 */
	public static void setxml(String lj) {
		// �Ƚ���Document����
		Document doc = new Document();
		// ����Ԫ�ؽڵ�
		Element users = new Element("users");
		try {
			// �������Element
			Element user = new Element("user");
			Element name = new Element("name");
			Element age = new Element("age");
			Element fm = new Element("fm");
			Element gx = new Element("gx");
			Element fmname = new Element("name");
			 
			user.setAttribute("id", "1001");
			
			users.addContent(user);
			user.addContent(name);
			name.addContent("����");
			user.addContent(age);
			age.addContent("10");
			user.addContent(fm);
			fm.addContent(gx);
			gx.addContent("�ϰ�");
			fm.addContent(fmname);
			fmname.addContent("������");

			Element user1 = new Element("user");
			user1.setAttribute("id", "dfghfd");
			Element user1name = new Element("name");
			user1name.addContent("����");
			Element user1age = new Element("age");
			user1age.addContent("11");
			Element user2 = new Element("user");
			Element user2name = new Element("name");
			user2name.addContent("����");
			Element user2age = new Element("age");
			user2age.addContent("9");
			
			users.addContent(user1);
			user1.addContent(user1name);
			user1.addContent(user1age);
			users.addContent(user2);
			user2.addContent(user2name);
			user2.addContent(user2age);
			// ���ø��ڵ�
			doc.setRootElement(users);

			// ʹ��IO������
			FileWriter writer = new FileWriter(new File(lj));
			// �����������
			XMLOutputter outputter = new XMLOutputter();
			// ���ñ���
			Format f = Format.getCompactFormat();
			f.setEncoding("GBK");
			outputter.setFormat(f);
			// ���
			outputter.output(doc, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String xmllj = "E:\\wk2\\sy\\src\\jdom\\sr.xml";
		setxml(xmllj);
	}
}
