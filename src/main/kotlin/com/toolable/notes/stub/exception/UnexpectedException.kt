package com.toolable.notes.stub.exception

/**
 * An exception that should never been thrown in theory, because the method ensure it.
 *
 * Therefore, in practical cases, it allow to understand what gone wrong.
 *
 * @author jonathan
 */
class UnexpectedException(cause: Throwable) : RuntimeException(cause)
