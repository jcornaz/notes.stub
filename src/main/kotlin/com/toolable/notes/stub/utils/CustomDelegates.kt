package com.toolable.notes.stub.utils

import com.toolable.notes.stub.model.BaseStub
import kotlin.properties.Delegates


/**
 * Create a delegate for a property parent of the owner class
 * The parent will be created if needed only
 * The parent children list will always be up-to-date
 *
 * @param init Will be invoked to create a new instance of the parent if needed
 * @param removeChild Will be invoked if the owner has to be removed from a parent
 * @param addChild Will be invoked if the owner has to be added to a parent
 */
fun <ChildType, ParentType> lazyParent(
        init: () -> ParentType,
        removeChild: ParentType.() -> Unit,
        addChild: ParentType.() -> Unit) =
        MutableLazyDelegate<ChildType, ParentType>(init) { oldValue, newValue ->
            oldValue?.removeChild()
            newValue.addChild()
        }

/**
 * Create a delegate for a property that have to cascade it's value to other elements
 *
 * @param initialValue Initial value of the property
 * @param shouldCascade Predicate to determinate if the modification has to cascade
 * @param children Collection of elements that should be updated when cascading
 * @param cascade How a child should update itself
 */
fun <PropertyType, ChildType> cascade(
        initialValue: PropertyType,
        shouldCascade: (old: PropertyType, new: PropertyType) -> Boolean = { old, new -> true },
        children: () -> Collection<ChildType>,
        cascade: ChildType.(value: PropertyType) -> Unit
) = Delegates.observable(initialValue) { prop, old, new ->
    if (shouldCascade(old, new))
        children().forEach { it.cascade(new) }
}

/**
 * Create a delegate for a [BaseStub.isRecycled] property that have to cascade it value to all of it children
 *
 * @param children Compute and return the list of children
 */
fun cascadeRecyclingState(children: () -> Collection<BaseStub<*>>) =
        cascade(false, { old, new -> !old && new }, children, { isRecycled = it })