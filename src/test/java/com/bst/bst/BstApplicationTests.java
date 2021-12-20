package com.bst.bst;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import com.bst.controllers.BSTController;
import com.bst.models.Bst;

@SpringBootTest
class BstApplicationTests {
	@Mock
	BSTController controller;
	private Bst model;
	private Model thymeleafModel;

	@Test
	void testBST() {
		model = new Bst(1, "1,2,3", "data");

		Mockito.when(controller.getData(model, thymeleafModel));

		try {
            assertTrue(Objects.equals(controller.getData(model, thymeleafModel), "result"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void testBSTSpaces() {
		model = new Bst(1, "1    , 2,  3   ", "data");

		Mockito.when(controller.getData(model, thymeleafModel));

		try {
            assertTrue(Objects.equals(controller.getData(model, thymeleafModel), "result"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void testBSTNumbers() {
		model = new Bst(1, "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", "data");

		Mockito.when(controller.getData(model, thymeleafModel));

		try {
            assertTrue(Objects.equals(controller.getData(model, thymeleafModel), "result"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}