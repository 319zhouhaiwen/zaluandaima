package xmljx;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DomXml {
	public static void get(String lj) {
		DocumentBuilderFactory dxgc = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dx = dxgc.newDocumentBuilder();// �������󹤳�
			Document doc = dx.newDocument();
			Element users = doc.createElement("users");

			Element usera = doc.createElement("user");
			usera.setAttribute("id", "1001");
			Element name = doc.createElement("name");
			Element agea = doc.createElement("age");
			Element fm = doc.createElement("fm");
			Element gx = doc.createElement("gx");
			Element namea = doc.createElement("name");

			Element userb = doc.createElement("user");
			userb.setAttribute("id", "dfghfd");
			Element nameb = doc.createElement("name");
			Element ageb = doc.createElement("age");

			Element userc = doc.createElement("user");
			Element namec = doc.createElement("name");
			Element agec = doc.createElement("age");

			Text nametext = doc.createTextNode("����");
			Text ageatext = doc.createTextNode("10");

			Text gxtext = doc.createTextNode("�ϰ�");
			Text nameatext = doc.createTextNode("������");

			Text namebtext = doc.createTextNode("����");
			Text agetbext = doc.createTextNode("11");

			Text namectext = doc.createTextNode("����");
			Text agectext = doc.createTextNode("9");

			users.appendChild(usera);
			users.appendChild(userb);
			users.appendChild(userc);

			usera.appendChild(name);
			name.appendChild(nametext);
			usera.appendChild(agea);
			agea.appendChild(ageatext);
			usera.appendChild(fm);
			fm.appendChild(gx);
			gx.appendChild(gxtext);
			fm.appendChild(namea);
			namea.appendChild(nameatext);

			userb.appendChild(nameb);
			nameb.appendChild(namebtext);
			userb.appendChild(ageb);
			ageb.appendChild(agetbext);

			userc.appendChild(namec);
			namec.appendChild(namectext);
			userc.appendChild(agec);
			agec.appendChild(agectext);

			doc.appendChild(users);

			// ִ�б������
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			// ��װҪ�����doc
			DOMSource source = new DOMSource(doc);
			// ���������
			File file = new File(lj);
			StreamResult sr = new StreamResult(file);
			// �������������
			t.setOutputProperty("encoding", "UTF-8");
			// t.setOutputProperty("version", "1.0");
			// ���
			t.transform(source, sr);

		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		String lja="E:\\wk2\\sy\\src\\dom\\urers.xml";
		get(lja);
	}
}