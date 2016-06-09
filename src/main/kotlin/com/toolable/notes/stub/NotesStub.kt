package com.toolable.notes.stub

import com.toolable.notes.stub.model.BaseStub
import java.util.*

/**
 *
 * Main Class
 *
 * Can create and retrieve all the needed utilities

 * @author jonathan
 */
object NotesStub {

    /**
     * Assert that notes objects are recycled

     * @param stubs [NotesStub] objects to check
     * *
     * @throws AssertionError If one or more stubs are not recycled
     */
    @JvmStatic
    @Throws(AssertionError::class)
    fun assertRecycled(vararg stubs: BaseStub) {
        assertRecycled(Arrays.asList(*stubs))
    }

    /**
     * Assert that notes objects are recycled

     * @param stubs [NotesStub] objects to check
     * *
     * @throws AssertionError If one or more stubs are not recycled
     */
    @JvmStatic
    @Throws(AssertionError::class)
    fun assertRecycled(stubs: List<BaseStub>) {
        stubs.forEach { if (!it.isRecycled) throw AssertionError() }
    }

    /**
     * Assert that notes objects are not recycled

     * @param stubs [NotesStub] objects to check
     * *
     * @throws AssertionError If one or more stubs are recycled
     */
    @JvmStatic
    @Throws(AssertionError::class)
    fun assertNotRecycled(vararg stubs: BaseStub) {
        assertNotRecycled(Arrays.asList(*stubs))
    }

    /**
     * Assert that notes objects are not recycled

     * @param stubs [NotesStub] objects to check
     * *
     * @throws AssertionError If one or more stubs are recycled
     */
    @JvmStatic
    @Throws(AssertionError::class)
    fun assertNotRecycled(stubs: List<BaseStub>) {
        stubs.forEach { if (it.isRecycled) throw AssertionError() }
    }


}
