package com.huang.alpha.jvm;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "Day";
	
	

	public synchronized String getThermostat() {
		return thermostat;
	}

	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
	
	public void schedule(Runnable  event , long delay) {
		scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
	}
	
	public void repeat(Runnable event, long initialDelay, long period) {
		scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}

	public synchronized void setThermostat(String thermostat) {
		this.thermostat = thermostat;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class LightOn implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("turning on linghts");
			light= true;
			
		}
		
	}
	
	class WaterOn implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turnning greenhouse water on");
			water = true;
			
		}
		
	}
	
	class WaterOff implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turnning greenhouse water off");
			water = false;
			
		}
		
	}
	
	class ThrermostatNight implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thrermostat to night setting");
			setThermostat("Night");
			
		}
		
	}
	
	class ThrermostatDay implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thrermostat to day setting");
			setThermostat("Day");
			
		}
		
	}

}
