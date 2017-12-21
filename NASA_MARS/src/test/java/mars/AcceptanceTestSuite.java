package mars;

import java.util.List;

import net.serenitybdd.jbehave.SerenityStories;

/**
 * Created by Iryna_Bartnytska on 11/3/2017.
 */
public class AcceptanceTestSuite extends SerenityStories {

    private static final String STORIES_PATTERN_KEY = "story";
    private String storiesToRun;

    public AcceptanceTestSuite() {
    }

    @Override
    public List<String> storyPaths() {
        storiesToRun = getEnvironmentVariables().getProperty(STORIES_PATTERN_KEY);
        System.out.println("stories to run" + storiesToRun);

        if (storiesToRun == null) {
            return super.storyPaths();
        } else {
            findStoriesCalled(storiesToRun);
            return super.storyPaths();
        }
    }
}
