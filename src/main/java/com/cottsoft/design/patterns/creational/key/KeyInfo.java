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
 * KEY信息
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年07月07日
 * @version v1.0.0
 */
public class KeyInfo {
	private Logger logger = LoggerFactory.getLogger(KeyInfo.class);
	
	private int keyMax;
	private int keyMin;
	private int nextKey;
	private int poolSize;
	private String keyName;
	
	public KeyInfo(int poolSize,String keyName){
		this.poolSize = poolSize;
		this.keyName = keyName;
		this.callDatabase();
	}
	
		
	public int getKeyMax() {
		return keyMax;
	}

	public int getKeyMin() {
		return keyMin;
	}

	public int getNextKey() {
		if(nextKey>keyMax){
			this.callDatabase();
		}
		return nextKey ++;
	}

	/**
	 * 从数据库获取KEY
	 */
	private void callDatabase(){
		String sql1 = "UPDATE SYS_KEY_TABLE SET KEY_VAL=KEY_VAL+"+poolSize+" WHERE KEY_NAME='"+keyName+"'";
		String sql2 = "SELECT KEY_VAL FROM SYS_KEY_TABLE WHERE KEY_NAME='"+keyName+"'";
		
		Log.log(logger, sql1+"\r\n"+sql2);
		
		//执行数据库操作和查询,省略
		
		int dbKey = 888;//第二句SQL的结果值
		keyMax = dbKey;
		keyMin = dbKey - poolSize + 1;
		nextKey = keyMin;
	}
}


