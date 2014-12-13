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

package com.cottsoft.design.patterns.creational.polymorphicfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cottsoft.design.patterns.Log;

/**
 * Description：<br> 
 * 多态工厂（Polymorphic Factory），简单工厂和工厂方法的合体
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    2005年03月03日
 * @version v1.0.0
 */
public class PolymorphicFactory {
	private Logger logger = LoggerFactory.getLogger(PolymorphicFactory.class);
	
	//定义三家工厂：中国人工厂，美国人工厂，英国人工厂
	private static PersonFactory chineseFactory,americanFactory,britishFactory;
	
	//定义三种人类：中国人，美国人，英国人
	private static IPerson chinese,american,british;
	
	public static void main(String[] args) {
		//实例化厂家工厂:
		chineseFactory = new PolymorphicFactory().new ChineseFactory();
		americanFactory = new PolymorphicFactory().new AmericanFactory();
		britishFactory = new PolymorphicFactory().new BritishFactory();
		
		//每间工厂创建对应的人类
		chinese = chineseFactory.factory();
		american = americanFactory.factory();
		british = britishFactory.factory();
		
		//具体人类做具体的事：
		chinese.msg();
		american.msg();
		british.msg();
	}
	
	/**
	 * 抽像工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public abstract class PersonFactory{
		public abstract IPerson factory();
	}
	
	/**
	 * 具体工厂：中国人工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class ChineseFactory extends PersonFactory{
		@Override
		public IPerson factory() {
			return new ChineseImpl();
		}	
	}
	
	/**
	 * 具体工厂：美国人工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class AmericanFactory extends PersonFactory{
		@Override
		public IPerson factory() {
			return new AmericanImpl();
		}
	}
	
	/**
	 * 具体工厂：英国人工厂
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class BritishFactory extends PersonFactory{
		@Override
		public IPerson factory() {
			return new BritishImpl();
		}
	}
	
	/**
	 * 抽像人类
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public abstract class IPerson{
		
		/**
		 * 吃饭
		 */
		public abstract void eat();
		
		/**
		 * 走路
		 */
		public abstract void walk();
		
		/**
		 * 工作
		 */
		public abstract void work();
		
		public void msg(){
			eat();
			walk();
			work();
		}
	}
	
	/**
	 * 具体人类：中国人
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class ChineseImpl extends IPerson{
		private String location;
		
		public ChineseImpl(){
			Log.log(logger, getLocation());
			speakChinese();
		}
		public String getLocation() {
			return location==null?"亚洲":location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		@Override
		public void eat() {
			Log.log(logger, "中国人吃中餐。");
		}

		@Override
		public void walk() {
			Log.log(logger, "中国人在中国的地盘上行走。");
		}

		@Override
		public void work() {
			Log.log(logger, "中国人在中国公司工作。");
		}
		
		public void speakChinese(){
			Log.log(logger, "中国人说中国话。");
		}		
	}
	
	/**
	 * 具体人类：美国人
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class AmericanImpl extends IPerson{
		private String greenCard;
		
		public AmericanImpl(){
			Log.log(logger, getGreenCard());
			war();
		}
		public String getGreenCard() {
			return greenCard==null?"美国绿卡":greenCard;
		}

		public void setGreenCard(String greenCard) {
			this.greenCard = greenCard;
		}

		@Override
		public void eat() {
			Log.log(logger, "美国人吃火鸡。");
		}

		@Override
		public void walk() {
			Log.log(logger, "美国人在全世界行走。");
		}

		@Override
		public void work() {
			Log.log(logger, "美国人在全世界工作。");
		}	
		
		public void war(){
			Log.log(logger, "美国人爱打仗。");
		}
	}
	
	/**
	 * 具体人类：英国人
	 * @author  Simon.Hoo(Info@cottsoft.com)
	 * @version v1.0.0
	 */
	public class BritishImpl extends IPerson{
		public String gentleman;
		
		public BritishImpl(){
			Log.log(logger, getGentleman());
			action();
		}
		public String getGentleman() {
			return gentleman==null?"英国人很绅士":gentleman;
		}

		public void setGentleman(String gentleman) {
			this.gentleman = gentleman;
		}

		@Override
		public void eat() {
			Log.log(logger, "英国人爱吃西餐。");
		}

		@Override
		public void walk() {
			Log.log(logger, "英国跟着美国人在全世界行走。");
		}

		@Override
		public void work() {
			Log.log(logger, "英国人在欧洲工作。");
		}
		
		public void action(){
			Log.log(logger, "英国人老爱跟着美国人屁股后面屁点屁点的打仗。");
		}
		
	}

}


