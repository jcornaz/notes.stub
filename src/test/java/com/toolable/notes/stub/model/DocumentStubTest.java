package com.toolable.notes.stub.model;

import com.toolable.notes.stub.TestUtils;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.impl.DateTimeImpl;
import com.toolable.notes.stub.impl.DocumentImpl;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Unit tests of {@link DocumentStub}
 *
 * @author jonathan
 */
public class DocumentStubTest {

    private DocumentStub stub;
    private DocumentImpl impl;

    @Before
    public void setUp() throws Exception {
        stub = new DocumentStub();
        impl = this.stub.getImplementation();
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
    public void testStringValue() throws Exception {
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

    @Test
    public void testIntegerValue() throws Exception {
        stub.set("NumericField", 42);

        Assert.assertNull(impl.getItemValueString("NumericField"));
        Assert.assertEquals(42, impl.getItemValueDouble("NumericField"), 1e-10);
        Assert.assertEquals(42, impl.getItemValueInteger("NumericField"));
        Assert.assertEquals(42, impl.getItemValueInteger("NUMERICfield"));
        Assert.assertTrue(impl.getItemValueDateTimeArray("NumericField").isEmpty());

        Vector<?> values = impl.getItemValue("NumericField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals(42, (Double) values.get(0), 1e-10);
    }

    @Test
    public void testDoubleValue() throws Exception {
        stub.set("NumericField", 3.1415);

        Assert.assertNull(impl.getItemValueString("NumericField"));
        Assert.assertEquals(3.1415, impl.getItemValueDouble("NumericField"), 1e-10);
        Assert.assertEquals(3.1415, impl.getItemValueDouble("NUMERICfield"), 1e-10);
        Assert.assertEquals(3, impl.getItemValueInteger("NumericField"));
        Assert.assertTrue(impl.getItemValueDateTimeArray("NumericField").isEmpty());

        Vector<?> values = impl.getItemValue("NumericField");
        Assert.assertNotNull(values);
        Assert.assertEquals(1, values.size());
        Assert.assertEquals(3.1415, (Double) values.get(0), 1e-10);
    }

    @Test
    public void testDateTimeValue() throws Exception {
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

    @Test
    public void testEmptyItem() throws Exception {
        Assert.assertNull(impl.getItemValueString("empty_item_name"));
        Assert.assertEquals(0, impl.getItemValueInteger("empty_item_name"));
        Assert.assertEquals(0, impl.getItemValueDouble("empty_item_name"), 1e-10);
        Assert.assertTrue(impl.getItemValueDateTimeArray("empty_item_name").isEmpty());
        Assert.assertTrue(impl.getItemValue("empty_item_name").isEmpty());
    }

    @Test
    public void testReplaceString() throws Exception {
        impl.replaceItemValue("MyFieldName", "MyString");
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals("MyString", itemStub.get(0));
    }

    @Test
    public void testReplaceDouble() throws Exception {
        impl.replaceItemValue("MyFieldName", 3.1415);
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(3.1415, itemStub.get(0));
    }

    @Test
    public void testReplaceInteger() throws Exception {
        impl.replaceItemValue("MyFieldName", 42);
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(42.0, itemStub.get(0));
    }

    @Test
    public void testReplaceDateTime() throws Exception {
        DateTime now = DateTime.now();
        impl.replaceItemValue("MyFieldName", new DateTimeStub(now).getImplementation());
        ItemStub itemStub = stub.get("MyFieldName");
        Assert.assertNotNull(itemStub);
        Assert.assertSame(itemStub, stub.get("MYFIELDNAME"));
        Assert.assertEquals(now, itemStub.get(0));
    }

    @Test
    public void testReplaceVector() throws Exception {
        impl.replaceItemValue("MyFieldName", new Vector<Object>(Arrays.asList(1, 2, 3)));
        ItemStub itemStub = stub.get("MyFieldName");

        Assert.assertNotNull(itemStub);
        Assert.assertEquals(Arrays.asList(1, 2, 3), itemStub.getIntegers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReplaceNotVector() throws Exception {
        impl.replaceItemValue("MyFieldName", new LinkedList<Object>(Arrays.asList(1, 2, 3)));
    }
}
