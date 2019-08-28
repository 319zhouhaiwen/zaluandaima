package zy;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4j {
	public static void get(String lj) {
		OrderGoods ordergoods = new OrderGoods();
		Users us = new Users();
		Orders orders = new Orders();
		SAXReader saxreader = new SAXReader();
		try {
			Document doc = saxreader.read(new File(lj));
			Element users = doc.getRootElement();
//			System.out.println("¸ùÄ¿Â¼£º" + users.getName());
			for (Iterator<Element> iterator = users.elementIterator(); iterator.hasNext();) {
				Element user = iterator.next();
				//System.out.println(user.getName());
				for (Iterator<Element> iterator2 = user.elementIterator(); iterator2.hasNext();) {
					Element name = iterator2.next();
					//System.out.println(name.getName() + "------ " + name.getText());
						if(name.getName().equals("name")) {
							//us.setName(name.getTextTrim());
							System.out.println(name.getTextTrim());
						}else if(name.getName().equals("phone")) {
							Integer phone = new Integer(name.getTextTrim());
							us.setPhone(phone);
						}
					for (Iterator<Element> iterator3 = name.elementIterator(); iterator3.hasNext();) {
						Element fmname = iterator3.next();
						//System.out.println("-----" + fmname.getName() + "  " + fmname.getText());
						/*if (fmname.getName().equals("pname") && fmname.getName() != null) {
							ordergoods.setPname(fmname.getText());
						} else if (fmname.getName().equals("prodcode") ) {
							ordergoods.setProdcode(fmname.getText());
						} else if (fmname.getName().equals("price")) {
							ordergoods.setPrice(new Double(fmname.getText()));
						} else if (fmname.getName().equals("number") ) {
							ordergoods.setNumber(Integer.valueOf(fmname.getText()));
						} else if (fmname.getName().equals("total")) {
							ordergoods.setTotal(new Double(fmname.getText()));
						}*/
					}
//					System.out.println(orders);	
					//System.out.println(ordergoods);
				}
			}
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		String ljs = "E:\\wk2\\sy\\src\\zy\\users.xml";
		get(ljs);
	}
}
