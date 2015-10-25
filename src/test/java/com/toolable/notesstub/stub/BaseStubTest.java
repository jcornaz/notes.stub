package com.toolable.notesstub.stub;

import com.google.common.base.Preconditions;
import com.toolable.notesstub.exceptions.RecycledObjectException;
import com.toolable.notesstub.exceptions.UnexpectedException;
import lotus.domino.Base;
import lotus.domino.NotesException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Units tests for {@link BaseStub} and test utilities for derived classes
 * @author jonathan
 */
public class BaseStubTest {

    /**
     * Assert that all method that a stub implements from a Lotus Notes interface raise a {@link RecycledObjectException} if the stub is recycled
     * @param stub
     */
    public static void assertRecycledObjectExceptionsRaised(final BaseStub stub) {
        Preconditions.checkNotNull(stub);

        stub.setRecycled(true);

        for (Method method : getNotesMethods(stub.getClass())) {
            try {
                method.invoke(stub, mock(method));
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
     * @param method Method for which create mock parameters
     * @return Mocked parameters objects
     */
    public static Object[] mock(Method method) {
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
        BaseStubTest.assertRecycledObjectExceptionsRaised(new BaseStub());
    }
}