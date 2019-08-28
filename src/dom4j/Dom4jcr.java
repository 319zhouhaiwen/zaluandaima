package dom4j;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jcr {
	public static void set(String lj) {
		Document doc=DocumentHelper.createDocument();
		Element users=doc.addElement("users");
		Element user=users.addElement("user");
		user.addAttribute("id","1001");
		Element name=user.addElement("name");
		name.setText("张三");
		Element age=user.addElement("age");
		age.setText("10");
		Element fm=user.addElement("fm");
		Element fmgx=fm.addElement("gx");
		fmgx.setText("老爸");
		Element fmname=fm.addElement("name");
		fmname.setText("张三丰");
		Element user1=users.addElement("user");
		user1.addAttribute("id", "dfghfd");
		Element name1=user1.addElement("name");
		name1.setText("李四");
		Element age1=user1.addElement("age");
		age1.setText("11");
		Element user2=users.addElement("user");
		Element name2=user2.addElement("name");
		name2.setText("李五");
		Element age2=user2.addElement("age");
		age2.setText("9");
		try {
			OutputFormat format=OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter xmlwriter=new XMLWriter(new FileOutputStream(lj),format);
			xmlwriter.write(doc);
			xmlwriter.close();
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		String ljs = "E:\\wk2\\sy\\src\\dom4j\\users.xml";
		set(ljs);
	}
}
