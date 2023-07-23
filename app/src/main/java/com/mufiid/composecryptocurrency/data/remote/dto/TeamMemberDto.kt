package com.mufiid.composecryptocurrency.data.remote.dto

import com.mufiid.composecryptocurrency.domain.model.TeamMember


data class TeamMemberDto(
    val id: String?,
    val name: String?,
    val position: String?
)

fun TeamMemberDto.toDomain(): TeamMember {
    return TeamMember(
        id = id.orEmpty(),
        name = name.orEmpty(),
        position = position.orEmpty(),
    )
}