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
		// 先建立Document对象
		Document doc = new Document();
		// 建立元素节点
		Element users = new Element("users");
		try {
			// 建立多个Element
			Element user = new Element("user");
			Element name = new Element("name");
			Element age = new Element("age");
			Element fm = new Element("fm");
			Element gx = new Element("gx");
			Element fmname = new Element("name");
			 
			user.setAttribute("id", "1001");
			
			users.addContent(user);
			user.addContent(name);
			name.addContent("张三");
			user.addContent(age);
			age.addContent("10");
			user.addContent(fm);
			fm.addContent(gx);
			gx.addContent("老爸");
			fm.addContent(fmname);
			fmname.addContent("张三丰");

			Element user1 = new Element("user");
			user1.setAttribute("id", "dfghfd");
			Element user1name = new Element("name");
			user1name.addContent("李四");
			Element user1age = new Element("age");
			user1age.addContent("11");
			Element user2 = new Element("user");
			Element user2name = new Element("name");
			user2name.addContent("李五");
			Element user2age = new Element("age");
			user2age.addContent("9");
			
			users.addContent(user1);
			user1.addContent(user1name);
			user1.addContent(user1age);
			users.addContent(user2);
			user2.addContent(user2name);
			user2.addContent(user2age);
			// 设置根节点
			doc.setRootElement(users);

			// 使用IO流操作
			FileWriter writer = new FileWriter(new File(lj));
			// 定义输出对象
			XMLOutputter outputter = new XMLOutputter();
			// 设置编码
			Format f = Format.getCompactFormat();
			f.setEncoding("GBK");
			outputter.setFormat(f);
			// 输出
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
