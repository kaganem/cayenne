/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.unit.di.server;

import org.apache.cayenne.configuration.server.ServerModule;
import org.apache.cayenne.dba.DbAdapter;
import org.apache.cayenne.di.Inject;
import org.apache.cayenne.di.Module;
import org.apache.cayenne.di.Provider;
import org.apache.cayenne.unit.UnitDbAdapter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @since 4.1
 */
public class ServerRuntimeProviderContextsSync extends ServerRuntimeProvider {

    public ServerRuntimeProviderContextsSync(@Inject ServerCaseDataSourceFactory dataSourceFactory,
                                             @Inject ServerCaseProperties properties,
                                             @Inject ServerCaseExtraModules extraModulesProperties,
                                             @Inject Provider<DbAdapter> dbAdapterProvider,
                                             @Inject UnitDbAdapter unitDbAdapter) {
        super(dataSourceFactory, properties, extraModulesProperties, dbAdapterProvider, unitDbAdapter);
    }

    @Override
    protected Collection<? extends Module> getExtraModules() {
        Collection<Module> modules = new ArrayList<>(super.getExtraModules());
        modules.add(binder -> ServerModule.extend(binder).syncContexts());
        return modules;
    }
}
