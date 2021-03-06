package uk.gov.justice.hmpps.offendersearch.dto

import io.swagger.annotations.ApiModelProperty

data class AllTeam(
  @ApiModelProperty(required = true) val providerTeamId: Long? = null,
  @ApiModelProperty(required = true) val teamId: Long? = null,
  val code: String? = null,
  val description: String? = null,
  val name: String? = null,
  val isPrivate: Boolean? = null,
  val externalProvider: KeyValue? = null,
  val scProvider: KeyValue? = null,
  val localDeliveryUnit: KeyValue? = null,
  val district: KeyValue? = null,
  val borough: KeyValue? = null
)
