package com.baiye.config;


import org.aeonbits.owner.Config;

/**
 * Created by Baiye on 2017/2/7.
 */
@Config.Sources({
        "file:~/.taskCore.config",
        "file:/etc/taskCore.config",
        "classpath:taskCore.config"
})
public interface CoreConfig extends Config{

    @Key("server.host.ip")
    @DefaultValue("127.0.0.1")
    String ip();

    @Key("base.jar.path")
    @DefaultValue("/var/baiye-task")
    String jobJarBasePath();

}
