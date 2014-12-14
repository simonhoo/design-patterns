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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 多例模式（Multiton）,实例个数无上限
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年06月06
 * 
 * @version v1.0.0
 */
public class ConfigFileNoLimit {
	private Logger logger = LoggerFactory.getLogger(ConfigFileNoLimit.class);
	
	private static Map<String,ConfigFileNoLimit> instances = new HashMap<String,ConfigFileNoLimit>();
	
	private String language = "zh";
	private String region = "CN";
	private String localeCode = "zh_CN";
	//private static final String fileName = "resources";
	
	//private Locale locale = null;
	//private ResourceBundle resourceBundle = null;
	
	private ConfigFileNoLimit(){
		
	}
	private ConfigFileNoLimit(String language,String region){
		this.region = region;
		this.language = language;
		this.localeCode = mergeLocaleCode(language,region);
		
		//this.locale = new Locale(language,region);
		//this.resourceBundle = ResourceBundle.getBundle(fileName, locale);
		
		instances.put(localeCode, this);
	}
	
	public synchronized static ConfigFileNoLimit getInstance(String language,String region){
		if(instances.get(mergeLocaleCode(language,region))==null){
			new ConfigFileNoLimit(language,region);
		}
		return instances.get(mergeLocaleCode(language,region));
	}
	
	private static String mergeLocaleCode(String language,String region){
		return language+"_"+region;
	}
	
	public synchronized void method(){
		Log.log(logger, "语言:"+language+"\r\n国家："+region+"\r\nCode："+localeCode);
	}
}