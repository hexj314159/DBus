/*-
 * <<
 * DBus
 * ==
 * Copyright (C) 2016 - 2017 Bridata
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package com.creditease.dbus.heartbeat.resource.local;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.SystemUtils;

import com.creditease.dbus.heartbeat.resource.AbstractConfigResource;
import com.creditease.dbus.heartbeat.util.IOUtil;

public abstract class FileConfigResource<T> extends AbstractConfigResource<T> {

    protected FileConfigResource(String name) {
        super(name);
    }

    protected void init() {
        FileInputStream fis = null;
        try {
            prop = new Properties();
            File jdbc = new File(SystemUtils.USER_DIR.replaceAll("\\\\", "/") + "/conf/" + name);
            fis = new FileInputStream(jdbc);
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("inti config resource " + name + " error!");
        } finally {
            IOUtil.close(fis);
        }
    }

}
