package com.toolable.notes.stub.model

interface Parent<ChildType> {

    fun add(child: ChildType)

    fun remove(child: ChildType)
}