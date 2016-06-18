package com.toolable.notes.stub;

import com.toolable.notes.stub.model.DocumentStub;
import org.junit.Test;

/**
 * Unit test for {@link NotesStub}
 */
public class NotesStubTest {

    @Test(expected = AssertionError.class)
    public void testErrorOnBulkAssertNotRecycled() throws Exception {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc2.setRecycled(true);

        NotesStub.assertNotRecycled(doc1, doc2, doc3);
    }

    @Test
    public void testNoErrorOnBulkAssertNotRecycled() throws Exception {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        NotesStub.assertNotRecycled(doc1, doc2, doc3);
    }

    @Test(expected = AssertionError.class)
    public void testErrorOnBulkAssertRecycled() throws Exception {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc2.setRecycled(true);
        doc3.setRecycled(true);

        NotesStub.assertRecycled(doc1, doc2, doc3);
    }

    @Test
    public void testNoErrorOnBulkAssertRecycled() throws Exception {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc1.setRecycled(true);
        doc2.setRecycled(true);
        doc3.setRecycled(true);

        NotesStub.assertRecycled(doc1, doc2, doc3);
    }
}
