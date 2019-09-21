package com.hmtmcse.devops.common

import com.hmtmcse.common.CommonConst
import com.hmtmcse.jtfutil.io.FDHelper
import com.hmtmcse.jtfutil.parser.YmlReader

class ConfigLoader {

    public static String CONFIG_FILE = "config.yml"

    public static Config getConfig() {
        String path = CONFIG_FILE
        Config config = new Config()
        try {
            if (FDHelper.instance().isExist(path)) {
                path = FDHelper.instance().getFile(path).getAbsolutePath()
            } else {
                path = CommonConst.ALL_MODULE_DIRECTORY + "/" + CONFIG_FILE
            }
        } catch (Exception e) {
            return config
        }

        if (path) {
            try {
                YmlReader ymlReader = new YmlReader()
                config = ymlReader.ymlAsKlass(path, Config.class)
            } catch (Exception e) {
                return config
            }
        }
        return config
    }

}
