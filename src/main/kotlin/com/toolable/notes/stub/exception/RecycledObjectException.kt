package com.toolable.notes.stub.exception

/**
 * Exception raised when a Lotus Notes method as been called on a recycled object

 * @author jonathan
 * *
 * @see Base.recycle
 * @see BaseStub.setRecycled
 * @see BaseStub.isRecycled
 */
class RecycledObjectException : RuntimeException {

    /**
     * Constructs a new runtime exception with `null` as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to [.initCause].
     */
    constructor()

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to [.initCause].

     * @param message the detail message. The detail message is saved for
     * *                later retrieval by the [.getMessage] method.
     */

    constructor(message: String) : super(message)

    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of
     * cause).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.

     * @param cause the cause (which is saved for later retrieval by the
     * *              [.getCause] method).  (A null value is
     * *              permitted, and indicates that the cause is nonexistent or
     * *              unknown.)
     */
    constructor(cause: Throwable) : super(cause)


    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.
     *
     *Note that the detail message associated with
     * `cause` is *not* automatically incorporated in
     * this runtime exception's detail message.

     * @param message the detail message (which is saved for later retrieval
     * *                by the [.getMessage] method).
     * *
     * @param cause   the cause (which is saved for later retrieval by the
     * *                [.getCause] method).  (A null value is
     * *                permitted, and indicates that the cause is nonexistent or
     * *                unknown.)
     */
    constructor(message: String, cause: Throwable) : super(message, cause)
}
