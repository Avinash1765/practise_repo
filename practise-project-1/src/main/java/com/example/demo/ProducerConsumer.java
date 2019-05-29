package com.example.demo;


class Resource{
	int value;
	boolean valueSet=false;
	
	public synchronized void put(int i){
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Put: "+ i);
		value=i;
		valueSet=true;
		notify();
	}
	
	public synchronized void get() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
		}
		System.out.println("Get: "+value);
		valueSet=false;
		notify();
	}
}
}


class Producer implements Runnable{
	
	Resource resource;
	
	public Producer(Resource resource) {
		this.resource=resource;
		Thread t=new Thread(this,"Producer");
		t.start();
	}

	@Override
	public void run() {
		int i=0;
		while(true) {
			resource.put(i);
			i++;
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
}

class Consumer implements Runnable{
	
	Resource resource;
	
	public Consumer(Resource resource) {
		this.resource=resource;
		Thread t=new Thread(this,"Consumer");
		t.start();
	}

	@Override
	public void run() {
		while(true) {
			resource.get();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}


public class ProducerConsumer {

	public static void main(String[] args) {
		Resource r=new Resource();
		new Producer(r);
		new Consumer(r);
	}

}
