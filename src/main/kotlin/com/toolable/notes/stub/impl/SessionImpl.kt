package com.toolable.notes.stub.impl

import com.toolable.notes.stub.exception.RecycledObjectException
import com.toolable.notes.stub.model.DateTimeStub
import com.toolable.notes.stub.model.SessionStub
import lotus.domino.*
import java.util.*

/**
 * Implementation of [Session] with a stub
 *
 * @constructor Create a new implementation
 * @param stub Stub holding data for this implementation
 */
class SessionImpl(stub: SessionStub) : BaseImpl<SessionStub>(stub), Session {

    /**
     * Create a new [DateTime]
     *
     * @param value Value of the date-time
     * @return The created [DateTime]
     * @throws RecycledObjectException The session is recycled
     */
    @Throws(RecycledObjectException::class)
    override fun createDateTime(value: Date?): DateTime? {
        assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime(value)).implementation
    }

    /**
     * Create a new [DateTime]
     *
     * @param value Value of the date-time
     * @return The created [DateTime]
     * @throws RecycledObjectException The session is recycled
     */
    override fun createDateTime(value: Calendar): DateTime {
        assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime(value)).implementation
    }

    /**
     * Create a new [DateTime]
     *
     * @param value Value of the date-time
     * @return The created [DateTime]
     * @throws RecycledObjectException The session is recycled
     */
    override fun createDateTime(value: String): DateTime {
        assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime.parse(value)).implementation
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isConvertMIME(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createDxlImporter(): DxlImporter? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun verifyPassword(p0: String?, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getAddressBooks(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createColorObject(): ColorObject? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createDxlExporter(): DxlExporter? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getDirectory(): Directory? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getDirectory(p0: String?): Directory? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(): DateRange? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(p0: DateTime?, p1: DateTime?): DateRange? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createDateRange(p0: Date?, p1: Date?): DateRange? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isOnServer(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isRestricted(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentString(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentString(p0: String?, p1: Boolean): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun freeTimeSearch(p0: DateRange?, p1: Int, p2: Any?, p3: Boolean): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setConvertMIME(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isTrustedSession(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isTrackMillisecInJavaDates(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createName(p0: String?): Name? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createName(p0: String?, p1: String?): Name? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentValue(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEnvironmentValue(p0: String?, p1: Boolean): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserName(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getCredentials(): Any? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createRichTextParagraphStyle(): RichTextParagraphStyle? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getCommonUserName(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createNewsletter(p0: DocumentCollection?): Newsletter? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createRichTextStyle(): RichTextStyle? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getURLDatabase(): Database? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun sendConsoleCommand(p0: String?, p1: String?): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun resolve(p0: String?): Base? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setConvertMime(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserGroupNameList(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getEffectiveUserName(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getServerName(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setAllowLoopBack(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createLog(p0: String?): Log? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getPropertyBroker(): PropertyBroker? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun resetUserPassword(p0: String?, p1: String?, p2: String?): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun resetUserPassword(p0: String?, p1: String?, p2: String?, p3: Int): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getNotesVersion(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getDatabase(p0: String?, p1: String?): Database? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getDatabase(p0: String?, p1: String?, p2: Boolean): Database? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setEnvironmentVar(p0: String?, p1: Any?) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setEnvironmentVar(p0: String?, p1: Any?, p2: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getCurrentDatabase(): Database? {
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
    override fun getDbDirectory(p0: String?): DbDirectory? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createStream(): Stream? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createRegistration(): Registration? {
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
    override fun getHttpURL(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getPlatform(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getOrgDirectoryPath(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun hashPassword(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun setTrackMillisecInJavaDates(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun isConvertMime(): Boolean {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getAgentContext(): AgentContext? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserPolicySettings(p0: String?, p1: String?, p2: Int): Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserPolicySettings(p0: String?, p1: String?, p2: Int, p3: String?): Document? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserNameObject(): Name? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getSessionToken(): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getSessionToken(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun evaluate(p0: String?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun evaluate(p0: String?, p1: Document?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun createAdministrationProcess(p0: String?): AdministrationProcess? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getInternational(): International? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getUserNameList(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun getCalendar(p0: Database?): NotesCalendar {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun freeResourceSearch(p0: DateTime?, p1: DateTime?, p2: String?, p3: Int, p4: Int): Vector<*> {
        throw UnsupportedOperationException()
    }

    /**
     * Unsupported operation
     *
     * @throws UnsupportedOperationException This operation is not supported yet
     */
    @Throws(UnsupportedOperationException::class)
    override fun freeResourceSearch(p0: DateTime?, p1: DateTime?, p2: String?, p3: Int, p4: Int, p5: String?, p6: Int, p7: String?, p8: String?, p9: Int): Vector<*> {
        throw UnsupportedOperationException()
    }
}