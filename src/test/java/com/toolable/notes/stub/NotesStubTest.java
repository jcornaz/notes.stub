package com.toolable.notes.stub;

import com.toolable.notes.stub.model.DocumentStub;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for {@link NotesStub}
 */
public class NotesStubTest {

    /**
     * Test error for {@link NotesStub#assertNotRecycled(List)}
     */
    @Test(expected = AssertionError.class)
    public void testErrorOnBulkAssertNotRecycled() {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc2.setRecycled(true);

        NotesStub.assertNotRecycled(doc1, doc2, doc3);
    }

    /**
     * Test no error for {@link NotesStub#assertNotRecycled(List)}
     */
    @Test
    public void testNoErrorOnBulkAssertNotRecycled() {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        NotesStub.assertNotRecycled(doc1, doc2, doc3);
    }

    /**
     * Test error for {@link NotesStub#assertRecycled(List)}
     */
    @Test(expected = AssertionError.class)
    public void testErrorOnBulkAssertRecycled() {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc2.setRecycled(true);
        doc3.setRecycled(true);

        NotesStub.assertRecycled(doc1, doc2, doc3);
    }

    /**
     * Test no error for {@link NotesStub#assertRecycled(List)}
     */
    @Test
    public void testNoErrorOnBulkAssertRecycled() {

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();
        DocumentStub doc3 = new DocumentStub();

        doc1.setRecycled(true);
        doc2.setRecycled(true);
        doc3.setRecycled(true);

        NotesStub.assertRecycled(doc1, doc2, doc3);
    }
}
