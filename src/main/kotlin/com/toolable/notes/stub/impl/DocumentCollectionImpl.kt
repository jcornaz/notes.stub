package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DocumentCollectionStub
import lotus.domino.*

/**
 * Implementation of [DocumentCollection] with a stub
 */
class DocumentCollectionImpl(stub: DocumentCollectionStub) : BaseImpl<DocumentCollectionStub>(stub), DocumentCollection {

    /**
     * Index of the last returned document
     */
    private var index = -1
        set(value) {
            field = Math.max(-1, Math.min(stub.size, value))
        }

    /**
     * Remove a document from the collection (not from the database)
     *
     * @param document Document to remove
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun deleteDocument(document: Document) {
        assertNotRecycled()
        if (document is DocumentImpl)
            stub.documents -= document.stub
        else
            throw UnsupportedOperationException()
    }

    /**
     * Add a document to the collection
     *
     * @param document Document to add
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun addDocument(document: Document) {
        assertNotRecycled()
        if (document is DocumentImpl)
            stub.documents += document.stub
        else
            throw UnsupportedOperationException()
    }

    /**
     * Return the parent database
     *
     * @return The parent database
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getParent(): Database {
        assertNotRecycled()
        return stub.database.implementation
    }

    /**
     * Return the number of documents in this collection
     *
     * @return The number of documents in this collection
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getCount(): Int {
        assertNotRecycled()
        return stub.size
    }

    /**
     * Return the first document of the collection
     *
     * @return The first document of the collection or null if the collection is empty
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getFirstDocument(): Document? {
        assertNotRecycled()
        index = 0
        if (stub.isEmpty())
            return null
        else
            return stub[0].implementation
    }

    /**
     * Return the last document of the collection
     *
     * @return The last document of the collection or null if the collection is empty
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getLastDocument(): Document? {
        assertNotRecycled()
        index = stub.size - 1
        if (stub.isEmpty())
            return null
        else
            return stub[stub.size - 1].implementation
    }

    /**
     * Return an arbitrary document of the collection
     *
     * @param index The index of the document (Must be >= 0 and < [getCount])
     * @return The document present at the given index
     * @throws RecycledObjectException The collection is recycled
     * @throws IndexOutOfBoundsException If the index is incorrect
     */
    @Throws(RecycledObjectException::class, IndexOutOfBoundsException::class)
    override fun getNthDocument(index: Int): Document {
        assertNotRecycled()
        this.index = index
        return stub[index].implementation
    }

    /**
     * Return document that is just before an another one in the list
     *
     * @param document Document after the desired document
     * @return The document before the argument in the list or null if there is no such document
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getPrevDocument(document: Document): Document? {
        assertNotRecycled()
        if (document is DocumentImpl) {
            index = stub.indexOf(document.stub) - 1
            if (index >= 0)
                return stub[index].implementation
            else {
                return null
            }
        } else
            throw UnsupportedOperationException()
    }

    /**
     * Return document that is just before the last retrieved document
     *
     * @return The document before the last retrieved document or null if there is no such document
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getPrevDocument(): Document? {
        assertNotRecycled()
        index--
        if (index >= 0) {
            return stub[index].implementation
        } else {
            return null
        }
    }

    /**
     * Return document that is just before an another one in the list
     *
     * @param document Document after the desired document
     * @return The document before the argument in the list or null if there is no such document
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getNextDocument(document: Document): Document? {
        assertNotRecycled()
        if (document is DocumentImpl) {
            index = stub.indexOf(document.stub) + 1
            if (index < stub.size)
                return stub[index].implementation
            else
                return null
        } else
            throw UnsupportedOperationException()
    }

    /**
     * Return document that is just after the last retrieved document
     *
     * @return The document after the last retrieved document or null if there is no such document
     * @throws RecycledObjectException The collection is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getNextDocument(): Document? {
        assertNotRecycled()
        index++
        if (index < stub.size) {
            return stub[index].implementation
        } else {
            return null
        }
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun stampAll(fieldName: String, value: Any) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun addDocument(p0: Document?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun contains(p0: Int): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun contains(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun contains(p0: Base?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUntilTime(): DateTime? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun FTSearch(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun FTSearch(p0: String?, p1: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun merge(p0: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun merge(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun merge(p0: Base?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun removeAll(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markAllRead(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markAllRead() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markAllUnread(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markAllUnread() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun subtract(p0: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun subtract(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun subtract(p0: Base?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSorted(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getQuery(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getDocument(p0: Document?): Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun removeAllFromFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun putAllInFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun putAllInFolder(p0: String?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun intersect(p0: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun intersect(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun intersect(p0: Base?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun cloneCollection(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun updateAll() {
        throw UnsupportedOperationException()
    }
}