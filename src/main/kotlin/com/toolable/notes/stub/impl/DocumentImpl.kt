package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.*
import lotus.domino.*
import java.io.Writer
import java.util.*


class DocumentImpl(stub: DocumentStub) : BaseImpl<DocumentStub>(stub), Document {

    @Throws(RecycledObjectException::class)
    override fun getUniversalID(): String {
        assertNotRecycled()
        return stub.unid.toString()
    }

    @Throws(RecycledObjectException::class)
    override fun setUniversalID(value: String) {
        assertNotRecycled()
        stub.unid = Unid.parse(value)
    }

    @Throws(RecycledObjectException::class)
    override fun getParentDatabase(): Database {
        assertNotRecycled()
        return stub.database.implementation
    }

    @Throws(RecycledObjectException::class)
    override fun getParentDocumentUNID(): String? {
        assertNotRecycled()
        return stub.parentDocument?.unid?.toString()
    }

    //region Items
    @Throws(RecycledObjectException::class)
    override fun getFirstItem(name: String): ItemImpl? {
        assertNotRecycled()
        return stub.items[name]?.implementation
    }

    @Throws(RecycledObjectException::class)
    override fun getItemValueDateTimeArray(name: String): Vector<*> {
        assertNotRecycled()
        return Vector(stub[name]?.dateTimeStubs?.map { it.implementation }.orEmpty())
    }

    @Throws(RecycledObjectException::class)
    override fun getItemValueDouble(name: String): Double {
        assertNotRecycled()
        return stub[name].asDouble()
    }

    @Throws(RecycledObjectException::class)
    override fun getItemValueInteger(name: String): Int {
        assertNotRecycled()
        return stub[name].asInt()
    }

    @Throws(RecycledObjectException::class)
    override fun getItemValueString(name: String): String? {
        assertNotRecycled()
        return stub[name].asString()
    }

    @Throws(RecycledObjectException::class)
    override fun getItemValue(name: String): Vector<*> {
        assertNotRecycled()

        return Vector(stub[name]?.let { item ->
            if (item.type == Item.DATETIMES) item.dateTimeStubs.map { it.implementation }
            else item.values
        }.orEmpty())
    }

    @Throws(RecycledObjectException::class)
    override fun replaceItemValue(name: String, value: Any): ItemImpl {
        assertNotRecycled()

        val item = stub[name] ?: ItemStub(stub, name)
        item.values = if (value is Vector<*>) value else listOf(value)
        item.document = stub

        return item.implementation
    }
    //endregion

    override fun isNewNote(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun encrypt() {
        throw UnsupportedOperationException()
    }

    override fun isSentByAgent(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(p0: String?, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(p0: Vector<*>?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lock(p0: Vector<*>?, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun markRead() {
        throw UnsupportedOperationException()
    }

    override fun markRead(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun createMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun createMIMEEntity(p0: String?): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun unlock() {
        throw UnsupportedOperationException()
    }

    override fun replaceItemValueCustomData(p0: String?, p1: String?, p2: Any?): Item? {
        throw UnsupportedOperationException()
    }

    override fun replaceItemValueCustomData(p0: String?, p1: Any?): Item? {
        throw UnsupportedOperationException()
    }

    override fun getInitiallyModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun isSigned(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lockProvisional(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lockProvisional(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun lockProvisional(p0: Vector<*>?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getColumnValues(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun isProfile(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getNameOfProfile(): String? {
        throw UnsupportedOperationException()
    }

    override fun setEncryptionKeys(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    override fun getSize(): Int {
        throw UnsupportedOperationException()
    }

    override fun isEncryptOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun replaceItemValueCustomDataBytes(p0: String?, p1: String?, p2: ByteArray?): Item? {
        throw UnsupportedOperationException()
    }

    override fun setPreferJavaDates(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isSignOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun copyItem(p0: Item?, p1: String?): Item? {
        throw UnsupportedOperationException()
    }

    override fun copyItem(p0: Item?): Item? {
        throw UnsupportedOperationException()
    }

    override fun setSaveMessageOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun copyAllItems(p0: Document?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun getMIMEEntity(p0: String?): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun putInFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun putInFolder(p0: String?, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun convertToMIME() {
        throw UnsupportedOperationException()
    }

    override fun convertToMIME(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun convertToMIME(p0: Int, p1: Int) {
        throw UnsupportedOperationException()
    }

    override fun isValid(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun removeItem(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun renderToRTItem(p0: RichTextItem?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getHttpURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun getVerifier(): String? {
        throw UnsupportedOperationException()
    }

    override fun sign() {
        throw UnsupportedOperationException()
    }

    override fun getResponses(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getRead(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getRead(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLockHolders(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getAuthors(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getNoteID(): String? {
        throw UnsupportedOperationException()
    }

    override fun isSaveMessageOnSend(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun hasEmbedded(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getKey(): String? {
        throw UnsupportedOperationException()
    }

    override fun setSignOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isPreferJavaDates(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun computeWithForm(p0: Boolean, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getEmbeddedObjects(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun createReplyMessage(p0: Boolean): Document? {
        throw UnsupportedOperationException()
    }

    override fun appendItemValue(p0: String?, p1: Any?): Item? {
        throw UnsupportedOperationException()
    }

    override fun appendItemValue(p0: String?): Item? {
        throw UnsupportedOperationException()
    }

    override fun appendItemValue(p0: String?, p1: Int): Item? {
        throw UnsupportedOperationException()
    }

    override fun appendItemValue(p0: String?, p1: Double): Item? {
        throw UnsupportedOperationException()
    }

    override fun createRichTextItem(p0: String?): RichTextItem? {
        throw UnsupportedOperationException()
    }

    override fun save(p0: Boolean, p1: Boolean, p2: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun save(p0: Boolean, p1: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun save(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun save(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getSigner(): String? {
        throw UnsupportedOperationException()
    }

    override fun setEncryptOnSend(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun removeFromFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun generateXML(): String? {
        throw UnsupportedOperationException()
    }

    override fun generateXML(p0: Writer?) {
        throw UnsupportedOperationException()
    }

    override fun generateXML(p0: Any?, p1: XSLTResultTarget?) {
        throw UnsupportedOperationException()
    }

    override fun getLastModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun getNotesURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun isResponse(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getFTSearchScore(): Int {
        throw UnsupportedOperationException()
    }

    override fun closeMIMEEntities(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun closeMIMEEntities(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun closeMIMEEntities(p0: Boolean, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isDeleted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun markUnread() {
        throw UnsupportedOperationException()
    }

    override fun markUnread(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun isEncrypted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getAttachment(p0: String?): EmbeddedObject? {
        throw UnsupportedOperationException()
    }

    override fun removePermanently(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getCreated(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun makeResponse(p0: Document?) {
        throw UnsupportedOperationException()
    }

    override fun attachVCard(p0: Base?) {
        throw UnsupportedOperationException()
    }

    override fun attachVCard(p0: Base?, p1: String?) {
        throw UnsupportedOperationException()
    }

    override fun getItems(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getFolderReferences(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getEncryptionKeys(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun remove(p0: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun copyToDatabase(p0: Database?): Document? {
        throw UnsupportedOperationException()
    }

    override fun getLastAccessed(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun getParentView(): View? {
        throw UnsupportedOperationException()
    }

    override fun getReceivedItemText(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getItemValueCustomDataBytes(p0: String?, p1: String?): ByteArray? {
        throw UnsupportedOperationException()
    }

    override fun getItemValueCustomData(p0: String?, p1: String?): Any? {
        throw UnsupportedOperationException()
    }

    override fun getItemValueCustomData(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    override fun send(p0: Boolean, p1: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    override fun send(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    override fun send(p0: Boolean, p1: String?) {
        throw UnsupportedOperationException()
    }

    override fun send(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun send(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun send() {
        throw UnsupportedOperationException()
    }

    override fun hasItem(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }
}