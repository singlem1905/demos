package org.sl.demo.multiThread;

public class Main {

	public static void main(String[] args) {
		final CenterService s = new CenterService();
		for(int i=0;i<10;i++){
//			Thread t = new Thread() {
//
//				@Override
//				public void run() {
//					s.doBusiness();
//				}
//				
//			};
//			t.start();
			s.doBusiness();
		}
		
	}
}
