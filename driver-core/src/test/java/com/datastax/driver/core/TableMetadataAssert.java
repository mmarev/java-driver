/*
 *      Copyright (C) 2012-2015 DataStax Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.datastax.driver.core;

import org.assertj.core.api.AbstractAssert;

import static com.datastax.driver.core.Assertions.assertThat;

public class TableMetadataAssert extends AbstractAssert<TableMetadataAssert, TableMetadata> {

    protected TableMetadataAssert(TableMetadata actual) {
        super(actual, TableMetadataAssert.class);
    }

    public TableMetadataAssert hasName(String name) {
        assertThat(actual.getName()).isEqualTo(name);
        return this;
    }

    public TableMetadataAssert isCompactStorage() {
        assertThat(actual.getOptions().isCompactStorage()).isTrue();
        return this;
    }

    public TableMetadataAssert isNotCompactStorage() {
        assertThat(actual.getOptions().isCompactStorage()).isFalse();
        return this;
    }

    public TableMetadataAssert hasNumberOfColumns(int expected) {
        assertThat(actual.getColumns().size()).isEqualTo(expected);
        return this;
    }

    public TableMetadataAssert hasMaterializedView(MaterializedViewMetadata expected) {
        assertThat(actual.getView(expected.getName())).isNotNull().isEqualTo(expected);
        return this;
    }
}