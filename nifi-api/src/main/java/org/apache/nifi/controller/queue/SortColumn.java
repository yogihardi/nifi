/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.nifi.controller.queue;

/**
 * Specifies which column to sort on when performing a Listing of FlowFiles via
 * {@link FlowFileQueue#listFlowFiles(String, SortColumn, SortDirection)}
 */
public enum SortColumn {
    /**
     * Sort based on the current position in the queue
     */
    QUEUE_POSITION,

    /**
     * Sort based on the UUID of the FlowFile
     */
    FLOWFILE_UUID,

    /**
     * Sort based on the 'filename' attribute of the FlowFile
     */
    FILENAME,

    /**
     * Sort based on the size of the FlowFile
     */
    FLOWFILE_SIZE,

    /**
     * Sort based on how long the FlowFile has been sitting in the queue
     */
    QUEUED_DURATION,

    /**
     * Sort based on the age of the FlowFile. I.e., the time at which the FlowFile's
     * "greatest ancestor" entered the flow
     */
    FLOWFILE_AGE,

    /**
     * Sort based on when the FlowFile's penalization ends
     */
    PENALIZATION;
}
