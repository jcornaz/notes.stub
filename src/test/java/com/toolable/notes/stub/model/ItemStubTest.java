package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DateTimeImpl;
import com.toolable.notes.stub.impl.DocumentImpl;
import com.toolable.notes.stub.impl.ItemImpl;
import lotus.domino.Document;
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
        Assert.assertEquals("Value", itemStub.getString());
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));

        itemStub = new ItemStub(docStub, "ItemName", 42);
        Assert.assertFalse(itemStub.isEmpty());
        Assert.assertEquals(42, itemStub.getInteger());
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));

        DateTime date = DateTime.now();
        itemStub = new ItemStub(docStub, "ItemName", date);
        Assert.assertFalse(itemStub.isEmpty());
        Assert.assertEquals(date, itemStub.getDateTime());
        Assert.assertEquals("ItemName", itemStub.getName());
        Assert.assertSame(docStub, itemStub.getDocument());
        Assert.assertSame(itemStub, docStub.get("ItemName"));
    }

    @Test
    public void testDefaultName() throws Exception {
        String name = impl.getName();
        Assert.assertNotNull(name);
        Assert.assertFalse(name.isEmpty());
    }

    @Test
    public void testName() throws Exception {
        stub = new ItemStub("FieldName");
        impl = stub.getImplementation();

        Assert.assertEquals("FieldName", impl.getName());
    }

    @Test
    public void testDefaultParent() throws Exception {
        Assert.assertNotNull(impl.getParent());
    }

    @Test
    public void testParent() throws Exception {
        DocumentStub docStub = new DocumentStub();
        stub.setDocument(docStub);
        Document docImpl = impl.getParent();
        Assert.assertNotNull(docImpl);
        Assert.assertTrue(docImpl instanceof DocumentImpl);
        Assert.assertSame(docStub, ((DocumentImpl) docImpl).getStub());
    }

    @Test
    public void testGetType() {
        Assert.assertTrue(stub.isEmpty());

        stub.setValues(Arrays.asList("Monday", "Tuesday", "TowelDay"));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());
        Assert.assertEquals(Item.TEXT, impl.getType());

        stub.setValues(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());
        Assert.assertEquals(Item.NUMBERS, impl.getType());

        stub.setValues(Collections.singletonList(DateTime.now()));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertTrue(stub.isDateTime());
        Assert.assertEquals(Item.DATETIMES, impl.getType());
    }

    @Test
    public void testSetNumber() {
        stub.setStrings(Arrays.asList("Saluton", "Gxis la revido"));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());

        stub.setNumeric(true);
        Assert.assertTrue(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());
    }

    @Test
    public void testSetDateTime() {
        stub.setIntegers(Arrays.asList(1, 2, 3, 4));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertTrue(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());

        stub.setDateTime(true);
        Assert.assertTrue(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertTrue(stub.isDateTime());
    }

    @Test
    public void testSetText() {
        stub.setDateTimes(Collections.singletonList(DateTime.now()));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertFalse(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertTrue(stub.isDateTime());

        stub.setText();
        Assert.assertTrue(stub.isEmpty());
        Assert.assertTrue(stub.isText());
        Assert.assertFalse(stub.isNumeric());
        Assert.assertFalse(stub.isDateTime());
    }

    @Test
    public void testClear() {
        stub.setStrings(Arrays.asList("Bonan matenon", "Bonan tagon", "Bonan vesperon"));
        Assert.assertFalse(stub.isEmpty());
        Assert.assertTrue(stub.isNotEmpty());

        stub.clear();
        Assert.assertTrue(stub.isEmpty());
        Assert.assertFalse(stub.isNotEmpty());
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

    @Test
    public void testSetValueString() {
        impl.setValueString("Kafo");
        Assert.assertTrue(stub.isText());
        Assert.assertEquals("Kafo", stub.getString());
    }

    @Test
    public void testSetValueDouble() {
        impl.setValueDouble(3.1415);
        Assert.assertTrue(stub.isNumeric());
        Assert.assertEquals(3.1415, stub.getDouble(), 1e-10);
    }

    @Test
    public void testSetValueInteger() {
        impl.setValueInteger(42);
        Assert.assertTrue(stub.isNumeric());
        Assert.assertEquals(42, stub.getInteger());
    }

    @Test
    public void testSetValueDateTime() {
        DateTime date = DateTime.now();
        impl.setDateTimeValue(new DateTimeStub(date).getImplementation());
        Assert.assertTrue(stub.isDateTime());
        Assert.assertEquals(date, stub.getDateTime());
    }

    @Test
    public void testGetDateTimeValue() {
        DateTime date = DateTime.now();
        stub.setDateTime(date);

        lotus.domino.DateTime dateTimeImpl = impl.getDateTimeValue();
        Assert.assertNotNull(dateTimeImpl);
        Assert.assertTrue(dateTimeImpl instanceof DateTimeImpl);
        Assert.assertEquals(date, ((DateTimeImpl) dateTimeImpl).getStub().getValue());
    }

    @Test
    public void testCopy() throws Exception {
        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();

        stub.setDocument(doc1);

        Item itemCreated = impl.copyItemToDocument(doc2.getImplementation());
        Assert.assertNotNull(itemCreated);
        Assert.assertTrue(itemCreated instanceof ItemImpl);
        Assert.assertNotSame(impl, itemCreated);
        Assert.assertEquals(stub.getName(), itemCreated.getName());
    }

    @Test
    public void testCopyAndChangeName() throws Exception {
        Assert.assertNotEquals("NewName", stub.getName());

        DocumentStub doc1 = new DocumentStub();
        DocumentStub doc2 = new DocumentStub();

        stub.setDocument(doc1);

        Item itemCreated = impl.copyItemToDocument(doc2.getImplementation(), "NewName");
        Assert.assertNotNull(itemCreated);
        Assert.assertTrue(itemCreated instanceof ItemImpl);
        Assert.assertNotSame(impl, itemCreated);
        Assert.assertNotEquals(stub.getName(), itemCreated.getName());
        Assert.assertEquals("NewName", itemCreated.getName());
    }
}
