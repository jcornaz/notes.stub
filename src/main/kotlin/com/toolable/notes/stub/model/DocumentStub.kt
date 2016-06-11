package com.toolable.notes.stub.model

import lotus.domino.*
import java.io.Writer
import java.util.*


class DocumentStub : BaseStub(), Document {
    var parentDatabase: DatabaseStub by lazyChildStub(this) { DatabaseStub() }

    override fun getFirstItem(p0: String?): Item? {
        throw UnsupportedOperationException()
    }

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

    override fun getItemValue(p0: String?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun markRead() {
        throw UnsupportedOperationException()
    }

    override fun markRead(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun replaceItemValue(p0: String?, p1: Any?): Item? {
        throw UnsupportedOperationException()
    }

    override fun createMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun createMIMEEntity(p0: String?): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun getItemValueInteger(p0: String?): Int {
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

    override fun getItemValueString(p0: String?): String? {
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

    override fun getParentDocumentUNID(): String? {
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

    override fun getParentDatabase(): Database {
        this.assertNotRecycled()
        return parentDatabase
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

    override fun getUniversalID(): String? {
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

    override fun getItemValueDouble(p0: String?): Double {
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

    override fun getItemValueDateTimeArray(p0: String?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun setUniversalID(p0: String?) {
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