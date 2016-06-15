package com.toolable.notes.stub.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit tests for {@link Unid}
 */
public class UnidTest {

    @Test(timeout = 1000)
    public void testGeneration() throws Exception {
        Set<String> generated = new HashSet<String>();
        for (int i = 0; i < 100000; i++) {
            String unid = Unid.generate().toString();
            Assert.assertTrue(unid.matches("^[A-F0-9]{32}$"));
            Assert.assertTrue(generated.add(unid));
        }
    }
}
