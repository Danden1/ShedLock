/**
 * Copyright 2009 the original author or authors.
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.javacrumbs.micronaut.test;

import io.micronaut.context.annotation.Factory;
import io.micronaut.transaction.TransactionOperations;
import jakarta.inject.Singleton;
import java.sql.Connection;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbc.micronaut.MicronautJdbcLockProvider;

@Factory
public class Configuration {

    @Singleton
    public LockProvider lockProvider(TransactionOperations<Connection> transactionOperations) {
        return new MicronautJdbcLockProvider(transactionOperations);
    }
}
