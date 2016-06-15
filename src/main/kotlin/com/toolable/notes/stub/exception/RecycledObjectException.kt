package com.toolable.notes.stub.exception

/**
 * Exception raised when a Lotus Notes method as been called on a recycled object
 *
 * @author jonathan
 *
 * @see Base.recycle
 * @see BaseStub.setRecycled
 * @see BaseStub.isRecycled
 */
class RecycledObjectException : RuntimeException()
