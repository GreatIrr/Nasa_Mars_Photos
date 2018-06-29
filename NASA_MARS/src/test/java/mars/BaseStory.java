package mars;

import static org.jbehave.core.reporters.Format.CONSOLE;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import steps.NasaRestSteps;

/**
 * Created by Iryna_Bartnytska on 12/12/2017.
 */
public class BaseStory// extends JUnitStory
{

/*
    private static final String STORIES_PATTERN_KEY = "story";

    @Override
    public Configuration configuration() {
        if (super.hasConfiguration()) {
            return super.configuration();
        }
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
                .withFormats(CONSOLE).withReporters(new AllureReporter()));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new NasaRestSteps());
    }

    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        embedder.embedderControls().doGenerateViewAfterStories(false);
        return embedder;
    } */
}
