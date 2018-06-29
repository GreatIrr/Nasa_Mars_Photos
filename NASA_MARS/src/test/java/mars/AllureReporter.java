package mars;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.config.AllureModelUtils;
import ru.yandex.qatools.allure.events.ClearStepStorageEvent;
import ru.yandex.qatools.allure.events.TestCaseStartedEvent;
import ru.yandex.qatools.allure.events.TestSuiteFinishedEvent;
import ru.yandex.qatools.allure.events.TestSuiteStartedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Iryna_Bartnytska on 12/12/2017.
 */
public class AllureReporter //implements StoryReporter
{

    /*private Allure allure = Allure.LIFECYCLE;
    private final Map<String, String> suites = new HashMap<>();
    private String uid;

    @Override
    public void storyNotAllowed(Story story, String s) {

    }

    @Override
    public void storyCancelled(Story story, StoryDuration storyDuration) {

    }

    @Override
    public void beforeStory(Story story, boolean givenStory) {
        if (!givenStory) {
            uid = generateSuiteUid(story.getName());
            TestSuiteStartedEvent event = new TestSuiteStartedEvent(uid, story.getPath());
            event.withLabels(AllureModelUtils.createTestFrameworkLabel("JBehave"));
            event.withTitle(story.getName());
            getLifecycle().fire(event);
        }
    }

    @Override
    public void afterStory(boolean givenStory) {
        if (!givenStory) {
            getLifecycle().fire(new TestSuiteFinishedEvent(uid));
        }
    }

    @Override
    public void narrative(Narrative narrative) {

    }

    @Override
    public void lifecyle(Lifecycle lifecycle) {

    }

    @Override
    public void scenarioNotAllowed(Scenario scenario, String s) {

    }

    @Override
    public void beforeScenario(String s) {
        allure.fire(new TestCaseStartedEvent(uid, s));
        allure.fire(new ClearStepStorageEvent());

    }

    @Override
    public void scenarioMeta(Meta meta) {

    }

    @Override
    public void afterScenario() {

    }

    @Override
    public void givenStories(GivenStories givenStories) {

    }

    @Override
    public void givenStories(List<String> list) {

    }

    @Override
    public void beforeExamples(List<String> list, ExamplesTable examplesTable) {

    }

    @Override
    public void example(Map<String, String> map) {

    }

    @Override
    public void afterExamples() {

    }

    @Override
    public void beforeStep(String s) {

    }

    @Override
    public void successful(String s) {

    }

    @Override
    public void ignorable(String s) {

    }

    @Override
    public void pending(String s) {

    }

    @Override
    public void notPerformed(String s) {

    }

    @Override
    public void failed(String s, Throwable throwable) {

    }

    @Override
    public void failedOutcomes(String s, OutcomesTable outcomesTable) {

    }

    @Override
    public void restarted(String s, Throwable throwable) {

    }

    @Override
    public void restartedStory(Story story, Throwable throwable) {

    }

    @Override
    public void dryRun() {

    }

    @Override
    public void pendingMethods(List<String> list) {

    }

    private String generateSuiteUid(String suiteName) {
        String uid = UUID.randomUUID().toString();
        synchronized (getSuites()) {
            getSuites().put(suiteName, uid);
        }
        return uid;
    }

    private Allure getLifecycle() {
        return allure;
    }

    private Map<String, String> getSuites() {
        return suites;
    }
    */
}
