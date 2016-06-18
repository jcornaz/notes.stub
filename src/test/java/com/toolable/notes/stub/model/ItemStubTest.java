package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.ItemImpl;
import lotus.domino.Item;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Unit tests of {@link ItemStub}
 *
 * @author jonathan
 */
public class ItemStubTest {

    private ItemStub stub;
    private ItemImpl impl;

    /**
     * All method of a {@link com.toolable.notes.stub.impl.ItemImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new ItemStub());
    }

    @Before
    public void setUp() throws Exception {
        stub = new ItemStub();
        impl = stub.getImplementation();
        Assert.assertNotNull(impl);
    }

    @Test
    public void testCreateStub() throws Exception {
        DocumentStub docStub = new DocumentStub();

        ItemStub itemStub = new ItemStub(docStub, "ItemName");
        Assert.assertTrue(itemStub.isEmpty());
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));

        itemStub = new ItemStub(docStub, "ItemName", "Value");
        Assert.assertFalse(itemStub.isEmpty());
        Assert.assertEquals("Value", itemStub.getString(0));
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));

        itemStub = new ItemStub(docStub, "ItemName", 42);
        Assert.assertFalse(itemStub.isEmpty());
        Assert.assertEquals(42, itemStub.getInt(0));
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));

        DateTime date = DateTime.now();
        itemStub = new ItemStub(docStub, "ItemName", date);
        Assert.assertFalse(itemStub.isEmpty());
        Assert.assertEquals(date, itemStub.getDateTime(0));
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));
    }

    @Test
    public void testGetType() {
        Assert.assertTrue(stub.isEmpty());

        stub.setValues(Arrays.asList("Monday", "Tuesday", "TowelDay"));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());
        Assert.assertEquals(Item.TEXT, impl.getType());

        stub.setValues(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());
        Assert.assertEquals(Item.NUMBERS, impl.getType());

        stub.setValues(Collections.singletonList(DateTime.now()));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertTrue(stub.isDateTimes());
        Assert.assertEquals(Item.DATETIMES, impl.getType());
    }

    @Test
    public void testSetNumber() {
        stub.setStrings(Arrays.asList("Saluton", "Gxis la revido"));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());

        stub.setNumbers(true);
        Assert.assertTrue(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());
    }

    @Test
    public void testSetDateTime() {
        stub.setIntegers(Arrays.asList(1, 2, 3, 4));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());

        stub.setDateTimes(true);
        Assert.assertTrue(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertTrue(stub.isDateTimes());
    }

    @Test
    public void testSetText() {
        stub.setDateTimes(Collections.singletonList(DateTime.now()));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertTrue(stub.isDateTimes());

        stub.setText();
        Assert.assertTrue(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumbers());
        Assert.assertFalse(stub.isDateTimes());
    }

    @Test
    public void testClear() {
        stub.setStrings(Arrays.asList("Bonan matenon", "Bonan tagon", "Bonan vesperon"));
        Assert.assertFalse(stub.isEmpty());

        stub.clear();
        Assert.assertTrue(stub.isEmpty());
        Assert.assertEquals(Collections.emptyList(), stub.getStrings());
    }

    @Test
    public void testReader() {
        stub.setReaders(true);
        Assert.assertTrue(impl.isReaders());
        Assert.assertFalse(impl.isAuthors());
        Assert.assertFalse(impl.isNames());

        stub.setReaders(false);
        Assert.assertFalse(impl.isReaders());
        Assert.assertFalse(impl.isAuthors());
        Assert.assertFalse(impl.isNames());

        impl.setReaders(true);
        Assert.assertTrue(stub.isReaders());
    }

    @Test
    public void testAuthors() {
        stub.setAuthors(true);
        Assert.assertFalse(impl.isReaders());
        Assert.assertTrue(impl.isAuthors());
        Assert.assertFalse(impl.isNames());

        stub.setAuthors(false);
        Assert.assertFalse(impl.isReaders());
        Assert.assertFalse(impl.isAuthors());
        Assert.assertFalse(impl.isNames());

        impl.setAuthors(true);
        Assert.assertTrue(stub.isAuthors());
    }

    @Test
    public void testNames() {
        stub.setNames(true);
        Assert.assertFalse(impl.isReaders());
        Assert.assertFalse(impl.isAuthors());
        Assert.assertTrue(impl.isNames());

        stub.setNames(false);
        Assert.assertFalse(impl.isReaders());
        Assert.assertFalse(impl.isAuthors());
        Assert.assertFalse(impl.isNames());

        impl.setNames(true);
        Assert.assertTrue(stub.isNames());
    }

    @Test
    public void testSummary() {
        Assert.assertTrue(stub.isSummary());
        Assert.assertTrue(impl.isSummary());

        stub.setSummary(false);
        Assert.assertFalse(stub.isSummary());
        Assert.assertFalse(impl.isSummary());

        impl.setSummary(true);
        Assert.assertTrue(stub.isSummary());
    }

    @Test
    public void testProtected() {
        Assert.assertFalse(stub.isProtected());
        Assert.assertFalse(impl.isProtected());

        stub.setProtected(true);
        Assert.assertTrue(stub.isProtected());
        Assert.assertTrue(impl.isProtected());

        impl.setProtected(false);
        Assert.assertFalse(stub.isProtected());
    }

    @Test
    public void testSigned() {
        Assert.assertFalse(stub.isSigned());
        Assert.assertFalse(impl.isSigned());

        stub.setSigned(true);
        Assert.assertTrue(stub.isSigned());
        Assert.assertTrue(impl.isSigned());

        impl.setSigned(false);
        Assert.assertFalse(stub.isSigned());
    }

    @Test
    public void testEncrypted() {
        Assert.assertFalse(stub.isEncrypted());
        Assert.assertFalse(impl.isEncrypted());

        stub.setEncrypted(true);
        Assert.assertTrue(stub.isEncrypted());
        Assert.assertTrue(impl.isEncrypted());

        impl.setEncrypted(false);
        Assert.assertFalse(stub.isEncrypted());
    }
}
