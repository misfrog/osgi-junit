package com.misfrog.osgi.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryServiceImplTest {

	@Test
	public void testCheck() {
		Dictionary dictionary = new DictionaryImpl();
		DictionaryService service = new DictionaryServiceImpl();
		service.registerDictionary(dictionary);
		assertTrue(service.check("osgi"));
	}
}
