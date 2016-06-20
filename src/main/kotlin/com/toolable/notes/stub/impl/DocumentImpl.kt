package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DocumentStub
import com.toolable.notes.stub.model.ItemStub
import com.toolable.notes.stub.model.Unid
import com.toolable.notes.stub.utils.orZero
import lotus.domino.*
import java.io.Writer
import java.util.*

/**
 * Implementation of [Document] with a stub
 *
 * @constructor Create a new implementation
 * @param stub Stub holding data for this implementation
 */
class DocumentImpl(stub: DocumentStub) : BaseImpl<DocumentStub>(stub), Document {

    /**
     * Return the universal id of the document
     *
     * @return The universal ID
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getUniversalID(): String {
        assertNotRecycled()
        return stub.unid.toString()
    }

    /**
     * Define the universal id of the document
     *
     * @param value Universal ID
     * @throws RecycledObjectException The document is recycled
     * @throws IllegalArgumentException The argument is not a valid unid
     * @throws IllegalStateException There is already a document with that unid in the parent database
     */
    @Throws(RecycledObjectException::class, IllegalArgumentException::class, IllegalStateException::class)
    override fun setUniversalID(value: String) {
        assertNotRecycled()
        stub.unid = Unid.parse(value)
    }

    /**
     * Return the parent database
     *
     * @return Parent database
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getParentDatabase(): Database {
        assertNotRecycled()
        return stub.database.implementation
    }

    /**
     * Return true if the document is response
     *
     * @return true if, and only if, the document is response
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun isResponse(): Boolean {
        assertNotRecycled()
        return stub.parentDocument != null
    }

    /**
     * Return the parent document unid
     *
     * @return The parent document unid or null if this is not a response document
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getParentDocumentUNID(): String? {
        assertNotRecycled()
        return stub.parentDocument?.unid?.toString()
    }

    /**
     * Return the first item with the specified name
     *
     * @param name Name of the desired item (case-insensitive)
     * @return The first item in the document that have the specified name or null if there is no such item
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getFirstItem(name: String): ItemImpl? {
        assertNotRecycled()
        return stub[name]?.implementation
    }

    /**
     * Return an array of [DateTime] from the specified item
     *
     * @param name Item name
     * @return The [Vector] of [DateTime] of the values at the specified item. Return An empty vector, if there is no such item or if it doesn't contains date-time values
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getItemValueDateTimeArray(name: String): Vector<*> {
        return getFirstItem(name)?.valueDateTimeArray ?: Vector<Any>()
    }

    /**
     * Return the double value of an item
     *
     * @param name Item name
     * @return The value of the item as [Double]. Return 0.0 if there is no such item or if the value is not numeric
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getItemValueDouble(name: String): Double {
        return getFirstItem(name)?.valueDouble.orZero()
    }

    /**
     * Return the integer value of an item
     *
     * @param name Item name
     * @return The value of the item as [Int]. Return 0 if there is no such item or if the value is not numeric
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getItemValueInteger(name: String): Int {
        return getFirstItem(name)?.valueInteger.orZero()
    }

    /**
     * Return the string value of an item
     *
     * @param name Item name
     * @return The value of the item as [String]. Return null if there is no such item or if the value is not a String
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getItemValueString(name: String): String? {
        return getFirstItem(name)?.valueString
    }

    /**
     * Return the raw values of an item
     *
     * @param name Item name
     * @return The [Vector] of values of the item. The values can be [Double], [String] or [DateTime]. Return An empty vector, if there is no such item or if it is empty.
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun getItemValue(name: String): Vector<*> {
        return getFirstItem(name)?.values ?: Vector<Any>()
    }

    /**
     * Replace the value(s) of an item
     *
     * @param name Item name
     * @param value New value for the item. Accepted types are [Number], [String], [DateTime]. It can also be a [Vector] of one theses types.
     * @return The item instance
     * @throws RecycledObjectException The document is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun replaceItemValue(name: String, value: Any): ItemImpl {
        assertNotRecycled()

        val item = stub[name] ?: ItemStub(stub, name)
        item.values = if (value is Vector<*>) value else listOf(value)

        stub.isSaved = false

        return item.implementation
    }

    /**
     * Save the document
     *
     * @param p0 Ignored
     * @param p1 Ignored
     * @param p2 Ignored
     * @return Always true
     * @throws RecycledObjectException The document is recycled
     */
    override fun save(p0: Boolean, p1: Boolean, p2: Boolean): Boolean {
        assertNotRecycled()
        stub.isSaved = true
        return true
    }

    /**
     * Save the document
     *
     * @param p0 Ignored
     * @param p1 Ignored
     * @return Always true
     * @throws RecycledObjectException The document is recycled
     */
    override fun save(p0: Boolean, p1: Boolean) = save(p0, p1, false)

    /**
     * Save the document
     *
     * @param p0 Ignored
     * @return Always true
     * @throws RecycledObjectException The document is recycled
     */
    override fun save(p0: Boolean) = save(p0, false, false)

    /**
     * Save the document
     *
     * @return Always true
     * @throws RecycledObjectException The document is recycled
     */
    override fun save() = save(false, false, false)

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isNewNote(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun encrypt() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSentByAgent(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(p0: String?, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(p0: Vector<*>?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lock(p0: Vector<*>?, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markRead() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markRead(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createMIMEEntity(p0: String?): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun unlock() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun replaceItemValueCustomData(p0: String?, p1: String?, p2: Any?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun replaceItemValueCustomData(p0: String?, p1: Any?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getInitiallyModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSigned(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lockProvisional(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lockProvisional(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun lockProvisional(p0: Vector<*>?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getColumnValues(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isProfile(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getNameOfProfile(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setEncryptionKeys(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getSize(): Int {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isEncryptOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun replaceItemValueCustomDataBytes(p0: String?, p1: String?, p2: ByteArray?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setPreferJavaDates(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSignOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun copyItem(p0: Item?, p1: String?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun copyItem(p0: Item?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setSaveMessageOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun copyAllItems(p0: Document?, p1: Boolean) {
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
    override fun getMIMEEntity(p0: String?): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun putInFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun putInFolder(p0: String?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun convertToMIME() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun convertToMIME(p0: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun convertToMIME(p0: Int, p1: Int) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isValid(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getURL(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun removeItem(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun renderToRTItem(p0: RichTextItem?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getHttpURL(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getVerifier(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun sign() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getResponses(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getRead(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getRead(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getLockHolders(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getAuthors(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getNoteID(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isSaveMessageOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun hasEmbedded(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getKey(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setSignOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isPreferJavaDates(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun computeWithForm(p0: Boolean, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEmbeddedObjects(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createReplyMessage(p0: Boolean): Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendItemValue(p0: String?, p1: Any?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendItemValue(p0: String?): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendItemValue(p0: String?, p1: Int): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun appendItemValue(p0: String?, p1: Double): Item? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createRichTextItem(p0: String?): RichTextItem? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getSigner(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setEncryptOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun removeFromFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun generateXML(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun generateXML(p0: Writer?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun generateXML(p0: Any?, p1: XSLTResultTarget?) {
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
    override fun getNotesURL(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getFTSearchScore(): Int {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun closeMIMEEntities(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun closeMIMEEntities(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun closeMIMEEntities(p0: Boolean, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isDeleted(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markUnread() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun markUnread(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isEncrypted(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getAttachment(p0: String?): EmbeddedObject? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun removePermanently(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getCreated(): DateTime? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun makeResponse(p0: Document?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun attachVCard(p0: Base?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun attachVCard(p0: Base?, p1: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getItems(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getFolderReferences(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEncryptionKeys(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun remove(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun copyToDatabase(p0: Database?): Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getLastAccessed(): DateTime? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getParentView(): View? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getReceivedItemText(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getItemValueCustomDataBytes(p0: String?, p1: String?): ByteArray? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getItemValueCustomData(p0: String?, p1: String?): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getItemValueCustomData(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun send(p0: Boolean, p1: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)

    override fun send(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun send(p0: Boolean, p1: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun send(p0: String?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun send(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun send() {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun hasItem(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }
}