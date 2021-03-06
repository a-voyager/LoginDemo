package com.voyager;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	private UserDao() {
	}

	private static Map<String, String> users = new HashMap<String, String>();
	static {
		users.put("zhangsan", "123456");
		users.put("lisi", "123456");
		users.put("wangwu", "123456");
	}

	public static boolean isAvailable(String usrName, String pwd) {
		return users.containsKey(usrName) && users.get(usrName).equals(pwd);
	}

}
