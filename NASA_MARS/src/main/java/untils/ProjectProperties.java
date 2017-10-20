package untils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * Created by Iryna_Bartnytska on 10/13/2017.
 */
public class ProjectProperties {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectProperties.class);
    private static EnvironmentVariables environmentVariables = Injectors.getInjector()
            .getProvider(EnvironmentVariables.class).get();
    private static ProjectProperties instance = new ProjectProperties();
    private final String PROPERTY_FILE = "src/main/resources/projet.properties";
    private Properties properties;

    private ProjectProperties() {
        this.properties = new Properties();
        loadProperiesFromFile(PROPERTY_FILE);
        afterPropertiesSet();
    }

    public static ProjectProperties getInstance() {
        return instance;
    }

    public String getProperty(final String property) {
        return properties.getProperty(property);
    }

    private void loadProperiesFromFile(final String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            LOG.error("Counld not find file " + fileName, e);
        } catch (IOException e) {
            LOG.error("IOException =( " + fileName, e);
        }
    }

    private void afterPropertiesSet() {
        for (Map.Entry props : properties.entrySet()) {
            String key = String.valueOf(props.getKey());
            String value = String.valueOf(props.getValue());
            if (StringUtils.isBlank(System.getProperty(key))) {
                System.setProperty(key, value);
                // LOG.debug("System property {} was successfully added: {}", key, value);
            }
        }
    }

    public enum Key {

        API_KEY("api.key");

        private final String text;

        Key(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
