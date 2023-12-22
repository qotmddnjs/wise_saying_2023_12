package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {//다른 클래스의 요청에 대한 처리를 해주는 클래스
	private String actionCode;
	private Map<String, String> params;

	public Rq(String cmd) {
		String[] cmdBits = cmd.split("\\?", 2);

		actionCode = cmdBits[0];

		params = new HashMap<>();

		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);

			if (paramStrBits.length == 1) {
				continue;
			}

			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}

	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) {
		try {
			return Integer.parseInt(getParam(name));//param 벨류
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}