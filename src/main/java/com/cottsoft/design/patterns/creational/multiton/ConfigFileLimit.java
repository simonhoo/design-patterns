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

package com.cottsoft.design.patterns.creational.multiton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 多例模式（Multiton）,实例个数有上限
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年06月06
 * 
 * @version v1.0.0
 */
public class ConfigFileLimit {
	private Logger logger = LoggerFactory.getLogger(ConfigFileLimit.class);
	
	private static ConfigFileLimit configFile1 = new ConfigFileLimit(1);
	private static ConfigFileLimit configFile2 = new ConfigFileLimit(2);
	
	private int flag;
	private ConfigFileLimit(){
		
	}
	private ConfigFileLimit(int flag){
		this.flag = flag;
	}
	
	public static ConfigFileLimit getInstance(int whichFile){
		switch(whichFile){
			case 1:  return configFile1;
			case 2:  return configFile2;
			default : return null;
		}
	}
	
	public synchronized void method(){
		Log.log(logger, "我是文件："+flag);
	}
}