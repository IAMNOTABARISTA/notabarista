package com.test.helloworld

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface NotabaristaRepository : JpaRepository<Notabarista?, Int?>, JpaSpecificationExecutor<Notabarista?> 