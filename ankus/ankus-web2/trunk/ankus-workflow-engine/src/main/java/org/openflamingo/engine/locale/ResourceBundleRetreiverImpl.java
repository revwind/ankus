/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openflamingo.engine.locale;

import org.openflamingo.engine.configuration.LocaleSupport;
import org.openflamingo.provider.locale.ResourceBundleRetreiver;
import org.springframework.stereotype.Component;

/**
 * Resource Bundle Retreiver for Localization Implementation.
 *
 * @author Byoung Gon, Kim
 * @since 1.0
 */
@Component
public class ResourceBundleRetreiverImpl implements ResourceBundleRetreiver {

    @Override
    public String message(String mainKey, String subKey, String... args) {
        return new LocaleSupport().message(mainKey, subKey, args);
    }

}
