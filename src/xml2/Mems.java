package xml2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Mems {
	public static void get(String lj) {
		DocumentBuilderFactory dxgc=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dx=dxgc.newDocumentBuilder();//创建对象工厂
			Document document=dx.parse(new File(lj));
			NodeList list=document.getElementsByTagName("mems");
			Node mems=list.item(0);
			System.out.println("根目录："+mems.getNodeName());
			NodeList mem=mems.getChildNodes();
			for (int i = 0; i < mem.getLength(); i++) {
				Node mema=mem.item(i);
				System.out.println(mema.getNodeName());
				NodeList number=mema.getChildNodes();
				for (int j = 0; j < number.getLength(); j++) {
					Node type=number.item(j);
					if(type.hasChildNodes()) {
						System.out.println(type.getFirstChild().getNodeValue());
					}
					NodeList info=type.getChildNodes(); 
					for (int k = 0; k < info.getLength(); k++) {
						Node infoa=info.item(k);
						if(infoa.hasChildNodes()) {
							System.out.println(infoa.getNodeName()+"  "+infoa.getFirstChild().getNodeValue());
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		String ljz="E:\\wk2\\sy\\src\\xml2\\mems.xml";
		get(ljz);
	}
}
