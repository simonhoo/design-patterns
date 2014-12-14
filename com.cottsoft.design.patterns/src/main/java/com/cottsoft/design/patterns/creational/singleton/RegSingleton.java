/*
 * Copyright 2005-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Author:	Simon.Hoo
 * Blog:   	http://www.cottsoft.com 
 * Email:	Info@cottsoft.com
 * 
 * You can @simonhoo  on Github.com, weibo.com, twitter, t.qq.com
 */

package com.cottsoft.design.patterns.creational.singleton;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 单例（Singleton）,登记式
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年05月11日
 * @version v1.0.0
 */
public class RegSingleton {
	private Logger logger = LoggerFactory.getLogger(RegSingleton.class);
	
	public static final String className = "com.cottsoft.design.patterns.creational.singleton.RegSingleton";
	private static HashMap<String,Object> registry = new HashMap<String,Object>();
	
	static{
		RegSingleton instance = new RegSingleton();
		registry.put(className, instance);
	}
	
	/**
	 * 受保护的构造方法
	 */
	protected RegSingleton(){
		
	}
	
	/**
	 * 静态工厂方法，返回唯一的实例
	 * @param name
	 * @return
	 */
	public static RegSingleton getInstance(String name){
		if(name==null){
			name = className;
		}
		if(registry.get(name)==null){
			try{
				registry.put(name, Class.forName(name).newInstance());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return (RegSingleton) registry.get(name);
	}
	
	/**
	 * 测试方法
	 */
	public void test(){
		Log.log(logger, "单例（Singleton）,登记式");
	}
}


