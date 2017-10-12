package com.github.siiilas.testcodeanalyzer.service;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CodeAnalyzerServiceTest {

    private CodeAnalyzerService service;

    @Before
    public void init() {
        service = new CodeAnalyzerService();
    }

    @Test
    public void shouldReturnIsJavaFile() {
        File file = new File("Teste.java");
        boolean result = service.isJavaFile(file);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnIsNotJavaFile() {
        File file = new File("Teste.txt");
        boolean result = service.isJavaFile(file);
        Assert.assertFalse(result);
    }

}
