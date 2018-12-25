package com.jp.tradereporting.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jp.tradereporting.vo.InstructionVO;

@RunWith(MockitoJUnitRunner.class)
public class CacheServiceTest {

	@InjectMocks
	private CacheServiceImpl service;
	
	private List<InstructionVO> instructions;
	@Mock
	private InstructionVO instruction1;
	@Mock
	private InstructionVO instruction2;
	@Mock
	private InstructionVO instruction3;
	
	@Before
	public void runBeforeTestMethod() {
		instructions = new ArrayList<>();
		instructions.add(instruction1);
		instructions.add(instruction2);
		instructions.add(instruction3);
	}

	@Test
	public void testPersistCollectionSucceeds() {
		service.persist(instructions);
		assertTrue(instructions.containsAll(service.getInstructions()));
		assertEquals(3, service.getInstructions().size());
	}

}
