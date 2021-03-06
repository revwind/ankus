/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openflamingo.engine.context;

import org.quartz.JobExecutionContext;

/**
 * Quarz Job Scheduler Context Implementation for Daemon Scheduler.
 *
 * @author Byoung Gon, Kim
 * @since 0.2
 */
public class QuartzJobSchedulerContext implements SchedulerContext {

    /**
     * Quartz Job Execution Context.
     */
    private JobExecutionContext jobExecutionContext;

    /**
     * 기본 생성자.
     *
     * @param jobExecutionContext Quartz Job Execution Context.
     */
    public QuartzJobSchedulerContext(JobExecutionContext jobExecutionContext) {
        this.jobExecutionContext = jobExecutionContext;
    }

    @Override
    public void put(String key, Object object) {
        jobExecutionContext.put(key, object);
    }

    @Override
    public Object get(String key) {
        return jobExecutionContext.get(key);
    }

    @Override
    public JobExecutionContext getJobExecutionContext() {
        return jobExecutionContext;
    }

}
