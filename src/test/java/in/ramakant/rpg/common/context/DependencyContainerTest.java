package in.ramakant.rpg.common.context;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.common.exceptions.DependencyException;
import in.ramakant.rpg.common.utils.OutputWriter;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class DependencyContainerTest {

    @Test
    public void DependencyContainer_Throws_DependencyException_IfDependencyNotFound(){
        Throwable thrown = catchThrowable(() ->
                DependencyContainer.resolve(Object.class)
        );
        Assertions.assertThat(thrown).isInstanceOf(DependencyException.class);
    }

    @Test
    public void DependencyContainer_Returns_Dependency(){
        OutputWriter outputWriter = DependencyContainer.resolve(OutputWriter.class);
        assertThat(outputWriter).isNotNull();
    }
}
