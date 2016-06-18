package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DocumentCollectionStub
import lotus.domino.*


class DocumentCollectionImpl(stub: DocumentCollectionStub) : BaseImpl<DocumentCollectionStub>(stub), DocumentCollection {

    private var index = -1
        set(value) {
            field = Math.max(-1, Math.min(stub.size, value))
        }

    @Throws(RecycledObjectException::class)
    override fun deleteDocument(document: Document) {
        assertNotRecycled()
        if (document is DocumentImpl)
            stub.documents -= document.stub
        else
            throw UnsupportedOperationException()
    }

    @Throws(RecycledObjectException::class)
    override fun addDocument(document: Document) {
        assertNotRecycled()
        if (document is DocumentImpl)
            stub.documents += document.stub
        else
            throw UnsupportedOperationException()
    }

    @Throws(RecycledObjectException::class)
    override fun getParent(): Database {
        assertNotRecycled()
        return stub.database.implementation
    }

    @Throws(RecycledObjectException::class)
    override fun getCount(): Int {
        assertNotRecycled()
        return stub.size
    }

    @Throws(RecycledObjectException::class)
    override fun getFirstDocument(): Document? {
        assertNotRecycled()
        index = 0
        if (stub.isEmpty())
            return null
        else
            return stub[0].implementation
    }

    @Throws(RecycledObjectException::class)
    override fun getLastDocument(): Document? {
        assertNotRecycled()
        index = stub.size - 1
        if (stub.isEmpty())
            return null
        else
            return stub[stub.size - 1].implementation
    }

    @Throws(RecycledObjectException::class)
    override fun getNthDocument(index: Int): Document {
        assertNotRecycled()
        this.index = index
        return stub[index].implementation
    }

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

    override fun stampAll(fieldName: String, value: Any) {
        throw UnsupportedOperationException()
    }

    override fun addDocument(p0: Document?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun contains(p0: Int): Boolean {
        throw UnsupportedOperationException()
    }

    override fun contains(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun contains(p0: Base?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getUntilTime(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun FTSearch(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun FTSearch(p0: String?, p1: Int) {
        throw UnsupportedOperationException()
    }

    override fun merge(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun merge(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun merge(p0: Base?) {
        throw UnsupportedOperationException()
    }

    override fun removeAll(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun markAllRead(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun markAllRead() {
        throw UnsupportedOperationException()
    }

    override fun markAllUnread(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun markAllUnread() {
        throw UnsupportedOperationException()
    }

    override fun subtract(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun subtract(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun subtract(p0: Base?) {
        throw UnsupportedOperationException()
    }

    override fun isSorted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getQuery(): String? {
        throw UnsupportedOperationException()
    }

    override fun getDocument(p0: Document?): Document? {
        throw UnsupportedOperationException()
    }

    override fun removeAllFromFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun putAllInFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun putAllInFolder(p0: String?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun intersect(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun intersect(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun intersect(p0: Base?) {
        throw UnsupportedOperationException()
    }

    override fun cloneCollection(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun updateAll() {
        throw UnsupportedOperationException()
    }
}