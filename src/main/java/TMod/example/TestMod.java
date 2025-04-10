package TMod.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {

    public static final String TEST_MOD_ID = "Test";

    public static final Logger TESTLOGGER = LoggerFactory.getLogger(TEST_MOD_ID);

    @Override
    public void onInitialize() {
        TESTLOGGER.info("Loaded Test Logger");
    }
}
