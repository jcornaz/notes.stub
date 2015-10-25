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
 * @author jonathan
 */
public class BaseStubTest {

    public static void assertRecycledObjectExceptionsRaised(final BaseStub stub)  {
        Preconditions.checkNotNull(stub);

        stub.setRecycled(true);

        for (Method method : getNotesMethods(stub.getClass())) {
            try {
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

                method.invoke(stub, parameters);

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

    public static <T extends BaseStub> Collection<Method> getNotesMethods(Class<T> stubClass) {
        Preconditions.checkNotNull(stubClass);

        Collection<Method> methods = new LinkedList<Method>();

        for (Class<?> i : stubClass.getInterfaces()) {
            if (Base.class.isAssignableFrom(i)) {
                Collections.addAll(methods, i.getMethods());
            }
        }
        return methods;
    }

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

    @Test
    public void testSetRecycled() throws NotesException {
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

    @Test
    public void testRecycleObjectExceptionsRaised() throws InstantiationException, IllegalAccessException {
        BaseStubTest.assertRecycledObjectExceptionsRaised(new BaseStub());
    }
}