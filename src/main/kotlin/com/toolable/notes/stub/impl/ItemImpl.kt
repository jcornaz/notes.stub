package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.ItemStub
import com.toolable.notes.stub.utils.toJodaTime
import com.toolable.notes.stub.utils.toStub
import lotus.domino.*
import org.xml.sax.InputSource
import java.io.InputStream
import java.io.Reader
import java.util.*

/**
 * Implementation of [Item] with a stub
 *
 * @constructor Create a new implementation
 * @param stub Stub holding data for this implementation
 */
class ItemImpl(stub: ItemStub) : BaseImpl<ItemStub>(stub), Item {

    /**
     * Return the parent document
     *
     * @return The parent document
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getParent(): Document {
        assertNotRecycled()
        return stub.document.implementation
    }

    /**
     * Return the item name
     *
     * @return Name of the item
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getName(): String {
        assertNotRecycled()
        return stub.name
    }

    /**
     * Set the item as encrypted
     *
     * @param value true if the field has to be encrypted
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setEncrypted(value: Boolean) {
        assertNotRecycled()
        stub.isEncrypted = value
    }

    /**
     * Return if the item is encrypted
     *
     * @return true if the field is encrypted
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isEncrypted(): Boolean {
        assertNotRecycled()
        return stub.isEncrypted
    }

    /**
     * Set the item as summary
     *
     * @param value true if the field has to be summary
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setSummary(value: Boolean) {
        assertNotRecycled()
        stub.isSummary = value
    }

    /**
     * Return if the item is summary
     *
     * @return true if the field is summary
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isSummary(): Boolean {
        assertNotRecycled()
        return stub.isSummary
    }

    /**
     * Set the item as authors
     *
     * @param value true if the field has to be authors
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setAuthors(value: Boolean) {
        assertNotRecycled()
        stub.isAuthors = value
    }

    /**
     * Return if the item is authors
     *
     * @return true if the field is authors
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isAuthors(): Boolean {
        assertNotRecycled()
        return stub.isAuthors
    }

    /**
     * Set the item as readers
     *
     * @param value true if the field has to be readers
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setReaders(value: Boolean) {
        assertNotRecycled()
        stub.isReaders = value
    }

    /**
     * Return if the item is readers
     *
     * @return true if the field is readers
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isReaders(): Boolean {
        assertNotRecycled()
        return stub.isReaders
    }

    /**
     * Set the item as names
     *
     * @param value true if the field has to be names
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setNames(value: Boolean) {
        assertNotRecycled()
        stub.isNames = value
    }

    /**
     * Return if the item is names
     *
     * @return true if the field is names
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isNames(): Boolean {
        assertNotRecycled()
        return stub.isNames
    }

    /**
     * Set the item as signed
     *
     * @param value true if the field has to be signed
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setSigned(value: Boolean) {
        assertNotRecycled()
        stub.isSigned = value
    }

    /**
     * Return if the item is signed
     *
     * @return true if the field is signed
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isSigned(): Boolean {
        assertNotRecycled()
        return stub.isSigned
    }

    /**
     * Set the item as protected
     *
     * @param value true if the field has to be protected
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setProtected(value: Boolean) {
        assertNotRecycled()
        stub.isProtected = value
    }

    /**
     * Return if the item is protected
     *
     * @return true if the field is protected
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isProtected(): Boolean {
        assertNotRecycled()
        return stub.isProtected
    }

    /**
     * Replace the current values by a [DateTime]
     *
     * @param value The new value for the item
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setDateTimeValue(value: DateTime) {
        assertNotRecycled()
        stub.dateTimes = listOf(value.toJodaTime())
        stub.document.isSaved = false
    }

    /**
     * Replace the current values by a [Double]
     *
     * @param value The new value for the item
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setValueDouble(value: Double) {
        assertNotRecycled()
        stub.double = value
        stub.document.isSaved = false
    }

    /**
     * Replace the current values by an [Int]
     *
     * @param value The new value for the item
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setValueInteger(value: Int) {
        assertNotRecycled()
        stub.integer = value
        stub.document.isSaved = false
    }

    /**
     * Replace the current values by a [String]
     *
     * @param value The new value for the item
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setValueString(value: String) {
        assertNotRecycled()
        stub.string = value
        stub.document.isSaved = false
    }

    /**
     * Replace the current values by a new [Vector] of values
     *
     * @param values New values
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun setValues(values: Vector<*>) {
        assertNotRecycled()
        stub.values = values
        stub.document.isSaved = false
    }

    /**
     * Return the type of the item values
     *
     * @return type
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getType(): Int {
        assertNotRecycled()
        return stub.type
    }

    /**
     * Return values as a [Vector] of [DateTime]
     *
     * @return The [Vector] of [DateTime] of the values. Return An empty vector, if it doesn't contains date-time values
     * @throws RecycledObjectException The item is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getValueDateTimeArray(): Vector<*> {
        assertNotRecycled()
        return Vector(stub.dateTimes.map { it.toStub(stub.session).implementation })
    }

    /**
     * Return the first [DateTime] value
     *
     * @return The first value as [DateTime]. Return null if there is no value or if it's not date-time
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getDateTimeValue(): DateTime? {
        assertNotRecycled()
        return stub.dateTime?.toStub(stub.session)?.implementation
    }

    /**
     * Return the first [Double] value
     *
     * @return The first value as [Double]. Return 0.0 if there is no value or if it's not numeric
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getValueDouble(): Double {
        assertNotRecycled()
        return stub.double
    }

    /**
     * Return the first [Int] value
     *
     * @return The first value as [Int]. Return 0 if there is no value or if it's not numeric
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getValueInteger(): Int {
        assertNotRecycled()
        return stub.integer
    }

    /**
     * Return the first [String] value
     *
     * @return The first value as [String]. Return null if there is no value or if it's not a [String]
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getValueString(): String? {
        assertNotRecycled()
        return stub.string
    }

    /**
     * Return the raw values
     *
     * @return The [Vector] of values. The values can be [Double], [String], or [DateTime]. Return an empty vector if there is no value.
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getValues(): Vector<*> {
        assertNotRecycled()
        return Vector(if (stub.type == Item.DATETIMES) stub.dateTimes.map { it.toStub(stub.session).implementation } else stub.values)
    }

    /**
     * Copy this item to a document, changing the name of the item
     *
     * @param doc Destination of the copy
     * @param itemName Name for the copied item
     * @return The created item
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun copyItemToDocument(doc: Document, itemName: String): Item {
        assertNotRecycled()
        if (doc is DocumentImpl) {
            doc.assertNotRecycled()
            return stub.copy(doc.stub, itemName).implementation
        } else
            throw UnsupportedOperationException()
    }

    /**
     * Copy this item to another document, keeping the same name
     *
     * @param doc Destination of the copy
     * @return The created item
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun copyItemToDocument(doc: Document): Item {
        return copyItemToDocument(doc, stub.name)
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getText(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendToTextList(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendToTextList(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getText(p0: Int): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getValueLength(): Int {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun parseXML(p0: Boolean): org.w3c.dom.Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getInputSource(): InputSource? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun abstractText(p0: Int, p1: Boolean, p2: Boolean): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getLastModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun containsValue(p0: Any?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomDataBytes(p0: String?): ByteArray? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSaveToDisk(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getReader(): Reader? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomData(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getValueCustomData(): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomData(p0: String?, p1: Any?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomData(p0: Any?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setSaveToDisk(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getInputStream(): InputStream? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun remove() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setValueCustomDataBytes(p0: String?, p1: ByteArray?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun transformXML(p0: Any?, p1: XSLTResultTarget?) {
        throw UnsupportedOperationException()
    }
}
