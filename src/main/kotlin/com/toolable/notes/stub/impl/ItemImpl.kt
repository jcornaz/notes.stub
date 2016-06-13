package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.ItemStub
import com.toolable.notes.stub.model.ItemValues
import lotus.domino.*
import org.xml.sax.InputSource
import java.io.InputStream
import java.io.Reader
import java.util.*

/**
 * Implementation of [Item] with a stub
 */
class ItemImpl(stub: ItemStub) : BaseImpl<ItemStub>(stub), Item {

    @Throws(RecycledObjectException::class)
    override fun getParent(): Document {
        assertNotRecycled()
        return stub.document.implementation
    }

    //region Attributes
    @Throws(RecycledObjectException::class)
    override fun getName(): String {
        assertNotRecycled()
        return stub.name
    }

    @Throws(RecycledObjectException::class)
    override fun setEncrypted(value: Boolean) {
        assertNotRecycled()
        stub.isEncrypted = value
    }

    @Throws(RecycledObjectException::class)
    override fun isEncrypted(): Boolean {
        assertNotRecycled()
        return stub.isEncrypted
    }

    @Throws(RecycledObjectException::class)
    override fun setSummary(value: Boolean) {
        assertNotRecycled()
        stub.isSummary = value
    }

    @Throws(RecycledObjectException::class)
    override fun isSummary(): Boolean {
        assertNotRecycled()
        return stub.isSummary
    }

    @Throws(RecycledObjectException::class)
    override fun setAuthors(value: Boolean) {
        assertNotRecycled()
        stub.isAuthors = value
    }

    @Throws(RecycledObjectException::class)
    override fun isAuthors(): Boolean {
        assertNotRecycled()
        return stub.isAuthors
    }

    @Throws(RecycledObjectException::class)
    override fun setReaders(value: Boolean) {
        assertNotRecycled()
        stub.isReaders = value
    }

    @Throws(RecycledObjectException::class)
    override fun isReaders(): Boolean {
        assertNotRecycled()
        return stub.isReaders
    }

    @Throws(RecycledObjectException::class)
    override fun setNames(value: Boolean) {
        assertNotRecycled()
        stub.isNames = value
    }

    @Throws(RecycledObjectException::class)
    override fun isNames(): Boolean {
        assertNotRecycled()
        return stub.isNames
    }

    @Throws(RecycledObjectException::class)
    override fun setSigned(value: Boolean) {
        assertNotRecycled()
        stub.isSigned = value
    }

    @Throws(RecycledObjectException::class)
    override fun isSigned(): Boolean {
        assertNotRecycled()
        return stub.isSigned
    }

    @Throws(RecycledObjectException::class)
    override fun setProtected(value: Boolean) {
        assertNotRecycled()
        stub.isProtected = value
    }

    @Throws(RecycledObjectException::class)
    override fun isProtected(): Boolean {
        assertNotRecycled()
        return stub.isProtected
    }
    //endregion

    //region Values setters
    @Throws(RecycledObjectException::class)
    override fun setDateTimeValue(value: DateTime) {
        assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(RecycledObjectException::class)
    override fun setValueDouble(value: Double) {
        assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(RecycledObjectException::class)
    override fun setValueInteger(value: Int) {
        assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(RecycledObjectException::class)
    override fun setValueString(value: String?) {
        assertNotRecycled()
        stub.values = ItemValues(value.orEmpty())
    }

    @Throws(RecycledObjectException::class)
    override fun setValues(value: Vector<*>) {
        assertNotRecycled()
        stub.values = ItemValues() + value
    }
    //endregion

    //region Values Getters
    @Throws(RecycledObjectException::class)
    override fun getValueDateTimeArray(): Vector<*> {
        assertNotRecycled()
        return Vector(stub.values.filter { it is DateTime })
    }

    @Throws(RecycledObjectException::class)
    override fun getDateTimeValue(): DateTime? {
        assertNotRecycled()
        return stub.values.asDateTime()
    }

    @Throws(RecycledObjectException::class)
    override fun getValueDouble(): Double {
        assertNotRecycled()
        return stub.values.asDouble()
    }

    @Throws(RecycledObjectException::class)
    override fun getValueInteger(): Int {
        assertNotRecycled()
        return stub.values.asInt()
    }

    @Throws(RecycledObjectException::class)
    override fun getValueString(): String {
        assertNotRecycled()
        return stub.values.asString()
    }

    @Throws(RecycledObjectException::class)
    override fun getValues(): Vector<*>? {
        assertNotRecycled()
        return Vector(stub.values)
    }
    //endregion

    //region Operations
    @Throws(RecycledObjectException::class)
    override fun copyItemToDocument(doc: Document, itemName: String): Item {
        assertNotRecycled()
        if (doc is DocumentImpl) {
            doc.assertNotRecycled()
            return stub.copy(doc.stub, itemName).implementation
        } else
            throw UnsupportedOperationException()
    }

    @Throws(RecycledObjectException::class)
    override fun copyItemToDocument(doc: Document): Item {
        assertNotRecycled()
        if (doc is DocumentImpl) {
            doc.assertNotRecycled()
            return stub.copy(doc.stub).implementation
        } else
            throw UnsupportedOperationException()
    }
    //endregion

    @Throws(UnsupportedOperationException::class)
    override fun getText(): String? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun appendToTextList(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun appendToTextList(p0: String?) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getText(p0: Int): String? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueLength(): Int {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun parseXML(p0: Boolean): org.w3c.dom.Document? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getInputSource(): InputSource? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun abstractText(p0: Int, p1: Boolean, p2: Boolean): String? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getLastModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun containsValue(p0: Any?): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomDataBytes(p0: String?): ByteArray? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isSaveToDisk(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getReader(): Reader? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomData(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomData(): Any? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomData(p0: String?, p1: Any?) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomData(p0: Any?) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setSaveToDisk(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getInputStream(): InputStream? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getType(): Int {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun remove() {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomDataBytes(p0: String?, p1: ByteArray?) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun transformXML(p0: Any?, p1: XSLTResultTarget?) {
        throw UnsupportedOperationException()
    }
}
