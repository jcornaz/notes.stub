package com.toolable.notes.stub;

import com.google.common.base.Preconditions;
import com.toolable.notes.stub.exception.NotImplementedException;
import com.toolable.notes.stub.exception.RecycledObjectException;
import com.toolable.notes.stub.exception.UnexpectedException;
import com.toolable.notes.stub.model.BaseStub;
import lotus.domino.Base;
import org.junit.Assert;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Testing utilities
 *
 * @author jonathan
 */
public final class TestUtils {

    /**
     * Assert that all method that a stub implements from a Lotus Notes interface raise a {@link RecycledObjectException} if the stub is recycled
     *
     * @param stub Stub to test
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
     * Assert that a stub implements a specific Lotus Notes interface
     *
     * @param stubClass   Stub class
     * @param dominoClass Lotus Notes interface
     */
    public static void assertNotesInterface(Class<?> stubClass, Class<? extends Base> dominoClass) {
        Preconditions.checkNotNull(stubClass);
        Preconditions.checkNotNull(dominoClass);

        Assert.assertTrue(dominoClass.isAssignableFrom(stubClass));
    }

    /**
     * Mock the parameters of a method
     *
     * @param method Method for which create mockArguments parameters
     * @return Mocked parameters objects
     */
    private static Object[] mockArguments(Method method) {
        Class<?>[] types = method.getParameterTypes();
        Object[] parameters = new Object[types.length];

        for (int i = 0; i < types.length; i++) {
            if (types[i].isPrimitive()) {
                if (types[i].toString().equals("boolean")) {
                    parameters[i] = false;
                } else if (types[i].toString().matches("^(byte|char|short|int|long)$")) {
                    parameters[i] = 0;
                } else {
                    parameters[i] = 0f;
                }
            } else if (Modifier.isFinal(types[i].getModifiers())) {
                try {
                    parameters[i] = types[i].newInstance();
                } catch (Exception e) {
                    parameters[i] = null;
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
    private static Collection<Method> getNotesMethods(Class<?> stubClass) {
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
     * Private constructor
     */
    private TestUtils() {
        // Static utility class
    }
}
