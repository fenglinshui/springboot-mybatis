package conoha.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClawerTools {
	/**
	 * 字符串转换URL
	 *
	 * @param string
	 * @return
	 */
	public static URL StringToUrl(String string) {
		URL url = null;
		try {
			url = new URL(string);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("字符串转换URL出错");
			return null;
		}
		return url;
	}

	/**
	 * 下载页面代码并转码
	 *
	 * @param pageUrl
	 * @return
	 */
	public static String downloadPage(URL pageUrl, String encording) {
		if (pageUrl == null)
			return "";
//		System.out.println("下载页面代码："+pageUrl);
		if("https".equalsIgnoreCase(pageUrl.getProtocol())){
			try {
				SslTools.ignoreSsl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					pageUrl.openStream(), encording));
//			System.out.println("打开连接，读取数据");
			String line;

			StringBuffer pageBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				pageBuffer.append(line);

			}

			return pageBuffer.toString();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("下载页面代码时出错");
			return "";
		}
	}

	/**
	 * 根据链接现在页面代码
	 * @param pageUrl
	 * @param encording
	 * @return
	 */
	public static String downloadByConnect(URL pageUrl, String encording) {
		if (pageUrl == null)
			return "";
		URLConnection connection = null;
		try {
			connection = pageUrl.openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encording));
			String line;

			StringBuffer pageBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				pageBuffer.append(line);

			}

			return pageBuffer.toString();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("下载页面代码时出错");
			return "";
		}

	}

	/**
	 * 下载页面代码 含头字段
	 *
	 * @param pageUrl
	 * @param encording
	 * @param map
	 * @return
	 */
	public static String download(URL pageUrl, String encording,
								  Map<String, String> map) {

		if (pageUrl == null)
			return "";
		if("https".equalsIgnoreCase(pageUrl.getProtocol())){
			try {
				SslTools.ignoreSsl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Proxy proxy = new Proxy(Proxy.Type.HTTP,
				new InetSocketAddress("127.0.0.1",1080));
		URLConnection connection = null;
		try {
			connection = pageUrl.openConnection();
			if (map.size() > 0) {
				for (String key : map.keySet())
					connection.setRequestProperty(key, map.get(key));
			}
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), encording));
			String line;

			StringBuffer pageBuffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				pageBuffer.append(line);

			}

			return pageBuffer.toString();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("下载页面代码时出错");
			return "";
		}

	}

	/**
	 * 下载文件到本地。
	 * @param name name为本地保存路径，包括路径、文件名、扩展名
	 * @param link 链接
	 * @param map header 可包含登录信息，跳过登录
	 */
	public static void downloadFile(String name, String link,
									Map<String, String> map) {
		/*
		 * try { Thread.currentThread().sleep(5000); } catch
		 * (InterruptedException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		int index=1;
		OutputStream outputStream = null;
		URLConnection connection = null;
		InputStream inputStream = null;
		File file=null;
		try {
			file=new File(name);
			if(!file.exists())
				file.createNewFile();
			connection = StringToUrl(link).openConnection();
			if (map != null && map.size() > 0) {
				for (String key : map.keySet())
					connection.setRequestProperty(key, map.get(key));
			}
			inputStream = connection.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			outputStream = new FileOutputStream(name);
			while ((len = inputStream.read(bs)) != -1) {
				outputStream.write(bs, 0, len);
			}
			outputStream.flush();
			outputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("下载文件时出错：" + name);
			return;
		}
		System.out.println(Thread.currentThread().getName()+":"+name + "    下载完成");
	}

	/**
	 * 保存文件，追加内容
	 * @param string 内容
	 * @param address 文件地址
	 */
	public static void save(String string, String address) {
		File file = new File(address);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		FileWriter writer;
		try {
			writer = new FileWriter(address, true);
			writer.write(string);
			writer.write("\r\n");

			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			System.err.println("保存文件出错");
			return;
		}

	}
	/**
	 *  读取文件为字符串
	 * @param address
	 * @param encording
	 * @return
	 */
	public static String readFiletoString(String address,String encording){
		File file = new File(address);
		String txt="";
		try {
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = null;
				read = new InputStreamReader(
						new FileInputStream(file), encording);
				BufferedReader bufferedReader = new BufferedReader(read);
				;
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					txt+=lineTxt;
				}
				read.close();
			}
			else {

				System.out.println(file.getAbsolutePath());
			}
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return txt;
	}


	/**
	 *
	 * @return
	 */
	public static Map<String, String> readFile() {
		Map<String, String> nameMap = new HashMap<String, String>();
		try {
			// String encoding="GBK";
			File file = new File("f:/book/book.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), "GBK");// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] links = lineTxt.split("      ");
					if (links.length < 2)
						continue;
					nameMap.put(links[1], links[0]);

				}
				read.close();
			} else {
				// file.createNewFile();
				System.out.println(file.getAbsolutePath());
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return nameMap;

	}
	/**
	 * 逐行返回文件内容
	 * @param address
	 * @param encoding
	 * @return
	 */
	public static List readFile(String address, String encoding) {

		List<String> list = new ArrayList<String>();
		try {
			// String encoding="GBK";
			File file = new File(address);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					list.add(lineTxt);

				}
				read.close();
			} else {
				// file.createNewFile();
				System.out.println(file.getAbsolutePath());
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * 大小写敏感
	 *
	 * @param string
	 * @return
	 */
	public static Pattern stringToPattern(String string) {
		return Pattern.compile(string, Pattern.CASE_INSENSITIVE);
	}
	/**
	 * 返回匹配结果
	 * @param string 字符串
	 * @param regex 匹配规则
	 * @return
	 */
	public static Matcher getMatcher(String string, String regex) {
		return stringToPattern(regex).matcher(string);
	}

	public static Document getDocument(String url,String coding){
		return Jsoup.parse(downloadPage(StringToUrl(url),coding));
	}
	public static Document getDocument(String url,String coding,Map header){
		return Jsoup.parse(download(StringToUrl(url),coding,header));
	}
	public static Document getDocument(String url){
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1",
				1080);
		Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr);
		Document document=null;
		try{
			document=Jsoup.connect(url)
					.timeout(20 * 1000)
					.proxy(proxy)
					.get();
		}catch (Exception e){
			e.printStackTrace();
		}
		return document;
	}

}
