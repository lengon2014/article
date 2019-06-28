package cn.gov.saic.wssq;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zcnest.rcs.httpclient.HttpBaseDao;
import com.zcnest.rcs.httpclient.RequestModel;

public class PingshenGetMain {

	public static void main(String[] args) throws InterruptedException {
		String start = args[0];
		String end = args[1];
		for (int i = Integer.parseInt(start); i < Integer.parseInt(end); i++) {
			List<String> appIds = getMain(i);
			for (String appId : appIds) {
				getPage(appId, i);
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
		}
	}

	// http://wssq.saic.gov.cn:9080/tmsve/pingshen_getMain.xhtml
	private static List<String> getMain(int page) {
		HttpBaseDao http = new HttpBaseDao();
		List<String> appIds = new ArrayList<>();
		try {
			RequestModel request = new RequestModel("http://wssq.saic.gov.cn:9080/tmsve/pingshen_getMain.xhtml");
			request.addHeader(
					"User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
			request.addHeader("Content-Type: application/x-www-form-urlencoded");
			request.setBody(
					"param.regNum=&param.tmName=&param.appCnName=&param.objAppCnName=&param.agentName=&param.startDate=&param.endDate=&pagenum="
							+ page + "&pagesize=30&sum=380271&countpage=12676&gopage=2");
			String main = http.doPost(request);
			Document root = Jsoup.parse(main);
			Elements wenshus = root.getElementsByAttributeValueContaining("href", "appId");
			for (int i = 0; i < wenshus.size(); i++) {
				Element element = wenshus.get(i);
				String href = element.attr("href");
				String appId = href.substring(href.indexOf("appId"));
				appIds.add(appId);
			}
			// System.out.println(main);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

		return appIds;
	}

	// appId=e48b88386b86ea2a016b92c577fd2ba7
	private static void getPage(String uri, int page) {
		System.out.println("begin page---> " + page + " URI: --->" + uri);
		HttpBaseDao http = new HttpBaseDao();
		try {
			RequestModel request = new RequestModel("http://wssq.saic.gov.cn:9080/tmsve/pingshen_detail.xhtml?" + uri);
			request.addHeader(
					"User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
			String main = http.doGet(request);
			Document root = Jsoup.parse(main);

			String title = root.getElementsByClass("Three_xilan_03").get(0).html();
			
			title=title.replace("|", "-");
			String filePath = "files/" + page;
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			FileUtils.append(filePath, title + ".html", main);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
}
