package com.baga.data.mapper

import com.baga.data.db.entity.ProjectData
import com.baga.domain.entity.ProjectDomain

/**
 * Created by bagadesh on 04/03/23.
 */

fun ProjectDomain.toProjectData(): ProjectData {
    return ProjectData(
        id = id,
        title = title,
        projectType = projectType,
        dueDate = dueDate,
    )
}