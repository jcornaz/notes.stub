package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.RecycledObjectException
import lotus.domino.*
import java.util.*

/**
 * Stub for [Session]

 * @author jonathan
 */
class SessionStub : BaseStub(), Session {

    /**
     * Create a date time representing the current instant
     *
     * @return DateTime object created
     */
    fun createDateTime(): DateTimeStub {
        return DateTimeStub(this, org.joda.time.DateTime.now())
    }

    //region Implemented methods
    @Throws(RecycledObjectException::class)
    override fun createDateTime(date: Date): DateTimeStub {
        this.assertNotRecycled()
        return DateTimeStub(this, org.joda.time.DateTime(date))
    }

    @Throws(RecycledObjectException::class)
    override fun createDateTime(calendar: Calendar): DateTimeStub {
        this.assertNotRecycled()
        return DateTimeStub(this, org.joda.time.DateTime(calendar.timeInMillis))
    }
    //endregion

    //region Not implemented methods
    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(): DateRange {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(dateTime: DateTime, dateTime1: DateTime): DateRange {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(date: Date, date1: Date): DateRange {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createDateTime(string: String): DateTimeStub {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createLog(s: String): Log {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createName(s: String): Name {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createName(s: String, s1: String): Name {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createNewsletter(documentCollection: DocumentCollection): Newsletter {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createRegistration(): Registration {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createRichTextStyle(): RichTextStyle {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createRichTextParagraphStyle(): RichTextParagraphStyle {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createStream(): Stream {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createDxlExporter(): DxlExporter {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createDxlImporter(): DxlImporter {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createColorObject(): ColorObject {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun createAdministrationProcess(s: String): AdministrationProcess {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun evaluate(s: String): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun evaluate(s: String, document: Document): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun freeTimeSearch(dateRange: DateRange, i: Int, o: Any, b: Boolean): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getAddressBooks(): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getAgentContext(): AgentContext {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getCommonUserName(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isConvertMime(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setConvertMime(b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isConvertMIME(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setConvertMIME(b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getDatabase(s: String, s1: String): Database {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getDatabase(s: String, s1: String, b: Boolean): Database {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getDbDirectory(s: String): DbDirectory {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentString(s: String): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentString(s: String, b: Boolean): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentValue(s: String): Any {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentValue(s: String, b: Boolean): Any {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setEnvironmentVar(s: String, o: Any) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setEnvironmentVar(s: String, o: Any, b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getInternational(): International {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getNotesVersion(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getPlatform(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getServerName(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getURLDatabase(): Database {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserName(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getEffectiveUserName(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserNameObject(): Name {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isOnServer(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun resolve(s: String): Base {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserNameList(): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getURL(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getHttpURL(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getSessionToken(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getSessionToken(s: String): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getCredentials(): Any {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getOrgDirectoryPath(): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getCurrentDatabase(): Database {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isValid(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserGroupNameList(): Vector<Any> {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun sendConsoleCommand(s: String, s1: String): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserPolicySettings(s: String, s1: String, i: Int): Document {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getUserPolicySettings(s: String, s1: String, i: Int, s2: String): Document {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun hashPassword(s: String): String {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun verifyPassword(s: String, s1: String): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getPropertyBroker(): PropertyBroker {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getDirectory(): Directory {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun getDirectory(s: String): Directory {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isTrustedSession(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isRestricted(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun resetUserPassword(s: String, s1: String, s2: String): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun resetUserPassword(s: String, s1: String, s2: String, i: Int): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun isTrackMillisecInJavaDates(): Boolean {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setTrackMillisecInJavaDates(b: Boolean) {
        throw UnsupportedOperationException()
    }

    @Throws(UnsupportedOperationException::class)
    override fun setAllowLoopBack(b: Boolean) {
        throw UnsupportedOperationException()
    }
    //endregion
}
