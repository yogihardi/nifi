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
package org.apache.nifi.web.api.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.apache.nifi.web.api.dto.util.TimestampAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

public class FlowFileSummaryDTO {

    private String uuid;
    private String filename;
    private Integer position;
    private Long size;
    private Date lastQueuedTime;
    private Date linageStartDate;
    private Boolean isPenalized;

    /**
     * @return the FlowFile uuid
     */
    @ApiModelProperty(
        value = "The FlowFile UUID."
    )
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the FlowFile filename
     */
    @ApiModelProperty(
        value = "The FlowFile filename."
    )
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the FlowFile's position in the queue.
     */
    @ApiModelProperty(
        value = "The FlowFile's position in the queue."
    )
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * @return the FlowFile file size
     */
    @ApiModelProperty(
        value = "The FlowFile file size."
    )
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * @return when the FlowFile was last added to the queue
     */
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    @ApiModelProperty(
        value = "When the FlowFile was last added to the queue."
    )
    public Date getLastQueuedTime() {
        return lastQueuedTime;
    }

    public void setLastQueuedTime(Date lastQueuedTime) {
        this.lastQueuedTime = lastQueuedTime;
    }

    /**
     * @return when the FlowFile's greatest ancestor entered the flow
     */
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    @ApiModelProperty(
        value = "When the FlowFile's greatest ancestor entered the flow."
    )
    public Date getLinageStartDate() {
        return linageStartDate;
    }

    public void setLinageStartDate(Date linageStartDate) {
        this.linageStartDate = linageStartDate;
    }

    /**
     * @return if the FlowFile is penalized
     */
    @ApiModelProperty(
        value = "If the FlowFile is penalized."
    )
    public Boolean getPenalized() {
        return isPenalized;
    }

    public void setPenalized(Boolean penalized) {
        isPenalized = penalized;
    }
}
