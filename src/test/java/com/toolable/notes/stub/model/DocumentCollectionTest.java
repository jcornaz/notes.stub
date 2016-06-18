package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DocumentCollectionImpl;
import lotus.domino.Document;
import lotus.domino.NotesException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Unit tests for {@link lotus.domino.Document]
 */
public class DocumentCollectionTest {

    private DocumentCollectionStub stub;
    private DocumentCollectionImpl impl;

    /**
     * All method of a {@link com.toolable.notes.stub.impl.DocumentCollectionImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DocumentCollectionStub());
    }

    /**
     * Create a stub ready to test
     */
    @Before
    public void setUp() {
        stub = new DocumentCollectionStub();
        impl = stub.getImplementation();
        Assert.assertNotNull(impl);
    }

    /**
     * Test parent of the collection
     */
    @Test
    public void testParent() {
        Assert.assertNotNull(impl.getParent());
    }

    /**
     * Test a normal iteration
     *
     * @throws NotesException Unexpected exception
     */
    @Test(timeout = 1000)
    public void testIteration() throws NotesException {
        for (int i = 0; i < 100; i++)
            stub.add(new DocumentStub());

        Assert.assertEquals(100, impl.getCount());

        Set<String> unids = new HashSet<String>();

        Document currentDoc = impl.getFirstDocument();
        while (currentDoc != null) {
            Assert.assertTrue(unids.add(currentDoc.getUniversalID()));
            Document nextDoc = impl.getNextDocument();
            Assert.assertNotSame(currentDoc, nextDoc);
            currentDoc = nextDoc;
        }

        Assert.assertEquals(100, unids.size());
    }

    /**
     * Test an iteration with {@link lotus.domino.DocumentCollection#getNextDocument(Document)}
     *
     * @throws NotesException Unexpected exception
     */
    @Test(timeout = 1000)
    public void testIterationWithArgument() throws NotesException {
        for (int i = 0; i < 100; i++)
            stub.add(new DocumentStub());

        Assert.assertEquals(100, impl.getCount());

        Set<String> unids = new HashSet<String>();

        Document currentDoc = impl.getFirstDocument();
        while (currentDoc != null) {
            Assert.assertTrue(unids.add(currentDoc.getUniversalID()));
            Document nextDoc = impl.getNextDocument(currentDoc);
            Assert.assertNotSame(currentDoc, nextDoc);
            currentDoc = nextDoc;
        }

        Assert.assertEquals(100, unids.size());
    }

    /**
     * Test a reverse iteration (from the last document to the first)
     *
     * @throws NotesException Unexpected exception
     */
    @Test(timeout = 1000)
    public void testInverseIteration() throws NotesException {
        for (int i = 0; i < 100; i++)
            stub.add(new DocumentStub());

        Assert.assertEquals(100, impl.getCount());

        Set<String> unids = new HashSet<String>();

        Document currentDoc = impl.getLastDocument();
        while (currentDoc != null) {
            Assert.assertTrue(unids.add(currentDoc.getUniversalID()));
            Document prevDoc = impl.getPrevDocument();
            Assert.assertNotSame(currentDoc, prevDoc);
            currentDoc = prevDoc;
        }

        Assert.assertEquals(100, unids.size());
    }
}
