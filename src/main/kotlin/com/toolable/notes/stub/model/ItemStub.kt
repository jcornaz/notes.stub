package com.toolable.notes.stub.model

import lotus.domino.*
import org.xml.sax.InputSource
import java.io.InputStream
import java.io.Reader
import java.util.*


class ItemStub : BaseStub(), Item {

    var parent: DocumentStub by lazyChildStub(this) { DocumentStub() }

    override fun getValueLength(): Int {
        throw UnsupportedOperationException()
    }

    override fun setEncrypted(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun appendToTextList(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    override fun appendToTextList(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun getText(): String? {
        throw UnsupportedOperationException()
    }

    override fun getText(p0: Int): String? {
        throw UnsupportedOperationException()
    }

    override fun setValueString(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun setSigned(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun setDateTimeValue(p0: DateTime?) {
        throw UnsupportedOperationException()
    }

    override fun setReaders(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun setValueInteger(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun copyItemToDocument(p0: Document?, p1: String?): Item? {
        throw UnsupportedOperationException()
    }

    override fun copyItemToDocument(p0: Document?): Item? {
        throw UnsupportedOperationException()
    }

    override fun isAuthors(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isSummary(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isProtected(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun parseXML(p0: Boolean): org.w3c.dom.Document? {
        throw UnsupportedOperationException()
    }

    override fun getValueInteger(): Int {
        throw UnsupportedOperationException()
    }

    override fun getInputSource(): InputSource? {
        throw UnsupportedOperationException()
    }

    override fun getValueDateTimeArray(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun setValueDouble(p0: Double) {
        throw UnsupportedOperationException()
    }

    override fun abstractText(p0: Int, p1: Boolean, p2: Boolean): String? {
        throw UnsupportedOperationException()
    }

    override fun setNames(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isReaders(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isSigned(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLastModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun setSummary(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun containsValue(p0: Any?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getName(): String? {
        throw UnsupportedOperationException()
    }

    override fun setAuthors(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isEncrypted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getValueCustomDataBytes(p0: String?): ByteArray? {
        throw UnsupportedOperationException()
    }

    override fun isSaveToDisk(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setValues(p0: Vector<*>?) {
        throw UnsupportedOperationException()
    }

    override fun getValueDouble(): Double {
        throw UnsupportedOperationException()
    }

    override fun getReader(): Reader? {
        throw UnsupportedOperationException()
    }

    override fun getMIMEEntity(): MIMEEntity? {
        throw UnsupportedOperationException()
    }

    override fun getValueCustomData(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    override fun getValueCustomData(): Any? {
        throw UnsupportedOperationException()
    }

    override fun setValueCustomData(p0: String?, p1: Any?) {
        throw UnsupportedOperationException()
    }

    override fun setValueCustomData(p0: Any?) {
        throw UnsupportedOperationException()
    }

    override fun setSaveToDisk(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getInputStream(): InputStream? {
        throw UnsupportedOperationException()
    }

    override fun getParent(): Document {
        return parent
    }

    override fun getDateTimeValue(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun getType(): Int {
        throw UnsupportedOperationException()
    }

    override fun remove() {
        throw UnsupportedOperationException()
    }

    override fun setValueCustomDataBytes(p0: String?, p1: ByteArray?) {
        throw UnsupportedOperationException()
    }

    override fun setProtected(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isNames(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getValueString(): String? {
        throw UnsupportedOperationException()
    }

    override fun getValues(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun transformXML(p0: Any?, p1: XSLTResultTarget?) {
        throw UnsupportedOperationException()
    }
}