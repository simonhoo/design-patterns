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

/**
 * Description：<br> 
 * 多例模式（Multiton）
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年06月06
 * @version v1.0.0
 */
public class Multiton {

	public static void main(String[] args) {
		//有上限
		ConfigFileLimit limitFile1 = ConfigFileLimit.getInstance(1);
		limitFile1.method();
		ConfigFileLimit limitFile2 = ConfigFileLimit.getInstance(2);
		limitFile2.method();

		//无上限
		ConfigFileNoLimit noLimitEnUS = ConfigFileNoLimit.getInstance("en", "US");
		noLimitEnUS.method();		
		ConfigFileNoLimit noLimitZhTW = ConfigFileNoLimit.getInstance("zh", "TW");
		noLimitZhTW.method();		
		ConfigFileNoLimit noLimitZhHK = ConfigFileNoLimit.getInstance("zh", "HK");
		noLimitZhHK.method();
	}
}


