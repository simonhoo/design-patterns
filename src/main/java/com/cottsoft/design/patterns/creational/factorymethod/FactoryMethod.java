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

package com.cottsoft.design.patterns.creational.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 工厂方法（Factory Method）
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年02月19日
 * @version v1.0.0
 */
public class FactoryMethod {
	private Logger logger = LoggerFactory.getLogger(FactoryMethod.class);
	
	//富士康
	private static PhoneFactory foxconn;
	//三星
	private static PhoneFactory samsung;
	
	//iPhone手机
	private static CellPhone iphone;
	//三星GALAXY手机
	private static CellPhone samsungGalaxy;
	
	public static void main(String[] args) {
		
		//两间工厂
		foxconn = new FactoryMethod().new Foxconn();
		samsung = new FactoryMethod().new Samsung();
		
		//每间工厂生产对应的手机
		iphone = foxconn.factory();
		samsungGalaxy = samsung.factory();
		
		iphone.method();
		samsungGalaxy.method();
		
	}

	/**
	 * 抽像产品
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public interface CellPhone{
		public void method();
	}
	
	/**
	 * 抽像工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public interface PhoneFactory{
		
		/**
		 * 工厂方法
		 * @return
		 */
		public CellPhone factory();
	}
	
	/**
	 * 具体产品：iPhone手机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class IPhone implements CellPhone{
		@Override
		public void method() {
			Log.log(logger, "iPhone手机。");
		}	
	}
	
	/**
	 * 具体产品：三星GALAXY手机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class SamsungGalaxy implements CellPhone{
		@Override
		public void method() {
			Log.log(logger, "Samsung GALAXY手机。");
		}	
	}
	
	/**
	 * 具体工厂：富士康
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class Foxconn implements PhoneFactory{
		@Override
		public CellPhone factory() {
			// 富士康生产iPhone手机
			return new IPhone();
		}
		
	}
	
	/**
	 * 具体工厂：三星
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class Samsung implements PhoneFactory{
		@Override
		public CellPhone factory() {
			// 三星生产三星GALAXY手机
			return new SamsungGalaxy();
		}
		
	}
}


