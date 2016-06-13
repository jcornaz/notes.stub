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
        stub.assertNotRecycled()
        return stub.document.implementation
    }

    //region Attributes
    @Throws(RecycledObjectException::class)
    override fun getName(): String {
        stub.assertNotRecycled()
        return stub.name
    }

    @Throws(RecycledObjectException::class)
    override fun setEncrypted(value: Boolean) {
        stub.assertNotRecycled()
        stub.isEncrypted = value
    }

    @Throws(RecycledObjectException::class)
    override fun isEncrypted(): Boolean {
        stub.assertNotRecycled()
        return stub.isEncrypted
    }

    @Throws(RecycledObjectException::class)
    override fun setSummary(value: Boolean) {
        stub.assertNotRecycled()
        stub.isSummary = value
    }

    @Throws(RecycledObjectException::class)
    override fun isSummary(): Boolean {
        stub.assertNotRecycled()
        return stub.isSummary
    }

    @Throws(RecycledObjectException::class)
    override fun setAuthors(value: Boolean) {
        stub.assertNotRecycled()
        stub.isAuthors = value
    }

    @Throws(RecycledObjectException::class)
    override fun isAuthors(): Boolean {
        stub.assertNotRecycled()
        return stub.isAuthors
    }

    @Throws(RecycledObjectException::class)
    override fun setReaders(value: Boolean) {
        stub.assertNotRecycled()
        stub.isReaders = value
    }

    @Throws(RecycledObjectException::class)
    override fun isReaders(): Boolean {
        stub.assertNotRecycled()
        return stub.isReaders
    }

    @Throws(RecycledObjectException::class)
    override fun setNames(value: Boolean) {
        stub.assertNotRecycled()
        stub.isNames = value
    }

    @Throws(RecycledObjectException::class)
    override fun isNames(): Boolean {
        stub.assertNotRecycled()
        return stub.isNames
    }

    @Throws(RecycledObjectException::class)
    override fun setSigned(value: Boolean) {
        stub.assertNotRecycled()
        stub.isSigned = value
    }

    @Throws(RecycledObjectException::class)
    override fun isSigned(): Boolean {
        stub.assertNotRecycled()
        return stub.isSigned
    }
    //endregion

    //region Values setters
    @Throws(UnsupportedOperationException::class)
    override fun setDateTimeValue(value: DateTime) {
        stub.assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueDouble(value: Double) {
        stub.assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueInteger(value: Int) {
        stub.assertNotRecycled()
        stub.values = ItemValues(value)
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValueString(value: String?) {
        stub.assertNotRecycled()
        stub.values = ItemValues(value.orEmpty())
    }

    @Throws(UnsupportedOperationException::class)
    override fun setValues(value: Vector<*>) {
        stub.assertNotRecycled()
        stub.values = ItemValues() + value
    }
    //endregion

    //region Values Getters
    @Throws(UnsupportedOperationException::class)
    override fun getDateTimeValue(): DateTime? {
        stub.assertNotRecycled()
        return stub.values.asDateTime()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueDouble(): Double {
        stub.assertNotRecycled()
        return stub.values.asDouble()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueInteger(): Int {
        stub.assertNotRecycled()
        return stub.values.asInt()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValueString(): String {
        stub.assertNotRecycled()
        return stub.values.asString()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getValues(): Vector<*>? {
        stub.assertNotRecycled()
        return Vector(stub.values)
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
    override fun copyItemToDocument(p0: Document?, p1: String?): Item? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun copyItemToDocument(p0: Document?): Item? {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isProtected(): Boolean {
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
    override fun getValueDateTimeArray(): Vector<*>? {
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
    override fun setProtected(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun transformXML(p0: Any?, p1: XSLTResultTarget?) {
        throw UnsupportedOperationException()
    }
}
