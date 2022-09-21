package com.msb.apollo.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;

/**
 * @author: thirteenmj
 * @date: 2022-09-21 15:16
 */
//@Configuration
public class ApolloConfig {

//    @Bean
    public void config() {
        Config config = ConfigService.getAppConfig();
        config.addChangeListener(changeEvent -> {
            System.out.println("changes for nameSpace:" + changeEvent.getNamespace());
            for (String key : changeEvent.changedKeys()) {
                ConfigChange change = changeEvent.getChange(key);
                System.out.println(String.format("Found change - key:%s,oldKet:%s,newValue:%s,changeType:%s",
                        key, change.getOldValue(), change.getNewValue(), change.getChangeType()));
            }
        });
    }
}
