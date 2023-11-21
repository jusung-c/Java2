package Lab7.adaptee;

import Lab7.periodic.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

// XML 파일에서 데이터를 읽고 그 데이터를 Element 객체로 변환
public class ElementXMLLoader implements FileLoader<Element> {

    @Override
    public List<Element> load(String filepath) {
        // 반환할 Element 객체 리스트
        List<Element> elist = new ArrayList<Element>();

        // load data
        try {
            // XML 파일을 파싱해 Document 객체 생성
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(filepath);

            // <Elements> 엘리먼트 얻기 + normalize()로 정규화
            document.getDocumentElement().normalize();

            // <Element> 리스트 얻기
            NodeList nodeList = document.getElementsByTagName("Element");

            // nodeList 순회하면서 XML 데이터를 추출해 Element 객체로 만들기
            for (int i = 0; i < nodeList.getLength(); i++) {
                org.w3c.dom.Element node = (org.w3c.dom.Element) nodeList.item(i);

                // XML에서 데이터 추출해 Element 객체 생성
                int number = Integer.parseInt(node.getElementsByTagName("Number").item(0).getTextContent());
                String name = node.getElementsByTagName("Name").item(0).getTextContent();
                String symbol = node.getElementsByTagName("Symbol").item(0).getTextContent();
                double weight = Double.parseDouble(node.getElementsByTagName("Weight").item(0).getTextContent());

                Element element = new Element(number, name, symbol, weight);

                // 리스트에 추가
                elist.add(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return elist;
    }

    // XML 파일로 저장
    @Override
    public void save(String filepath, List<Element> list) {
        try {
            // DocumentBuilder 및 Document 객체 생성
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();

            // 최상위 엘리먼트 <Elements> 생성
            org.w3c.dom.Element elements = document.createElement("Elements");
            document.appendChild(elements);

            // Element 객체 리스트 순회하면서 XML 엘리먼트 생성
            for (Element e : list) {
                // <Element> 생성
                org.w3c.dom.Element element = document.createElement("Element");

                // <Number> 생성 후 값 설정
                Node number = document.createElement("Number");
                number.appendChild(document.createTextNode(String.valueOf(e.getNumber())));
                element.appendChild(number);

                // <Name> 생성 후 값 설정
                Node name = document.createElement("Name");
                name.appendChild(document.createTextNode(String.valueOf(e.getName())));
                element.appendChild(name);

                // <Symbol> 생성 후 값 설정
                Node symbol = document.createElement("Symbol");
                symbol.appendChild(document.createTextNode(String.valueOf(e.getSymbol())));
                element.appendChild(symbol);

                // <Weight> 생성 후 값 설정
                Node weight = document.createElement("Weight");
                weight.appendChild(document.createTextNode(String.valueOf(e.getWeight())));
                element.appendChild(weight);

                // <Element> 엘리먼트를 <Elements> 엘리먼트에 추가
                elements.appendChild(element);
            }

            // filepath에 XML 파일로 저장
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(filepath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
