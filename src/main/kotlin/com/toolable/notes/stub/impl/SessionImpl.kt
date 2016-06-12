package com.toolable.notes.stub.impl

import com.toolable.notes.stub.model.DateTimeStub
import com.toolable.notes.stub.model.SessionStub
import lotus.domino.*
import java.util.*

/**
 * Implementation of [Session] with a stub
 */
class SessionImpl(stub: SessionStub) : BaseImpl<SessionStub>(stub), Session {

    override fun createDateTime(p0: Date?): DateTime? {
        stub.assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime(p0)).implementation
    }

    override fun createDateTime(p0: Calendar): DateTime {
        stub.assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime(p0)).implementation
    }

    override fun createDateTime(p0: String): DateTime {
        stub.assertNotRecycled()
        return DateTimeStub(stub, org.joda.time.DateTime.parse(p0)).implementation
    }

    override fun isConvertMIME(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun createDxlImporter(): DxlImporter? {
        throw UnsupportedOperationException()
    }

    override fun verifyPassword(p0: String?, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getAddressBooks(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun createColorObject(): ColorObject? {
        throw UnsupportedOperationException()
    }

    override fun createDxlExporter(): DxlExporter? {
        throw UnsupportedOperationException()
    }

    override fun getDirectory(): Directory? {
        throw UnsupportedOperationException()
    }

    override fun getDirectory(p0: String?): Directory? {
        throw UnsupportedOperationException()
    }

    override fun createDateRange(): DateRange? {
        throw UnsupportedOperationException()
    }

    override fun createDateRange(p0: DateTime?, p1: DateTime?): DateRange? {
        throw UnsupportedOperationException()
    }

    override fun createDateRange(p0: Date?, p1: Date?): DateRange? {
        throw UnsupportedOperationException()
    }

    override fun isOnServer(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isRestricted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getEnvironmentString(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun getEnvironmentString(p0: String?, p1: Boolean): String? {
        throw UnsupportedOperationException()
    }

    override fun freeTimeSearch(p0: DateRange?, p1: Int, p2: Any?, p3: Boolean): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun setConvertMIME(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isTrustedSession(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isTrackMillisecInJavaDates(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun createName(p0: String?): Name? {
        throw UnsupportedOperationException()
    }

    override fun createName(p0: String?, p1: String?): Name? {
        throw UnsupportedOperationException()
    }

    override fun getEnvironmentValue(p0: String?): Any? {
        throw UnsupportedOperationException()
    }

    override fun getEnvironmentValue(p0: String?, p1: Boolean): Any? {
        throw UnsupportedOperationException()
    }

    override fun getUserName(): String? {
        throw UnsupportedOperationException()
    }

    override fun getCredentials(): Any? {
        throw UnsupportedOperationException()
    }

    override fun createRichTextParagraphStyle(): RichTextParagraphStyle? {
        throw UnsupportedOperationException()
    }

    override fun getCommonUserName(): String? {
        throw UnsupportedOperationException()
    }

    override fun createNewsletter(p0: DocumentCollection?): Newsletter? {
        throw UnsupportedOperationException()
    }

    override fun createRichTextStyle(): RichTextStyle? {
        throw UnsupportedOperationException()
    }

    override fun getURLDatabase(): Database? {
        throw UnsupportedOperationException()
    }

    override fun sendConsoleCommand(p0: String?, p1: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun resolve(p0: String?): Base? {
        throw UnsupportedOperationException()
    }

    override fun setConvertMime(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getUserGroupNameList(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getEffectiveUserName(): String? {
        throw UnsupportedOperationException()
    }

    override fun getServerName(): String? {
        throw UnsupportedOperationException()
    }

    override fun setAllowLoopBack(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun createLog(p0: String?): Log? {
        throw UnsupportedOperationException()
    }

    override fun getPropertyBroker(): PropertyBroker? {
        throw UnsupportedOperationException()
    }

    override fun resetUserPassword(p0: String?, p1: String?, p2: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun resetUserPassword(p0: String?, p1: String?, p2: String?, p3: Int): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getNotesVersion(): String? {
        throw UnsupportedOperationException()
    }

    override fun getDatabase(p0: String?, p1: String?): Database? {
        throw UnsupportedOperationException()
    }

    override fun getDatabase(p0: String?, p1: String?, p2: Boolean): Database? {
        throw UnsupportedOperationException()
    }

    override fun setEnvironmentVar(p0: String?, p1: Any?) {
        throw UnsupportedOperationException()
    }

    override fun setEnvironmentVar(p0: String?, p1: Any?, p2: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getCurrentDatabase(): Database? {
        throw UnsupportedOperationException()
    }

    override fun isValid(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getDbDirectory(p0: String?): DbDirectory? {
        throw UnsupportedOperationException()
    }

    override fun createStream(): Stream? {
        throw UnsupportedOperationException()
    }

    override fun createRegistration(): Registration? {
        throw UnsupportedOperationException()
    }

    override fun getURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun getHttpURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun getPlatform(): String? {
        throw UnsupportedOperationException()
    }

    override fun getOrgDirectoryPath(): String? {
        throw UnsupportedOperationException()
    }

    override fun hashPassword(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun setTrackMillisecInJavaDates(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun isConvertMime(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getAgentContext(): AgentContext? {
        throw UnsupportedOperationException()
    }

    override fun getUserPolicySettings(p0: String?, p1: String?, p2: Int): Document? {
        throw UnsupportedOperationException()
    }

    override fun getUserPolicySettings(p0: String?, p1: String?, p2: Int, p3: String?): Document? {
        throw UnsupportedOperationException()
    }

    override fun getUserNameObject(): Name? {
        throw UnsupportedOperationException()
    }

    override fun getSessionToken(): String? {
        throw UnsupportedOperationException()
    }

    override fun getSessionToken(p0: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun evaluate(p0: String?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun evaluate(p0: String?, p1: Document?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun createAdministrationProcess(p0: String?): AdministrationProcess? {
        throw UnsupportedOperationException()
    }

    override fun getInternational(): International? {
        throw UnsupportedOperationException()
    }

    override fun getUserNameList(): Vector<*>? {
        throw UnsupportedOperationException()
    }
}