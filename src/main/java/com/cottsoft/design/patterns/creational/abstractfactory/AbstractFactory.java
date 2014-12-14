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

package com.cottsoft.design.patterns.creational.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 抽象工厂（Abstract Factory）
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年04月04日
 * @version v1.0.0
 */
public class AbstractFactory {
	private Logger logger = LoggerFactory.getLogger(AbstractFactory.class);
	
	//定义两家工厂
	public static PhoneFactory foxconn,samsung;
	
	//定义两款手机
	public static CellPhone iphone,samsungGalaxy;
	
	//定议两款电话机
	public static TelPhone siemensPhone,tclPhone;
	
	public static void main(String[] args) {
		//实例化工厂：富士康
		foxconn = new AbstractFactory().new Foxconn();
		//富士康生产手机：iPhone
		iphone = foxconn.factoryCellPhone();
		//手机工作：
		iphone.cell();
		
		//富士康生产电话机：西门子电话机
		siemensPhone = foxconn.factoryTelPhone();
		//电话工作：
		siemensPhone.phone();
		
		//实例化工厂：三星
		samsung = new AbstractFactory().new Samsung();
		//三星生产手机：Samsung GALAXY手机
		samsungGalaxy = samsung.factoryCellPhone();
		//手机工作：
		samsungGalaxy.cell();
		
		//三星生产电话机：TCL电话机
		tclPhone = samsung.factoryTelPhone();
		//电话工作：
		tclPhone.phone();
	}

	/**
	 * 抽像工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public interface PhoneFactory{
		public CellPhone factoryCellPhone();
		public TelPhone factoryTelPhone();
	}
	
	/**
	 * 抽象产品：手机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public interface CellPhone{
		public void cell();
	}
	
	/**
	 * 抽象产品：电话机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public interface TelPhone{
		public void phone();
	}
	
	/**
	 * 具体工厂：富士康
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class Foxconn implements PhoneFactory{
		public Foxconn(){
			Log.log(logger, "富士康工厂生产：");
		}
		
		@Override
		public CellPhone factoryCellPhone() {
			return new IPhone();
		}

		@Override
		public TelPhone factoryTelPhone() {
			return new SiemensPhone();
		}		
	}
	
	/**
	 * 具体工厂：三星
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class Samsung implements PhoneFactory{
		public Samsung(){
			Log.log(logger, "三星工厂生产：");
		}
		
		@Override
		public CellPhone factoryCellPhone() {
			return new SamsungGalaxy();
		}

		@Override
		public TelPhone factoryTelPhone() {
			return new TclPhone();
		}		
	}
	
	/**
	 * 手机实现：iPhone手机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class IPhone implements CellPhone{
		@Override
		public void cell() {
			Log.log(logger, "Iphone 手机");
		}
	}
	
	/**
	 * 手机实现：三星GALAXY手机
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class SamsungGalaxy implements CellPhone{
		@Override
		public void cell() {
			Log.log(logger, "Samsung GALAXY手机。");
		}
	}
	
	/**
	 * 电话机实现：西门子电话
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class SiemensPhone implements TelPhone{
		@Override
		public void phone() {
			Log.log(logger, "西门子电话机。");
		}		
	}
	
	/**
	 * 电话机实现：TCL电话
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class TclPhone implements TelPhone{
		@Override
		public void phone() {
			Log.log(logger, "TCL电话机。");
		}
	}
}


