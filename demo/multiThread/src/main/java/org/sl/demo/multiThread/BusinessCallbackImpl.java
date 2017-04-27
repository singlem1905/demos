package org.sl.demo.multiThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessCallbackImpl implements IBusinessCallback {

	private final CenterService service;

	public BusinessCallbackImpl(final CenterService service) {
		this.service = service;
	}

	public void onComplete() {
		logger.info("callback called");
		this.service.doRelease();
	}

	private static final Logger logger = LoggerFactory.getLogger(BusinessCallbackImpl.class);
}
