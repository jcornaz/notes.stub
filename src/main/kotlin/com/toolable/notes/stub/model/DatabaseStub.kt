package com.toolable.notes.stub.model

import com.toolable.notes.stub.impl.DatabaseImpl
import com.toolable.notes.stub.utils.cascadeRecyclingState
import com.toolable.notes.stub.utils.lazyParent

/**
 * Stub for [lotus.domino.Database]
 */
class DatabaseStub : BaseStub<DatabaseImpl> {
    override val implementation = DatabaseImpl(this)
    override var isRecycled by cascadeRecyclingState { documents.values }

    /**
     * Session of the database
     */
    var session by lazyParent<DatabaseStub, SessionStub>(
            { SessionStub() },
            { databases -= this@DatabaseStub },
            { databases += this@DatabaseStub }
    )

    /**
     * Documents contained in the database
     *
     * Change the database of a document with [DocumentStub.database]
     */
    var documents = emptyMap<Unid, DocumentStub>()
        internal set

    /**
     * Collections that are linked to this database
     *
     * Change the database of a collection with [DocumentCollectionStub.database]
     */
    var collections = emptyList<DocumentCollectionStub>()
        internal set

    /**
     * Server name
     */
    var server: String = "DEFAULT_SERVER"

    /**
     * File name
     */
    var fileName: String = "default_database.nsf"

    /**
     * File path (include the file name)
     */
    var filePath: String = ""
        get() = field + (if (field.isNotEmpty()) "/" else "") + fileName
        set(value) {
            fileName = value.substringAfterLast("/")
            field = value.substringBeforeLast("/")
        }

    /**
     * Return the document with the specified UNID
     *
     * @param unid ID of the desired document
     * @return The document with the specified UNID or null if there is no document with that unid in this database
     */
    operator fun get(unid: Unid) = documents[unid]

    /**
     * Return true the database contains a document with the specified unid
     *
     * @param unid UNID to check
     * @return true if, and only if, the database contains a document with the specified unid
     */
    operator fun contains(unid: Unid) = unid in documents
}