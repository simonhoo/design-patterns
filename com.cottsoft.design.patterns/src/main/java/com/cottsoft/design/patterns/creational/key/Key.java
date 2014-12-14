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

package com.cottsoft.design.patterns.creational.key;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 利用单例和多例模式生成唯一KEY
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年07月07日
 * @version v1.0.0
 */
public class Key {
	private static Logger logger = LoggerFactory.getLogger(Key.class);
	
	public static void main(String[] args) {
		//单例方式
		KeyGeneratorSingleton keyGenSingleton = KeyGeneratorSingleton.getInstance();
		for(int i=0;i<100;i++){
			Log.log(logger, ""+keyGenSingleton.getNextKey("CUS"));
		}
		
		//多例模式
		KeyGeneratorMultiton cusKeyGen = KeyGeneratorMultiton.getInstance("CUS");
		KeyGeneratorMultiton sysKeyGen = KeyGeneratorMultiton.getInstance("SYS");
		for(int i=0;i<100;i++){
			Log.log(logger, ""+cusKeyGen.getNextKey());
			Log.log(logger, ""+sysKeyGen.getNextKey());
		}
	}

}


