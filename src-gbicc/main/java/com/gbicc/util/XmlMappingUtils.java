package com.gbicc.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import com.gbicc.common.CommonService;
import com.huateng.ebank.entity.data.mng.DataDic;

@SuppressWarnings("unchecked")
public class XmlMappingUtils {

	private Document DOCUMENT;
	private Element ROOT;
	Map<String, String> ALL = new HashMap<String, String>();

	private static XmlMappingUtils utils = new XmlMappingUtils();
	private ServletContext servletContext;

	public static XmlMappingUtils getInstance() {
		return utils;
	}

	public void init(ServletContext servletContext) {
		this.servletContext = servletContext;
		SAXReader reader = new SAXReader();
		String[] files = new String[] {
				"/WEB-INF/query/gbicc-meta/companyMeta.xml",
				"/WEB-INF/query/gbicc-meta/personMeta.xml",
				"/WEB-INF/query/gbicc-meta/reportMeta.xml" };
		for (String fx : files) {
			try {
				Document d = reader
						.read(servletContext.getResourceAsStream(fx));
				List<Element> els = d.getRootElement().selectNodes("Query");
				if (els != null) {
					for (Element el : els) {
						ALL.put(el.attributeValue("id"),
								el.attributeValue("path"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void read(String meta) {
		SAXReader reader = new SAXReader();
		try {
			DOCUMENT = reader.read(servletContext.getResourceAsStream(ALL
					.get(meta)));
			ROOT = DOCUMENT.getRootElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] readElementByArray(String field) {
		List<Element> els = ROOT.selectNodes("Fields/Field[@id=\"" + field
				+ "\"]");
		if (els != null && !els.isEmpty()) {
			String translated = els.get(0).attributeValue("translated");
			if (StringUtils.hasText(translated)) {
				if (translated.startsWith("LIST:")) {
					String values[] = translated.substring(5).split(";");
					return values;
				}
			}
		}
		return null;
	}

	public String readElementByDict(String field) {
		List<Element> els = ROOT.selectNodes("Fields/Field[@id=\"" + field
				+ "\"]");
		if (els != null && !els.isEmpty()) {
			String translated = els.get(0).attributeValue("translated");
			if (StringUtils.hasText(translated)) {
				if (translated.startsWith("DATA_DIC.")) {
					return translated.substring(9);
				}
			}
		}
		return null;
	}

	public String readElement(String field, String key) {
		String[] array = readElementByArray(field);
		if (array != null) {
			for (String _key : array) {
				String dt[] = _key.split("[,]");
				if (dt.length > 1) {
					if (dt[0].trim().equals(key)) {
						return dt[1];
					}
				}
			}
		}
		String dict = readElementByDict(field);
		if (dict != null) {
			List<DataDic> list = (List<DataDic>) CommonService.getInstance()
					.queryListHQL("from DataDic t where dataTypeNo=" + dict);
			for (DataDic dic : list) {
				if (key.equals(dic.getDataNo())) {
					return dic.getDataName();
				}
			}
		}
		return "";
	}
}
