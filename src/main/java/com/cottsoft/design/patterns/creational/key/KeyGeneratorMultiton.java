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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 利用多例模式生成唯一KEY
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年07月07日
 * @version v1.0.0
 */
public class KeyGeneratorMultiton {
	private static Logger logger = LoggerFactory.getLogger(KeyGeneratorMultiton.class);
	
	private static Map<String,KeyGeneratorMultiton> keyGens = new HashMap<String,KeyGeneratorMultiton>();
	private static final int POOL_SIZE = 100;
	private KeyInfo key;
	
	private KeyGeneratorMultiton(){
		
	}
	
	private KeyGeneratorMultiton(String keyName){
		key = new KeyInfo(POOL_SIZE,keyName);
	}
	
	public static synchronized KeyGeneratorMultiton getInstance(String keyName){
		KeyGeneratorMultiton keyGen;
		if(keyGens.containsKey(keyName)){
			keyGen = keyGens.get(keyName);
			Log.log(logger, "从缓存中找到KEY生成器了。");
		}else{
			keyGen = new KeyGeneratorMultiton(keyName);
			Log.log(logger, "重新生成新的KEY生成器了。");
		}
		
		return keyGen;
	}
	
	public synchronized int getNextKey(){
		return key.getNextKey();
	}
	
}


