package dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {
	public static void get(String lj) {
		SAXReader saxreader = new SAXReader();
		try {
			Document doc = saxreader.read(new File(lj));
			Element users = doc.getRootElement();
			System.out.println("¸ùÄ¿Â¼£º"+users.getName());
			for (Iterator<Element> iterator = users.elementIterator(); iterator.hasNext();) {
				Element user = iterator.next();
				System.out.println(user.getName());
				for (Iterator<Attribute> iterator4 = user.attributeIterator(); iterator4.hasNext();) {
					Attribute sx=iterator4.next();
					System.out.println("ÊôÐÔ£º"+sx.getName()+"=="+sx.getValue());
				}
				for (Iterator<Element> iterator2 = user.elementIterator(); iterator2.hasNext();) {
					Element name = iterator2.next();
					System.out.println(name.getName() + " " + name.getText());
					for (Iterator<Element> iterator3 = name.elementIterator(); iterator3.hasNext();) {
						Element fmname = iterator3.next();
						System.out.println(fmname.getName() + "  " + fmname.getText());
					}
				}
			}
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		String ljs = "E:\\wk2\\sy\\src\\dom4j\\users.xml";
		get(ljs);
	}
}
