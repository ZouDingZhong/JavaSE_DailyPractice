package com.zoudingzhon.tankwar;

import java.io.IOException;
import java.util.Properties;

/**
 * 用来调用配置文件的类 已经引入内存 使用静态方法即可
 * @author 邹定中
 *
 */
public class PropertyMgr {
	static Properties props;
	static
	{
	 props = new Properties();
	try {
		props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/tankwar.properties"));
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	}	
    static int initEnemyTankAmount = Integer.parseInt(props.getProperty("initEnemyTankAmount")); 
    static int getInitEnemyTankAmount ()
	{
		return initEnemyTankAmount;
	}
}
