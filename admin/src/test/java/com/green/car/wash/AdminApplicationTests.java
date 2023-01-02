package com.green.car.wash;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.green.car.wash.admin.controller.AdminController;
import com.green.car.wash.admin.model.WashPacks;
import com.green.car.wash.admin.repository.WashPackRepo;
import com.green.car.wash.admin.service.WashPackService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminApplicationTests {
    @MockBean
    WashPackRepo washrepo;
    @Autowired
    WashPackService service;
    @Autowired
    AdminController ac;


   @Test
    public void allWPTest() {
        when(washrepo.findAll()).thenReturn(Stream.of(new WashPacks("123","clean",300,"clean wash"),
                new WashPacks("124","clean",200,"clean wash")
                ).collect(Collectors.toList()));
        assertEquals("This should return all the wash packs available and count them",2,service.findallWP().size());
    }
	
	/*
	 * @Test public void oneWPTest() {
	 * 
	 * when(washrepo.findAll()).thenReturn(Stream.of(new
	 * WashPacks("123","clean",300,"clean wash")) .collect(Collectors.toList()));
	 * assertEquals("this should return one available washpack from waskpacks list"
	 * ,123,service.findoneWP()).new
	 * Exception("Washpack with ID -> "+123+" not found"); }
	 */
	 
    }