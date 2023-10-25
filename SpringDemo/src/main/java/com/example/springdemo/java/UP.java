package com.example.springdemo.java;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UP {
	private static final String CHARSET = "utf-8";

	public static void main(String[] args) {
		String filePath = "C:\\Users\\Tmind\\Pictures\\Saved Pictures\\123.jpg";// 图片本地地址
		String mUrl = "https://fl.test.you.163.com/welfare/upload/img?isTF=ture";// 图片上传的地址
		System.out.println("mUrl=" + mUrl);
		System.out.println("mUrl=" + filePath);

		final String BOUNDARY = "+++++"; // 边界标识 随机生成
		final String PREFIX = "--";
		final String LINE_END = "\r\n";
		final String CONTENT_TYPE = "multipart/form-data"; // 内容类型
	
		 File file = new File(filePath);
		 byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(file.toPath());
			System.out.println("bytes="+bytes.length);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		HttpURLConnection uRLConnection;
		try {
			URL url = new URL(mUrl);
			uRLConnection = (HttpURLConnection) url.openConnection();
			uRLConnection.setDoInput(true);
			uRLConnection.setDoOutput(true);
			uRLConnection.setRequestMethod("POST");
			uRLConnection.setUseCaches(false);
			uRLConnection.setInstanceFollowRedirects(false);
			uRLConnection.setRequestProperty("Charset", CHARSET); // 设置编码
			uRLConnection.setRequestProperty("connection", "keep-alive");
			uRLConnection.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
			uRLConnection.connect();
			// 设置请求的超时时间
			uRLConnection.setReadTimeout(10000);
			uRLConnection.setConnectTimeout(10000);
			OutputStream outputSteam = uRLConnection.getOutputStream();
			DataOutputStream out = new DataOutputStream(outputSteam);
			StringBuilder sb = new StringBuilder();
			Map<String, String> map = new HashMap<>();
			map.put("name", "file");
			map.put("type", "STORE_ALBUM");
			Set<Map.Entry<String, String>> entrySet = map.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {// 构建表单字段内容
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				sb.append("Content-Disposition: form-data; name=\"").append(entry.getKey()).append("\"\r\n\r\n");
				sb.append(entry.getValue());
				sb.append(LINE_END);
			}
			String paramStrings = sb.toString();
			byte[] paramsData = paramStrings.getBytes(CHARSET);
			out.write(paramsData);
			/*
			 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
			 * filename是文件的名字，包含后缀名的 比如:abc.png
			 */
			sb.setLength(0);
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + "text.jpg" + "\"")
					.append(LINE_END);
			sb.append("Content-Type: application/octet-stream; charset=" + CHARSET).append(LINE_END);
			sb.append(LINE_END);
			out.write(sb.toString().getBytes());

			long total = bytes.length;
			System.out.println("total_M=" + total / 1024 / 1024);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length;
			long progressBarLength = 0;
			// 从文件读取数据至缓冲区
			while ((length = byteArrayInputStream.read(buffer)) != -1) {
				// 将请求体写入DataOutputStream中
				out.write(buffer, 0, length);
				// 获取进度
				progressBarLength += length;
			}
			out.write(LINE_END.getBytes());
			byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes(CHARSET);
			out.write(end_data);
			out.flush();
			// 获取响应数据
			System.out.println("1111111111111111111->" + uRLConnection.getResponseCode());
			InputStream is = uRLConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();
			String readLine;
			while ((readLine = br.readLine()) != null) {
				response.append(readLine);
			}
			is.close();
			br.close();
			System.out.println("444444444444444444->" + response);

			uRLConnection.disconnect();
			System.out.println("555555555555555>" + response);
			System.out.println("服务端的返回数据=" + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("网络异常");
		}
	}
}
