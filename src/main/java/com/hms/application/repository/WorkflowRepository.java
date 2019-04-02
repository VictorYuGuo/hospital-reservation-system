package com.hms.application.repository;

import com.hms.application.entity.infoWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 工作流数据库接口
 */
public interface WorkflowRepository extends JpaRepository<infoWorkflow,String> {

}
