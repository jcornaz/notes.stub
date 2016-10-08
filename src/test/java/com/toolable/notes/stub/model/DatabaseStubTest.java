package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.NonExistantDocumentException;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DatabaseImpl;
import com.toolable.notes.stub.impl.DocumentImpl;
import lotus.domino.Document;
import lotus.domino.NotesException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests of {@link DatabaseStub}
 *
 * @author jonathan
 */
public class DatabaseStubTest {

    private DatabaseStub stub;
    private DatabaseImpl impl;

    /**
     * All method of a {@link com.toolable.notes.stub.impl.DatabaseImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DatabaseStub());
    }

    /**
     * Create a stub ready to test
     */
    @Before
    public void setUp() {
        stub = new DatabaseStub();
        impl = stub.getImplementation();
    }

    /**
     * Test to get a document by UNID
     *
     * @throws NonExistantDocumentException Unexpected exception
     */
    @Test
    public void testGetDocumentByUNID() throws NonExistantDocumentException {
        DocumentStub docStub = new DocumentStub(stub);
        docStub.setUnid(Unid.parse("DEADBEEFDEADBEEFDEADBEEFDEADBEEF"));

        Document docImpl = impl.getDocumentByUNID("DEADBEEFDEADBEEFDEADBEEFDEADBEEF");
        Assert.assertNotNull(docImpl);
        Assert.assertTrue(docImpl instanceof DocumentImpl);
        Assert.assertSame(docStub, ((DocumentImpl) docImpl).getStub());
    }

    /**
     * Test to get a document by UNID that does not exist
     *
     * @throws NonExistantDocumentException Expected exception
     */
    @Test(expected = NonExistantDocumentException.class)
    public void testGetNonExistantDocumentByUNID() throws NonExistantDocumentException {
        impl.getDocumentByUNID("DEADBEEFDEADBEEFDEADBEEFDEADBEEF");
    }

    @Test
    public void testCreateDocument() throws NotesException {
        Document doc = impl.createDocument();
        Assert.assertNotNull(doc);
        Assert.assertSame(impl, doc.getParentDatabase());
    }
}
