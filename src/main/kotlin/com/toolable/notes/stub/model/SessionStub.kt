package com.toolable.notes.stub.model

import com.toolable.notes.stub.exception.NotImplementedException
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
    @Throws(NotImplementedException::class)
    override fun createDateRange(): DateRange {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createDateRange(dateTime: DateTime, dateTime1: DateTime): DateRange {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createDateRange(date: Date, date1: Date): DateRange {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createDateTime(string: String): DateTimeStub {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createLog(s: String): Log {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createName(s: String): Name {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createName(s: String, s1: String): Name {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createNewsletter(documentCollection: DocumentCollection): Newsletter {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createRegistration(): Registration {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createRichTextStyle(): RichTextStyle {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createRichTextParagraphStyle(): RichTextParagraphStyle {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createStream(): Stream {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createDxlExporter(): DxlExporter {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createDxlImporter(): DxlImporter {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createColorObject(): ColorObject {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun createAdministrationProcess(s: String): AdministrationProcess {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun evaluate(s: String): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun evaluate(s: String, document: Document): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun freeTimeSearch(dateRange: DateRange, i: Int, o: Any, b: Boolean): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getAddressBooks(): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getAgentContext(): AgentContext {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getCommonUserName(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isConvertMime(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setConvertMime(b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isConvertMIME(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setConvertMIME(b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getDatabase(s: String, s1: String): Database {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getDatabase(s: String, s1: String, b: Boolean): Database {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getDbDirectory(s: String): DbDirectory {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getEnvironmentString(s: String): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getEnvironmentString(s: String, b: Boolean): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getEnvironmentValue(s: String): Any {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getEnvironmentValue(s: String, b: Boolean): Any {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setEnvironmentVar(s: String, o: Any) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setEnvironmentVar(s: String, o: Any, b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getInternational(): International {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getNotesVersion(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getPlatform(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getServerName(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getURLDatabase(): Database {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserName(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getEffectiveUserName(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserNameObject(): Name {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isOnServer(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun resolve(s: String): Base {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserNameList(): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getURL(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getHttpURL(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getSessionToken(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getSessionToken(s: String): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getCredentials(): Any {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getOrgDirectoryPath(): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getCurrentDatabase(): Database {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isValid(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserGroupNameList(): Vector<Any> {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun sendConsoleCommand(s: String, s1: String): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserPolicySettings(s: String, s1: String, i: Int): Document {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getUserPolicySettings(s: String, s1: String, i: Int, s2: String): Document {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun hashPassword(s: String): String {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun verifyPassword(s: String, s1: String): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getPropertyBroker(): PropertyBroker {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getDirectory(): Directory {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun getDirectory(s: String): Directory {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isTrustedSession(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isRestricted(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun resetUserPassword(s: String, s1: String, s2: String): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun resetUserPassword(s: String, s1: String, s2: String, i: Int): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun isTrackMillisecInJavaDates(): Boolean {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setTrackMillisecInJavaDates(b: Boolean) {
        throw NotImplementedException()
    }

    @Throws(NotImplementedException::class)
    override fun setAllowLoopBack(b: Boolean) {
        throw NotImplementedException()
    }
    //endregion
}
