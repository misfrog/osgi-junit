package com.misfrog.osgi.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class DictionaryServiceTest {
	
	private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext(); 
	
	private ServiceTracker tracker;
	private DictionaryService service;

	@Before
	public void setUp() throws Exception {
		tracker = new ServiceTracker(context, DictionaryService.class.getName(), null);
		tracker.open();
		
		service = (DictionaryService) tracker.getService();
	}

	@After
	public void tearDown() throws Exception {
		tracker.close();
		service = null;
	}

	@Test
	public void test() {
		Dictionary dictionary = new DictionaryImpl();
		service.registerDictionary(dictionary);
		assertTrue(service.check("osgi"));		
	}
}
