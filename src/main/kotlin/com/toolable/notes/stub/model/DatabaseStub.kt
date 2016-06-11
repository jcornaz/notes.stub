package com.toolable.notes.stub.model

import lotus.domino.*
import java.util.*


class DatabaseStub : BaseStub(), Database {
    var parent: SessionStub by lazyChildStub(this) { SessionStub() }

    override fun getFileName(): String? {
        throw UnsupportedOperationException()
    }

    override fun setDelayUpdates(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getModifiedDocuments(p0: DateTime?, p1: Int): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getModifiedDocuments(p0: DateTime?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getModifiedDocuments(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getView(p0: String?): View? {
        throw UnsupportedOperationException()
    }

    override fun search(p0: String?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun search(p0: String?, p1: DateTime?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun search(p0: String?, p1: DateTime?, p2: Int): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getACLActivityLog(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun isDesignLockingEnabled(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isMultiDbSearch(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isDirectoryCatalog(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setLimitUpdatedBy(p0: Double) {
        throw UnsupportedOperationException()
    }

    override fun getViews(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun getFolderReferencesEnabled(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setInMultiDbIndexing(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun markForDelete() {
        throw UnsupportedOperationException()
    }

    override fun createDocumentCollection(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getFileFormat(): Int {
        throw UnsupportedOperationException()
    }

    override fun isAllowOpenSoftDeleted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getDocumentByID(p0: String?): Document? {
        throw UnsupportedOperationException()
    }

    override fun isLink(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isPendingDelete(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun compactWithOptions(p0: String?): Int {
        throw UnsupportedOperationException()
    }

    override fun compactWithOptions(p0: Int): Int {
        throw UnsupportedOperationException()
    }

    override fun compactWithOptions(p0: Int, p1: String?): Int {
        throw UnsupportedOperationException()
    }

    override fun createReplica(p0: String?, p1: String?): Database? {
        throw UnsupportedOperationException()
    }

    override fun createDocument(): Document? {
        throw UnsupportedOperationException()
    }

    override fun openByReplicaID(p0: String?, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getSize(): Double {
        throw UnsupportedOperationException()
    }

    override fun updateFTIndex(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun setListInDbCatalog(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun enableFolder(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun createView(): View? {
        throw UnsupportedOperationException()
    }

    override fun createView(p0: String?): View? {
        throw UnsupportedOperationException()
    }

    override fun createView(p0: String?, p1: String?): View? {
        throw UnsupportedOperationException()
    }

    override fun createView(p0: String?, p1: String?, p2: View?): View? {
        throw UnsupportedOperationException()
    }

    override fun createView(p0: String?, p1: String?, p2: View?, p3: Boolean): View? {
        throw UnsupportedOperationException()
    }

    override fun getDB2Schema(): String? {
        throw UnsupportedOperationException()
    }

    override fun getACL(): ACL? {
        throw UnsupportedOperationException()
    }

    override fun getDocumentByURL(p0: String?, p1: Boolean): Document? {
        throw UnsupportedOperationException()
    }

    override fun getDocumentByURL(p0: String?, p1: Boolean, p2: Boolean, p3: Boolean, p4: String?, p5: String?, p6: String?, p7: String?, p8: String?, p9: Boolean): Document? {
        throw UnsupportedOperationException()
    }

    override fun isPublicAddressBook(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getCategories(): String? {
        throw UnsupportedOperationException()
    }

    override fun createFromTemplate(p0: String?, p1: String?, p2: Boolean): Database? {
        throw UnsupportedOperationException()
    }

    override fun createFromTemplate(p0: String?, p1: String?, p2: Boolean, p3: Int): Database? {
        throw UnsupportedOperationException()
    }

    override fun setDesignLockingEnabled(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun setLimitRevisions(p0: Double) {
        throw UnsupportedOperationException()
    }

    override fun getURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun isDocumentLockingEnabled(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getHttpURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun sign() {
        throw UnsupportedOperationException()
    }

    override fun sign(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun sign(p0: Int, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun sign(p0: Int, p1: Boolean, p2: String?) {
        throw UnsupportedOperationException()
    }

    override fun sign(p0: Int, p1: Boolean, p2: String?, p3: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getType(): Int {
        throw UnsupportedOperationException()
    }

    override fun removeFTIndex() {
        throw UnsupportedOperationException()
    }

    override fun getForm(p0: String?): Form? {
        throw UnsupportedOperationException()
    }

    override fun getTemplateName(): String? {
        throw UnsupportedOperationException()
    }

    override fun createQueryView(p0: String?, p1: String?): View? {
        throw UnsupportedOperationException()
    }

    override fun createQueryView(p0: String?, p1: String?, p2: View?): View? {
        throw UnsupportedOperationException()
    }

    override fun createQueryView(p0: String?, p1: String?, p2: View?, p3: Boolean): View? {
        throw UnsupportedOperationException()
    }

    override fun getSizeWarning(): Long {
        throw UnsupportedOperationException()
    }

    override fun setUndeleteExpireTime(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun isFTIndexed(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getListInDbCatalog(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLastFTIndexed(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun compact(): Int {
        throw UnsupportedOperationException()
    }

    override fun setAllowOpenSoftDeleted(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun setCategories(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun isConfigurationDirectory(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getAllReadDocuments(p0: String?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getAllReadDocuments(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun createCopy(p0: String?, p1: String?): Database? {
        throw UnsupportedOperationException()
    }

    override fun createCopy(p0: String?, p1: String?, p2: Int): Database? {
        throw UnsupportedOperationException()
    }

    override fun FTSearch(p0: String?, p1: Int): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun FTSearch(p0: String?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun FTSearch(p0: String?, p1: Int, p2: Int, p3: Int): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getSizeQuota(): Int {
        throw UnsupportedOperationException()
    }

    override fun createNoteCollection(p0: Boolean): NoteCollection? {
        throw UnsupportedOperationException()
    }

    override fun getManagers(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun setTitle(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun isDB2(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getTitle(): String? {
        throw UnsupportedOperationException()
    }

    override fun revokeAccess(p0: String?) {
        throw UnsupportedOperationException()
    }

    override fun setSizeQuota(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun fixup() {
        throw UnsupportedOperationException()
    }

    override fun fixup(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun getAllDocuments(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getUndeleteExpireTime(): Int {
        throw UnsupportedOperationException()
    }

    override fun open(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getOption(p0: Int): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLastFixup(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun setOption(p0: Int, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getProfileDocument(p0: String?, p1: String?): Document? {
        throw UnsupportedOperationException()
    }

    override fun isCurrentAccessPublicWriter(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getFilePath(): String? {
        throw UnsupportedOperationException()
    }

    override fun getLastModified(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun openWithFailover(p0: String?, p1: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getNotesURL(): String? {
        throw UnsupportedOperationException()
    }

    override fun getPercentUsed(): Double {
        throw UnsupportedOperationException()
    }

    override fun isCurrentAccessPublicReader(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getOutline(p0: String?): Outline? {
        throw UnsupportedOperationException()
    }

    override fun isInMultiDbIndexing(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLimitRevisions(): Double {
        throw UnsupportedOperationException()
    }

    override fun getDesignTemplateName(): String? {
        throw UnsupportedOperationException()
    }

    override fun setInService(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getDocumentByUNID(p0: String?): Document? {
        throw UnsupportedOperationException()
    }

    override fun setDocumentLockingEnabled(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun FTSearchRange(p0: String?, p1: Int, p2: Int, p3: Int, p4: Int): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getForms(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun replicate(p0: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun isDelayUpdates(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getCreated(): DateTime? {
        throw UnsupportedOperationException()
    }

    override fun isOpen(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getLimitUpdatedBy(): Double {
        throw UnsupportedOperationException()
    }

    override fun createFTIndex(p0: Int, p1: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun getFTIndexFrequency(): Int {
        throw UnsupportedOperationException()
    }

    override fun getProfileDocCollection(p0: String?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun setFTIndexFrequency(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun openIfModified(p0: String?, p1: String?, p2: DateTime?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun queryAccessPrivileges(p0: String?): Int {
        throw UnsupportedOperationException()
    }

    override fun getAllUnreadDocuments(p0: String?): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getAllUnreadDocuments(): DocumentCollection? {
        throw UnsupportedOperationException()
    }

    override fun getParent(): Session {
        return parent
    }

    override fun getURLHeaderInfo(p0: String?, p1: String?, p2: String?, p3: String?, p4: String?, p5: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun getReplicaID(): String? {
        throw UnsupportedOperationException()
    }

    override fun queryAccessRoles(p0: String?): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun isClusterReplication(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setSizeWarning(p0: Int) {
        throw UnsupportedOperationException()
    }

    override fun remove() {
        throw UnsupportedOperationException()
    }

    override fun getAgent(p0: String?): Agent? {
        throw UnsupportedOperationException()
    }

    override fun setFolderReferencesEnabled(p0: Boolean) {
        throw UnsupportedOperationException()
    }

    override fun queryAccess(p0: String?): Int {
        throw UnsupportedOperationException()
    }

    override fun FTDomainSearch(p0: String?, p1: Int, p2: Int, p3: Int, p4: Int, p5: Int, p6: String?): Document? {
        throw UnsupportedOperationException()
    }

    override fun getMaxSize(): Long {
        throw UnsupportedOperationException()
    }

    override fun isPrivateAddressBook(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getCurrentAccessLevel(): Int {
        throw UnsupportedOperationException()
    }

    override fun getReplicationInfo(): Replication? {
        throw UnsupportedOperationException()
    }

    override fun getAgents(): Vector<*>? {
        throw UnsupportedOperationException()
    }

    override fun createOutline(p0: String?): Outline? {
        throw UnsupportedOperationException()
    }

    override fun createOutline(p0: String?, p1: Boolean): Outline? {
        throw UnsupportedOperationException()
    }

    override fun getServer(): String? {
        throw UnsupportedOperationException()
    }

    override fun isInService(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun grantAccess(p0: String?, p1: Int) {
        throw UnsupportedOperationException()
    }
}