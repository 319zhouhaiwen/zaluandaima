package jdom;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Jdom {
	public static void list(String lj) {
		try {
			SAXBuilder sax=new SAXBuilder();
			Document doc=sax.build(new File(lj));
			Element users=doc.getRootElement();
			List<Element> list=users.getChildren();
			if(list!=null&&list.size()>0) {
				for (int i = 0; i <list.size(); i++) {
					Element user=list.get(i);
					System.out.println(user.getName());
					List<Attribute> a=user.getAttributes();
					for (Attribute attribute : a) {
						System.out.println(" Ù–‘£∫"+"----"+attribute.getName()+" = "+attribute.getValue());
					}
						Element name = user.getChild("name");
						Element age = user.getChild("age");
						Element fm = user.getChild("fm");
						System.out.println(name.getName()+"=="+name.getTextTrim() + " --- " + age.getName()+" == "+age.getTextTrim());
						if(fm!=null) {
							System.out.println(fm.getName());
							Element	gx=fm.getChild("gx");
							System.out.println(gx.getName()+" "+gx.getTextTrim());
							Element	name1=fm.getChild("name");
							System.out.println(name1.getName()+" "+name1.getTextTrim());
						}
				}
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		String xmllj="E:\\wk2\\sy\\src\\jdom\\users.xml";
		list(xmllj);
	}
}
