/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.crunch.io;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

/**
 * A target whose output goes to a given path on a file system.
 */
public interface PathTarget extends MapReduceTarget {

  Path getPath();

  /**
   * Get the naming scheme to be used for outputs being written to an output
   * path.
   * 
   * @return the naming scheme to be used
   */
  FileNamingScheme getFileNamingScheme();
  
  /**
   * Handles moving the output data for this target from a temporary location on the
   * filesystem to its target path at the end of a MapReduce job.
   * 
   * @param conf The job {@code Configuration}
   * @param workingPath The temp directory that contains the output of the job
   * @param index The index of this target for jobs that write multiple output files to a single directory
   * @param mapOnlyJob Whether or not this is a map-only job
   * @throws IOException
   */
  void handleOutputs(Configuration conf, Path workingPath, int index, boolean mapOnlyJob) throws IOException;
}
