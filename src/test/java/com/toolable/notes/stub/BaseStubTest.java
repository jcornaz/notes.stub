package com.toolable.notes.stub;

import com.google.common.base.Preconditions;
import com.toolable.notes.stub.exception.NotImplementedException;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.exception.UnexpectedException;
import lotus.domino.Base;
import lotus.domino.NotesException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Units tests for {@link BaseStub} and test utilities for derived classes
 *
 * @author jonathan
 */
public class BaseStubTest {

    /**
     * Assert that all method that a stub implements from a Lotus Notes interface raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @param stub
     */
    public static void assertExceptionsRaisedOnRecycledObject(final BaseStub stub) {
        Preconditions.checkNotNull(stub);

        stub.setRecycled(true);

        for (Method method : getNotesMethods(stub.getClass())) {
            try {
                method.invoke(stub, mockArguments(method));
                Assert.fail("The method \"" + method.getName() + "\" of the class \"" + stub.getClass().getSimpleName() + "\" should raise an exception if the object is recycled");
            } catch (InvocationTargetException e) {
                Class<? extends Throwable> causeClass = e.getCause().getClass();

                // Expected exception
                if (!causeClass.equals(NotImplementedException.class)) {
                    Assert.assertEquals(RecycledObjectException.class, causeClass);
                }

            } catch (IllegalAccessException e) {
                throw new UnexpectedException(e);
            }
        }
    }

    /**
     * Mock the parameters of a method
     *
     * @param method Method for which create mockArguments parameters
     * @return Mocked parameters objects
     */
    public static Object[] mockArguments(Method method) {
        Class<?>[] types = method.getParameterTypes();
        Object[] parameters = new Object[types.length];

        for (int i = 0; i < types.length; i++) {
            if (types[i].isPrimitive()) {
                if (types[i].toString().equals("boolean")) {
                    parameters[i] = false;
                } else {
                    parameters[i] = types[i].cast(0);
                }
            } else {
                parameters[i] = Mockito.mock(types[i]);
            }
        }

        return parameters;
    }

    /**
     * Return the collection of method of an object that are implemented from a Lotus Notes interface
     *
     * @param stubClass Object class
     * @return List of the method that the object class implements from a Lotus Notes interface
     */
    public static Collection<Method> getNotesMethods(Class<?> stubClass) {
        Preconditions.checkNotNull(stubClass);

        Collection<Method> methods = new LinkedList<Method>();

        for (Class<?> i : stubClass.getInterfaces()) {
            if (Base.class.isAssignableFrom(i)) {
                Collections.addAll(methods, i.getMethods());
            }
        }

        return methods;
    }

    /**
     * Base object should be recyclables.<br />
     * A second recycle call should raise an {@link RecycledObjectException}
     *
     * @throws NotesException Unexpected exception
     */
    @Test
    public void testRecycling() throws NotesException {
        Base base = new BaseStub();

        try {
            base.recycle();
        } catch (RecycledObjectException e) {
            Assert.fail("No exception should be thrown on the first recycle");
        }

        try {
            base.recycle();
            Assert.fail("An exception should have been thrown on the second recycle");
        } catch (RecycledObjectException e) {
            // Expected exception
        }
    }

    /**
     * The recycling state of a {@link BaseStub} should be settable
     */
    @Test
    public void testSetRecycled() {
        BaseStub base = new BaseStub();

        base.setRecycled(true);
        Assert.assertTrue(base.isRecycled());

        try {
            base.recycle();
            Assert.fail("An exception should have be thrown if the instance as been set to a recycled state");
        } catch (RecycledObjectException e) {
            // Expected exception
        }

        base.setRecycled(false);
        try {
            base.recycle();
        } catch (RecycledObjectException e) {
            Assert.fail("No exception should be thrown if the instance as been set to a non-recycled state");
        }
    }

    /**
     * all method of a {@link BaseStub} implemented from a Lotus Notes interface should raise a {@link RecycledObjectException} if the stub is recycled
     */
    @Test
    public void testRecycleObjectExceptionsRaised() {
        BaseStubTest.assertExceptionsRaisedOnRecycledObject(new BaseStub());
    }

    /**
     * A list of Base object should be recycled by a call of {@link BaseStub#recycle(Vector)}
     *
     * @throws NotesException
     */
    @Test
    public void testBulkRecycling() throws NotesException {
        Vector<BaseStub> slaves = new Vector<BaseStub>();

        for (int i = 0; i < 10; i++) {
            slaves.add(new BaseStub());
        }

        BaseStub master = new BaseStub();
        master.recycle(slaves);

        // The object that made the call shouldn't be recycled
        Assert.assertFalse(master.isRecycled());

        for (BaseStub slave : slaves) {
            Assert.assertTrue(slave.isRecycled());
        }
    }

    /**
     * It should be easy to check if the recycling states of the NotesStubs
     */
    @Test
    public void testAsserts() {
        BaseStub stub = new BaseStub();

        NotesStub.assertNotRecycled(stub);
        try {
            NotesStub.assertRecycled(stub);
            Assert.fail("An exception should have been thrown");
        } catch (AssertionError e) {
            // Expected exception
        }

        stub.setRecycled(true);

        NotesStub.assertRecycled(stub);
        try {
            NotesStub.assertNotRecycled(stub);
            Assert.fail("An exception should have been thrown");
        } catch (AssertionError e) {
            // Expected exception
        }
    }
}