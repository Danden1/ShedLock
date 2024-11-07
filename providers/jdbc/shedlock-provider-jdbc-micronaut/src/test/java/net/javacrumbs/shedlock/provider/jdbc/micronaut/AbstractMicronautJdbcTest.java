package net.javacrumbs.shedlock.provider.jdbc.micronaut;

import io.micronaut.data.spring.jdbc.SpringJdbcConnectionOperations;
import io.micronaut.transaction.jdbc.DataSourceTransactionManager;
import net.javacrumbs.shedlock.support.StorageBasedLockProvider;
import net.javacrumbs.shedlock.test.support.jdbc.AbstractJdbcLockProviderIntegrationTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractMicronautJdbcTest extends AbstractJdbcLockProviderIntegrationTest {
    @BeforeAll
    public void startDb() {
        getDbConfig().startDb();
    }

    @AfterAll
    public void shutDownDb() {
        getDbConfig().shutdownDb();
    }

    @Override
    protected boolean useDbTime() {
        return false;
    }

    @Override
    protected StorageBasedLockProvider getLockProvider() {
        return new MicronautJdbcLockProvider(new DataSourceTransactionManager(
                getDatasource(), new SpringJdbcConnectionOperations(getDatasource()), null));
    }
}
