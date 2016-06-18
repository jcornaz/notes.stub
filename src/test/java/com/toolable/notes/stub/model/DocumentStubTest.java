package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DateTimeImpl;
import com.toolable.notes.stub.impl.DocumentImpl;
import lotus.domino.Document;
import lotus.domino.Item;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Unit tests of {@link DocumentStub}
 *
 * @author jonathan
 */
public class DocumentStubTest {

    private DocumentStub stub;
    private DocumentImpl impl;

    /**
     * Create a new stub to test
     */
    @Before
    public void setUp() {
        stub = new DocumentStub();
        impl = this.stub.getImplementation();
        Assert.assertNotNull(impl);

        //noinspection ConstantConditions
        Assert.assertTrue(impl instanceof Document);
    }

    /**
     * All method of a {@link com.toolable.notes.stub.impl.DocumentImpl} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @see TestUtils#assertExceptionsRaisedOnRecycledObject(BaseStub)
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        TestUtils.assertExceptionsRaisedOnRecycledObject(new DocumentStub());
    }

    @Test
    public void testGetFirstItem() throws Exception {
        stub.set("MyFirstItem", "StringValue");
        Item item = impl.getFirstItem("MyFirstItem");
        Assert.assertNotNull(item);
        Assert.assertEquals("StringValue", item.getValueString());
    }

    /**
     * Test the implementation behavior when the field contains a string
     */
    @Test
    public void testStringValue() {
        stub.set("StringField", "customvalue");

        Assert.assertEquals("customvalue", impl.getItemValueString("StringField"));
        Assert.assertEquals("customvalue", impl.getItemValueString("STRINGfield"));
        Assert.assertEquals(0, impl.getItemValueDouble("StringField"), 1e-10);
        Assert.assertEquals(0, impl.getItemValueInteger("StringField"));
        Assert.assertTrue(impl.getItemValueDateTimeArray("StringField").isEmpty());

        Vector<?> values = impl.getItemValue("StringField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals("customvalue", values.get(0));
    }

    /**
     * Test the implementation behavior when the field contains an integer
     */
    @Test
    public void testIntegerValue() {
        stub.set("NumericField", 42);

        Assert.assertNull(impl.getItemValueString("NumericField"));
        Assert.assertEquals(42, impl.getItemValueDouble("NumericField"), 1e-10);
        Assert.assertEquals(42, impl.getItemValueInteger("NumericField"));
        Assert.assertEquals(42, impl.getItemValueInteger("NUMERICfield"));
        Assert.assertTrue(impl.getItemValueDateTimeArray("NumericField").isEmpty());

        Vector<?> values = impl.getItemValue("NumericField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals(42.0, values.get(0));
    }

    /**
     * Test the implementation behavior when the field contains a double
     */
    @Test
    public void testDoubleValue() {
        stub.set("NumericField", 3.1415);

        Assert.assertNull(impl.getItemValueString("NumericField"));
        Assert.assertEquals(3.1415, impl.getItemValueDouble("NumericField"), 1e-10);
        Assert.assertEquals(3.1415, impl.getItemValueDouble("NUMERICfield"), 1e-10);
        Assert.assertEquals(3, impl.getItemValueInteger("NumericField"));
        Assert.assertTrue(impl.getItemValueDateTimeArray("NumericField").isEmpty());

        Vector<?> values = impl.getItemValue("NumericField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals(3.1415, values.get(0));
    }

    /**
     * Test the implementation behavior when the field contains a date-time
     */
    @Test
    public void testDateTimeValue() {
        stub.set("DateTimeField", new DateTime(2015, 3, 14, 9, 26, 53));

        Assert.assertNull(impl.getItemValueString("DateTimeField"));
        Assert.assertEquals(0, impl.getItemValueDouble("DateTimeField"), 1e-10);
        Assert.assertEquals(0, impl.getItemValueInteger("DateTimeField"));

        Vector<?> dates = impl.getItemValueDateTimeArray("DateTimeField");
        Assert.assertNotNull(dates);
        Assert.assertEquals(1, dates.size());
        Object dateImpl = dates.get(0);
        Assert.assertNotNull(dateImpl);
        Assert.assertTrue(dateImpl instanceof DateTimeImpl);
        Assert.assertEquals(new DateTime(2015, 3, 14, 9, 26, 53), ((DateTimeImpl) dateImpl).getStub().getValue());

        Vector<?> values = impl.getItemValue("DateTimeField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals(dateImpl, values.get(0));
    }

    /**
     * Test the implementation behavior when accessing a non-existent item
     */
    @Test
    public void testNonExistentItem() {
        Assert.assertNull(impl.getFirstItem("non_existent_item_name"));
        Assert.assertNull(impl.getItemValueString("non_existent_item_name"));
        Assert.assertEquals(0, impl.getItemValueInteger("non_existent_item_name"));
        Assert.assertEquals(0, impl.getItemValueDouble("non_existent_item_name"), 1e-10);
        Assert.assertTrue(impl.getItemValueDateTimeArray("non_existent_item_name").isEmpty());
        Assert.assertTrue(impl.getItemValue("non_existent_item_name").isEmpty());
    }

    /**
     * Test replacing a value by a string
     */
    @Test
    public void testReplaceString() {
        impl.replaceItemValue("MyFieldName", "MyString");
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals("MyString", itemStub.get(0));
    }

    /**
     * Test replacing a value by a double
     */
    @Test
    public void testReplaceDouble() {
        impl.replaceItemValue("MyFieldName", 3.1415);
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(3.1415, itemStub.get(0));
    }

    /**
     * Test replacing a value by an integer
     */
    @Test
    public void testReplaceInteger() {
        impl.replaceItemValue("MyFieldName", 42);
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(42.0, itemStub.get(0));
    }

    /**
     * Test replacing a value by a date-time
     */
    @Test
    public void testReplaceDateTime() {
        DateTime now = DateTime.now();
        impl.replaceItemValue("MyFieldName", new DateTimeStub(now).getImplementation());
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(now, itemStub.get(0));
    }

    /**
     * Test replacing a value by a vector
     */
    @Test
    public void testReplaceVector() {
        impl.replaceItemValue("MyFieldName", new Vector<Object>(Arrays.asList(1, 2, 3)));
        ItemStub itemStub = stub.get("MyFieldName");

        Assert.assertNotNull(itemStub);
        Assert.assertEquals(Arrays.asList(1, 2, 3), itemStub.getIntegers());
    }

    /**
     * Test replacing a value by a non-vector list
     */
    @Test(expected = IllegalArgumentException.class)
    public void testreplaceNonVector() {
        impl.replaceItemValue("MyFieldName", new LinkedList<Object>(Arrays.asList(1, 2, 3)));
    }

    /**
     * Test the UniversalID
     */
    @Test
    public void testUnid() {
        Set<String> unids = new HashSet<String>();
        for (int i = 0; i < 1000; i++) {
            String unid = new DocumentStub().getImplementation().getUniversalID();
            Assert.assertNotNull(unid);
            Assert.assertTrue(unid.matches("^[A-F0-9]{32}$"));
            Assert.assertTrue(unids.add(unid));
        }
    }

    /**
     * Test we can define the UniversalID
     */
    @Test
    public void testSetUnid() {
        String unid1 = "DEADBEEF1234567890123456DEADBEEF";
        String unid2 = "1234567890DEADBEEF12345678901234";

        stub.setUnid(Unid.parse(unid1));
        Assert.assertEquals(unid1, impl.getUniversalID());

        impl.setUniversalID(unid2);
        Assert.assertEquals(stub.getUnid().toString(), unid2);
        Assert.assertEquals(unid2, impl.getUniversalID());
    }

    /**
     * Verify there is a non-null parent database
     */
    @Test
    public void testParentDatabase() {
        Assert.assertNotNull(impl.getParentDatabase());
    }

    /**
     * Test parent document association
     */
    @Test
    public void testParentDocumentUNID() {
        Assert.assertNull(impl.getParentDocumentUNID());

        DocumentStub parentStub = new DocumentStub(stub.getDatabase());
        stub.setParentDocument(parentStub);

        String unidParent = impl.getParentDocumentUNID();
        Assert.assertNotNull(unidParent);
        Assert.assertEquals(parentStub.getUnid().toString(), unidParent);

        Assert.assertEquals(unidParent, impl.getItemValueString("$Ref"));
    }
}
