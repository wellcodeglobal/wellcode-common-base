package com.wellcode.common.base

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*
import kotlin.reflect.KClass
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
open class WgBaseEntity(

  @Id
  @Column(name = ID)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  var id: String = "",

  @Column(name = MARK_FOR_DELETE)
  var markForDelete: Boolean = false,

  @Column(name = OPTLOCK)
  @Version
  var version: Long = 0,

  @LastModifiedDate
  @Column(name = UPDATED_DATE)
  @Temporal(TemporalType.TIMESTAMP)
  var updatedDate: Date = Date(),

  @LastModifiedBy
  @Column(name = UPDATED_BY)
  var updatedBy: String = "",

  @CreatedDate
  @Column(name = CREATED_DATE)
  @Temporal(TemporalType.TIMESTAMP)
  var createdDate: Date = Date(),

  @CreatedBy
  @Column(name = CREATED_BY)
  var createdBy: String = ""

) {

  companion object {
    const val ID = "ID"
    const val MARK_FOR_DELETE = "MARK_FOR_DELETE"
    const val OPTLOCK= "OPTLOCK"
    const val UPDATED_DATE = "UPDATED_DATE"
    const val UPDATED_BY = "UPDATED_BY"
    const val CREATED_DATE = "CREATED_DATE"
    const val CREATED_BY = "CREATED_BY"
  }

  val serialVersionUID: Long = 7983591921094856852L

}