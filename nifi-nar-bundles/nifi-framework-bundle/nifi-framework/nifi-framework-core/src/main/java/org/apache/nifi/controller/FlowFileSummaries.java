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

package org.apache.nifi.controller;

import java.util.Collections;
import java.util.Comparator;

import org.apache.nifi.controller.queue.FlowFileSummary;
import org.apache.nifi.controller.queue.SortColumn;
import org.apache.nifi.controller.queue.SortDirection;
import org.apache.nifi.web.api.dto.FlowFileSummaryDTO;

public class FlowFileSummaries {

    public static Comparator<FlowFileSummary> createComparator(final SortColumn column, final SortDirection direction) {
        final Comparator<FlowFileSummary> comparator = new Comparator<FlowFileSummary>() {
            @Override
            public int compare(final FlowFileSummary o1, final FlowFileSummary o2) {
                switch (column) {
                    case FILENAME:
                        return o1.getFilename().compareTo(o2.getFilename());
                    case FLOWFILE_AGE:
                        return Long.compare(o1.getLineageStartDate(), o2.getLineageStartDate());
                    case FLOWFILE_SIZE:
                        return Long.compare(o1.getSize(), o2.getSize());
                    case FLOWFILE_UUID:
                        return o1.getUuid().compareTo(o2.getUuid());
                    case PENALIZATION:
                        return Boolean.compare(o1.isPenalized(), o2.isPenalized());
                    case QUEUE_POSITION:
                        return Long.compare(o1.getPosition(), o2.getPosition());
                    case QUEUED_DURATION:
                        return Long.compare(o1.getLastQueuedTime(), o2.getLastQueuedTime());
                }

                return 0;
            }
        };


        if (direction == SortDirection.DESCENDING) {
            return Collections.reverseOrder(comparator);
        } else {
            return comparator;
        }
    }

    public static Comparator<FlowFileSummaryDTO> createDTOComparator(final SortColumn column, final SortDirection direction) {
        final Comparator<FlowFileSummaryDTO> comparator = new Comparator<FlowFileSummaryDTO>() {
            @Override
            public int compare(final FlowFileSummaryDTO o1, final FlowFileSummaryDTO o2) {
                final int val;
                switch (column) {
                    case FILENAME:
                        val = o1.getFilename().compareTo(o2.getFilename());
                        break;
                    case FLOWFILE_AGE:
                        val = o1.getLineageDuration().compareTo(o2.getLineageDuration());
                        break;
                    case FLOWFILE_SIZE:
                        val = Long.compare(o1.getSize(), o2.getSize());
                        break;
                    case FLOWFILE_UUID:
                        val = o1.getUuid().compareTo(o2.getUuid());
                        break;
                    case PENALIZATION:
                        val = Boolean.compare(o1.getPenalized(), o2.getPenalized());
                        break;
                    case QUEUE_POSITION:
                        val = Long.compare(o1.getPosition(), o2.getPosition());
                        break;
                    case QUEUED_DURATION:
                        val = o1.getQueuedDuration().compareTo(o2.getQueuedDuration());
                        break;
                    default:
                        return 0;
                }

                if (val == 0) {
                    // secondary sort on cluster node id if populated
                    if (o1.getClusterNodeId() == null && o2.getClusterNodeId() == null) {
                        return val;
                    } else if (o2.getClusterNodeId() == null) {
                        return -1;
                    } else if (o1.getClusterNodeId() == null) {
                        return 1;
                    } else {
                        return o1.getClusterNodeId().compareTo(o2.getClusterNodeId());
                    }
                } else {
                    return val;
                }
            }
        };

        if (direction == SortDirection.DESCENDING) {
            return Collections.reverseOrder(comparator);
        } else {
            return comparator;
        }
    }

}
