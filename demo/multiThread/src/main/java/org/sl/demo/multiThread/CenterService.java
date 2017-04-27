package org.sl.demo.multiThread;

import java.util.Random;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CenterService {

	private Semaphore semaphore;

	private Random random;

	public CenterService() {
		this.semaphore = new Semaphore(1);
		this.random = new Random(System.currentTimeMillis());
	}

	public void doLock() throws InterruptedException {
		this.semaphore.acquire();
	}

	public void doRelease() {
		this.semaphore.release();
	}

	public void doBusiness() {

		try {
			doLock();
			logger.info("do service");
			Thread t = new Thread() {

				@Override
				public void run() {
					try {
						int s = random.nextInt(10);
						Thread.sleep(s * 1000);
						logger.info("business using {} s.", s);
						BusinessCallbackImpl i = new BusinessCallbackImpl(CenterService.this);
						i.onComplete();
					} catch (InterruptedException e) {
						logger.error(e.getMessage(), e);
					}
				}

			};
			t.start();
			logger.info("waiting complete...");

		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}

	}

	private static final Logger logger = LoggerFactory.getLogger(CenterService.class);
}
