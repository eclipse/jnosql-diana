/*
 *  Copyright (c) 2018 Otávio Santana and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *  You may elect to redistribute this code under either of these licenses.
 *  Contributors:
 *  Otavio Santana
 */
package org.jnosql.diana.query.method;

import jakarta.nosql.query.Condition;
import jakarta.nosql.query.ConditionQueryValue;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

final class MethodConditionValue implements ConditionQueryValue {

    private final List<Condition> conditions;

    private MethodConditionValue(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public List<Condition> get() {
        return unmodifiableList(conditions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MethodConditionValue)) {
            return false;
        }
        MethodConditionValue that = (MethodConditionValue) o;
        return Objects.equals(conditions, that.conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(conditions);
    }

    @Override
    public String toString() {
        return conditions.toString();
    }

    public static ConditionQueryValue of(List<Condition> conditions) {
        return new MethodConditionValue(conditions);
    }
}
