/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.access.sqlbuilder;

import org.apache.cayenne.access.sqlbuilder.sqltree.Node;

/**
 * @since 4.2
 */
public interface NodeTreeVisitor {

    /**
     * @param node to visit
     * @return false if visitor should stop
     */
    boolean onNodeStart(Node node);

    /**
     * @param parent node
     * @param child node
     * @param index of this child in parent
     * @param hasMore true if more children after this child
     * @return false if visitor should stop
     */
    boolean onChildNodeStart(Node parent, Node child, int index, boolean hasMore);

    void onChildNodeEnd(Node parent, Node child, int index, boolean hasMore);

    void onNodeEnd(Node node);
}
